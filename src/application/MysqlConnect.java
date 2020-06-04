package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.PreparedStatement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;


public class MysqlConnect {

	static Connection conn=null;
    public static Connection ConnectDb(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/stajtakip","root","");
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Connection Established");
            alert.showAndWait();
            return conn;
        } catch (Exception e) {
        	 Alert alert=new Alert(Alert.AlertType.ERROR);
        	 alert.setContentText("Baglanti Hatasi...");
            return null;
        }  
    }
    public static ObservableList<OgrKayitt> getDatausers(){
    	conn=MysqlConnect.ConnectDb();
        ObservableList<OgrKayitt> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = (PreparedStatement) conn.prepareStatement("select * from ogrKayit");
            ResultSet result = ps.executeQuery();
            
            while (result.next()){   
                list.add(new OgrKayitt(Integer.parseInt(result.getString("user_id")), result.getString("username"), result.getString("surname"), result.getString("email"), result.getString("ogrno"),result.getString("sýnýf"),result.getString("cinsiyet"),result.getString("stajOnay"),result.getString("Bolum"),result.getString("Fakulte")));               
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    
    public static ObservableList<StajBilgi> getDataStaj(){
    	conn=MysqlConnect.ConnectDb();
        ObservableList<StajBilgi> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = (PreparedStatement) conn.prepareStatement("select * from stajDefteri");
            ResultSet result = ps.executeQuery();
            
            while (result.next()){   
                list.add(new StajBilgi(result.getInt("date"),result.getString("Gunluk"),result.getInt("OgrNo")));            
            }
        } catch (Exception e) {
        }
        return list;
    }
	}
 
