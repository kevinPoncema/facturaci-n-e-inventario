/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//esta calse gestionara la logica del producto 
package inventario;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class productos {

    //atributos de la clase
    public String nombre;
    public String marca;
    public double precio = 0;
    public double costo = 0;
    public int id;
    //variables para gestionar la conexion a dbb
    //1.Primero se crea la variable de conección
    private static Connection conn;
    //2.Se crea la variable para manipular los datos
    static PreparedStatement ps;
    //una variable vara almacenar los resultados de las consultas
    static ResultSet rs;
    static ResultSetMetaData rsm;

    //funcion para establecer conexion
    void con() throws SQLException {

        conn = DriverManager.getConnection(conexionConfig.host
                + "?useUnicode=true&useJDBCCompliantTimezonesShift="
                + "true&useLegacyDatetimeCode=false&serverTimezone=UTC", conexionConfig.user, conexionConfig.pass);
    }
//metodo para borrar un producto de la base de datos

    public static void borrarProducto(int id) {
        try {
            // Instanciar un objeto de la clase productos para acceder al método con()
            productos p = new productos();
            p.con(); // Llamar al método con() para establecer la conexión
            String sql = "DELETE FROM productos WHERE id = ?";
            // Preparar la sentencia SQL
            productos.ps = conn.prepareStatement(sql);
            // Establecer el valor del parámetro (ID)
            productos.ps.setInt(1, id);
            // Ejecutar la consulta DELETE
            int res = ps.executeUpdate();
            // Mostrar mensaje con JOptionPane
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Se ha eliminado el producto con éxito.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningún producto con el ID proporcionado.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al eliminar el producto. " + e, "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    //metodo para actualizar un producto

    public static void actualizar(int id, String nombre, String marca, double precio, double costo, Component parentComponent) {
        try {
            // Instanciar un objeto de la clase productos para acceder al método con()
            productos p = new productos();
            p.con(); // Llamar al método con() para establecer la conexión
            // Consulta SQL DELETE con un parámetro
            String sql = "UPDATE productos SET nombre = ?, marca = ?, costo_predeterminado = ?, precio_predeterminado = ? WHERE id = ?";
            // Preparar la sentencia SQL
            productos.ps = conn.prepareStatement(sql);
            // Establecer el valor de los parametros
            productos.ps.setString(1, nombre);
            productos.ps.setString(2, marca);
            productos.ps.setDouble(3, costo);
            productos.ps.setDouble(4, precio);
            productos.ps.setInt(5, id);
            // Ejecutar la consulta DELETE
            int res = ps.executeUpdate();
            // Mostrar mensaje con JOptionPane
            if (res > 0) {
                JOptionPane.showMessageDialog(parentComponent, "Se ha actualizado el producto con éxito. ");
            } else {
                JOptionPane.showMessageDialog(parentComponent, "No se encontró ningún producto con el ID proporcionado.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(parentComponent, "Error al actualizar el producto.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    //metodo para agragar un producto
    public static void agregarProducto(String nombre, String marca, double precio, double costo, Component parentComponent) {
        try {
            // Instanciar un objeto de la clase productos para acceder al método con()
            productos p = new productos();
            p.con(); // Llamar al método con() para establecer la conexión
            // Consulta SQL DELETE con un parámetro
            String sql = "INSERT INTO productos(nombre,marca,costo_predeterminado,precio_predeterminado) VALUE(?,?,?,?);";
            // Preparar la sentencia SQL
            productos.ps = conn.prepareStatement(sql);
            // Establecer el valor de los parametros
            productos.ps.setString(1, nombre);
            productos.ps.setString(2, marca);
            productos.ps.setDouble(3, costo);
            productos.ps.setDouble(4, precio);
            // Ejecutar la consulta DELETE
            int res = ps.executeUpdate();
            // Mostrar mensaje con JOptionPane
            if (res > 0) {
                JOptionPane.showMessageDialog(parentComponent, "Se ha agregado el producto con éxito. ");
            } else {
                JOptionPane.showMessageDialog(parentComponent, "No se encontró ningún producto con el ID proporcionado.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(parentComponent, "Error al agregar el producto.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    //metodo para buscar un producto de la base de datos por su id
    public static productos buscarPorId(int id) {
        try {
            // Instanciar un objeto de la clase productos para acceder al método con()
            productos p = new productos();
            p.con(); // Llamar al método con() para establecer la conexión
            // Consulta SQL DELETE con un parámetro
            String sql = "SELECT * FROM productos WHERE id = ?;";
            // Preparar la sentencia SQL
            productos.ps = conn.prepareStatement(sql);
            // Establecer el valor del parámetro (ID)
            productos.ps.setInt(1, id);
            // Ejecutar la consulta DELETE
            productos.rs = ps.executeQuery();
            // Mostrar mensaje con JOptionPane
            if (productos.rs.next()) {
                p.nombre = productos.rs.getString("nombre");
                p.marca = productos.rs.getString("marca");
                p.id = productos.rs.getInt("id");
                p.costo = productos.rs.getDouble("costo_predeterminado");
                p.precio = productos.rs.getDouble("precio_predeterminado");
                return p;
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningún producto con el ID proporcionado.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al buscar el producto.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    //metodo que busca productos  por nombre  y coloca los resultados en un un combobox
    public static ArrayList<Integer> buscarPorNombre(String nombre, DefaultComboBoxModel model, Component parentComponent) {
        try {
            ArrayList<Integer> alist = new ArrayList();
            model.removeAllElements();
            nombre = "%" + nombre + "%";
            // Instanciar un objeto de la clase productos para acceder al método con()
            productos p = new productos();
            p.con(); // Llamar al método con() para establecer la conexión
            String sql = "SELECT id,nombre from productos  WHERE nombre LIKE ?;";
            // Preparar la sentencia SQL
            productos.ps = conn.prepareStatement(sql);
            // Establecer el valor del parámetro (ID)
            productos.ps.setString(1, nombre);
            // Ejecutar la consulta DELETE
            productos.rs = ps.executeQuery();
            boolean hayResultados = false;
            model.addElement("Resultados");
            while (productos.rs.next()) {
                model.addElement(productos.rs.getString("nombre"));
                alist.add(productos.rs.getInt("id"));
                hayResultados = true;
            }

            if (!hayResultados) {
                JOptionPane.showMessageDialog(parentComponent, "No se encontró ningún producto que consida con el parametro.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }

            return alist;
        } catch (SQLException ex) {
            Logger.getLogger(productos.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error de base de datos. " + ex, "Error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (java.lang.NumberFormatException ex) {
            JOptionPane.showMessageDialog(parentComponent, "No se admiten letras en la búsqueda por ID.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    //metodo que busca un producto por id y recive los JTextField para colocar los datos
    public static void buscarPorId(int id, Component parentComponent, JTextField idTxt,
            JTextField nomTxt, JTextField marTxt, JTextField preTxt, JTextField cosTxt) {
        try {
            // Instanciar un objeto de la clase productos para acceder al método con()
            productos p = new productos();
            p.con(); // Llamar al método con() para establecer la conexión
            // Consulta SQL DELETE con un parámetro
            String sql = "SELECT * FROM productos WHERE id = ?;";
            // Preparar la sentencia SQL
            productos.ps = conn.prepareStatement(sql);
            // Establecer el valor del parámetro (ID)
            productos.ps.setInt(1, id);
            // Ejecutar la consulta DELETE
            productos.rs = ps.executeQuery();
            // Mostrar mensaje con JOptionPane
            if (productos.rs.next()) {
                DecimalFormat dm = new DecimalFormat("#,##0.##");
                nomTxt.setText(productos.rs.getString("nombre"));
                marTxt.setText(productos.rs.getString("marca"));
                idTxt.setText(Integer.toString(productos.rs.getInt("id")));
                cosTxt.setText(dm.format(productos.rs.getDouble("costo_predeterminado")));
                preTxt.setText(dm.format(productos.rs.getDouble("precio_predeterminado")));
            } else {
                JOptionPane.showMessageDialog(parentComponent, "No se encontró ningún producto con el ID proporcionado.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(parentComponent, "Error al buscar el producto.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (java.lang.NumberFormatException ex) {
            JOptionPane.showMessageDialog(parentComponent, "No se admiten letras en la búsqueda por ID.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    //metodo que busca productos  por marca  y coloca los resultados en un un combobox
    public static ArrayList<Integer> buscarPorMarca(String marca, DefaultComboBoxModel model, Component parentComponent) {
        try {
            ArrayList<Integer> alist = new ArrayList();
            model.removeAllElements();
            marca = "%" + marca + "%";
            // Instanciar un objeto de la clase productos para acceder al método con()
            productos p = new productos();
            p.con(); // Llamar al método con() para establecer la conexión
            String sql = "SELECT id,nombre from productos  WHERE marca LIKE ?;";
            // Preparar la sentencia SQL
            productos.ps = conn.prepareStatement(sql);
            // Establecer el valor del parámetro (ID)
            productos.ps.setString(1, marca);
            // Ejecutar la consulta DELETE
            productos.rs = ps.executeQuery();
            boolean hayResultados = false;
            model.addElement("Resultados");
            while (productos.rs.next()) {
                model.addElement(productos.rs.getString("nombre"));
                alist.add(productos.rs.getInt("id"));
                hayResultados = true;
            }
            if (!hayResultados) {
                JOptionPane.showMessageDialog(parentComponent, "No se encontró ningún producto que consida con el parametro.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
            return alist;
        } catch (SQLException ex) {
            Logger.getLogger(productos.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error de base de datos. " + ex, "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    //obtiene solo el nombre de un producto por su id
    public static void buscarPorId(int id, Component parentComponent, JTextField idTxt,
            JTextField nomTxt) {
        try {
            // Instanciar un objeto de la clase productos para acceder al método con()
            productos p = new productos();
            p.con(); // Llamar al método con() para establecer la conexión
            // Consulta SQL DELETE con un parámetro
            String sql = "SELECT nombre FROM productos WHERE id = ?;";
            // Preparar la sentencia SQL
            productos.ps = conn.prepareStatement(sql);
            // Establecer el valor del parámetro (ID)
            productos.ps.setInt(1, id);
            // Ejecutar la consulta DELETE
            productos.rs = ps.executeQuery();
            // Mostrar mensaje con JOptionPane
            if (productos.rs.next()) {
                nomTxt.setText(productos.rs.getString("nombre"));
                idTxt.setText(Integer.toString(id));
            } else {
                JOptionPane.showMessageDialog(parentComponent, "No se encontró ningún producto con el ID proporcionado.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(parentComponent, "Error al buscar el producto.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (java.lang.NumberFormatException ex) {
            JOptionPane.showMessageDialog(parentComponent, "No se admiten letras en la búsqueda por ID.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
