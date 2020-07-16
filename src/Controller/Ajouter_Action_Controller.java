package Controller;
import Class.Operateur;
import com.jfoenix.controls.JFXComboBox;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Ajouter_Action_Controller implements Initializable {

    @FXML
    private Button AAjouter;

    @FXML
    private TextField atf9;

    @FXML
    private DatePicker atf8;

    @FXML
    private TextField atf7;

    @FXML
    private TextField atf6;

    @FXML
    private TextField atf5;

    @FXML
    private JFXComboBox atf4;

    @FXML
    private TextArea atf3;

    @FXML
    private TextField atf2;

    @FXML
    private TextField atf1;

    @FXML
    private TextField atf12;

    @FXML
    private JFXComboBox atf10;

    @FXML
    private TextField atf11;

    ObservableList AAlist ;

    @FXML
    void FAAjouter() {
        AAlist = FXCollections.observableArrayList();
        AAlist.add(atf1.getText());
        AAlist.add(atf2.getText());
        AAlist.add(atf3.getText());
        AAlist.add(atf4.getValue());
        AAlist.add(atf5.getText());
        AAlist.add(atf6.getText());
        AAlist.add(atf7.getText());
        if(atf8.getValue()!=null) AAlist.add(atf8.getValue().toString()); else AAlist.add(null);
        AAlist.add(atf9.getText());
        AAlist.add(atf10.getValue());
        AAlist.add(atf11.getText());
        AAlist.add(atf12.getText());
        Gestion_Personne.s.close();
        if(Gestion_Personne.getActpButt()==1){
            Operateur.ajouter_action(Operateur.list_to_action(AAlist),"actions_planif");
        }else{
            Operateur.ajouter_action(Operateur.list_to_action(AAlist),"actions_non_planif");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //todo seteditable checkcombobox
        atf4.setItems(FXCollections.observableArrayList(Operateur.importer_choix("structure")));
        atf10.setItems(FXCollections.observableArrayList(Operateur.importer_choix("organisme")));
        //atf8.setValue(LocalDate.parse("2019-01-01", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        atf1.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    atf1.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        atf5.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    atf5.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        atf6.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    atf6.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        atf7.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    atf7.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        atf9.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    atf9.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }

}
