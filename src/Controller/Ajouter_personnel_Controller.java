package Controller;

import Class.Operateur;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Ajouter_personnel_Controller implements Initializable {

    @FXML
    private TextField ptf1;

    @FXML
    private TextField ptf2;

    @FXML
    private TextField ptf3;

    @FXML
    private DatePicker ptf4;

    @FXML
    private JFXComboBox<String> ptf5;

    @FXML
    private Button APAjouter;

    @FXML
    private JFXComboBox<String> ptf8;

    @FXML
    private JFXComboBox<String> ptf6;

    @FXML
    private JFXComboBox<String> ptf7;

    @FXML
    private JFXComboBox<String> ptf9;

    @FXML
    private JFXComboBox<String> ptf10;

    private ObservableList<String> PAlist;
    @FXML
    public void FAPAjouter() {
        PAlist = FXCollections.observableArrayList();
        PAlist.add(ptf1.getText());
        PAlist.add(ptf2.getText());
        PAlist.add(ptf3.getText());
        if(ptf4.getValue()!=null) PAlist.add(ptf4.getValue().toString()); else PAlist.add(null);
        PAlist.add(ptf5.getValue());
        PAlist.add(ptf6.getValue());
        PAlist.add(ptf7.getValue());
        PAlist.add(ptf8.getValue());
        PAlist.add(ptf9.getValue());
        PAlist.add(ptf10.getValue());
        Gestion_Personne.s.close();
        Operateur.ajouter_personnel(Operateur.list_to_personnel(PAlist));

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ptf5.setItems(FXCollections.observableArrayList(Operateur.importer_choix("poste")));
        ptf6.setItems(FXCollections.observableArrayList(Operateur.importer_choix("type_emploi")));
        ptf7.setItems(FXCollections.observableArrayList(Operateur.importer_choix("categorie")));
        ptf8.setItems(FXCollections.observableArrayList(Operateur.importer_choix("direction")));
        ptf9.setItems(FXCollections.observableArrayList(Operateur.importer_choix("departement")));
        ptf10.setItems(FXCollections.observableArrayList(Operateur.importer_choix("service")));
        //ptf4.setValue(LocalDate.parse("2019-01-01", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }
}
