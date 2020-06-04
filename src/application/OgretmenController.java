package application;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.input.MouseEvent;

public class OgretmenController implements Initializable{
	@FXML
	private TableView<OgrKayitt> table_users;

    @FXML
    private TableColumn<OgrKayitt, Integer> col_id;

    @FXML
    private TableColumn<OgrKayitt, String> col_username;

    @FXML
    private TableColumn<OgrKayitt, String> col_surname;

    @FXML
    private TableColumn<OgrKayitt, String> col_email;

    @FXML
    private TableColumn<OgrKayitt, String> col_ogrno;
    @FXML
    private TableColumn<OgrKayitt, String> col_sýnýf; 

    @FXML
    private TableColumn<OgrKayitt, String> col_cinsiyet;
    
    @FXML
    private TableColumn<OgrKayitt, String>col_onaydurum,col_fakulte,col_bolum;
    
     @FXML
    private TextField txt_username;

    @FXML
    private TextField txt_surname;

    @FXML
    private TextField txt_email;

    @FXML
    private TextField txt_ogrno;
        
    @FXML
    private TextField txt_id;
    @FXML
    private TextField txt_sýnýf;
    
    @FXML
    private TextField filterField;
    
    @FXML
    private ComboBox<String> cmb_Bolum,cmb_Fakulte;
    
    @FXML
    private ToggleGroup cinsiyet;
    @FXML
    private ToggleGroup stajDurum;
       
    ObservableList<OgrKayitt> listM;
    ObservableList<OgrKayitt> dataList;
    
    
    int index = -1;
    
 
    
    static Connection conn=null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    
    
    
    @FXML
    public void Add_users (){    
    	conn=(Connection) MysqlConnect.ConnectDb();
        String sql = "insert into ogrKayit (user_id,username,surname,email,ogrno,sýnýf,cinsiyet,stajOnay,Bolum,Fakulte)values(?,?,?,?,?,?,?,?,?,?)";
        RadioButton gender=(RadioButton)cinsiyet.getSelectedToggle();
        RadioButton onay=(RadioButton)stajDurum.getSelectedToggle();
        
        try {
            pst = (PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, txt_id.getText());
            pst.setString(2, txt_username.getText());
            pst.setString(3, txt_surname.getText());
            pst.setString(4, txt_email.getText());
            pst.setString(5, txt_ogrno.getText());
            pst.setString(6, txt_sýnýf.getText());
            pst.setString(7, gender.getText());
            pst.setString(8, onay.getText());
            pst.setString(9, cmb_Bolum.getValue().toString());
            pst.setString(10, cmb_Fakulte.getValue().toString());
            pst.execute();
            
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Ogrenci ekleme islemi");
            alert.setContentText("Eklemek istediginize emin misiniz?");
            alert.showAndWait();
            
            //JOptionPane.showMessageDialog(null, "Users Add succes");
            UpdateTable();
            search_user();
        } catch (Exception e) {
        	 Alert alert=new Alert(Alert.AlertType.ERROR);
             alert.setHeaderText("Ogrenci ekleme islemi");
             alert.setContentText("Eklenirken hata olustu...");
             alert.showAndWait();
        }
    }
    

    @FXML
    void getSelected (MouseEvent event){
    	   RadioButton gender=(RadioButton)cinsiyet.getSelectedToggle();
    	   RadioButton onay=(RadioButton)stajDurum.getSelectedToggle();
    index = table_users.getSelectionModel().getSelectedIndex();
    
    if (index <= -1){
    
        return;
    }
    txt_id.setText(col_id.getCellData(index).toString());
    txt_username.setText(col_username.getCellData(index).toString());
    txt_surname.setText(col_surname.getCellData(index).toString());
    txt_email.setText(col_email.getCellData(index).toString());
    txt_ogrno.setText(col_ogrno.getCellData(index).toString());
    txt_sýnýf.setText(col_sýnýf.getCellData(index).toString());
    gender.setText(col_cinsiyet.getCellData(index).toString());
    onay.setText(col_onaydurum.getCellData(index).toString());
    cmb_Bolum.setValue(col_bolum.getCellData(index).toString());
    cmb_Fakulte.setValue(col_fakulte.getCellData(index).toString());
    }
    @FXML
    public void Edit (){   
        try {
        	conn=(Connection) MysqlConnect.ConnectDb();
        	 RadioButton gender=(RadioButton)cinsiyet.getSelectedToggle();
        	 RadioButton onay=(RadioButton)stajDurum.getSelectedToggle();
            String value1 = txt_id.getText();
            String value2 = txt_username.getText();
            String value3 = txt_surname.getText();
            String value4 = txt_email.getText();
            String value5 = txt_ogrno.getText();
            String value6 = txt_sýnýf.getText();
            String value7 = gender.getText();
            String value8 = onay.getText();
            String value9=cmb_Bolum.getValue().toString();
            String value10=cmb_Fakulte.getValue().toString();
            String sql = "update ogrkayit set user_id= '"+value1+"',username= '"+value2+"',surname= '"+
            value3+"',email= '"+value4+"',ogrno= '"+value5+"',sýnýf= '"+value6+"',cinsiyet='"+value7+"',stajOnay='"+value8+"',Bolum='"+value9+"',Fakulte='"+value10+"' where user_id='"+value1+"'";
            pst= (PreparedStatement) conn.prepareStatement(sql);
            pst.execute();
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Ogrenci guncellem islemi");
            alert.setContentText("Guncelleme islemi basarili...");
            alert.showAndWait();
            UpdateTable();
            search_user();
        } catch (Exception e) {
        	 Alert alert=new Alert(Alert.AlertType.ERROR);
             alert.setHeaderText("Ogrenci guncelleme islemi");
             alert.setContentText("Guncellenirken hata olustu...");
             alert.showAndWait();
        }
        
    }
    @FXML
    public void Delete(){
    	conn=(Connection) MysqlConnect.ConnectDb();
    String sql = "delete from ogrKayit where user_id = ?";
        try {
            pst = (PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, txt_id.getText());
            pst.execute();
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Ogrenci silme islemi");
            alert.setContentText("Bilgiler basarili bir sekilde silindi...");
            alert.showAndWait();
            UpdateTable();
            search_user();
        } catch (Exception e) {
        	 Alert alert=new Alert(Alert.AlertType.ERROR);
             alert.setHeaderText("Ogrenci silme islemi");
             alert.setContentText("Silme sirasinda hata olustu...");
             alert.showAndWait();
        }
    
    }

    
    public void UpdateTable(){
        col_id.setCellValueFactory(new PropertyValueFactory<OgrKayitt,Integer>("id"));
        col_username.setCellValueFactory(new PropertyValueFactory<OgrKayitt,String>("username"));
        col_surname.setCellValueFactory(new PropertyValueFactory<OgrKayitt,String>("surname"));
        col_email.setCellValueFactory(new PropertyValueFactory<OgrKayitt,String>("email"));
        col_ogrno.setCellValueFactory(new PropertyValueFactory<OgrKayitt,String>("ogrno"));
        col_sýnýf.setCellValueFactory(new PropertyValueFactory<OgrKayitt,String>("sýnýf"));
        col_cinsiyet.setCellValueFactory(new PropertyValueFactory<OgrKayitt,String>("cinsiyet"));
        col_onaydurum.setCellValueFactory(new PropertyValueFactory<OgrKayitt,String>("stajDurum"));
        col_bolum.setCellValueFactory(new PropertyValueFactory<OgrKayitt,String>("bolum"));
        col_fakulte.setCellValueFactory(new PropertyValueFactory<OgrKayitt,String>("fakulte"));
        listM = MysqlConnect.getDatausers();
        table_users.setItems(listM);
    }
    
    
    
