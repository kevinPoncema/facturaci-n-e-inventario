/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facturacion;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfNumber;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import inventario.Invetario;
import inventario.conexionConfig;
import inventario.productos;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kd462
 */
public class factura {
    //variables para gestionar la conexion a dbb
    //1.Primero se crea la variable de conección

    private static Connection conn;
    //2.Se crea la variable para manipular los datos
    static PreparedStatement ps;
    //una variable vara almacenar los resultados de las consultas
    static ResultSet rs;
    static ResultSetMetaData rsm;
    static String Ruta = "C:/Users/Dell/Desktop/factura";

    //funcion para establecer conexion
    private static void con() throws SQLException {

        conn = DriverManager.getConnection(conexionConfig.host
                + "?useUnicode=true&useJDBCCompliantTimezonesShift="
                + "true&useLegacyDatetimeCode=false&serverTimezone=UTC", conexionConfig.user, conexionConfig.pass);
    }

    //metodo para añadir productos a la tabla
    public static void addProductoInTable(DefaultTableModel mt, String precio, String can, String produc, String id) {
        DecimalFormat dm = new DecimalFormat("#,##0.##");
        double canNum = Double.parseDouble(can);
        //obtiene la cantidad de producto del inventario
        String[] etiquetas = Invetario.obtenerRestantes(Integer.parseInt(id));
        etiquetas[0] = etiquetas[0].replace(",", "");
        if (canNum > Double.parseDouble(etiquetas[0])) {//verifica si la cantidad es mayor a la del inventario
            JOptionPane.showMessageDialog(null, "La cantidad que quieres agregar es mayor que la del inventario", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            //calcula el total
            String total = dm.format(Double.parseDouble(precio.replace(",", "")) * canNum);
            precio = dm.format(Double.parseDouble(precio.replace(",", "")));
            Object rowData[] = {id, can, produc, precio, total};
            mt.addRow(rowData);
        }

    }

    //metodo para remover productos de la tabla 
    public static void RemoveroductoInTable(DefaultTableModel mt, int i) {
        if (i == -1) {
            JOptionPane.showMessageDialog(null, "Debes selecionar una columna", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            mt.removeRow(i);
        }
    }

    //metodo para registrar ventas en la base de datos y actualizar el inventario
    public static void registrarVenta(int id, int egreso, double ganacia, String fecha) {
        try {
            String[] e = Invetario.obtenerRestantes(id);
            if (Integer.parseInt(e[0].replace(",", "")) >= egreso) {
                factura f = new factura();
                factura.con(); // Establecer la conexión
                String sql = "call registrar_venta(?,?,?,?);";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, id);
                ps.setInt(2, egreso);
                ps.setDouble(3, ganacia);
                ps.setString(4, fecha);
                int res = ps.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(factura.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al registrar la venta: " + ex.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        
    }
    //metodo para pedirle al usuario donde desea guardar el archivo 

    public static String obtenerDirectorioSeleccionado() {
        // Verifica si ya hay una ruta seleccionada
        if (Ruta != null) {
            File carpetaExistente = new File(Ruta);
            if (carpetaExistente.exists() && carpetaExistente.isDirectory()) {
                return Ruta;
            }
        }

        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        fileChooser.setDialogTitle("Seleccione un directorio");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); // Solo permite seleccionar directorios

        int seleccion = fileChooser.showDialog(null, "Seleccionar");

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File directorioSeleccionado = fileChooser.getSelectedFile();
            Ruta = directorioSeleccionado.getAbsolutePath();
            return Ruta;
        } else {
            return null; // El usuario canceló la selección o hubo un error
        }
    }

    public static void abrirDocumento(String rutaPDF) {
        Object[] options = {"Imprimir", "Cerrar"};
        int res = JOptionPane.showOptionDialog(null,
                "¿Deseas imprimir esta factura?",
                "Confirmación",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);

        if (res == 0) {
            try {
                // Abre el PDF con el navegador predeterminado
                Desktop desktop = Desktop.getDesktop();
                desktop.open(new File(rutaPDF));

            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al abrir el documento: " + ex.getMessage(), "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static float mmToPoints(float mm) {
        return mm * 2.83465f; // Aproximadamente 1 mm = 2.83465 puntos
    }

    //metodo para generar facturas 
    public static int generarFactura(DefaultTableModel mt, JTextField txtCambio, JTextField txtTotal, JTextField txtPagado, String usname) {
        try {
            DecimalFormat dm = new DecimalFormat("#,##0.##");
            int max = mt.getRowCount();
            double total = 0;

            // Obtener la fecha y hora actual
            LocalDateTime fechaHoraActual = LocalDateTime.now();
            // Formatear la fecha y hora
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy-HH:mm:ss");
            String fechaHoraFormateada = fechaHoraActual.format(formato);

            // Verifica que la tabla no esté vacía
            if (max <= 0) {
                JOptionPane.showMessageDialog(null, "Debes añadir productos a la tabla antes de facturar");
                return -1;
            }

            double totalNeto = 0;
            // Prepara el documento
            Document documento = new Document();
            // Reemplaza caracteres no permitidos en nombres de archivos
            String idFactura = fechaHoraFormateada.replace(":", "_").replace("/", "_");
            String rutaSel =obtenerDirectorioSeleccionado();
            if(rutaSel == null){
                return -1;
            }
            String filePath = rutaSel + File.separator + "factura_" + idFactura + ".pdf";
            PdfWriter.getInstance(documento, new FileOutputStream(filePath));
            documento.setPageSize(new Rectangle(mmToPoints(80), mmToPoints(3750))); // Ancho: 80 mm, Alto: 3750 mm
            documento.open();

            // Añadir el título centrado
            Font fontTitulo = new Font(Font.FontFamily.HELVETICA, 8, Font.BOLD);
            Paragraph title = new Paragraph("INVERSIONES PONCE", fontTitulo);
            title.setAlignment(Paragraph.ALIGN_CENTER);
            documento.add(title);

            // Añadir información adicional
            Font fontInformacion = new Font(Font.FontFamily.HELVETICA, 8);
            Paragraph informacion = new Paragraph("\nBo. Medina, 7 y 8 Calle, 8 Ave"
                    + "\nTel: 8789-1881"
                    + "\nFecha: " + fechaHoraFormateada
                    + "\nCajero: " + usname
                    + "\nNumero de factura:" + idFactura, fontInformacion);
            informacion.setSpacingAfter(8);
            documento.add(informacion);

            // Prepara la tabla
            PdfPTable tablaDoc = new PdfPTable(4);
            tablaDoc.setWidthPercentage(100);
            float[] columnWidths = {16, 27, 18, 20};
            tablaDoc.setWidths(columnWidths);

            // Configura la fuente para el texto de la tabla
            Font fontTabla = new Font(Font.FontFamily.HELVETICA, 10);

            // Añade celdas a la tabla con la fuente configurada
            tablaDoc.addCell(new PdfPCell(new Phrase("Cant", fontTabla)));
            tablaDoc.addCell(new PdfPCell(new Phrase("Producto", fontTabla)));
            tablaDoc.addCell(new PdfPCell(new Phrase("Precio", fontTabla)));
            tablaDoc.addCell(new PdfPCell(new Phrase("Total", fontTabla)));

            // Llena la tabla en el PDF y calcula las cosas
            for (int i = 0; i < max; i++) {
                total = Double.parseDouble(mt.getValueAt(i, 4).toString().replace(",", ""));
                totalNeto += total;
                int id = Integer.parseInt(mt.getValueAt(i, 0).toString().replace(",", ""));
                String cantidad = mt.getValueAt(i, 1).toString().replace(",", "");
                String producto = mt.getValueAt(i, 2).toString().replace(",", "");
                String precio = mt.getValueAt(i, 3).toString().replace(",", "");

                PdfPCell cellCantidadData = new PdfPCell(new Phrase(cantidad, fontTabla));
                PdfPCell cellProductoData = new PdfPCell(new Phrase(producto, fontTabla));
                PdfPCell cellPrecioData = new PdfPCell(new Phrase(precio, fontTabla));
                PdfPCell cellTotalData = new PdfPCell(new Phrase(dm.format(total), fontTabla));

                cellCantidadData.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellProductoData.setHorizontalAlignment(Element.ALIGN_LEFT);
                cellPrecioData.setHorizontalAlignment(Element.ALIGN_RIGHT);
                cellTotalData.setHorizontalAlignment(Element.ALIGN_RIGHT);

                tablaDoc.addCell(cellCantidadData);
                tablaDoc.addCell(cellProductoData);
                tablaDoc.addCell(cellPrecioData);
                tablaDoc.addCell(cellTotalData);

                // Actualiza la base de datos
                factura.registrarVenta(id, Integer.parseInt(cantidad), Double.parseDouble(precio), idFactura);
            }

            // Calcula el cambio y agrega la información a los txt
            String totalNetoFormat = dm.format(totalNeto);
            JOptionPane.showMessageDialog(null, "Total a pagar: " + totalNetoFormat + " Lempiras");

            double cantidadPagada = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad que se le pagó."));
            double vuelto = 0;

            // Verifica si se pagó lo suficiente o no y calcula el cambio o el dinero faltante
            if (cantidadPagada > totalNeto) {
                vuelto = cantidadPagada - totalNeto;
                JOptionPane.showMessageDialog(null, "Cambio: " + dm.format(vuelto));
            } else if (cantidadPagada != totalNeto) {
                vuelto = (cantidadPagada - totalNeto);
                JOptionPane.showMessageDialog(null, "Cantidad pagada insuficiente, faltan: " + dm.format(vuelto * -1) + " lempiras");
            }

            // Añade los txt
            String cantidadPagadaFormat = dm.format(cantidadPagada);
            String vueltoFormat = dm.format(vuelto);
            txtCambio.setText(vueltoFormat);
            txtTotal.setText(totalNetoFormat);
            txtPagado.setText(cantidadPagadaFormat);

            // Añade los datos del cambio y total al PDF
            Font fontTotalDoc = new Font(Font.FontFamily.HELVETICA, 8);
            Font fontCambio = new Font(Font.FontFamily.HELVETICA, 8);
            Font fontCanPag = new Font(Font.FontFamily.HELVETICA, 8);
            Font fontFecha = new Font(Font.FontFamily.HELVETICA, 8);
            Font fontCajero = new Font(Font.FontFamily.HELVETICA, 8);

            Paragraph totalDoc = new Paragraph();
            totalDoc.add(new Chunk("Total a pagar: ", fontTotalDoc));
            totalDoc.add(new Chunk(totalNetoFormat, FontFactory.getFont(FontFactory.HELVETICA_BOLD, 8)));
            totalDoc.setAlignment(Paragraph.ALIGN_RIGHT);

            Paragraph cambio = new Paragraph();
            cambio.add(new Chunk("Cambio: ", fontCambio));
            cambio.add(new Chunk(vueltoFormat, FontFactory.getFont(FontFactory.HELVETICA_BOLD, 8)));
            cambio.setAlignment(Paragraph.ALIGN_RIGHT);

            Paragraph canPag = new Paragraph();
            canPag.add(new Chunk("Cantidad pagada: ", fontCanPag));
            canPag.add(new Chunk(cantidadPagadaFormat, FontFactory.getFont(FontFactory.HELVETICA_BOLD, 8)));
            canPag.setAlignment(Paragraph.ALIGN_RIGHT);

            documento.add(tablaDoc);
            documento.add(totalDoc);
            documento.add(canPag);
            documento.add(cambio);

            // Cierra el documento
            documento.close();

            // Imprime la factura si el usuario lo desea
            abrirDocumento(filePath);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(factura.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al generar la factura: " + ex.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (DocumentException ex) {
            Logger.getLogger(factura.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al generar la factura: " + ex.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        return 0;
    }

    public static void cambiarEstadoFactura(boolean estado, String facId) {
        try {
            factura f = new factura();
            factura.con(); // Establecer la conexión
            String sql = "CALL ActualizarEstado(?,?);";
            ps = conn.prepareStatement(sql);
            ps.setBoolean(1, estado);
            ps.setString(2, facId);
            int res = ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se actualizó el estado con éxito.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el  estado: " + ex.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(factura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
