package Controller;

import Class.*;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXRadioButton;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.converter.DateStringConverter;
import javafx.util.converter.IntegerStringConverter;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class Gestion_Personne implements Initializable {
    @FXML
    private ImageView image;
    @FXML
    private Button Cancel;
    @FXML
    private TableView<Personnel> tableP;
    @FXML
    private TableView<Action> tableA;
    @FXML
    private TableView<Suivi> tableS;
    //------------ Personnel
    @FXML
    private TableColumn<Personnel, String> Matricule;
    @FXML
    private TableColumn<Personnel, String> Nom;
    @FXML
    private TableColumn<Personnel, String> Prenom;
    @FXML
    private TableColumn<Personnel, Date> Date_entree;
    @FXML
    private TableColumn<Personnel, String> Poste;
    @FXML
    private TableColumn<Personnel, String> Type_emploi;
    @FXML
    private TableColumn<Personnel, String> Categorie;
    @FXML
    private TableColumn<Personnel, String> Direction;
    @FXML
    private TableColumn<Personnel, String> Departement;
    @FXML
    private TableColumn<Personnel, String> Service;
    //------------ Action
    @FXML
    private TableColumn<Action, Integer> Num;
    @FXML
    private TableColumn<Action, String> Action;
    @FXML
    private TableColumn<Action, String> Objectif;
    @FXML
    private TableColumn<Action, String> Structure;
    @FXML
    private TableColumn<Action, Integer> Effectif;
    @FXML
    private TableColumn<Action, Integer> NbrP;
    @FXML
    private TableColumn<Action, Integer> Duree;
    @FXML
    private TableColumn<Action, Date> DebutF;
    @FXML
    private TableColumn<Action, Integer> Cout;
    @FXML
    private TableColumn<Action, String> OrganismeF;
    @FXML
    private TableColumn<Action, String> Lformation;
    @FXML
    private TableColumn<Action, String> Periode;
    //------------ Suivi
    @FXML
    private TableColumn<Suivi, Integer> Nact;
    @FXML
    private TableColumn<Suivi, String> Mat;
    @FXML
    private TableColumn<Suivi, String> Nom1;
    @FXML
    private TableColumn<Suivi, String> Prenom1;
    @FXML
    private TableColumn<Suivi, String> Fonction;
    @FXML
    private TableColumn<Suivi, String> Diraff;
    @FXML
    private TableColumn<Suivi, String> Cat;
    @FXML
    private TableColumn<Suivi, String> Ifor;
    @FXML
    private TableColumn<Suivi, Date> Ddebut;
    @FXML
    private TableColumn<Suivi, Date> Dfin;
    @FXML
    private TableColumn<Suivi, Integer> Cfor;
    @FXML
    private TableColumn<Suivi, Integer> NbrJ;
    @FXML
    private TableColumn<Suivi, Integer> Nbrh;
    @FXML
    private TableColumn<Suivi, String> Tfor;
    @FXML
    private TableColumn<Suivi, String> Ofor;
    @FXML
    private TableColumn<Suivi, String> Lfor;
    @FXML
    private TableColumn<Suivi, String> Lfor2;
    @FXML
    private TableColumn<Suivi, String> Tfor2;
    @FXML
    private TableColumn<Suivi, String> Plan;
    @FXML
    private TableColumn<Suivi, String> Peva;
    @FXML
    private TableColumn<Suivi, String> Att;
    @FXML
    private TableColumn<Suivi, String> Aseof;
    @FXML
    private TableColumn<Suivi, String> asref;
    @FXML
    private TableColumn<Suivi, String> apsefi;
    @FXML
    private TableColumn<Suivi, Integer> pef;
    @FXML
    private TableColumn<Suivi, Integer> pcf;
    @FXML
    private TableColumn<Suivi, Date> pdr;
    @FXML
    private TableColumn<Suivi, Integer> pNj;
    @FXML
    private TableColumn<Suivi, Integer> Pnh;
    //-----------------------------CHECK BOX AND RADIO BUTTON---------------------------------//
    //                             Personnel
    @FXML
    private JFXRadioButton RBP1;

    @FXML
    private JFXRadioButton RBP2;

    @FXML
    private JFXRadioButton RBP6;

    @FXML
    private JFXRadioButton RBP5;

    @FXML
    private JFXRadioButton RBP4;

    @FXML
    private JFXRadioButton RBP3;

    @FXML
    private JFXRadioButton RBP7;

    @FXML
    private Button BP1;

    @FXML
    private Button BP2;

    @FXML
    private Button BP3;

    @FXML
    private Button BP4;

    @FXML
    private Button BP5;

    @FXML
    private Button BP7;

    @FXML
    private Button BP6;
    @FXML
    private ScrollPane filterscp;
    @FXML
    private AnchorPane ANP;
    //---------------------------------------------------
    //------------------ Action --------------------------
    @FXML
    private JFXRadioButton RBA1;

    @FXML
    private JFXRadioButton RBA2;

    @FXML
    private JFXRadioButton RBA6;

    @FXML
    private JFXRadioButton RBA5;

    @FXML
    private JFXRadioButton RBA4;

    @FXML
    private JFXRadioButton RBA3;

    @FXML
    private JFXRadioButton RBA7;

    @FXML
    private Button BA1;

    @FXML
    private Button BA2;

    @FXML
    private Button BA3;

    @FXML
    private Button BA4;

    @FXML
    private Button BA5;

    @FXML
    private Button BA7;

    @FXML
    private Button BA6;
    @FXML
    private ScrollPane filtersca;
    @FXML
    private AnchorPane ANA;
    //----------------------------------------------------
    //------------------ Suivi --------------------------
    @FXML
    private JFXRadioButton RBS1;

    @FXML
    private JFXRadioButton RBS2;

    @FXML
    private JFXRadioButton RBS6;

    @FXML
    private JFXRadioButton RBS5;

    @FXML
    private JFXRadioButton RBS4;

    @FXML
    private JFXRadioButton RBS3;

    @FXML
    private JFXRadioButton RBS7;

    @FXML
    private JFXRadioButton RBS8;

    @FXML
    private JFXRadioButton RBS9;

    @FXML
    private JFXRadioButton RBS10;

    @FXML
    private JFXRadioButton RBS11;

    @FXML
    private JFXRadioButton RBS12;

    @FXML
    private JFXRadioButton RBS13;

    @FXML
    private JFXRadioButton RBS14;

    @FXML
    private JFXRadioButton RBS15;


    @FXML
    private Button BS1;

    @FXML
    private Button BS2;

    @FXML
    private Button BS3;

    @FXML
    private Button BS4;

    @FXML
    private Button BS5;

    @FXML
    private Button BS7;

    @FXML
    private Button BS6;

    @FXML
    private Button BS8;

    @FXML
    private Button BS9;

    @FXML
    private Button BS10;

    @FXML
    private Button BS11;

    @FXML
    private Button BS12;

    @FXML
    private Button BS13;

    @FXML
    private Button BS14;

    @FXML
    private Button BS15;
    @FXML
    private ScrollPane filterscs;
    @FXML
    private AnchorPane ANS;
    //----------------------------------------------------
    @FXML
    public Button Ajouter;

    @FXML
    private Button supprimer;

    @FXML
    private Button fil;
    @FXML
    private TextField filterField;
    @FXML
    private Button imprtBtn;
    @FXML
    private Button exprtBtn;
    @FXML
    private Button Vider;
    @FXML Button Act;
    @FXML Button Actnp;
    @FXML Button Actp;
    @FXML Button Per;
    @FXML Button Sui;
    @FXML Button Tableau_bord;


    static Stage s;

    public static int getActnButt() {
        return ActnButt;
    }

    public static int getActpButt() {
        return ActpButt;
    }

    private int perbutt;
    private int ActButt;
    private static int ActnButt;
    private static int ActpButt;
    private int SuiButt;
    private boolean btp1 = true;
    private boolean btp2 = true;
    private boolean btp3 = true;
    private boolean btp4 = true;
    private boolean btp5 = true;
    private boolean btp6 = true;
    private boolean btp7 = true;
    private boolean bta1 = true;
    private boolean bta2 = true;
    private boolean bta3 = true;
    private boolean bta4 = true;
    private boolean bta5 = true;
    private boolean bta6 = true;
    private boolean bta7 = true;
    private boolean bts1 = true;
    private boolean bts2 = true;
    private boolean bts3 = true;
    private boolean bts4 = true;
    private boolean bts5 = true;
    private boolean bts6 = true;
    private boolean bts7 = true;
    private boolean bts8 = true;
    private boolean bts9 = true;
    private boolean bts10 = true;
    private boolean bts11 = true;
    private boolean bts12 = true;
    private boolean bts13 = true;
    private boolean bts14 = true;
    private boolean bts15 = true;
    private DatePicker datedebutp;
    private DatePicker datefinp;
    private DatePicker datedebuta;
    private DatePicker datefina;
    private DatePicker datedebuts;
    private DatePicker datefins;
    private TextField text1;
    private TextField text2;
    private TextField text3;
    private TextField text4;
    private TextField text5;
    private TextField text6;
    private TextField text7;
    private TextField text8;
    private int k;
    public ObservableList<JFXCheckBox> radiobuttomP1 = FXCollections.observableArrayList();
    public ObservableList<JFXCheckBox> radiobuttomP2 = FXCollections.observableArrayList();
    public ObservableList<JFXCheckBox> radiobuttomP3 = FXCollections.observableArrayList();
    public ObservableList<JFXCheckBox> radiobuttomP4 = FXCollections.observableArrayList();
    public ObservableList<JFXCheckBox> radiobuttomP5 = FXCollections.observableArrayList();
    public ObservableList<JFXCheckBox> radiobuttomP6 = FXCollections.observableArrayList();
    public ObservableList<JFXCheckBox> radiobuttomP7 = FXCollections.observableArrayList();
    public ObservableList<ObservableList<JFXCheckBox>> radiobuttomP = FXCollections.observableArrayList();
    public ObservableList<JFXCheckBox> radiobuttomA1 = FXCollections.observableArrayList();
    public ObservableList<JFXCheckBox> radiobuttomA2 = FXCollections.observableArrayList();
    public ObservableList<JFXCheckBox> radiobuttomA3 = FXCollections.observableArrayList();
    public ObservableList<JFXCheckBox> radiobuttomA4 = FXCollections.observableArrayList();
    public ObservableList<JFXCheckBox> radiobuttomA5 = FXCollections.observableArrayList();
    public ObservableList<JFXCheckBox> radiobuttomA6 = FXCollections.observableArrayList();
    public ObservableList<JFXCheckBox> radiobuttomA7 = FXCollections.observableArrayList();
    public ObservableList<ObservableList<JFXCheckBox>> radiobuttomA = FXCollections.observableArrayList();
    public ObservableList<JFXCheckBox> radiobuttomS1 = FXCollections.observableArrayList();
    public ObservableList<JFXCheckBox> radiobuttomS2 = FXCollections.observableArrayList();
    public ObservableList<JFXCheckBox> radiobuttomS3 = FXCollections.observableArrayList();
    public ObservableList<JFXCheckBox> radiobuttomS4 = FXCollections.observableArrayList();
    public ObservableList<JFXCheckBox> radiobuttomS5 = FXCollections.observableArrayList();
    public ObservableList<JFXCheckBox> radiobuttomS6 = FXCollections.observableArrayList();
    public ObservableList<JFXCheckBox> radiobuttomS7 = FXCollections.observableArrayList();
    public ObservableList<JFXCheckBox> radiobuttomS8 = FXCollections.observableArrayList();
    public ObservableList<JFXCheckBox> radiobuttomS9 = FXCollections.observableArrayList();
    public ObservableList<JFXCheckBox> radiobuttomS10 = FXCollections.observableArrayList();
    public ObservableList<JFXCheckBox> radiobuttomS11 = FXCollections.observableArrayList();
    public ObservableList<JFXCheckBox> radiobuttomS12 = FXCollections.observableArrayList();
    public ObservableList<JFXCheckBox> radiobuttomS13 = FXCollections.observableArrayList();
    public ObservableList<JFXCheckBox> radiobuttomS14 = FXCollections.observableArrayList();
    public ObservableList<JFXCheckBox> radiobuttomS15 = FXCollections.observableArrayList();
    public ObservableList<ObservableList<JFXCheckBox>> radiobuttomS = FXCollections.observableArrayList();


    public ObservableList<Personnel> Pdata;
    public ObservableList<Action> Adata;
    public ObservableList<Action> Andata;
    public ObservableList<Suivi> Sdata;
    private ArrayList<String> list;
    private Filtre_personnel filtre_personnel;
    private Filtre_action filtre_action;
    private Filtre_suivi filtre_suivi;
    @FXML
    private  ImageView Logo;



    /************************************SUPPRIMER**************************************************/
    @FXML
    void Fsupprimer() {
        Stage stage= new Stage();
        Pane layout = new Pane();
        Button button =new Button("Supprimer");
        Label label = new Label("Voulez vous supprimer cette ligne?");
        label.setLayoutX(10);
        label.setLayoutY(20);
        button.setLayoutX(220);
        button.setLayoutY(65);
        layout.getStyle();
        layout.getChildren().addAll(label,button);
        Scene scene = new Scene(layout,300,100);
        stage.setScene(scene);
        //todo must select before delete
        stage.show();
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    if (perbutt == 1) {
                        Operateur.supprimer_personnel(tableP.getSelectionModel().getSelectedItem().getId());
                    tableP.getItems().removeAll(tableP.getSelectionModel().getSelectedItem());
                    stage.close();
                } else if(ActButt == 1) {
                        if (ActpButt==1){
                        Operateur.supprimer_action(tableA.getSelectionModel().getSelectedItem().getNum(), "actions_planif");
                        tableA.getItems().removeAll(tableA.getSelectionModel().getSelectedItem());
                        }else if (ActnButt==1){
                            Operateur.supprimer_action(tableA.getSelectionModel().getSelectedItem().getNum(), "actions_non_planif");
                            tableA.getItems().removeAll(tableA.getSelectionModel().getSelectedItem());
                        }
                    }else if (SuiButt == 1) {
                        Operateur.supprimer_suivi(tableS.getSelectionModel().getSelectedItem().getN());
                        tableS.getItems().removeAll(tableS.getSelectionModel().getSelectedItem());
                    }
                    stage.close();
                }});
    }
    /*************************************** AJOUTER *************************************/
    /////////////////////////////////////////////////////////////////////////////////****
    /////////////////////////////////////////////////////////////////////////////////////
    void showajouter(Stage stage, String s1, String s2) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(s1));
        stage.setTitle(s2);
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void Fajouter() throws IOException {
        Stage stage = new Stage();
        stage.setResizable(false); /**  test  **/
        s = stage;
        if (perbutt == 1) {
            showajouter(stage, "../sample/ajouterPersonnel.fxml", "Ajouter Personnel");
        } else if (ActButt == 1) {
            showajouter(stage, "../sample/ajouterAction.fxml", "Ajouter Action");
        } else if (SuiButt == 1) {
            showajouter(stage, "../sample/ajouterSuivi.fxml", "Ajouter Suivi");
        }
    }
    /********************************     FILTRER ********************************/
    /****                 Personnel                  *********/

    @FXML
    void FBP1() {
        ButP(btp1, radiobuttomP1, BP1);
        if (btp1){
            btp1 = false;
        datefinp.setVisible(true);
        datefinp.setDisable(false);
        datedebutp.setDisable(false);
        datedebutp.setVisible(true);
        }
        else {
            datefinp.setVisible(false);
            datefinp.setDisable(true);
            datedebutp.setDisable(true);
            datedebutp.setVisible(false);
            btp1 = true;
            BP1.setLayoutX(75);
        }
    }

    @FXML
    void FBP2() {
        ButP(btp2, radiobuttomP2, BP2);
        if (btp2)
            btp2 = false;
        else {
            btp2 = true;
            BP2.setLayoutX(211);
        }
    }

    @FXML
    void FBP3() {
        ButP(btp3, radiobuttomP3, BP3);
        if (btp3)
            btp3 = false;
        else {
            btp3 = true;
            BP3.setLayoutX(367);
        }
    }

    @FXML
    void FBP4() {
        ButP(btp4, radiobuttomP4, BP4);
        if (btp4)
            btp4 = false;
        else {
            btp4 = true;
            BP4.setLayoutX(517);
        }
    }

    @FXML
    void FBP5() {
        ButP(btp5, radiobuttomP5, BP5);
        if (btp5)
            btp5 = false;
        else {
            btp5 = true;
            BP5.setLayoutX(654);
        }
    }

    @FXML
    void FBP6() {
        ButP(btp6, radiobuttomP6, BP6);
        if (btp6)
            btp6 = false;
        else {
            btp6 = true;
            BP6.setLayoutX(793);
        }
    }

    @FXML
    void FBP7() {
        ButP(btp7, radiobuttomP7, BP7);
        if (btp7)
            btp7 = false;
        else {
            btp7 = true;
            BP7.setLayoutX(933);
        }
    }

    @FXML
    void FRBP1() {
        if (RBP1.isSelected()) {
            BP1.setDisable(false);
        } else BP1.setDisable(true);
    }

    @FXML
    void FRBP2() {
        if (RBP2.isSelected()) {
            BP2.setDisable(false);
        } else BP2.setDisable(true);
    }

    @FXML
    void FRBP3() {
        if (RBP3.isSelected()) {
            BP3.setDisable(false);
        } else BP3.setDisable(true);
    }
    @FXML
    void FRBP4() {
        if (RBP4.isSelected()) {
            BP4.setDisable(false);
        } else BP4.setDisable(true);
    }
    @FXML
    void FRBP5() {
        if (RBP5.isSelected()) {
            BP5.setDisable(false);
        } else BP5.setDisable(true);
    }
    @FXML
    void FRBP6() {
        if (RBP6.isSelected()) {
            BP6.setDisable(false);
        } else BP6.setDisable(true);
    }
    @FXML
    void FRBP7() {
        if (RBP7.isSelected()) {
            BP7.setDisable(false);
        } else BP7.setDisable(true);
    }
    /*************************************                       *************************/
    /*************************************    Action             ************************/
    @FXML
    void FBA1() {
        ButA(bta1, radiobuttomA1, BA1);
        if (bta1)
            bta1 = false;
        else {
            bta1 = true;
            BA1.setLayoutX(75);
        }
    }

    @FXML
    void FBA2() {
        ButA(bta2, radiobuttomA2, BA2);
        if (bta2){
            bta2 = false;
            text1.setVisible(true);
            text1.setDisable(false);
            text2.setDisable(false);
            text2.setVisible(true);
        }
        else {
            text1.setVisible(false);
            text1.setDisable(true);
            text2.setDisable(true);
            text2.setVisible(false);
            bta2 = true;
            BA2.setLayoutX(211);
        }
    }

    @FXML
    void FBA3() {
        ButA(bta3, radiobuttomA3, BA3);
        if (bta3){
            bta3 = false;
            text3.setVisible(true);
            text3.setDisable(false);
            text4.setDisable(false);
            text4.setVisible(true);
        }
        else {
            text3.setVisible(false);
            text3.setDisable(true);
            text4.setDisable(true);
            text4.setVisible(false);
            bta3 = true;
            BA3.setLayoutX(367);
        }
    }

    @FXML
    void FBA4() {
        ButA(bta4, radiobuttomA4, BA4);
        if (bta4){
            bta4 = false;
            text5.setVisible(true);
            text5.setDisable(false);
            text6.setDisable(false);
            text6.setVisible(true);
        }
        else {
            text5.setVisible(false);
            text5.setDisable(true);
            text6.setDisable(true);
            text6.setVisible(false);
            bta4 = true;
            BA4.setLayoutX(517);
        }
    }

    @FXML
    void FBA5() {
        ButA(bta5, radiobuttomA5, BA5);
        if (bta5){
            bta5 = false;
            datefina.setVisible(true);
            datefina.setDisable(false);
            datedebuta.setDisable(false);
            datedebuta.setVisible(true);
        }
        else {
            datefina.setVisible(false);
            datefina.setDisable(true);
            datedebuta.setDisable(true);
            datedebuta.setVisible(false);
            bta5 = true;
            BA5.setLayoutX(654);
        }
    }

    @FXML
    void FBA6() {
        ButA(bta6, radiobuttomA6, BA6);
        if (bta6){
            bta6 = false;
            text7.setVisible(true);
            text7.setDisable(false);
            text8.setDisable(false);
            text8.setVisible(true);
        }
        else {
            text7.setVisible(false);
            text7.setDisable(true);
            text8.setDisable(true);
            text8.setVisible(false);
            bta6 = true;
            BA6.setLayoutX(793);
        }
    }

    @FXML
    void FBA7() {
        ButA(bta7, radiobuttomA7, BA7);
        if (bta7)
            bta7 = false;
        else {
            bta7 = true;
            BA7.setLayoutX(933);
        }
    }

    @FXML
    void FRBA1() {
        if (RBA1.isSelected()) {
            BA1.setDisable(false);
        } else BA1.setDisable(true);
    }

    @FXML
    void FRBA2() {
        if (RBA2.isSelected()) {
            BA2.setDisable(false);
        } else BA2.setDisable(true);
    }

    @FXML
    void FRBA3() {
        if (RBA3.isSelected()) {
            BA3.setDisable(false);
        } else BA3.setDisable(true);
    }
    @FXML
    void FRBA4() {
        if (RBA4.isSelected()) {
            BA4.setDisable(false);
        } else BA4.setDisable(true);
    }
    @FXML
    void FRBA5() {
        if (RBA5.isSelected()) {
            BA5.setDisable(false);
        } else BA5.setDisable(true);
    }
    @FXML
    void FRBA6() {
        if (RBA6.isSelected()) {
            BA6.setDisable(false);
        } else BA6.setDisable(true);
    }
    @FXML
    void FRBA7() {
        if (RBA7.isSelected()) {
            BA7.setDisable(false);
        } else BA7.setDisable(true);
    }
    /*********************************                           *********************************/
    /*********************************          Suivi             *******************************/
    @FXML
    void FBS1() {
        ButS(bts1, radiobuttomS1, BS1);
        if (bts1)
            bts1 = false;
        else {
            bts1 = true;
            BS1.setLayoutX(75);
        }
    }

    @FXML
    void FBS2() {
        ButS(bts2, radiobuttomS2, BS2);
        if (bts2)
            bts2 = false;
        else {
            bts2 = true;
            BS2.setLayoutX(225);
        }
    }

    @FXML
    void FBS3() {
        ButS(bts3, radiobuttomS3, BS3);
        if (bts3)
            bts3 = false;
        else {
            bts3 = true;
            BS3.setLayoutX(375);
        }
    }

    @FXML
    void FBS4() {
        ButS(bts4, radiobuttomS4, BS4);
        if (bts4){
            bts4 = false;
            datedebuts.setVisible(true);
            datedebuts.setDisable(false);
        }
        else {
            datedebuts.setVisible(false);
            datedebuts.setDisable(true);
            bts4 = true;
            BS4.setLayoutX(525);
        }
    }

    @FXML
    void FBS5() {
        ButS(bts5, radiobuttomS5, BS5);
        if (bts5){
            bts5 = false;
            datefins.setVisible(true);
            datefins.setDisable(false);
        }
        else {
            datefins.setVisible(false);
            datefins.setDisable(true);
            bts5 = true;
            BS5.setLayoutX(675);
        }
    }

    @FXML
    void FBS6() {
        ButS(bts6, radiobuttomS6, BS6);
        if (bts6)
            bts6 = false;
        else {
            bts6 = true;
            BS6.setLayoutX(825);
        }
    }

    @FXML
    void FBS7() {
        ButS(bts7, radiobuttomS7, BS7);
        if (bts7)
            bts7 = false;
        else {
            bts7 = true;
            BS7.setLayoutX(975);
        }
    }
    @FXML
    void FBS8() {
        ButS(bts8, radiobuttomS8, BS8);
        if (bts8)
            bts8 = false;
        else {
            bts8 = true;
            BS8.setLayoutX(1125);
        }
    }
    @FXML
    void FBS9() {
        ButS(bts9, radiobuttomS9, BS9);
        if (bts9)
            bts9 = false;
        else {
            bts9 = true;
            BS9.setLayoutX(1275);
        }
    }
    @FXML
    void FBS10() {
        ButS(bts10, radiobuttomS10, BS10);
        if (bts10)
            bts10 = false;
        else {
            bts10 = true;
            BS10.setLayoutX(1425);
        }
    }
    @FXML
    void FBS11() {
        ButS(bts11, radiobuttomS11, BS11);
        if (bts11)
            bts11 = false;
        else {
            bts11 = true;
            BS11.setLayoutX(1575);
        }
    }
    @FXML
    void FBS12() {
        ButS(bts12, radiobuttomS12, BS12);
        if (bts12)
            bts12 = false;
        else {
            bts12 = true;
            BS12.setLayoutX(1725);
        }
    }
    @FXML
    void FBS13() {
        ButS(bts13, radiobuttomS13, BS13);
        if (bts13)
            bts13 = false;
        else {
            bts13 = true;
            BS13.setLayoutX(1875);
        }
    }
    @FXML
    void FBS14() {
        ButS(bts14, radiobuttomS14, BS14);
        if (bts14)
            bts14 = false;
        else {
            bts14 = true;
            BS14.setLayoutX(2025);
        }
    }
    @FXML
    void FBS15() {
        ButS(bts15, radiobuttomS15, BS15);
        if (bts15)
            bts15 = false;
        else {
            bts15 = true;
            BS15.setLayoutX(2175);
        }
    }

    @FXML
    void FRBS1() {
        if (RBS1.isSelected()) {
            BS1.setDisable(false);
        } else BS1.setDisable(true);
    }

    @FXML
    void FRBS2() {
        if (RBS2.isSelected()) {
            BS2.setDisable(false);
        } else BS2.setDisable(true);
    }

    @FXML
    void FRBS3() {
        if (RBS3.isSelected()) {
            BS3.setDisable(false);
        } else BS3.setDisable(true);
    }
    @FXML
    void FRBS4() {
        if (RBS4.isSelected()) {
            BS4.setDisable(false);
        } else BS4.setDisable(true);
    }
    @FXML
    void FRBS5() {
        if (RBS5.isSelected()) {
            BS5.setDisable(false);
        } else BS5.setDisable(true);
    }
    @FXML
    void FRBS6() {
        if (RBS6.isSelected()) {
            BS6.setDisable(false);
        } else BS6.setDisable(true);
    }
    @FXML
    void FRBS7() {
        if (RBS7.isSelected()) {
            BS7.setDisable(false);
        } else BP7.setDisable(true);
    }
    @FXML
    void FRBS8() {
        if (RBS8.isSelected()) {
            BS8.setDisable(false);
        } else BS8.setDisable(true);
    }
    @FXML
    void FRBS9() {
        if (RBS9.isSelected()) {
            BS9.setDisable(false);
        } else BS9.setDisable(true);
    }
    @FXML
    void FRBS10() {
        if (RBS10.isSelected()) {
            BS10.setDisable(false);
        } else BS10.setDisable(true);
    }
    @FXML
    void FRBS11() {
        if (RBS11.isSelected()) {
            BS11.setDisable(false);
        } else BS11.setDisable(true);
    }
    @FXML
    void FRBS12() {
        if (RBS12.isSelected()) {
            BS12.setDisable(false);
        } else BS12.setDisable(true);
    }
    @FXML
    void FRBS13() {
        if (RBS13.isSelected()) {
            BS13.setDisable(false);
        } else BS13.setDisable(true);
    }
    @FXML
    void FRBS14() {
        if (RBS14.isSelected()) {
            BS14.setDisable(false);
        } else BS14.setDisable(true);
    }
    @FXML
    void FRBS15() {
        if (RBS15.isSelected()) {
            BS15.setDisable(false);
        } else BS15.setDisable(true);
    }

    void testP(Button butt, ObservableList<JFXCheckBox> radiobuttom) {
        for (JFXCheckBox chbox : radiobuttom) {
            chbox.setVisible(true);
            chbox.setDisable(false);
        }
        disableallbuttonP(true);
        visibleallbuttonP(false);
        disableallRadiobuttonP(true);
        visibleallRadiobuttonP(false);
        butt.setVisible(true);
        butt.setDisable(false);
        butt.setLayoutX(50);
    }
    void testA(Button butt, ObservableList<JFXCheckBox> radiobuttom) {
        for (JFXCheckBox chbox : radiobuttom) {
            chbox.setVisible(true);
            chbox.setDisable(false);
        }
        disableallbuttonA(true);
        visibleallbuttonA(false);
        disableallRadiobuttonA(true);
        visibleallRadiobuttonA(false);
        butt.setVisible(true);
        butt.setDisable(false);
        butt.setLayoutX(50);
    }
    void testS(Button butt, ObservableList<JFXCheckBox> radiobuttom) {
        for (JFXCheckBox chbox : radiobuttom) {
            chbox.setVisible(true);
            chbox.setDisable(false);
        }
        disableallbuttonS(true);
        visibleallbuttonS(false);
        disableallRadiobuttonS(true);
        visibleallRadiobuttonS(false);
        butt.setVisible(true);
        butt.setDisable(false);
        butt.setLayoutX(50);
    }

    public void ButP(boolean b, ObservableList<JFXCheckBox> cb, Button bp) {
        if (b) {
            fil.setDisable(true);
            Cancel.setDisable(true);
            Cancel.setVisible(false);
            testP(bp, cb);
            if (cb.size() > 2)
                ANP.setPrefHeight(20 + cb.size() * 30);
            else ANP.setPrefHeight(98);
        } else {
            fil.setDisable(false);
            Cancel.setVisible(true);
            Cancel.setDisable(false);
            visibleallbuttonP(true);
            disableallRadiobuttonP(false);
            visibleallRadiobuttonP(true);
            ANP.setPrefHeight(98);
            for (JFXCheckBox JF : cb) {
                JF.setVisible(false);
                JF.setDisable(true);
            }
        }
    }
    public void ButA(boolean b, ObservableList<JFXCheckBox> cb, Button bp) {
        if (b) {
            fil.setDisable(true);
            Cancel.setDisable(true);
            Cancel.setVisible(false);
            testA(bp, cb);
            if (cb.size() > 2)
                ANA.setPrefHeight(20 + cb.size() * 30);
            else ANA.setPrefHeight(98);
        } else {
            fil.setDisable(false);
            Cancel.setVisible(true);
            Cancel.setDisable(false);
            visibleallbuttonA(true);
            disableallRadiobuttonA(false);
            visibleallRadiobuttonA(true);
            ANA.setPrefHeight(98);
            for (JFXCheckBox JF : cb) {
                JF.setVisible(false);
                JF.setDisable(true);
            }
        }
    }
    public void ButS(boolean b, ObservableList<JFXCheckBox> cb, Button bp) {
        if (b) {
            fil.setDisable(true);
            Cancel.setDisable(true);
            Cancel.setVisible(false);
            testS(bp, cb);
            if (cb.size() > 2)
                ANS.setPrefHeight(20 + cb.size() * 30);
            else ANS.setPrefHeight(98);
        } else {
            fil.setDisable(false);
            Cancel.setVisible(true);
            Cancel.setDisable(false);
            visibleallbuttonS(true);
            disableallRadiobuttonS(false);
            visibleallRadiobuttonS(true);
            ANS.setPrefHeight(98);
            for (JFXCheckBox JF : cb) {
                JF.setVisible(false);
                JF.setDisable(true);
            }
        }
    }

    /********************************                   disable visible  ******************************/
    //                                   Personnel
    public void diselectallRbuttonP(boolean b){
        RBP1.setSelected(!b);
        RBP2.setSelected(!b);
        RBP3.setSelected(!b);
        RBP4.setSelected(!b);
        RBP5.setSelected(!b);
        RBP6.setSelected(!b);
        RBP7.setSelected(!b);
    }
    public void disableallbuttonP(boolean b){
        if (!RBP1.isSelected())BP1.setDisable(b);
        if (!RBP2.isSelected())BP2.setDisable(b);
        if (!RBP3.isSelected())BP3.setDisable(b);
        if (!RBP4.isSelected())BP4.setDisable(b);
        if (!RBP5.isSelected())BP5.setDisable(b);
        if (!RBP6.isSelected())BP6.setDisable(b);
        if (!RBP7.isSelected())BP7.setDisable(b);
    }
    public void visibleallbuttonP(boolean b){
        BP1.setVisible(b);
        BP2.setVisible(b);
        BP3.setVisible(b);
        BP4.setVisible(b);
        BP5.setVisible(b);
        BP6.setVisible(b);
        BP7.setVisible(b);
    }
    public void disableallRadiobuttonP(boolean b){
        RBP1.setDisable(b);
        RBP2.setDisable(b);
        RBP3.setDisable(b);
        RBP4.setDisable(b);
        RBP5.setDisable(b);
        RBP6.setDisable(b);
        RBP7.setDisable(b);
    }
    public void visibleallRadiobuttonP(boolean b){
        RBP1.setVisible(b);
        RBP2.setVisible(b);
        RBP3.setVisible(b);
        RBP4.setVisible(b);
        RBP5.setVisible(b);
        RBP6.setVisible(b);
        RBP7.setVisible(b);
    }
    //                                 Action
    public void diselectallRbuttonA(boolean b){
        RBA1.setSelected(!b);
        RBA2.setSelected(!b);
        RBA3.setSelected(!b);
        RBA4.setSelected(!b);
        RBA5.setSelected(!b);
        RBA6.setSelected(!b);
        RBA7.setSelected(!b);
    }
    public void disableallbuttonA(boolean b){
        if (!RBA1.isSelected())BA1.setDisable(b);
        if (!RBA2.isSelected())BA2.setDisable(b);
        if (!RBA3.isSelected())BA3.setDisable(b);
        if (!RBA4.isSelected())BA4.setDisable(b);
        if (!RBA5.isSelected())BA5.setDisable(b);
        if (!RBA6.isSelected())BA6.setDisable(b);
        if (!RBA7.isSelected())BA7.setDisable(b);
    }
    public void visibleallbuttonA(boolean b){
        BA1.setVisible(b);
        BA2.setVisible(b);
        BA3.setVisible(b);
        BA4.setVisible(b);
        BA5.setVisible(b);
        BA6.setVisible(b);
        BA7.setVisible(b);
    }
    public void disableallRadiobuttonA(boolean b){
        RBA1.setDisable(b);
        RBA2.setDisable(b);
        RBA3.setDisable(b);
        RBA4.setDisable(b);
        RBA5.setDisable(b);
        RBA6.setDisable(b);
        RBA7.setDisable(b);
    }
    public void visibleallRadiobuttonA(boolean b){
        RBA1.setVisible(b);RBA2.setVisible(b);RBA3.setVisible(b);RBA4.setVisible(b);RBA5.setVisible(b);RBA6.setVisible(b);
        RBA7.setVisible(b);
    }
    //                                Suivi
    public void diselectallRbuttonS(boolean b){
        RBS1.setSelected(!b);
        RBS2.setSelected(!b);
        RBS3.setSelected(!b);
        RBS4.setSelected(!b);
        RBS5.setSelected(!b);
        RBS6.setSelected(!b);
        RBS7.setSelected(!b);
        RBS8.setSelected(!b);
        RBS9.setSelected(!b);
        RBS10.setSelected(!b);
        RBS11.setSelected(!b);
        RBS12.setSelected(!b);
        RBS13.setSelected(!b);
        RBS14.setSelected(!b);
        RBS15.setSelected(!b);
    }
    public void disableallbuttonS(boolean b){
        if (!RBS1.isSelected())BS1.setDisable(b);
        if (!RBS2.isSelected())BS2.setDisable(b);
        if (!RBS3.isSelected())BS3.setDisable(b);
        if (!RBS4.isSelected())BS4.setDisable(b);
        if (!RBS5.isSelected())BS5.setDisable(b);
        if (!RBS6.isSelected())BS6.setDisable(b);
        if (!RBS7.isSelected())BS7.setDisable(b);
        if (!RBS8.isSelected())BS8.setDisable(b);
        if (!RBS9.isSelected())BS9.setDisable(b);
        if (!RBS10.isSelected())BS10.setDisable(b);
        if (!RBS11.isSelected())BS11.setDisable(b);
        if (!RBS12.isSelected())BS12.setDisable(b);
        if (!RBS13.isSelected())BS13.setDisable(b);
        if (!RBS14.isSelected())BS14.setDisable(b);
        if (!RBS15.isSelected())BS15.setDisable(b);

    }
    public void visibleallbuttonS(boolean b){
        BS1.setVisible(b);
        BS2.setVisible(b);
        BS3.setVisible(b);
        BS4.setVisible(b);
        BS5.setVisible(b);
        BS6.setVisible(b);
        BS7.setVisible(b);
        BS8.setVisible(b);
        BS9.setVisible(b);
        BS10.setVisible(b);
        BS11.setVisible(b);
        BS12.setVisible(b);
        BS13.setVisible(b);
        BS14.setVisible(b);
        BS15.setVisible(b);
    }
    public void disableallRadiobuttonS(boolean b){
        RBS1.setDisable(b);
        RBS2.setDisable(b);
        RBS3.setDisable(b);
        RBS4.setDisable(b);
        RBS5.setDisable(b);
        RBS6.setDisable(b);
        RBS7.setDisable(b);
        RBS8.setDisable(b);
        RBS9.setDisable(b);
        RBS10.setDisable(b);
        RBS11.setDisable(b);
        RBS12.setDisable(b);
        RBS13.setDisable(b);
        RBS14.setDisable(b);
        RBS15.setDisable(b);

    }
    public void visibleallRadiobuttonS(boolean b){
        RBS1.setVisible(b);
        RBS2.setVisible(b);
        RBS3.setVisible(b);
        RBS4.setVisible(b);
        RBS5.setVisible(b);
        RBS6.setVisible(b);
        RBS7.setVisible(b);
        RBS8.setVisible(b);
        RBS9.setVisible(b);
        RBS10.setVisible(b);
        RBS11.setVisible(b);
        RBS12.setVisible(b);
        RBS13.setVisible(b);
        RBS14.setVisible(b);
        RBS15.setVisible(b);

    }
    /********************************                            *******************************/

    /*******************************              CHOIX                       **************************/
    ArrayList<String> choixP(int i) {
        switch (i) {
            case 0:
                datedebutp =new DatePicker();
                datefinp =new DatePicker();
                datedebutp.setValue(LocalDate.parse("2016-01-01", DateTimeFormatter.ofPattern("yyyy-MM-dd"))); //TODO arreter la reinitialisation des dates au click boutton
                datefinp.setValue(LocalDate.parse("2020-12-31", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                datedebutp.setLayoutX(300);
                datedebutp.setPromptText("Date début");
                datefinp.setPromptText("Date fin");
                datedebutp.setLayoutY(15);
                datedebutp.setDisable(true);
                datefinp.setDisable(true);
                datedebutp.setVisible(false);
                datefinp.setVisible(false);
                datefinp.setLayoutX(500);
                datefinp.setLayoutY(15);
                ANP.getChildren().add(datedebutp);
                ANP.getChildren().add(datefinp);
                return null;
            case 1:
                return (ArrayList<String>) Operateur.importer_choix("poste");
            case 2:
                return (ArrayList<String>) Operateur.importer_choix("type_emploi");

            case 3:
                return (ArrayList<String>) Operateur.importer_choix("categorie");

            case 4:
                return (ArrayList<String>) Operateur.importer_choix("direction");

            case 5:
                return (ArrayList<String>) Operateur.importer_choix("departement");

            case 6:
                return (ArrayList<String>) Operateur.importer_choix("service");
            default:return null;
        }
    }
    ArrayList<String> choixA(int i) {
        switch (i) {
            case 0:
                return (ArrayList<String>) Operateur.importer_choix("structure");
            case 1:
                text1 =new TextField();
                text2 =new TextField();
                text1.setLayoutX(300);
                text1.setPromptText("MIN");
                text2.setPromptText("MAX");
                text1.setLayoutY(15);
                text1.setDisable(true);
                text2.setDisable(true);
                text1.setVisible(false);
                text2.setVisible(false);
                text2.setLayoutX(500);
                text2.setLayoutY(15);
                ANA.getChildren().add(text1);
                ANA.getChildren().add(text2);
                return null;
            case 2:
                text3 =new TextField();
                text4 =new TextField();
                text3.setLayoutX(300);
                text3.setPromptText("MIN");
                text4.setPromptText("MAX");
                text3.setLayoutY(15);
                text3.setDisable(true);
                text4.setDisable(true);
                text3.setVisible(false);
                text4.setVisible(false);
                text4.setLayoutX(500);
                text4.setLayoutY(15);
                ANA.getChildren().add(text3);
                ANA.getChildren().add(text4);
                return null;
            case 3:
                text5 =new TextField();
                text6 =new TextField();
                text5.setLayoutX(300);
                text5.setPromptText("MIN");
                text6.setPromptText("MAX");
                text5.setLayoutY(15);
                text5.setDisable(true);
                text6.setDisable(true);
                text5.setVisible(false);
                text6.setVisible(false);
                text6.setLayoutX(500);
                text6.setLayoutY(15);
                ANA.getChildren().add(text5);
                ANA.getChildren().add(text6);
                return null;
            case 4:
                datedebuta =new DatePicker();
                datefina =new DatePicker();
                datedebuta.setValue(LocalDate.parse("2016-01-01", DateTimeFormatter.ofPattern("yyyy-MM-dd"))); //TODO arreter la reinitialisation des dates au click boutton
                datefina.setValue(LocalDate.parse("2020-12-31", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                datedebuta.setLayoutX(300);
                datedebuta.setPromptText("Date début");
                datefina.setPromptText("Date fin");
                datedebuta.setLayoutY(15);
                datedebuta.setDisable(true);
                datefina.setDisable(true);
                datedebuta.setVisible(false);
                datefina.setVisible(false);
                datefina.setLayoutX(500);
                datefina.setLayoutY(15);
                ANA.getChildren().add(datedebuta);
                ANA.getChildren().add(datefina);
                return null;
            case 5:
                text7 =new TextField();
                text8 =new TextField();
                text7.setLayoutX(300);
                text7.setPromptText("MIN");
                text8.setPromptText("MAX");
                text7.setLayoutY(15);
                text7.setDisable(true);
                text8.setDisable(true);
                text7.setVisible(false);
                text8.setVisible(false);
                text8.setLayoutX(500);
                text8.setLayoutY(15);
                ANA.getChildren().add(text7);
                ANA.getChildren().add(text8);
                return null;
            case 6:
                return (ArrayList<String>) Operateur.importer_choix("organisme");
            default:return null;
        }
    }
    ArrayList<String> choixS(int i) {
        switch (i) {
            case 0:
                return (ArrayList<String>) Operateur.importer_choix("poste");
            case 1:
                return (ArrayList<String>) Operateur.importer_choix("direction");
            case 2:
                return (ArrayList<String>) Operateur.importer_choix("categorie");

            case 3:
                datedebuts =new DatePicker();
                datedebuts.setLayoutX(300);
                datedebuts.setPromptText("Date début");
                datedebuts.setValue(LocalDate.parse("2016-12-31", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                datedebuts.setLayoutY(15);
                datedebuts.setDisable(true);
                datedebuts.setVisible(false);
                ANS.getChildren().add(datedebuts);
                return null;
            case 4:
                datefins =new DatePicker();
                datefins.setLayoutX(300);
                datefins.setPromptText("Date fin");
                datefins.setValue(LocalDate.parse("2020-12-31", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                datefins.setDisable(true);
                datefins.setVisible(false);
                datefins.setLayoutY(15);
                ANS.getChildren().add(datefins);
                return null;
            case 5:
                return (ArrayList<String>) Operateur.importer_choix("type_formation");

            case 6:
                return (ArrayList<String>) Operateur.importer_choix("organisme");
            case 7:
                return (ArrayList<String>) Operateur.importer_choix("lieu_formation");

            case 8:
                return (ArrayList<String>) Operateur.importer_choix("lieu_formation_2");
            case 9:
                return (ArrayList<String>) Operateur.importer_choix("type_formation_2");

            case 10:
                ArrayList<String> liste = new ArrayList<String>();
                liste.add("Planifié");
                liste.add("Hors Plan");
                return liste;
            case 11:
                ArrayList<String> liste1 = new ArrayList<String>();
                liste1.add("Oui");
                liste1.add("Non");
                return liste1;

            case 12:
                return (ArrayList<String>) Operateur.importer_choix("avis_evaluation_organisme");
            case 13:
                return (ArrayList<String>) Operateur.importer_choix("avis_retour_evaluation");

            case 14:
                return (ArrayList<String>) Operateur.importer_choix("action_evaluation_insuffisante");

            default:return null;
        }
    }
    void OffScrollpane (ScrollPane scrollPane){
        scrollPane.setDisable(true);
        scrollPane.setVisible(false);
        scrollPane.setPrefHeight(0);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
    }
    void OnScrollpane (ScrollPane scrollPane){
        scrollPane.setDisable(false);
        scrollPane.setVisible(true);
        scrollPane.setPrefHeight(100);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
    }
    @FXML
    void Filtrer() {
        if (k==0) {
            try {
                k = 1;
                Cancel.setDisable(false);
                Cancel.setVisible(true);
                ArrayList<String> list = new ArrayList<String>();
                filterField.setDisable(true);
                Ajouter.setDisable(true);
                Per.setDisable(true);
                Act.setDisable(true);
                Actp.setDisable(true);
                Actnp.setDisable(true);
                Sui.setDisable(true);
                /*********************            Personnel                    ******************/
                if (perbutt == 1) {
                    OnScrollpane(filterscp);
                    visibleallbuttonP(true);
                    disableallbuttonP(true);
                    visibleallRadiobuttonP(true);
                    disableallRadiobuttonP(false);
                    list = choixP(0);
                    int u = 1;
                    radiobuttomP.addAll(radiobuttomP2, radiobuttomP3, radiobuttomP4, radiobuttomP5, radiobuttomP6, radiobuttomP7);
                    for (ObservableList<JFXCheckBox> father : radiobuttomP) {
                        list = (ArrayList<String>) choixP(u);
                        u++;
                        for (int i = 0; i < list.size(); i++) {
                            JFXCheckBox rb = new JFXCheckBox();
                            rb.setText((String) list.get(i));
                            rb.setLayoutX(300);
                            rb.setLayoutY(5 + i * 30);
                            rb.setDisable(true);
                            rb.setVisible(false);
                            rb.setStyle("-fx-text-fill : #FFF");
                            ANP.getChildren().add(rb);
                            father.add(rb);
                        }
                    }
                } else if (ActButt == 1) {
                    OnScrollpane(filtersca);
                    visibleallbuttonA(true);
                    disableallbuttonA(true);
                    visibleallRadiobuttonA(true);
                    disableallRadiobuttonA(false);
                    filtersca.setVisible(true);
                    filtersca.setDisable(false);
                    list = choixA(1);
                    list = choixA(2);
                    list = choixA(3);
                    list = choixA(4);
                    list = choixA(5);
                    radiobuttomA.addAll(radiobuttomA1, radiobuttomA7);
                    for (int u = 0; u < 2; u++) {
                        if (u==0)
                                list = choixA(0);
                            if (u==1)
                                list = choixA(6);
                        for (int i = 0; i < list.size(); i++) {
                            JFXCheckBox rb = new JFXCheckBox();
                            rb.setText((String) list.get(i));
                            rb.setLayoutX(300);
                            rb.setLayoutY(5 + i * 30);
                            rb.setDisable(true);
                            rb.setVisible(false);
                            rb.setStyle("-fx-text-fill : #FFF");
                            ANA.getChildren().add(rb);
                                if (u==0)
                                    radiobuttomA1.add(rb);
                                if (u==1)
                                    radiobuttomA7.add(rb);
                        }
                    }
                } else if (SuiButt == 1) {
                    OnScrollpane(filterscs);
                    filterscp.setPrefHeight(0);
                    filtersca.setPrefHeight(0);
                    filterscs.setPrefHeight(100);
                    visibleallbuttonS(true);
                    disableallbuttonS(true);
                    visibleallRadiobuttonS(true);
                    disableallRadiobuttonS(false);
                    filterscs.setVisible(true);
                    filterscs.setDisable(false);
                    list = choixS(3);
                    list = choixS(4);
                    int u = 0;
                    radiobuttomS.addAll(radiobuttomS1, radiobuttomS2, radiobuttomS3, radiobuttomS6, radiobuttomS7, radiobuttomS8, radiobuttomS9, radiobuttomS10, radiobuttomS11,  radiobuttomS12, radiobuttomS13, radiobuttomS14, radiobuttomS15);
                    for (ObservableList<JFXCheckBox> father : radiobuttomS) {
                        list = (ArrayList<String>) choixS(u);
                        if (u == 2) u +=2;
                        u++;
                        for (int i = 0; i < list.size(); i++) {
                            JFXCheckBox rb = new JFXCheckBox();
                            rb.setText((String) list.get(i));
                            rb.setLayoutX(300);
                            rb.setLayoutY(5 + i * 30);
                            rb.setDisable(true);
                            rb.setVisible(false);
                            rb.setStyle("-fx-text-fill : #FFF");
                            ANS.getChildren().add(rb);
                            father.add(rb);
                        }
                    }
                } }catch(Exception e){
                    e.printStackTrace();
                }
            } else{
            fil.setDisable(true);
            k=0;
            if (perbutt == 1){
                Filtre_date filtre_datep = null;
                OffScrollpane(filterscp);
                if(RBP1.isSelected()){
                    filtre_datep = new Filtre_date(java.sql.Date.valueOf(datedebutp.getValue()),java.sql.Date.valueOf(datefinp.getValue()));
                }
                ArrayList<ArrayList<String>> lfp = new ArrayList<ArrayList<String>>();
                for (ObservableList<JFXCheckBox> father : radiobuttomP) {
                    ArrayList<String> table = new ArrayList<String>();
                    for (int i = 0; i < father.size(); i++) {
                        if (father.get(i).isSelected()) table.add(father.get(i).getText());
                    }
                    lfp.add(table);
                }
                Pdata = FXCollections.observableArrayList(Operateur.importer_peronnel(Operateur.array_to_filtre_personnel(lfp),filtre_datep));
                tableP.setItems(Pdata);
            }else if (ActButt == 1){
                OffScrollpane(filtersca);
                Filtre_date filtre_datea = null;
                Filtre_entier filtre_entier1 = null,filtre_entier2 =null,filtre_entier3=null,filtre_entier4=null;
                filtersca.setVisible(false);
                filtersca.setDisable(true);
                if(RBA5.isSelected()){
                    filtre_datea = new Filtre_date(java.sql.Date.valueOf(datedebuta.getValue()),java.sql.Date.valueOf(datefina.getValue()));
                }
                ArrayList<ArrayList<String>> lfa = new ArrayList<ArrayList<String>>();
                for (ObservableList<JFXCheckBox> father : radiobuttomA) {
                    ArrayList<String> table = new ArrayList<String>();
                    for (int i = 0; i < father.size(); i++) {
                        if (father.get(i).isSelected()) table.add(father.get(i).getText());
                    }
                    lfa.add(table);
                }
                if (RBA5.isSelected())  filtre_datea = new Filtre_date(java.sql.Date.valueOf(datedebuta.getValue()),java.sql.Date.valueOf(datefina.getValue()));
                if ((RBA2.isSelected())&&((text1.getText().equals(null))&&(text2.getText().equals(null)))) { filtre_entier1 = new Filtre_entier(Integer.valueOf(text1.getText()),Integer.valueOf(text2.getText()));}
                if ((RBA3.isSelected())&&((text3.getText().equals(null))&&(text4.getText().equals(null))))  filtre_entier2 = new Filtre_entier(Integer.valueOf(text3.getText()),Integer.valueOf(text4.getText()));
                if ((RBA4.isSelected())&&((text5.getText().equals(null))&&(text6.getText().equals(null))))  filtre_entier3 = new Filtre_entier(Integer.valueOf(text5.getText()),Integer.valueOf(text6.getText()));
                if ((RBA7.isSelected())&&((text7.getText().equals(null))&&(text8.getText().equals(null))))  filtre_entier4 = new Filtre_entier(Integer.valueOf(text7.getText()),Integer.valueOf(text8.getText()));
                ArrayList<Filtre_entier>  fil_ent= new ArrayList<Filtre_entier>();
                fil_ent.add(filtre_entier1);
                fil_ent.add(filtre_entier2);
                fil_ent.add(filtre_entier3);
                fil_ent.add(filtre_entier4);
                if (ActpButt == 1){
                    Adata = FXCollections.observableArrayList(Operateur.importer_action("actions_planif",Operateur.array_to_filtre_action(lfa,fil_ent),filtre_datea));
                tableA.setItems(Adata);
                }
                else if (ActnButt==1){
                    Andata = FXCollections.observableArrayList(Operateur.importer_action("actions_non_planif",Operateur.array_to_filtre_action(lfa,fil_ent),filtre_datea));
                    tableA.setItems(Andata);
                }
            }else if (SuiButt == 1){
                OffScrollpane(filterscs);
                Filtre_date filtre_dates = null;
                filterscs.setVisible(false);
                filterscs.setDisable(true);
                if((RBS4.isSelected())&&(RBS5.isSelected())){
                    filtre_dates = new Filtre_date(java.sql.Date.valueOf(datedebuts.getValue()),java.sql.Date.valueOf(datefins.getValue()));
                }

                ArrayList<ArrayList<String>> lfs = new ArrayList<ArrayList<String>>();
                for (ObservableList<JFXCheckBox> father : radiobuttomS) {
                    ArrayList<String> table = new ArrayList<String>();
                    for (int i = 0; i < father.size(); i++) {
                        if (father.get(i).isSelected()) table.add(father.get(i).getText());
                    }
                    lfs.add(table);
                }
                    Sdata = FXCollections.observableArrayList(Operateur.importer_suivi(Operateur.array_to_filtre_suivi(lfs),filtre_dates));
                    tableS.setItems(Sdata);
                }
            }
        }
    @FXML
    void FCancel() {
        Per.setDisable(false);
        Act.setDisable(false);
        Actp.setDisable(false);
        Actnp.setDisable(false);
        Sui.setDisable(false);
        if (perbutt == 1){
            filtre_personnel =new Filtre_personnel();
            pfonc();
            radiobuttomP1 = FXCollections.observableArrayList();
            radiobuttomP2 = FXCollections.observableArrayList();
            radiobuttomP3 = FXCollections.observableArrayList();
            radiobuttomP5 = FXCollections.observableArrayList();
            radiobuttomP4 = FXCollections.observableArrayList();
            radiobuttomP6 = FXCollections.observableArrayList();
            radiobuttomP7 = FXCollections.observableArrayList();
            radiobuttomP  = FXCollections.observableArrayList();
            diselectallRbuttonP(true);
            visibleallRadiobuttonP(false);
            visibleallbuttonP(false);
            disableallbuttonP(true);
            disableallRadiobuttonP(true);
            OffScrollpane(filterscp);
        }else if (ActButt == 1){
            filtre_action = new Filtre_action();
            radiobuttomA1 = FXCollections.observableArrayList();
            radiobuttomA2 = FXCollections.observableArrayList();
            radiobuttomA3 = FXCollections.observableArrayList();
            radiobuttomA4 = FXCollections.observableArrayList();
            radiobuttomA5 = FXCollections.observableArrayList();
            radiobuttomA6 = FXCollections.observableArrayList();
            radiobuttomA7 = FXCollections.observableArrayList();
            radiobuttomA = FXCollections.observableArrayList();
            diselectallRbuttonA(true);
            visibleallRadiobuttonA(false);
            visibleallbuttonA(false);
            disableallbuttonA(true);
            disableallRadiobuttonA(true);
            OffScrollpane(filtersca);
            if (ActpButt == 1){
                apfonc();
            }else if (ActnButt == 1){
                anfonc();
            }

        }else if (SuiButt == 1){
            filtre_suivi = new Filtre_suivi();
            sfonc();
            radiobuttomS1 = FXCollections.observableArrayList();
            radiobuttomS2 = FXCollections.observableArrayList();
            radiobuttomS3 = FXCollections.observableArrayList();
            radiobuttomS4 = FXCollections.observableArrayList();
            radiobuttomS5 = FXCollections.observableArrayList();
            radiobuttomS6 = FXCollections.observableArrayList();
            radiobuttomS7 = FXCollections.observableArrayList();
            radiobuttomS8 = FXCollections.observableArrayList();
            radiobuttomS9 = FXCollections.observableArrayList();
            radiobuttomS10 = FXCollections.observableArrayList();
            radiobuttomS11 = FXCollections.observableArrayList();
            radiobuttomS12 = FXCollections.observableArrayList();
            radiobuttomS13 = FXCollections.observableArrayList();
            radiobuttomS14 = FXCollections.observableArrayList();
            radiobuttomS15 = FXCollections.observableArrayList();
            radiobuttomS = FXCollections.observableArrayList();
            diselectallRbuttonS(true);
            visibleallRadiobuttonS(false);
            visibleallbuttonS(false);
            disableallbuttonS(true);
            disableallRadiobuttonS(true);
            OffScrollpane(filterscs);
        }
        k=0;
        Cancel.setDisable(true);
        Cancel.setVisible(false);
        fil.setDisable(false);
        Ajouter.setDisable(false);
        supprimer.setDisable(false);
        filterField.setDisable(false);
    }
    /**************************************************************************************/
    public void onoffT (TableView T , String f){
        if (f == "on"){
            T.setVisible(true);
            T.setDisable(false);
        }else{
            T.setVisible(false);
            T.setDisable(true);
        }
    }
    @FXML public void pfonc(){
        try {
            Logo.setVisible(false);
            Logo.setDisable(true);
            Ajouter.setDisable(false);
            Vider.setDisable(false);
            supprimer.setDisable(false);
            fil.setDisable(false);
            filterField.setDisable(false);
            filterField.setText("");
            perbutt = 1;ActButt=0;SuiButt=0;ActpButt=0;ActnButt=0;
            onoffT(tableP,"on");
            onoffT(tableA,"off");
            onoffT(tableS,"off");
            Pdata = FXCollections.observableArrayList(Operateur.importer_peronnel((filtre_personnel),null));
            tableP.setItems(Pdata);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML public void afonc(){
        try {
            /***             Button Action recoit Button planif et non planif         ***/
            Act.setVisible(false);
            Act.setDisable(true);
            Actnp.setDisable(false);
            Actnp.setVisible(true);
            Actp.setVisible(true);
            Actp.setDisable(false);
            Act.setPrefHeight(0);
            Actp.setPrefHeight(56);
            Actnp.setPrefHeight(56.5);
            /****************************************               *****************************/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML public void apfonc(){
        Logo.setVisible(false);
        Logo.setDisable(true);
        perbutt = 0;ActButt=1;SuiButt=0;
        Vider.setDisable(false);
        ActnButt =0;
        ActpButt = 1;
        Ajouter.setDisable(false);
        supprimer.setDisable(false);
        fil.setDisable(false);
        filterField.setDisable(false);
        onoffT(tableP,"off");
        onoffT(tableA,"on");
        onoffT(tableS,"off");
        Adata = FXCollections.observableArrayList(Operateur.importer_action("actions_planif",new Filtre_action(),null));
        tableA.setItems(Adata);
        filterField.setText("");
    }
    @FXML public void anfonc(){
        Logo.setVisible(false);
        Logo.setDisable(true);
        perbutt = 0;ActButt=1;SuiButt=0;
        ActnButt =1;
        Vider.setDisable(false);
        Ajouter.setDisable(false);
        supprimer.setDisable(false);
        fil.setDisable(false);
        filterField.setDisable(false);
        ActpButt =0;
        onoffT(tableP,"off");
        onoffT(tableA,"on");
        onoffT(tableS,"off");
        Andata = FXCollections.observableArrayList(Operateur.importer_action("actions_non_planif",new Filtre_action(),null));
        tableA.setItems(Andata);
        filterField.setText("");
    }
    @FXML public void sfonc(){
        try {
            Logo.setVisible(false);
            Logo.setDisable(true);
            Ajouter.setDisable(false);
            Vider.setDisable(false);
            supprimer.setDisable(false);
            fil.setDisable(false);
            filterField.setDisable(false);
            filterField.setText("");
            perbutt = 0;ActButt=0;SuiButt=1;ActpButt=0;ActnButt=0;
            onoffT(tableP,"off");
            onoffT(tableA,"off");
            onoffT(tableS,"on");
            Sdata = FXCollections.observableArrayList(Operateur.importer_suivi(new Filtre_suivi(),null));

            tableS.setItems(Sdata);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void searchP(String oldValue ,String newValue ){
        ObservableList<Personnel> filtredlist = FXCollections.observableArrayList();
        tableP.setItems(Pdata);
        if (filterField == null ||  newValue.length()==0){
            tableP.setItems(Pdata);
        }else{
            newValue=newValue.toUpperCase();
            for(Personnel personnel : tableP.getItems()){
                if (personnel.getId().toUpperCase().indexOf(newValue)>=0||personnel.getNom().toUpperCase().indexOf(newValue)>=0||personnel.getPrenom().toUpperCase().indexOf(newValue)>=0)
                    filtredlist.add(personnel);
            }
            tableP.setItems(filtredlist);
        }

    }
    public void searchA(String oldValue ,String newValue ){
        ObservableList<Action> filtredlist = FXCollections.observableArrayList();
        tableA.setItems(Adata);
        if (filterField == null ||  newValue.length()==0){
            tableP.setItems(Pdata);
        }else{
            newValue=newValue.toUpperCase();
            for(Action action : tableA.getItems()){
                if (Integer.toString(action.getNum()).toUpperCase().indexOf(newValue)>=0||action.getAct().toUpperCase().indexOf(newValue)>=0||action.getObj_rech().toUpperCase().indexOf(newValue)>=0)
                    filtredlist.add(action);
            }
            tableA.setItems(filtredlist);
        }

    }
    public void searchS(String oldValue ,String newValue ){
        ObservableList<Suivi> filtredlist = FXCollections.observableArrayList();
        tableS.setItems(Sdata);
        if (filterField == null ||  newValue.length()==0){
            tableS.setItems(Sdata);
        }else{
            newValue=newValue.toUpperCase();
            for(Suivi suivi : tableS.getItems()){
                if ((suivi.getAct()==Integer.valueOf(newValue))||suivi.getNom().toUpperCase().indexOf(newValue)>=0||suivi.getPrenom().toUpperCase().indexOf(newValue)>=0)
                    filtredlist.add(suivi);
            }
            tableS.setItems(filtredlist);
        }

    }
    @FXML
    void importer(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Ouvrir votre document Excel");
        fileChooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter("EXCEL Files","*.xlsx"));
        fileChooser.setInitialDirectory(new File("C:/Users/" + System.getProperty("user.name") + "/Desktop/"));
        Doc_manager.importer_xlsx(fileChooser.showOpenDialog(null));
    }
    @FXML
    void exporter(){
        //TODO button disabled until tab (perso,action ..) is selected
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Enregistrer votre document Excel");
        fileChooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter("EXCEL Files","*.xlsx"));
        fileChooser.setInitialDirectory(new File("C:/Users/" + System.getProperty("user.name") + "/Desktop/"));
        if(!tableP.isDisabled()){ //TODO utiliser les variables perButt actButt ....
            fileChooser.setInitialFileName("export_personnel.xlsx");
            Doc_manager.exporter_xlsx_personnel(fileChooser.showSaveDialog(null),tableP.getItems());
        }else if((!tableA.isDisabled()) && (ActpButt == 1)){
            fileChooser.setInitialFileName("export_actions_planif.xlsx");//TODO Separer les deux cas
            Doc_manager.exporter_xlsx_actions_planif(fileChooser.showSaveDialog(null),tableA.getItems());
        }else if((!tableA.isDisabled()) && (ActnButt == 1)){
            fileChooser.setInitialFileName("export_actions_non_planif.xlsx");
            Doc_manager.exporter_xlsx_actions_non_planif(fileChooser.showSaveDialog(null),tableA.getItems());
        }else if(!tableS.isDisabled()){
            fileChooser.setInitialFileName("export_suivi.xlsx");
            Doc_manager.exporter_xlsx_suivi(fileChooser.showSaveDialog(null),tableS.getItems());
        }
    }
    @FXML
    void FVider(){
        Stage stage= new Stage();
        Pane layout = new Pane();
        Button button =new Button("Vider");
        Label label = new Label("Voulez vous vider cette table?");
        label.setLayoutX(10);
        label.setLayoutY(20);
        button.setLayoutX(210);
        button.setPrefWidth(70);
        button.setLayoutY(65);
        layout.getStyle();
        layout.getChildren().addAll(label,button);
        stage.setScene(new Scene(layout,300,100));
        //todo must select before delete
        stage.show();
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (perbutt == 1) {
                    Doc_manager.vider_table("personnel");
                    pfonc();
                } else if(ActButt == 1) {
                    if (ActpButt==1){
                        Doc_manager.vider_table("actions_planif");
                        apfonc();
                    }else if (ActnButt==1){
                        Doc_manager.vider_table("actions_non_planif");
                        anfonc();
                    }
                }else if (SuiButt == 1) {
                    Doc_manager.vider_table("suivi_actions");
                    sfonc();
                }
                stage.close();
            }});
    }
    @ FXML
    public void FTableau_bord() throws IOException {
        Stage tableau_satge = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("../sample/Tableau_bord.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        tableau_satge.setTitle("");
        tableau_satge.setResizable(false);
        tableau_satge.setScene(new Scene(root));
        tableau_satge.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /***                  Initialisation                     ***/
        //----------------------- Personnel-----------------------------
        Matricule.setCellValueFactory(new PropertyValueFactory<Personnel,String>("id"));
        Nom.setCellValueFactory(new PropertyValueFactory<Personnel,String>("nom"));
        Prenom.setCellValueFactory(new PropertyValueFactory<Personnel,String>("Prenom"));
        Date_entree.setCellValueFactory(new PropertyValueFactory<Personnel,Date>("date_dentree"));
        Poste.setCellValueFactory(new PropertyValueFactory<Personnel,String>("poste"));
        Type_emploi.setCellValueFactory(new PropertyValueFactory<Personnel,String>("type_demploi"));
        Categorie.setCellValueFactory(new PropertyValueFactory<Personnel,String>("categorie"));
        Direction.setCellValueFactory(new PropertyValueFactory<Personnel,String>("direction"));
        Departement.setCellValueFactory(new PropertyValueFactory<Personnel,String>("departement"));
        Service.setCellValueFactory(new PropertyValueFactory<Personnel,String>("service"));
        //-------------------------Action---------------------------------------
        Num.setCellValueFactory(new PropertyValueFactory<Action,Integer>("num"));
        Action.setCellValueFactory(new PropertyValueFactory<Action,String>("act"));
        Objectif.setCellValueFactory(new PropertyValueFactory<Action,String>("obj_rech"));
        Structure.setCellValueFactory(new PropertyValueFactory<Action,String>("structure"));
        Effectif.setCellValueFactory(new PropertyValueFactory<Action,Integer>("eff_real_forme"));
        NbrP.setCellValueFactory(new PropertyValueFactory<Action,Integer>("nbr_participants"));
        Duree.setCellValueFactory(new PropertyValueFactory<Action,Integer>("duree_jour"));
        DebutF.setCellValueFactory(new PropertyValueFactory<Action,Date>("debut_formation"));
        Cout.setCellValueFactory(new PropertyValueFactory<Action,Integer>("cout"));
        OrganismeF.setCellValueFactory(new PropertyValueFactory<Action,String>("organisme_formation"));
        Lformation.setCellValueFactory(new PropertyValueFactory<Action,String>("lieu_formation"));
        Periode.setCellValueFactory(new PropertyValueFactory<Action,String>("Periode_devaluation"));
        Actnp.setDisable(true);
        Actnp.setVisible(false);
        Actp.setVisible(false);
        Actp.setDisable(true);
        Actp.setPrefHeight(0);
        Actnp.setPrefHeight(0);

        //-----------------------------------Suivi--------------------------------------
        Nact.setCellValueFactory(new PropertyValueFactory<Suivi,Integer>("act"));
        Mat.setCellValueFactory(new PropertyValueFactory<Suivi,String>("id"));
        Nom1.setCellValueFactory(new PropertyValueFactory<Suivi,String>("nom"));
        Prenom1.setCellValueFactory(new PropertyValueFactory<Suivi,String>("prenom"));
        Fonction.setCellValueFactory(new PropertyValueFactory<Suivi,String>("fonction"));
        Diraff.setCellValueFactory(new PropertyValueFactory<Suivi,String>("direction"));
        Cat.setCellValueFactory(new PropertyValueFactory<Suivi,String>("categorie"));
        Ifor.setCellValueFactory(new PropertyValueFactory<Suivi,String>("intitule"));
        Ddebut.setCellValueFactory(new PropertyValueFactory<Suivi,Date>("date_debut"));
        Dfin.setCellValueFactory(new PropertyValueFactory<Suivi,Date>("date_fin"));
        Cfor.setCellValueFactory(new PropertyValueFactory<Suivi,Integer>("cout"));
        NbrJ.setCellValueFactory(new PropertyValueFactory<Suivi,Integer>("nbr_jrs"));
        Nbrh.setCellValueFactory(new PropertyValueFactory<Suivi,Integer>("nbr_hr"));
        Tfor.setCellValueFactory(new PropertyValueFactory<Suivi,String>("type_formation"));
        Ofor.setCellValueFactory(new PropertyValueFactory<Suivi,String>("organisme"));
        Lfor.setCellValueFactory(new PropertyValueFactory<Suivi,String>("lieu_formation"));
        Lfor2.setCellValueFactory(new PropertyValueFactory<Suivi,String>("lieu_formation2"));
        Tfor2.setCellValueFactory(new PropertyValueFactory<Suivi,String>("type_formation2"));
        Plan.setCellValueFactory(new PropertyValueFactory<Suivi,String>("planification"));
        Peva.setCellValueFactory(new PropertyValueFactory<Suivi,String>("periode_eval"));
        Att.setCellValueFactory(new PropertyValueFactory<Suivi,String>("attestation_recue"));
        Aseof.setCellValueFactory(new PropertyValueFactory<Suivi,String>("avis_eval_organisme"));
        asref.setCellValueFactory(new PropertyValueFactory<Suivi,String>("avis_retour_eval"));
        apsefi.setCellValueFactory(new PropertyValueFactory<Suivi,String>("action_eval_inssuf"));
        pef.setCellValueFactory(new PropertyValueFactory<Suivi,Integer>("prevision_effectif"));
        pcf.setCellValueFactory(new PropertyValueFactory<Suivi,Integer>("prevision_cout"));
        pdr.setCellValueFactory(new PropertyValueFactory<Suivi,Date>("prevision_date"));
        pNj.setCellValueFactory(new PropertyValueFactory<Suivi,Integer>("prevision_nbr_jour"));
        Pnh.setCellValueFactory(new PropertyValueFactory<Suivi,Integer>("prevision_nbr_hr"));
        /***                      Initialisation générale                        *****/
        Logo.setVisible(true);
        Logo.setDisable(false);
        Cancel.setDisable(true);
        Cancel.setVisible(false);
        Ajouter.setDisable(true);
        Vider.setDisable(true);
        supprimer.setDisable(true);
        fil.setDisable(true);
        filterField.setDisable(true);
        OffScrollpane(filterscp);
        OffScrollpane(filtersca);
        OffScrollpane(filterscs);
        disableallbuttonP(true);
        onoffT(tableP,"off");
        onoffT(tableA,"off");
        onoffT(tableS,"off");
        perbutt = 0;ActButt=0;SuiButt=0;ActpButt=0;ActnButt=0;
        k=0;
        filtre_personnel = new Filtre_personnel();
        tableP.setEditable(true);
        tableA.setEditable(true);
        tableS.setEditable(true);

        //todo restriction valeur numérique dans les champs numériques
        /***-------------------------------------Modification---------------------------------------***/
        //----------------------------------------------Personnel-----------------------------------//
        Matricule.setCellFactory(TextFieldTableCell.forTableColumn());
        Matricule.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Personnel, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Personnel, String> p) {
                Operateur.modifier_personnel(p.getOldValue(),"Matricule",p.getNewValue());
                tableP.getItems().get(p.getTablePosition().getRow()).setId(p.getNewValue());
            }
        });
        Nom.setCellFactory(TextFieldTableCell.forTableColumn());
        Nom.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Personnel, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Personnel, String> p) {
                Operateur.modifier_personnel(tableP.getItems().get(p.getTablePosition().getRow()).getId(),"Nom",p.getNewValue());
                tableP.getItems().get(p.getTablePosition().getRow()).setNom(p.getNewValue());
            }
        });
        Prenom.setCellFactory(TextFieldTableCell.forTableColumn());
        Prenom.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Personnel, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Personnel, String> p) {
                Operateur.modifier_personnel(tableP.getItems().get(p.getTablePosition().getRow()).getId(),"Prenom",p.getNewValue());
                tableP.getItems().get(p.getTablePosition().getRow()).setPrenom(p.getNewValue());
            }
        });
                  Date_entree.setCellFactory(
                TextFieldTableCell.forTableColumn(new DateStringConverter("yyyy-MM-dd")));
                  Date_entree.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Personnel, Date>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Personnel,Date> p) {
                java.sql.Date sDate = new java.sql.Date(p.getNewValue().getTime());
                Operateur.modifier_personnel(tableP.getItems().get(p.getTablePosition().getRow()).getId(),"Date_Entree",sDate.toString());
                tableP.getItems().get(p.getTablePosition().getRow()).setDate_dentree(sDate);
            }
        });
        Poste.setCellFactory(TextFieldTableCell.forTableColumn());
        Poste.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Personnel, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Personnel, String> p) {
                Operateur.modifier_personnel(tableP.getItems().get(p.getTablePosition().getRow()).getId(),"Poste",p.getNewValue());
                tableP.getItems().get(p.getTablePosition().getRow()).setPoste(p.getNewValue());
            }
        });
        Type_emploi.setCellFactory(TextFieldTableCell.forTableColumn());
        Type_emploi.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Personnel, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Personnel, String> p) {
                Operateur.modifier_personnel(tableP.getItems().get(p.getTablePosition().getRow()).getId(),"Type_emploi",p.getNewValue());
                tableP.getItems().get(p.getTablePosition().getRow()).setType_demploi(p.getNewValue());
            }
        });
        Categorie.setCellFactory(TextFieldTableCell.forTableColumn());
        Categorie.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Personnel, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Personnel, String> p) {
                Operateur.modifier_personnel(tableP.getItems().get(p.getTablePosition().getRow()).getId(),"Categorie",p.getNewValue());
                tableP.getItems().get(p.getTablePosition().getRow()).setCategorie(p.getNewValue());
            }
        });
        Direction.setCellFactory(TextFieldTableCell.forTableColumn());
        Direction.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Personnel, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Personnel, String> p) {
                Operateur.modifier_personnel(tableP.getItems().get(p.getTablePosition().getRow()).getId(),"Direction",p.getNewValue());
                tableP.getItems().get(p.getTablePosition().getRow()).setDirection(p.getNewValue());
            }
        });
        Departement.setCellFactory(TextFieldTableCell.forTableColumn());
        Departement.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Personnel, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Personnel, String> p) {
                Operateur.modifier_personnel(tableP.getItems().get(p.getTablePosition().getRow()).getId(),"Departement",p.getNewValue());
                tableP.getItems().get(p.getTablePosition().getRow()).setDepartement(p.getNewValue());
            }
        });
        Service.setCellFactory(TextFieldTableCell.forTableColumn());
        Service.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Personnel, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Personnel, String> p) {
                Operateur.modifier_personnel(tableP.getItems().get(p.getTablePosition().getRow()).getId(),"Service",p.getNewValue());
                tableP.getItems().get(p.getTablePosition().getRow()).setService(p.getNewValue());
            }
        });
        //-------------------------------------------- Action ----------------------------------------
        Num.setCellFactory(
                TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        Num.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Action, Integer>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Action, Integer> p) {
                if (ActpButt==1)
                    Operateur.modifier_action(tableA.getItems().get(p.getTablePosition().getRow()).getNum(),"Actions_planif","N",p.getNewValue().toString());
                else if (ActnButt==1)
                    Operateur.modifier_action(tableA.getItems().get(p.getTablePosition().getRow()).getNum(),"Actions_non_planif","N",p.getNewValue().toString());
                tableA.getItems().get(p.getTablePosition().getRow()).setNum(p.getNewValue());
            }
        });
        Action.setCellFactory(TextFieldTableCell.forTableColumn());
        Action.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Action, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Action, String> p) {
                if (ActpButt==1)
                Operateur.modifier_action(tableA.getItems().get(p.getTablePosition().getRow()).getNum(),"Actions_planif","Action",p.getNewValue());
                else if (ActnButt==1)
                    Operateur.modifier_action(tableA.getItems().get(p.getTablePosition().getRow()).getNum(),"Actions_non_planif","Action",p.getNewValue());
                tableA.getItems().get(p.getTablePosition().getRow()).setAct(p.getNewValue());
            }
        });
        Objectif.setCellFactory(TextFieldTableCell.forTableColumn());
        Objectif.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Action, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Action, String> p) {
                if (ActpButt==1)
                    Operateur.modifier_action(tableA.getItems().get(p.getTablePosition().getRow()).getNum(),"Actions_planif","Objectif",p.getNewValue());
                else if (ActnButt==1)
                    Operateur.modifier_action(tableA.getItems().get(p.getTablePosition().getRow()).getNum(),"Actions_non_planif","Objectif",p.getNewValue());
                tableA.getItems().get(p.getTablePosition().getRow()).setAct(p.getNewValue());
            }
        });
        DebutF.setCellFactory(
                TextFieldTableCell.forTableColumn(new DateStringConverter("yyyy-MM-dd")));
        DebutF.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Action, Date>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Action, Date> p) {
                java.sql.Date sDate = new java.sql.Date(p.getNewValue().getTime());
                if (ActpButt==1)
                    Operateur.modifier_action(tableA.getItems().get(p.getTablePosition().getRow()).getNum(),"Actions_planif","Debut_formation",sDate.toString());
                else if (ActnButt==1)
                    Operateur.modifier_action(tableA.getItems().get(p.getTablePosition().getRow()).getNum(),"Actions_non_planif","Debut_formation",sDate.toString());
                tableA.getItems().get(p.getTablePosition().getRow()).setDebut_formation(sDate);
            }
        });
        Effectif.setCellFactory(
                TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        Effectif.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Action, Integer>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Action, Integer> p) {
                if (ActpButt==1)
                    Operateur.modifier_action(tableA.getItems().get(p.getTablePosition().getRow()).getNum(),"Actions_planif","Effectif_reel",p.getNewValue().toString());
                else if (ActnButt==1)
                    Operateur.modifier_action(tableA.getItems().get(p.getTablePosition().getRow()).getNum(),"Actions_non_planif","Effectif_reel",p.getNewValue().toString());
                tableA.getItems().get(p.getTablePosition().getRow()).setEff_real_forme(p.getNewValue());
            }
        });
        NbrP.setCellFactory(
                TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        NbrP.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Action, Integer>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Action, Integer> p) {
                if (ActpButt==1)
                    Operateur.modifier_action(tableA.getItems().get(p.getTablePosition().getRow()).getNum(),"Actions_planif","Nbre_participation",p.getNewValue().toString());
                else if (ActnButt==1)
                    Operateur.modifier_action(tableA.getItems().get(p.getTablePosition().getRow()).getNum(),"Actions_non_planif","Nbre_participation",p.getNewValue().toString());
                tableA.getItems().get(p.getTablePosition().getRow()).setNbr_participants(p.getNewValue());
            }
        });
        Duree.setCellFactory(
                TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        Duree.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Action, Integer>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Action, Integer> p) {
                if (ActpButt==1)
                    Operateur.modifier_action(tableA.getItems().get(p.getTablePosition().getRow()).getNum(),"Actions_planif","Duree",p.getNewValue().toString());
                else if (ActnButt==1)
                    Operateur.modifier_action(tableA.getItems().get(p.getTablePosition().getRow()).getNum(),"Actions_non_planif","Duree",p.getNewValue().toString());
                tableA.getItems().get(p.getTablePosition().getRow()).setDuree_jour(p.getNewValue());
            }
        });
        Cout.setCellFactory(
                TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        Cout.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Action, Integer>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Action, Integer> p) {
                if (ActpButt==1)
                    Operateur.modifier_action(tableA.getItems().get(p.getTablePosition().getRow()).getNum(),"Actions_planif","Cout_previsionnel",p.getNewValue().toString());
                else if (ActnButt==1)
                    Operateur.modifier_action(tableA.getItems().get(p.getTablePosition().getRow()).getNum(),"Actions_non_planif","Cout_previsionnel",p.getNewValue().toString());
                tableA.getItems().get(p.getTablePosition().getRow()).setCout(p.getNewValue());
            }
        });

        Lformation.setCellFactory(TextFieldTableCell.forTableColumn());
        Lformation.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Action, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Action, String> p) {
                if (ActpButt==1)
                    Operateur.modifier_action(tableA.getItems().get(p.getTablePosition().getRow()).getNum(),"Actions_planif","Lieu_formation",p.getNewValue());
                else if (ActnButt==1)
                    Operateur.modifier_action(tableA.getItems().get(p.getTablePosition().getRow()).getNum(),"Actions_non_planif","Lieu_formation",p.getNewValue());
                tableA.getItems().get(p.getTablePosition().getRow()).setAct(p.getNewValue());
            }
        });
        Periode.setCellFactory(TextFieldTableCell.forTableColumn());
        Periode.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Action, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Action, String> p) {
                if (ActpButt==1)
                    Operateur.modifier_action(tableA.getItems().get(p.getTablePosition().getRow()).getNum(),"Actions_planif","Periode_evaluation",p.getNewValue());
                else if (ActnButt==1)
                    Operateur.modifier_action(tableA.getItems().get(p.getTablePosition().getRow()).getNum(),"Actions_non_planif","Periode_evaluation",p.getNewValue());
                tableA.getItems().get(p.getTablePosition().getRow()).setAct(p.getNewValue());
            }
        });
        //-------------------------------------------------------------------------------------------
        filterField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                if (perbutt==1)
                searchP(s,t1);
                else if (ActButt==1)
                    searchA(s,t1);
                else if (SuiButt==1)
                    searchS(s,t1);
            }
        });

    }

}