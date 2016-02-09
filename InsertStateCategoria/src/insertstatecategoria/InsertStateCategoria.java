/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insertstatecategoria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Dxracso
 */
public class InsertStateCategoria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws SQLException{
         Connection connect=null;
        Statement sentencia=null;
        
        String servidorDB="jdbc:mysql://localhost:3306/online_shop";
        String userDB="root";
        String passwordDB="40431002";
        String id=JOptionPane.showInputDialog("Digite id del producto");
        String nombre=JOptionPane.showInputDialog("Digite nombre del producto");
        String activo=JOptionPane.showInputDialog("Digite 0 si No esta activo y 1 si esta activo");
        String catalogoIdCatalogo=JOptionPane.showInputDialog("Digite el id del catalogo superior");
        
        
        String sql="insert into online_shop.categoria values('"
                +id+"','"+nombre+"','"+activo+"','"+catalogoIdCatalogo+"');";
        
        try {
            connect=DriverManager.getConnection(servidorDB, userDB, passwordDB);
            sentencia=connect.createStatement();
            int resultado=sentencia.executeUpdate(sql);
            if (resultado==1) {
                System.out.println("Se inserto");
            }else{
                System.out.println("No se pudo insertar");
            }
            
            
        } catch (SQLException e) {
            System.out.println(e.toString());
        }finally{

            if (sentencia != null) {
                sentencia.close();
                System.out.println("se cerro sentencia");
            }
            if (connect != null) {
                connect.close();
                System.out.println("Se cerro coneccion");
            }
        }

    }
}