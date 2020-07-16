package Controller;

import Class.Dashboard;
import Class.Filtre_date;
import Class.Operateur;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class Dashboard_Controller implements Initializable {

    @FXML
    private JFXComboBox<String> Combobox;

    @FXML
    private TableView <Dashboard> Tableview ;
    @FXML
    private TableColumn<Dashboard, String> C1;

    @FXML
    private TableColumn<Dashboard, Integer> C2;

    @FXML
    private TableColumn<Dashboard, Integer> C3;

    @FXML
    private TableColumn<Dashboard, Integer> C4;

    @FXML
    private TableColumn<Dashboard, Integer> C5;

    @FXML
    private BarChart Barchart;

    @FXML
    private CategoryAxis XAxis;

    @FXML
    private NumberAxis YAxis;
    @FXML
    private DatePicker Date_debut;
    @FXML
    private DatePicker Date_fin;

    private ObservableList<Dashboard> Data;
    private XYChart.Series xycadre = new XYChart.Series();
    private XYChart.Series xymaitrise = new XYChart.Series();
    private XYChart.Series xyexecution = new XYChart.Series();
    private Filtre_date filtre_date;

    @FXML
    void FCombobox() {
        filtre_date = new Filtre_date(java.sql.Date.valueOf(Date_debut.getValue()),java.sql.Date.valueOf(Date_fin.getValue()));
        Tableview.setVisible(true);
        Tableview.setDisable(false);
        Barchart.setDisable(false);
        Barchart.setVisible(true);
        Data = FXCollections.observableArrayList();
        if (Combobox.getValue().equals("Nombre d'heures de formation")){
            Data.addAll(Operateur.fill_dash_table("Nbre_heures",filtre_date));
            Tableview.setItems(Data);
            Barchart.setTitle("Nombre d'heures de formation");
            Load_bar_chart("Nombre d'heures de formation");
        }else if (Combobox.getValue().equals("Cout de la formation")){
            Data.addAll(Operateur.fill_dash_table("Cout_formation",filtre_date));
            Tableview.setItems(Data);
            Barchart.setTitle("Cout de la formation");
            Load_bar_chart("Cout de la formation");

        }
        else if (Combobox.getValue().equals("Nombre d'effectif formé")){
            Data.addAll(Operateur.fill_dash_table2("Effectif_reel",filtre_date));
            Tableview.setItems(Data);
            Barchart.setTitle("Nombre d'effectif formé");
            Load_bar_chart("Nombre d'effectif formé");

        }
        Combobox.setDisable(true);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Barchart.setDisable(true);
        Barchart.setVisible(false);
        Date_debut.setValue(LocalDate.parse("2019-01-01", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        Date_fin.setValue(LocalDate.parse("2019-12-31", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        ObservableList<String> list =FXCollections.observableArrayList();
        list.add("Nombre d'heures de formation");
        list.add("Cout de la formation");
        list.add("Nombre d'effectif formé");
        Tableview.setDisable(true);
        Tableview.setVisible(false);
        Combobox.setItems(list);
        C1.setCellValueFactory(new PropertyValueFactory<Dashboard,String>("Lieu_formation"));
        C2.setCellValueFactory(new PropertyValueFactory<Dashboard,Integer>("Cadre"));
        C3.setCellValueFactory(new PropertyValueFactory<Dashboard,Integer>("Maitrise"));
        C4.setCellValueFactory(new PropertyValueFactory<Dashboard,Integer>("Execution"));
        C5.setCellValueFactory(new PropertyValueFactory<Dashboard,Integer>("Total_general"));
        xycadre.setName("Cadre");
        xymaitrise.setName("Maitrise");
        xyexecution.setName("Execution");
    }
    public void Load_bar_chart(String s){
        if (s.equals("Nombre d'heures de formation")) {
            xycadre.getData().add(new XYChart.Data<>("CFIC",Tableview.getItems().get(0).getCadre()));
            xymaitrise.getData().add(new XYChart.Data<>("CFIC",Tableview.getItems().get(0).getMaitrise()));
            xyexecution.getData().add(new XYChart.Data<>("CFIC",Tableview.getItems().get(0).getExecution()));
            xycadre.getData().add(new XYChart.Data<>("Externe",Tableview.getItems().get(1).getCadre()));
            xymaitrise.getData().add(new XYChart.Data<>("Externe",Tableview.getItems().get(1).getMaitrise()));
            xyexecution.getData().add(new XYChart.Data<>("Externe",Tableview.getItems().get(1).getExecution()));
            xycadre.getData().add(new XYChart.Data<>("Interne",Tableview.getItems().get(2).getCadre()));
            xymaitrise.getData().add(new XYChart.Data<>("Interne",Tableview.getItems().get(2).getMaitrise()));
            xyexecution.getData().add(new XYChart.Data<>("Interne",Tableview.getItems().get(2).getExecution()));
        }else if (s.equals("Cout de la formation")){
            xycadre.getData().add(new XYChart.Data<>("CFIC",Tableview.getItems().get(0).getCadre()));
            xymaitrise.getData().add(new XYChart.Data<>("CFIC",Tableview.getItems().get(0).getMaitrise()));
            xyexecution.getData().add(new XYChart.Data<>("CFIC",Tableview.getItems().get(0).getExecution()));
            xycadre.getData().add(new XYChart.Data<>("Externe",Tableview.getItems().get(1).getCadre()));
            xymaitrise.getData().add(new XYChart.Data<>("Externe",Tableview.getItems().get(1).getMaitrise()));
            xyexecution.getData().add(new XYChart.Data<>("Externe",Tableview.getItems().get(1).getExecution()));
            xycadre.getData().add(new XYChart.Data<>("Interne",Tableview.getItems().get(2).getCadre()));
            xymaitrise.getData().add(new XYChart.Data<>("Interne",Tableview.getItems().get(2).getMaitrise()));
            xyexecution.getData().add(new XYChart.Data<>("Interne",Tableview.getItems().get(2).getExecution()));
        }else if (s.equals("Nombre d'effectif formé")){
            xycadre.getData().add(new XYChart.Data<>("CFIC",Tableview.getItems().get(0).getCadre()));
            xymaitrise.getData().add(new XYChart.Data<>("CFIC",Tableview.getItems().get(0).getMaitrise()));
            xyexecution.getData().add(new XYChart.Data<>("CFIC",Tableview.getItems().get(0).getExecution()));
            xycadre.getData().add(new XYChart.Data<>("Externe",Tableview.getItems().get(1).getCadre()));
            xymaitrise.getData().add(new XYChart.Data<>("Externe",Tableview.getItems().get(1).getMaitrise()));
            xyexecution.getData().add(new XYChart.Data<>("Externe",Tableview.getItems().get(1).getExecution()));
            xycadre.getData().add(new XYChart.Data<>("Interne",Tableview.getItems().get(2).getCadre()));
            xymaitrise.getData().add(new XYChart.Data<>("Interne",Tableview.getItems().get(2).getMaitrise()));
            xyexecution.getData().add(new XYChart.Data<>("Interne",Tableview.getItems().get(2).getExecution()));
        }
        Barchart.getData().add(xycadre);Barchart.getData().add(xymaitrise);Barchart.getData().add(xyexecution);
    }

}
