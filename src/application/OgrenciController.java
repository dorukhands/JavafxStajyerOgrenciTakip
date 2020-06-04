package application;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class OgrenciController extends AdminController implements Initializable{

	
    @FXML
    protected TextField ogr;

    @FXML
    protected TextArea not;

    @FXML
    protected TextField tarih;
    
    @FXML
    private Button frmMail;


    static Connection conn=null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    @FXML
    void AdmineGonder(ActionEvent event) {
    	conn=(Connection) MysqlConnect.ConnectDb();
        String sql = "insert into stajDefteri (Gunluk,date,OgrNo)values(?,?,?)";
        try {
            pst = (PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, not.getText());
            pst.setString(2, tarih.getText());
            pst.setString(3, ogr.getText());
            pst.execute();
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Bilgi Teslim.");
            alert.setContentText("Bilgiler basarili bir sekilde iletildi...");
            alert.showAndWait();
         
        }catch (Exception e) {
        	   Alert alert=new Alert(Alert.AlertType.ERROR);
               alert.setHeaderText("Bilgi Hata.");
               alert.setContentText("Bilgiler iletilirken hata olustu...");
               alert.showAndWait();
        }
        
    }
    
    @FXML
    void SendMail(ActionEvent event){
    	frmMail.getScene().getWindow().hide();
    	AnchorPane root;
		try {
			root = FXMLLoader.load(getClass().getResource("Firma.fxml"));
			Stage mainStage=new Stage();
			Scene scene=new Scene(root);
			mainStage.setScene(scene);
			mainStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}
}
