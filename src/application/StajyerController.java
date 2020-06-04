package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class StajyerController implements Initializable {

	
	@FXML
    private AnchorPane pane_login;

    @FXML
    private TextField txt_username;

    @FXML
    private PasswordField txt_password;

    @FXML
    private ComboBox type;

    @FXML
    private Button btn_login,btn_ogr,btn_adm,btn_firma;

    @FXML
    private AnchorPane pane_signup;

    @FXML
    private TextField txt_username_up;

    @FXML
    private TextField txt_password_up;

    @FXML
    private TextField email_up;

    @FXML
    private ComboBox type_up;
    
  
    Connection conn=null;
    ResultSet rst=null;
    PreparedStatement pst=null;
    
    
    public void LoginpaneShow() {
    	pane_login.setVisible(true);
    	pane_signup.setVisible(false);
    }
    
    public void SignuppaneShow() {
    	pane_login.setVisible(false);
    	pane_signup.setVisible(true);
    }
    
    
    @FXML
    private void Login (ActionEvent event)throws Exception {
    	conn=MysqlConnect.ConnectDb();
    	String sql="Select * from users where userName = ? and password = ? and type = ?";
    	try {
    		pst=conn.prepareStatement(sql);
    		pst.setString(1, txt_username.getText());
    		pst.setString(2, txt_password.getText());
    		pst.setString(3, type.getValue().toString());
    		if(type.getValue()=="Ogretmen") {
    			rst=pst.executeQuery();
    		
    		
    		if(rst.next()) {
    			Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Ogretmen sisteme giris islemi");
                alert.setContentText("Bilgiler dogru.Baglanti kuruluyor");
                alert.showAndWait();
    			btn_login.getScene().getWindow().hide();
    			AnchorPane root=FXMLLoader.load(getClass().getResource("Ogretmen.fxml"));
    			Stage mainStage=new Stage();
    			Scene scene=new Scene(root);
    			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    			mainStage.setScene(scene);
    			mainStage.show();
    		}	
    		}else {
    			Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Ogretmen sisteme giris islemi");
                alert.setContentText("Kullanici adi veya sifre hatali...");
                alert.showAndWait();
    		}
    	}catch(Exception e) {
    		System.out.println(e);
    	}
    }
    
    @FXML
    private void Ogrenci (ActionEvent event)throws Exception {
    	conn=MysqlConnect.ConnectDb();
    	String sql="Select * from users where userName = ? and password = ? and type = ?";
    	try {
    		pst=conn.prepareStatement(sql);
    		pst.setString(1, txt_username.getText());
    		pst.setString(2, txt_password.getText());
    		pst.setString(3, type.getValue().toString());
    		if(type.getValue()=="Ogrenci") {
    			rst=pst.executeQuery();
    		
    		
    		if(rst.next()) {
    			Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Ogrenci sisteme giris islemi");
                alert.setContentText("Bilgiler dogru.Baglanti kuruluyor");
                alert.showAndWait();
                
    			btn_ogr.getScene().getWindow().hide();
    			Parent root=FXMLLoader.load(getClass().getResource("Ogrenci.fxml"));
    			Stage mainStage=new Stage();
    			Scene scene=new Scene(root);
    			mainStage.setScene(scene);
    			mainStage.show();
    		}	
    		}else {
    			Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Ogrenci sisteme giris islemi");
                alert.setContentText("Kullanici adi veya sifre hatali...");
                alert.showAndWait();
    		}
    	}catch(Exception e) {
    		System.out.println(e);
    	}
    }
    
    
    @FXML
    private void Admin (ActionEvent event)throws Exception {
    	conn=MysqlConnect.ConnectDb();
    	String sql="Select * from users where userName = ? and password = ? and type = ?";
    	try {
    		pst=conn.prepareStatement(sql);
    		pst.setString(1, txt_username.getText());
    		pst.setString(2, txt_password.getText());
    		pst.setString(3, type.getValue().toString());
    		if(type.getValue()=="Admin") {
    			rst=pst.executeQuery();
    		
    		
    		if(rst.next()) {
    			Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Admin sisteme giris islemi");
                alert.setContentText("Bilgiler dogru.Baglanti kuruluyor");
                alert.showAndWait();
    			btn_adm.getScene().getWindow().hide();
    			Parent root=FXMLLoader.load(getClass().getResource("Admin.fxml"));
    			Stage mainStage=new Stage();
    			Scene scene=new Scene(root);
    			mainStage.setScene(scene);
    			mainStage.show();
    		}	
    		}else {
    			Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Admin sisteme giris islemi");
                alert.setContentText("Kullanici adi veya sifre hatali...");
                alert.showAndWait();
    		}
    	}catch(Exception e) {
    		System.out.println(e);
    	}
    }
    
    @FXML
    void FirmaGiris(ActionEvent event) {
    	conn=MysqlConnect.ConnectDb();
    	String sql="Select * from users where userName = ? and password = ? and type = ?";
    	try {
    		pst=conn.prepareStatement(sql);
    		pst.setString(1, txt_username.getText());
    		pst.setString(2, txt_password.getText());
    		pst.setString(3, type.getValue().toString());
    		if(type.getValue()=="Firma") {
    			rst=pst.executeQuery();
    		
    		
    		if(rst.next()) {
    			Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Firma giris islemi");
                alert.setContentText("Bilgiler dogru.Baglanti kuruluyor");
                alert.showAndWait();
    			btn_firma.getScene().getWindow().hide();
    			Parent root=FXMLLoader.load(getClass().getResource("firma.fxml"));
    			Stage mainStage=new Stage();
    			Scene scene=new Scene(root);
    			mainStage.setScene(scene);
    			mainStage.show();
    		}	
    		}else {
    			Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Firma giris islemi");
                alert.setContentText("Kullanici adi veya sifre hatali...");
                alert.showAndWait();
    		}
    	}catch(Exception e) {
    		System.out.println(e);
    	}
    }
    
    @FXML
    public void add_users(ActionEvent event) {
    	conn=MysqlConnect.ConnectDb();
    	String sql="insert into users(username,password,type,email) values (?,?,?,?)";
    	try {
    		pst=conn.prepareStatement(sql);
    		pst.setString(1, txt_username_up.getText());
    		pst.setString(2, txt_password_up.getText());
    		pst.setString(3, type_up.getValue().toString());
    		pst.setString(4, email_up.getText());
    		pst.execute();
    		Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Ogrenci Ekleme");
            alert.setContentText("Kaydedildi...");
            alert.showAndWait();
    	}catch(Exception e) {
    		
    		System.out.println(e);
    	}
    }
    
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		type_up.getItems().addAll("Admin","Ogretmen","Ogrenci","Firma");
		type.getItems().addAll("Admin","Ogretmen","Ogrenci","Firma");
	}
	
}
