package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class AdminController  implements Initializable {
	

    @FXML
    private TableView<StajBilgi> table_admin;

    @FXML
    private TableColumn<StajBilgi, String> col_gunluk;

    @FXML
    private TableColumn<StajBilgi, String> col_tarih;

    @FXML
    private TableColumn<StajBilgi, String> col_ogr;
    @FXML
    private TextField txtSearch;
    
    @FXML
   private PieChart piechart;

     @FXML
    public void btnpie(ActionEvent event) {
    	
    	ObservableList<Data>list=FXCollections.observableArrayList(
    			new PieChart.Data("Staj Kabul edilen", 74),
    			new PieChart.Data("Staj Reddedilen", 26)
    			);
    	piechart.setData(list);
    }
    
    ObservableList<StajBilgi> data;
    ObservableList<StajBilgi> staj;

    @FXML
    void search() {          
        
    	col_gunluk.setCellValueFactory(new PropertyValueFactory<StajBilgi,String>("Gunluk"));
    	col_tarih.setCellValueFactory(new PropertyValueFactory<StajBilgi,String>("Date"));
    	col_ogr.setCellValueFactory(new PropertyValueFactory<StajBilgi,String>("OgrNo"));
        
        data = MysqlConnect.getDataStaj();
        table_admin.setItems(data);
        FilteredList<StajBilgi> filteredData = new FilteredList<>(data, b -> true);  
        txtSearch.textProperty().addListener((observable, oldValue, newValue) -> {
 filteredData.setPredicate(person -> {
    if (newValue == null || newValue.isEmpty()) {
     return true;
    }    
    String lowerCaseFilter = newValue.toLowerCase();
    
    if (person.getGunluk().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
     return true; 
    }else if(String.valueOf(person.getOgrNo()).indexOf(lowerCaseFilter)!=-1) {
    	return true;
    }
    
    else
	return false;
   });
  });  
  SortedList<StajBilgi> sortedData = new SortedList<>(filteredData);  
  sortedData.comparatorProperty().bind(table_admin.comparatorProperty());  
  table_admin.setItems(sortedData);      
    }
  
  
  public void UpdateTable(){
	  	
	  	col_tarih.setCellValueFactory(new PropertyValueFactory<StajBilgi,String>("date"));
    	col_gunluk.setCellValueFactory(new PropertyValueFactory<StajBilgi,String>("Gunluk"));
    	col_ogr.setCellValueFactory(new PropertyValueFactory<StajBilgi,String>("OgrNo"));
        staj = MysqlConnect.getDataStaj();
        table_admin.setItems(staj);
     
    }
  
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    	UpdateTable();
    	search();
	}
    
}
