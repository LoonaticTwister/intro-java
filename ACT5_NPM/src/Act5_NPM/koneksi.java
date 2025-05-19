/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Act5_NPM;

/**
 *
 * @author BAYU
 */
import java.sql.*;

public class koneksi {
    static Connection con;
    
    public static Connection connection(){
        try{
            String url = "jdbc:mysql://localhost:2526/sehidup_sesaldo_npm";
            String user = "root";
            String pw = "";
                
            con = DriverManager.getConnection(url,user,pw);
            System.out.println("Berhasil Konek");
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return con;
    }
    
    public static void main(String[] args){
        connection();
    }
}
