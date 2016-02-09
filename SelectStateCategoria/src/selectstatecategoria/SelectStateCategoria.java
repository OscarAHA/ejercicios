/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selectstatecategoria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Dxracso
 */
public class SelectStateCategoria {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        Connection coneccion = null;
        Statement sentencia = null;
        ResultSet rs = null;

        String servidor = "jdbc:mysql://localhost:3306/online_shop";
        String usuario = "root";
        String password = "40431002";
        
        
        String var=JOptionPane.showInputDialog("Indigite id catalogo a buscar");
        String sql = "SELECT * FROM online_shop.categoria where id_categoria = "+var+";";
        try {
            coneccion = DriverManager.getConnection(servidor, usuario, password);

            sentencia = coneccion.createStatement();
            rs = sentencia.executeQuery(sql);

            if (rs != null) {
                while (rs.next()) {
                    System.out.println("ID_CATEGORIA\t" + rs.getString("ID_CATEGORIA"));
                    System.out.println("NOMBRE\t" + rs.getString("NOMBRE"));
                    System.out.println("ACTIVA\t" + rs.getString("ACTIVA"));
                    System.out.println("CATEGORIA_ID_CATEGORIA\t" + rs.getString("CATEGORIA_ID_CATEGORIA"));
                    System.out.println("*************************************");
                }

            } else {
                System.out.println("No hay datos par mostrar");
            }

        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            if (rs != null) {
                rs.close();
                System.out.println("Se cerro RS");
            }
            if (sentencia != null) {
                sentencia.close();
                System.out.println("se cerro sentencia");
            }
            if (coneccion != null) {
                coneccion.close();
                System.out.println("Se cerro coneccion");
            }
        }

    }

}
