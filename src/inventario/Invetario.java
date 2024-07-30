/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventario;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import static inventario.productos.ps;
import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author kd462
 */
public class Invetario {

    //atributos de la clase
    String nombre;
    String marca;
    double precio = 0;
    double costo = 0;
    int id;
    //variables para gestionar la conexion a dbb
    //1.Primero se crea la variable de conección
    private static Connection conn;
    //2.Se crea la variable para manipular los datos
    static PreparedStatement ps;
    //una variable vara almacenar los resultados de las consultas
    static ResultSet rs;
    static ResultSetMetaData rsm;

    //funcion para establecer conexion
    private void con() throws SQLException {

        conn = DriverManager.getConnection(conexionConfig.host
                + "?useUnicode=true&useJDBCCompliantTimezonesShift="
                + "true&useLegacyDatetimeCode=false&serverTimezone=UTC", conexionConfig.user, conexionConfig.pass);
    }

    //funcion para  agregar productos al inventario
    public static void ingresoInvetario(int id, double costo, int ingreso, Component parentComponent, double cu) {
        try {
            // Instanciar un objeto de la clase productos para acceder al método con()
            Invetario p = new Invetario();
            p.con(); // Llamar al método con() para establecer la conexión
            String sql = "INSERT INTO inventario (producto_id,costo,ingreso,costo_unitario)VALUE(?,?,?,?);";
            // Preparar la sentencia SQL
            Invetario.ps = conn.prepareStatement(sql);
            // Establecer el valor del parámetro (ID)
            Invetario.ps.setInt(1, id);
            Invetario.ps.setDouble(2, costo);
            Invetario.ps.setInt(3, ingreso);
            Invetario.ps.setDouble(4, cu);

            // Ejecutar la consulta DELETE
            int res = ps.executeUpdate();
            // Mostrar mensaje con JOptionPane
            if (res > 0) {
                JOptionPane.showMessageDialog(parentComponent, "Se han agregado productos al inventario con éxito.");
            } else {
                JOptionPane.showMessageDialog(parentComponent, "No se encontró ningún producto con el ID proporcionado.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(parentComponent, "Error al agregar el producto al inventario."+e, "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    //funcion para obtener los productos restrantes 
    public static String[] obtenerRestantes(int id) {
        String[] etiquetas = new String[2]; // Array para almacenar los valores a devolver
        try {
            // Instanciar un objeto de la clase Invetario para acceder al método con()
            Invetario p = new Invetario();
            p.con(); // Llamar al método con() para establecer la conexión
            // Consulta SQL llamando al procedimiento almacenado con un parámetro
            String sql = "CALL obtener_invetario(?);";
            // Preparar la sentencia SQL
            Invetario.ps = conn.prepareStatement(sql);
            // Establecer el valor del parámetro (ID)
            Invetario.ps.setInt(1, id);
            // Ejecutar la consulta
            Invetario.rs = ps.executeQuery();
            // Mostrar mensaje con JOptionPane
            if (Invetario.rs.next()) {
                DecimalFormat dm = new DecimalFormat("#,##0.##");
                String totalCosto = dm.format(Invetario.rs.getDouble("total_costo"));
                String restantes = dm.format(Invetario.rs.getDouble("total_restante"));
                etiquetas[0] = restantes;
                etiquetas[1] = totalCosto;
            } else {
                JOptionPane.showMessageDialog(null, "No se  encontraron datos en el inventario para este producto.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al obtener los valores del inventario.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        return etiquetas;
    }

    //funcion que retira productos del inventario
    public static void egresoInvetario(int id, int egreso) {
        try {
            String[] e = Invetario.obtenerRestantes(id);
            int canInve = Integer.parseInt(e[0]);
            if (canInve >= egreso) {
                // Instanciar un objeto de la clase productos para acceder al método con()
                Invetario p = new Invetario();
                p.con(); // Llamar al método con() para establecer la conexión
                String sql = "INSERT INTO inventario (producto_id,egreso)VALUE(?,?);";
                // Preparar la sentencia SQL
                Invetario.ps = conn.prepareStatement(sql);
                // Establecer el valor del parámetro (ID)
                Invetario.ps.setInt(1, id);
                Invetario.ps.setInt(2, egreso);

                // Ejecutar la consulta DELETE
                int res = ps.executeUpdate();
                // Mostrar mensaje con JOptionPane
                if (res < 0) {
                    JOptionPane.showMessageDialog(null, "No se encontró ningún producto con el ID proporcionado.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Se retiró con éxito.");
                }
            }else{
                 JOptionPane.showMessageDialog(null, "La cantidad que desea eliminar es menor que la del inventario  "
                         + "\ncantidad actual = "+canInve, "Error",
                    JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al eliminar el producto del inventario", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