 @FXML
    void search_user() {          
        col_id.setCellValueFactory(new PropertyValueFactory<OgrKayitt,Integer>("id"));
        col_username.setCellValueFactory(new PropertyValueFactory<OgrKayitt,String>("username"));
        col_surname.setCellValueFactory(new PropertyValueFactory<OgrKayitt,String>("surname"));
        col_email.setCellValueFactory(new PropertyValueFactory<OgrKayitt,String>("email"));
        col_ogrno.setCellValueFactory(new PropertyValueFactory<OgrKayitt,String>("ogrno"));
        col_sýnýf.setCellValueFactory(new PropertyValueFactory<OgrKayitt,String>("sýnýf"));
        col_cinsiyet.setCellValueFactory(new PropertyValueFactory<OgrKayitt,String>("cinsiyet"));
        col_onaydurum.setCellValueFactory(new PropertyValueFactory<OgrKayitt,String>("stajDurum"));
        col_bolum.setCellValueFactory(new PropertyValueFactory<OgrKayitt,String>("Bolum"));
        
        dataList = MysqlConnect.getDatausers();
        table_users.setItems(dataList);
        FilteredList<OgrKayitt> filteredData = new FilteredList<>(dataList, b -> true);  
 filterField.textProperty().addListener((observable, oldValue, newValue) -> {
 filteredData.setPredicate(person -> {
    if (newValue == null || newValue.isEmpty()) {
     return true;
    }    
    String lowerCaseFilter = newValue.toLowerCase();
    
    if (person.getUsername().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
     return true; 
    } else if (person.getSurname().toLowerCase().indexOf(lowerCaseFilter) != -1) {
     return true; 
    }else if (person.getOgrno().toLowerCase().indexOf(lowerCaseFilter) != -1) {
     return true; 
    }else if (person.getStajDurum().toLowerCase().indexOf(lowerCaseFilter) != -1) {
        return true; 
       }else if(person.getSýnýf().toLowerCase().indexOf(lowerCaseFilter) != -1) {
    	return true;
    }else if(person.getCinsiyet().toLowerCase().indexOf(lowerCaseFilter) != -1) {
    	return true;
    }
    else if(person.getBolum().toLowerCase().indexOf(lowerCaseFilter) != -1) {
    	return true;
    }
    
    else if (String.valueOf(person.getEmail()).indexOf(lowerCaseFilter)!=-1)
         return true;
                                
         else  
          return false; 
   });
  });  
  SortedList<OgrKayitt> sortedData = new SortedList<>(filteredData);  
  sortedData.comparatorProperty().bind(table_users.comparatorProperty());  
  table_users.setItems(sortedData);      
    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg) {
    UpdateTable();
    search_user();
    cmb_Bolum.getItems().addAll("Bilgisayar Muhendisligi","Bilgisayar Muhendisligi(I.O)","Biyomedikal Muhendisligi","Ekonomi","Endustri Muhendisligi"
    	,"Elektrik-Elektronik Muhendisligi","Elektrik-Elektronik Muhendisligi(I.O)","Mimarlýk","Peyzaj Mimarlýgý","Makine Muhendisligi","Makine Muhendisligi(I.O))",
    	"Insaat Mühendisligi","Insaat Muhendisligi(I.O)");
    
    cmb_Fakulte.getItems().addAll("Muhendislik ve Doga Bilimleri Fakultesi","Isletme ve Yonetim Bilimleri Fakultesi","Mimarlýk Fakultesi");
    } 
}


