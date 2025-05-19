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
import java.util.*;
import java.util.logging.Logger;

public class action {
    Connection con;
    SehidupSesaldo frame;
    
    final String select = "SELECT * FROM catatan ORDER BY tanggal ASC";
    final String insert = "INSERT INTO catatan (tanggal, jenis, nominal, keterangan, kategori) VALUES (?, ?, ?, ?, ?)";
    final String update = "UPDATE catatan SET tanggal=?, jenis=?, nominal = ?, keterangan=?, kategori=? WHERE id = ?";
    final String delete = "DELETE FROM catatan WHERE id=?";
    
    public action(){
        con = koneksi.connection();
    }
    
    public List<Object[]>getAll() {
        List<Object[]> data = new ArrayList<>();
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                Object[] row = new Object[6];
                row[0] = rs.getInt("id");
                row[1] = rs.getString("tanggal");
                row[2] = rs.getString("jenis");
                row[3] = rs.getInt("nominal");
                row[4] = rs.getString("keterangan");
                row[5] = rs.getString("kategori");
                data.add(row);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return data;
    }
    
    public void saveData(Integer id, String tanggal, String jenis, int nominal, String keterangan, String kategori){
        PreparedStatement statement = null;
        try {
            String sql = (id == null) ? insert : update;
            statement = con.prepareStatement(sql);
            statement.setString(1, tanggal);
            statement.setString(2, jenis);
            statement.setInt(3, nominal);
            statement.setString(4, keterangan);
            statement.setString(5, kategori);
            
            if (id != null) {
                statement.setInt(6, id);
            }
            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void deleteData(int id){
        PreparedStatement statement = null;
        try{
            statement = con.prepareStatement(delete);
            statement.setInt(1, id);
            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
