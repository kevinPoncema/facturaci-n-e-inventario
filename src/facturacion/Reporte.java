/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facturacion;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import static facturacion.factura.obtenerDirectorioSeleccionado;
import inventario.conexionConfig;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Reporte {

    // Variables para gestionar la conexión a la base de datos
    private static Connection conn;
    static PreparedStatement ps;
    static ResultSet rs;
    static ResultSetMetaData rsm;

    // Función para establecer la conexión
    private static void con() throws SQLException {
        conn = DriverManager.getConnection(conexionConfig.host
                + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                conexionConfig.user, conexionConfig.pass);
    }

    // Método que devuelve un objeto con los datos del reporte general
    public static String[] reporteGenera(int i) {
        try {
            String[] etiquetas = new String[3]; // Array para almacenar los valores a devolver
            con(); // Establecer la conexión

            String sql = "";
            //genera un reporte diario o mensual dependiendo del indice recivido 
            switch (i) {
                case 0:
                    sql = "CALL `obtener-rendimiento-mes`();";
                    break;
                case 1:
                    sql = "CALL `obtener-rendimiento-diario`();";
                    break;
            }

            // Crear el PreparedStatement
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            // Mostrar mensaje con JOptionPane si no hay resultados
            if (rs.next()) {
                DecimalFormat dm = new DecimalFormat("#,##0.##");
                //devulve un arreglo con los datos
                String totalCosto = dm.format(rs.getDouble("GastosTotales"));
                String gananciasTotales = dm.format(rs.getDouble("GananciaVentas"));
                String GananciaReales = dm.format(rs.getDouble("GananciaReales"));
                etiquetas[0] = totalCosto;
                etiquetas[1] = gananciasTotales;
                etiquetas[2] = GananciaReales;
                return etiquetas;
            } else {
                JOptionPane.showMessageDialog(null, "Insuficientes datos para generar el informe.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al generar el reporte." + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        } finally {
            //cierra la secion
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }
//genera el reporte por producro

    public static void reporteProProducto() throws DocumentException {
        try {
            String filePath = factura.obtenerDirectorioSeleccionado() + File.separator + "reporte.pdf";
            JOptionPane.showMessageDialog(null, "la generación del informe podría tomar varios segundos o minutos.");
            System.out.println("hora 1: " + LocalDateTime.now().toString());
            String[] etiquetas = new String[2]; // Array para almacenar los valores a devolver
            con(); // Establecer la conexión
            String sql = "CALL `reporte-xproducto-mensual`();";
            // Crear el PreparedStatement
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            //crear el documento 
            Document documento = new Document();
            PdfWriter.getInstance(documento, new FileOutputStream(filePath));
            documento.open();
            Paragraph title = new Paragraph("Reporte por producto");
            title.setAlignment(Paragraph.ALIGN_CENTER);
            title.setSpacingAfter(15);
            documento.add(title);
            //crea los campos de la tabla
            PdfPTable tablaDoc = new PdfPTable(4);
            tablaDoc.addCell("producto");
            tablaDoc.addCell("ventas");
            tablaDoc.addCell("gastos");
            tablaDoc.addCell("restantes");
            //recorer los resultados y agregarlos en la tabla 
            if (rs.next()) { // Verificar si hay resultados antes de empezar a recorrer el ResultSet
                do {
                    String producto = rs.getString("NombreProducto");
                    String ventas = Double.toString(rs.getDouble("GananciaVentas"));
                    String gastos = Double.toString(rs.getDouble("CostoTotal"));
                    String cantidad = Integer.toString(rs.getInt("CantidadRestante"));
                    tablaDoc.addCell(producto);
                    tablaDoc.addCell(ventas);
                    tablaDoc.addCell(gastos);
                    tablaDoc.addCell(cantidad);
                } while (rs.next());
            } else {
                // No hay resultados en el ResultSet
                JOptionPane.showMessageDialog(null, "No hay datos para generar el reporte", "Sin resultados",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            //agrega la tabla y cierra el documento para que se pueda leer
            documento.add(tablaDoc);
            documento.close();
            // System.out.println("hora 2: "+LocalDateTime.now().toString());
            JOptionPane.showMessageDialog(null, "Se ha completado la generación del reporte");
             factura.abrirDocumento(filePath);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al generar el reporte: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al generar el reporte: " + ex.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

}
