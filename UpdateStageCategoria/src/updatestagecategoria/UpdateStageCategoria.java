/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package updatestagecategoria;


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
public class UpdateStageCategoria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException{
      
        Connection connect=null;
        Statement sentencia=null;
        //ResultSet rs=null;
        
        String servidorDB="jdbc:mysql://localhost:3306/online_shop";
        String userDB="root";
        String passwordDB="40431002";
        String var=JOptionPane.showInputDialog("Digite id a actualizar");
        String nNombre=JOptionPane.showInputDialog("Digite nuebo nombre");
        
        String sql="update online_shop.categoria \n" +
                    "set NOMBRE ='"+nNombre+"'  where ID_CATEGORIA = '"+var+"';";
        
        try {
            connect=DriverManager.getConnection(servidorDB, userDB, passwordDB);
            sentencia=connect.createStatement();
            int resultado=sentencia.executeUpdate(sql);
            if (resultado==1) {
                System.out.println("Se actualizo el campo");
            }else{
                System.out.println("No se pudo actualizar el campo");
            }
            
            
        } catch (SQLException e) {
            System.out.println(e.toString());
        }finally{
//            if (rs != null) {
//                rs.close();
//                System.out.println("Se cerro RS");
//            }
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
