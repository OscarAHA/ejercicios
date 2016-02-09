/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cosenojdbc1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Dxracso
 */
public class CosenoJDBC1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException{
  Connection conexion = null;
        String servidor = "jdbc:mysql://localhost:3306/online_shop";
        String usuarioDB = "root";
        String passwordDB = "40431002";
        CallableStatement sentencia = null;
        ResultSet rs  =null;
        String sql = "select cos(?);";

        System.out.println(sql);
        int var=Integer.parseInt(JOptionPane.showInputDialog("Digite el valos a sacar coseno"));


        try {
            conexion = DriverManager.getConnection(servidor, usuarioDB, passwordDB);
            System.out.println("se conecto");

            sentencia = conexion.prepareCall(sql);
            sentencia.setInt(1, var);
            
            System.out.println("sentencia ejecutada " + sql );

            boolean resultado = sentencia.execute();

            rs = sentencia.getResultSet();
            
            if (!rs.wasNull()) {

                  
                    while (rs.next() == true) {
                        System.out.print(rs.getString(1)+"\t");
                        
                    }
            }
            
            

        } catch (SQLException e) {
            System.err.println("error: " + e.toString());
        } finally {
            System.out.println("");
 
            if (sentencia != null) {
                sentencia.close();
                System.out.println("se cerro el statement");
            }


            if (conexion != null) {
                conexion.close();
                System.out.println("se cerro la conexion");
            }
        }
    }
}
  
