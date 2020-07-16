package Controller;
import Class.*;
import com.jfoenix.controls.JFXComboBox;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Ajouter_Suivi_Controller implements Initializable {

    @FXML
    private Button SAjouter;

    @FXML
    private TextField stf1;

    @FXML
    private TextField stf2;

    @FXML
    private DatePicker stf3;

    @FXML
    private DatePicker stf4;

    @FXML
    private TextField stf5;

    @FXML
    private TextField stf6;

    @FXML
    private JFXComboBox stf7;

    @FXML
    private JFXComboBox stf8;

    @FXML
    private JFXComboBox stf9;

    @FXML
    private JFXComboBox stf10;

    @FXML
    private JFXComboBox stf11;

    @FXML
    private JFXComboBox stf12;

    @FXML
    private JFXComboBox stf13;

    @FXML
    private JFXComboBox stf14;

    @FXML
    private JFXComboBox stf15;

    @FXML
    private JFXComboBox stf16;

    @FXML
    private TextField stf17;

    @FXML
    private TextField stf18;

    @FXML
    private DatePicker stf19;

    @FXML
    private TextField stf20;

    ObservableList SAlist ;

    @FXML
    void FSAjouter(){
        SAlist = FXCollections.observableArrayList();
        SAlist.add(stf1.getText());
        SAlist.add(stf2.getText());
        if(stf3.getValue()!=null) SAlist.add(stf3.getValue().toString()); else SAlist.add(null);
        if(stf4.getValue()!=null) SAlist.add(stf4.getValue().toString()); else SAlist.add(null);
        SAlist.add(stf5.getText());
        SAlist.add(stf6.getText());
        SAlist.add(stf7.getValue());
        SAlist.add(stf8.getValue());
        SAlist.add(stf9.getValue());
        SAlist.add(stf10.getValue());
        SAlist.add(stf11.getValue());
        SAlist.add(stf12.getValue());
        SAlist.add(stf13.getValue());
        SAlist.add(stf14.getValue());
        SAlist.add(stf15.getValue());
        SAlist.add(stf16.getValue());
        SAlist.add(stf17.getText());
        SAlist.add(stf18.getText());
        if(stf19.getValue()!=null) SAlist.add(stf19.getValue().toString()); else SAlist.add(null);
        SAlist.add(stf20.getText());
        Gestion_Personne.s.close();
        Operateur.ajouter_suivi(Operateur.list_to_suivi(SAlist));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        stf7.setItems(FXCollections.observableArrayList(Operateur.importer_choix("type_formation")));
        stf8.setItems(FXCollections.observableArrayList(Operateur.importer_choix("organisme")));
        stf9.setItems(FXCollections.observableArrayList(Operateur.importer_choix("lieu_formation")));
        stf10.setItems(FXCollections.observableArrayList(Operateur.importer_choix("lieu_formation_2")));
        stf11.setItems(FXCollections.observableArrayList(Operateur.importer_choix("type_formation_2")));
        stf12.setItems(FXCollections.observableArrayList("Planifié","Hors Plan"));
        stf13.setItems(FXCollections.observableArrayList("Oui","Non"));
        stf14.setItems(FXCollections.observableArrayList(Operateur.importer_choix("avis_evaluation_organisme")));
        stf15.setItems(FXCollections.observableArrayList(Operateur.importer_choix("avis_retour_evaluation")));
        stf16.setItems(FXCollections.observableArrayList(Operateur.importer_choix("action_evaluation_insuffisante")));

        stf1.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    stf1.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        stf5.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    stf5.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        stf6.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    stf6.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        stf17.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    stf17.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        stf18.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    stf18.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        stf20.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    stf20.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }
}
