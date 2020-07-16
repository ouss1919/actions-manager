package Class;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Operateur {
    public static Personnel get_personnel(String id){
        Personnel personnel = new Personnel();
        String url = "jdbc:mysql://localhost:3306/gica";
        String user = "root";
        String password = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,user,password);
            Statement stmt=con.createStatement();
            String query = "SELECT * FROM `personnel` WHERE `Matricule` in (?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(query);;
            try{
                preparedStatement.setInt(1,Integer.parseInt(id));
            }
            catch(NumberFormatException e){
                preparedStatement.setString(1,id);
            }
            preparedStatement.setString(2,id);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()) {
                remplir_personnel(personnel,rs);
            }
            else personnel = null;
            con.close();
        }
        catch(ClassNotFoundException e) {
            System.out.println("ClassNotFoundException");
            e.printStackTrace();
        }
        catch(SQLException e) {
            System.out.println("SQLException");
            e.printStackTrace();
        }
        return personnel;
    }
    public static Action get_action(int num){
        Action action = new Action();
        String url = "jdbc:mysql://localhost:3306/gica";
        String user = "root";
        String password = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,user,password);
            Statement stmt=con.createStatement();
            String query = "select * from `actions_planif` where `N` = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);;
            preparedStatement.setInt(1,num);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()) {
                remplir_action(action,rs);
                System.out.println("planif");
            }
            else
            {
                query = "select * from `actions_non_planif` where `N` = ?";
                preparedStatement = con.prepareStatement(query);
                preparedStatement.setInt(1,num);
                rs = preparedStatement.executeQuery();
                if(rs.next()) {
                    remplir_action(action,rs);
                    System.out.println("NONplanif");
                }
                else {
                    action = null;
                }
            }
            con.close();
        }
        catch(ClassNotFoundException e) {
            System.out.println("ClassNotFoundException");
            e.printStackTrace();
        }
        catch(SQLException e) {
            System.out.println("SQLException");
            e.printStackTrace();
        }
        return action;
    }
    public static void remplir_personnel(Personnel personnel, ResultSet rs){
        try{
            personnel.setId(rs.getString(1));
            personnel.setNom(rs.getString(2));
            personnel.setPrenom(rs.getString(3));
            personnel.setDate_dentree(rs.getDate(4));
            personnel.setPoste(rs.getString(5));
            personnel.setType_demploi(rs.getString(6));
            personnel.setCategorie(rs.getString(7));
            personnel.setDirection(rs.getString(8));
            personnel.setDepartement(rs.getString(9));
            personnel.setService(rs.getString(10));
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void remplir_action(Action action,ResultSet rs){
        try{
            action.setNum(rs.getInt(1));
            action.setAct(rs.getString(2));
            action.setObj_rech(rs.getString(3));
            action.setStructure(rs.getString(4));
            action.setEff_real_forme(rs.getInt(5));
            action.setNbr_participants(rs.getInt(6));
            action.setDuree_jour(rs.getInt(7));
            action.setDebut_formation(rs.getDate(8));
            action.setCout(rs.getInt(9));
            action.setOrganisme_formation(rs.getString(10));
            action.setLieu_formation(rs.getString(11));
            action.setPeriode_devaluation(rs.getString(12));
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void remplir_suivi(Suivi suivi,ResultSet rs){
        try{
            suivi.setN(rs.getInt(1));
            suivi.setAct(rs.getInt(2));
            suivi.setId(rs.getString(3));
            suivi.setNom(rs.getString(4));
            suivi.setPrenom(rs.getString(5));
            suivi.setFonction(rs.getString(6));
            suivi.setDirection(rs.getString(7));
            suivi.setCategorie(rs.getString(8));
            suivi.setIntitule(rs.getString(9));
            suivi.setDate_debut(rs.getDate(10));
            suivi.setDate_fin(rs.getDate(11));
            suivi.setCout(rs.getInt(12));
            suivi.setNbr_jrs(rs.getInt(13));
            suivi.setNbr_hr(rs.getInt(14));
            suivi.setType_formation(rs.getString(15));
            suivi.setOrganisme(rs.getString(16));
            suivi.setLieu_formation(rs.getString(17));
            suivi.setLieu_formation2(rs.getString(18));
            suivi.setType_formation2(rs.getString(19));
            suivi.setPlanification(rs.getString(20));
            suivi.setPeriode_eval(rs.getString(21));
            suivi.setAttestation_recue(rs.getString(22));
            suivi.setAvis_eval_organisme(rs.getString(23));
            suivi.setAvis_retour_eval(rs.getString(24));
            suivi.setAction_eval_inssuf(rs.getString(25));
            suivi.setPrevision_effectif(rs.getInt(26));
            suivi.setPrevision_cout(rs.getInt(27));
            suivi.setPrevision_date(rs.getDate(28));
            suivi.setPrevision_nbr_jour(rs.getInt(29));
            suivi.setPrevision_nbr_hr(rs.getInt(30));
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static List<Personnel> importer_peronnel(Filtre_personnel filtre_personnel,Filtre_date filtre_date){
        List<Personnel> donnee = new ArrayList<Personnel>();
        String url = "jdbc:mysql://localhost:3306/gica";
        String user = "root";
        String password = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,user,password);
            Statement stmt=con.createStatement();
            String query = "select * from personnel "+filtre_personnel.toString();
            PreparedStatement preparedStatement = null;
            ResultSet rs = null;
            if(filtre_date!=null){
                query = "select * from ("+query+") as temp_table where Date_Entree between ? and ?";
                preparedStatement = con.prepareStatement(query);
                preparedStatement.setDate(1,filtre_date.date_debut);
                preparedStatement.setDate(2,filtre_date.date_fin);
                rs = preparedStatement.executeQuery();
            }
            else
                rs = stmt.executeQuery(query);
            while(rs.next()) {
                Personnel ligne = new Personnel();
                remplir_personnel(ligne,rs);
                donnee.add(ligne);
            }
            con.close();
        }
        catch(ClassNotFoundException e) {
            System.out.println("ClassNotFoundException");
            e.printStackTrace();
        }
        catch(SQLException e) {
            System.out.println("SQLException");
            e.printStackTrace();
        }
        return donnee;
    }
    public static List<Action> importer_action(String table,Filtre_action filtre_action,Filtre_date filtre_date){
        List<Action> donnee = new ArrayList<Action>();
        String url = "jdbc:mysql://localhost:3306/gica";
        String user = "root";
        String password = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,user,password);
            Statement stmt=con.createStatement();
            String query = "select * from "+table+" "+filtre_action.toString();
            PreparedStatement preparedStatement = null;
            ResultSet rs = null;
            if(filtre_date!=null){
                query = "select * from ("+query+") as temp_table where Debut_formation between ? and ?";
                preparedStatement = con.prepareStatement(query);
                preparedStatement.setDate(1,filtre_date.date_debut);
                preparedStatement.setDate(2,filtre_date.date_fin);
                rs = preparedStatement.executeQuery();
            }
            else
                rs = stmt.executeQuery(query);
            while(rs.next()) {
                Action ligne = new Action();
                remplir_action(ligne,rs);
                donnee.add(ligne);
            }
            con.close();
        }
        catch(ClassNotFoundException e) {
            System.out.println("ClassNotFoundException");
            e.printStackTrace();
        }
        catch(SQLException e) {
            System.out.println("SQLException");
            e.printStackTrace();
        }
        return donnee;
    }
    public static List<Suivi> importer_suivi(Filtre_suivi filtre_suivi,Filtre_date filtre_date){
        List<Suivi> donnee = new ArrayList<Suivi>();
        String url = "jdbc:mysql://localhost:3306/gica";
        String user = "root";
        String password = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,user,password);
            Statement stmt=con.createStatement();
            String query = "select * from suivi_actions "+filtre_suivi.toString();
            PreparedStatement preparedStatement = null;
            ResultSet rs = null;
            if(filtre_date!=null){
                query = "select * from ("+query+") as temp_table where `Date_debut` >= ? and `Date_fin` <= ? ";
                preparedStatement = con.prepareStatement(query);
                preparedStatement.setDate(1,filtre_date.date_debut);
                preparedStatement.setDate(2,filtre_date.date_fin);
                rs = preparedStatement.executeQuery();
            }
            else
                rs = stmt.executeQuery(query);
            while(rs.next()) {
                Suivi ligne = new Suivi();
                remplir_suivi(ligne,rs);
                donnee.add(ligne);
            }
            con.close();
        }
        catch(ClassNotFoundException e) {
            System.out.println("ClassNotFoundException");
            e.printStackTrace();
        }
        catch(SQLException e) {
            System.out.println("SQLException");
            e.printStackTrace();
        }
        return donnee;
    }

    public static Personnel list_to_personnel(ObservableList<String> list){
        Personnel personnel = new Personnel();
        if(!(list.get(0).equals(""))){
            personnel.setId(list.get(0));
            if(!(list.get(1).equals(""))) personnel.setNom(list.get(1));
            if(!(list.get(2).equals(""))) personnel.setPrenom(list.get(2));
            if(!(list.get(3)==null)) personnel.setDate_dentree(Date.valueOf(list.get(3)));
            if(!(list.get(4)==null)) personnel.setPoste(list.get(4));
            if(!(list.get(5)==null)) personnel.setType_demploi(list.get(5));
            if(!(list.get(6)==null)) personnel.setCategorie(list.get(6));
            if(!(list.get(7)==null)) personnel.setDirection(list.get(7));
            if(!(list.get(8)==null)) personnel.setDepartement(list.get(8));
            if(!(list.get(9)==null)) personnel.setService(list.get(9));
            return personnel;}
        else {
            System.out.println("Personnel not added");
            return null;
        }
    }
    public static Action list_to_action(ObservableList<String> list){
        Action action = new Action();
        if(!(list.get(0).equals(""))) {action.setNum(Integer.parseInt(list.get(0)));
            if(!(list.get(1).equals(""))) action.setAct(list.get(1));
            if(!(list.get(2).equals(""))) action.setObj_rech(list.get(2));
            if(!(list.get(3)==null)) action.setStructure(list.get(3));
            if(!(list.get(4).equals(""))) action.setEff_real_forme(Integer.parseInt(list.get(4)));
            if(!(list.get(5).equals(""))) action.setNbr_participants(Integer.parseInt(list.get(5)));
            if(!(list.get(6).equals(""))) action.setDuree_jour(Integer.parseInt(list.get(6)));
            System.out.println("|"+list.get(7)+"|");
            if(!(list.get(7)==null)) {action.setDebut_formation(Date.valueOf(list.get(7)));} // TODO check date format
            if(!(list.get(8).equals(""))) action.setCout(Integer.parseInt(list.get(8)));
            if(!(list.get(9)==null)) action.setOrganisme_formation(list.get(9));
            if(!(list.get(10).equals(""))) action.setLieu_formation(list.get(10));
            if(!(list.get(11).equals(""))) action.setPeriode_devaluation(list.get(11));
            return action;}
        else {
            System.out.println("Action not added");
            return null;
        }
    }
    public static Suivi list_to_suivi(ObservableList<String> list){
        Suivi suivi = new Suivi();
        Action action = null;
        Personnel personnel = null;
        if(!list.get(0).equals("")) {action = Operateur.get_action(Integer.parseInt(list.get(0)));}
        if(!list.get(1).equals("")) personnel = Operateur.get_personnel(list.get(1));
        if((action!=null)&&(personnel!=null)) {
            suivi.setAct(Integer.valueOf(list.get(0)));
            suivi.setId(list.get(1));
            if(!(list.get(2)==null)) suivi.setDate_debut(Date.valueOf(list.get(2)));
            if(!(list.get(3)==null)) suivi.setDate_fin(Date.valueOf(list.get(3)));
            if(!(list.get(4).equals(""))) suivi.setCout(Integer.parseInt(list.get(4)));
            if(!(list.get(5).equals(""))) suivi.setNbr_jrs(Integer.parseInt(list.get(5)));
            if(!(list.get(6)==null)) suivi.setType_formation(list.get(6));
            if(!(list.get(7)==null)) suivi.setOrganisme(list.get(7));
            if(!(list.get(8)==null)) suivi.setLieu_formation(list.get(8));
            if(!(list.get(9)==null)) suivi.setLieu_formation2(list.get(9));
            if(!(list.get(10)==null)) suivi.setType_formation2(list.get(10));
            if(!(list.get(11)==null)) suivi.setPlanification(list.get(11));
            if(!(list.get(12)==null)) suivi.setAttestation_recue(list.get(12));
            if(!(list.get(13)==null)) suivi.setAvis_eval_organisme(list.get(13));
            if(!(list.get(14)==null)) suivi.setAvis_retour_eval(list.get(14));
            if(!(list.get(15)==null)) suivi.setAction_eval_inssuf(list.get(15));
            if(!(list.get(16).equals(""))) suivi.setPrevision_effectif(Integer.parseInt(list.get(16)));
            if(!(list.get(17).equals(""))) suivi.setPrevision_cout(Integer.parseInt(list.get(17)));
            if(!(list.get(18)==null)) suivi.setPrevision_date(Date.valueOf(list.get(18)));
            if(!(list.get(19).equals(""))) {suivi.setPrevision_nbr_jour(Integer.parseInt(list.get(19)));suivi.setPrevision_nbr_hr(suivi.getPrevision_nbr_jour()*6);}
            suivi.setNom(personnel.getNom());
            suivi.setPrenom(personnel.getPrenom());
            suivi.setFonction(personnel.getPoste());
            suivi.setDirection(personnel.getDirection());
            suivi.setCategorie(personnel.getCategorie());
            suivi.setIntitule(action.getAct());
            suivi.setPeriode_eval(action.getPeriode_devaluation());
            suivi.setNbr_jrs(action.getDuree_jour());
            suivi.setNbr_hr(suivi.getNbr_jrs()*6);
            return suivi;}
        else {
            System.out.println("Suivi not added");
            return null;
        }
    }

    public static void ajouter_personnel(Personnel personnel){
        if((personnel != null)&&(!personnel.getId().equals(""))){
            String url = "jdbc:mysql://localhost:3306/gica";
            String user = "root";
            String password = "";
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection(url,user,password);
                Statement stmt=con.createStatement();
                String query = "insert into personnel values (?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement preparedStatement = con.prepareStatement(query);
                preparedStatement.setString(1,personnel.getId());
                preparedStatement.setString(2,personnel.getNom());
                preparedStatement.setString(3,personnel.getPrenom());
                preparedStatement.setDate(4,personnel.getDate_dentree());
                preparedStatement.setString(5,personnel.getPoste());
                preparedStatement.setString(6,personnel.getType_demploi());
                preparedStatement.setString(7,personnel.getCategorie());
                preparedStatement.setString(8,personnel.getDirection());
                preparedStatement.setString(9,personnel.getDepartement());
                preparedStatement.setString(10,personnel.getService());
                preparedStatement.execute();
                con.close();
            }
            catch(ClassNotFoundException e) {
                System.out.println("ClassNotFoundException");
                e.printStackTrace();
            }
            catch(SQLException e) {
                System.out.println("SQLException");
                e.printStackTrace();
            }
        }

    }
    public static void ajouter_action(Action action, String table){
        if((action != null)&&(action.getNum()!=0)){
            String url = "jdbc:mysql://localhost:3306/gica";
            String user = "root";
            String password = "";
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection(url,user,password);
                Statement stmt=con.createStatement();
                String query = "insert into "+table+" values (?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement preparedStatement = con.prepareStatement(query);
                preparedStatement.setInt(1,action.getNum());
                preparedStatement.setString(2,action.getAct());
                preparedStatement.setString(3,action.getObj_rech());
                preparedStatement.setString(4,action.getStructure());
                preparedStatement.setInt(5,action.getEff_real_forme());
                preparedStatement.setInt(6,action.getNbr_participants());
                preparedStatement.setInt(7,action.getDuree_jour());
                preparedStatement.setDate(8,action.getDebut_formation());
                preparedStatement.setInt(9,action.getCout());
                preparedStatement.setString(10,action.getOrganisme_formation());
                preparedStatement.setString(11,action.getLieu_formation());
                preparedStatement.setString(12,action.getPeriode_devaluation());
                preparedStatement.execute();
                con.close();
            }
            catch(ClassNotFoundException e) {
                System.out.println("ClassNotFoundException");
                e.printStackTrace();
            }
            catch(SQLException e) {
                System.out.println("SQLException");
                e.printStackTrace();
            }
        }
    }
    public static void ajouter_suivi(Suivi suivi){
        if(suivi != null){
            String url = "jdbc:mysql://localhost:3306/gica";
            String user = "root";
            String password = "";
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection(url,user,password);
                Statement stmt=con.createStatement();
                String query = "insert into suivi_actions(`N_Action`, `Matricule`, `Nom`, `Prenom`, `Fonction`, `Direction_affectation`, `Categorie`, `Intitule_formation`, `Date_debut`, `Date_fin`, `Cout_formation`, `Nbre_jours`, `Nbre_heures`, `Type_formation`, `Organisme_formation`, `Lieu_formation`, `Lieu_formation_2`, `Type_formation_2`, `Planification`, `Periode_valuation_froid`, `Attestation_reçue`, `Avis_evaluation_organisme`, `Avis_retou_evaluation`, `Action_evaluation_insufisante`, `Prevision effectif`, `Previson_cout`, `Prevision_date_realisation`, `Prevision_Nbre_jours`, `Prevision_Nbre_heures`) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement preparedStatement = con.prepareStatement(query);
                preparedStatement.setInt(1,suivi.getAct());
                preparedStatement.setString(2,suivi.getId());
                preparedStatement.setString(3,suivi.getNom());
                preparedStatement.setString(4,suivi.getPrenom());
                preparedStatement.setString(5,suivi.getFonction());
                preparedStatement.setString(6,suivi.getDirection());
                preparedStatement.setString(7,suivi.getCategorie());
                preparedStatement.setString(8,suivi.getIntitule());
                preparedStatement.setDate(9,suivi.getDate_debut());
                preparedStatement.setDate(10,suivi.getDate_fin());
                preparedStatement.setInt(11,suivi.getCout());
                preparedStatement.setInt(12,suivi.getNbr_jrs());
                preparedStatement.setInt(13,suivi.getNbr_hr());
                preparedStatement.setString(14,suivi.getType_formation());
                preparedStatement.setString(15,suivi.getOrganisme());
                preparedStatement.setString(16,suivi.getLieu_formation());
                preparedStatement.setString(17,suivi.getLieu_formation2());
                preparedStatement.setString(18,suivi.getType_formation2());
                preparedStatement.setString(19,suivi.getPlanification());
                preparedStatement.setString(20,suivi.getPeriode_eval());
                preparedStatement.setString(21,suivi.getAttestation_recue());
                preparedStatement.setString(22,suivi.getAvis_eval_organisme());
                preparedStatement.setString(23,suivi.getAvis_retour_eval());
                preparedStatement.setString(24,suivi.getAction_eval_inssuf());
                preparedStatement.setInt(25,suivi.getPrevision_effectif());
                preparedStatement.setInt(26,suivi.getPrevision_cout());
                preparedStatement.setDate(27,suivi.getPrevision_date());
                preparedStatement.setInt(28,suivi.getPrevision_nbr_jour());
                preparedStatement.setInt(29,suivi.getPrevision_nbr_hr());
                preparedStatement.execute();
                con.close();
            }
            catch(ClassNotFoundException e) {
                System.out.println("ClassNotFoundException");
                e.printStackTrace();
            }
            catch(SQLException e) {
                System.out.println("SQLException");
                e.printStackTrace();
            }
        }

    }

    public static void supprimer_personnel(String id){
        String url = "jdbc:mysql://localhost:3306/gica";
        String user = "root";
        String password = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,user,password);
            Statement stmt=con.createStatement();
            String query = "delete from personnel where Matricule = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1,id);
            preparedStatement.execute();
            con.close();
        }
        catch(ClassNotFoundException e) {
            System.out.println("ClassNotFoundException");
            e.printStackTrace();
        }
        catch(SQLException e) {
            System.out.println("SQLException");
            e.printStackTrace();
        }
    }
    public static void supprimer_action(int num,String table){
        String url = "jdbc:mysql://localhost:3306/gica";
        String user = "root";
        String password = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,user,password);
            Statement stmt=con.createStatement();
            String query = "delete from "+table+" where N = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1,num);
            preparedStatement.execute();
            con.close();
        }
        catch(ClassNotFoundException e) {
            System.out.println("ClassNotFoundException");
            e.printStackTrace();
        }
        catch(SQLException e) {
            System.out.println("SQLException");
            e.printStackTrace();
        }
    }
    public static void supprimer_suivi(int n){
        String url = "jdbc:mysql://localhost:3306/gica";
        String user = "root";
        String password = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,user,password);
            Statement stmt=con.createStatement();
            String query = "delete from suivi_actions where N = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1,n);
            preparedStatement.execute();
            con.close();
        }
        catch(ClassNotFoundException e) {
            System.out.println("ClassNotFoundException");
            e.printStackTrace();
        }
        catch(SQLException e) {
            System.out.println("SQLException");
            e.printStackTrace();
        }
    }

    public static List<String> importer_choix(String choix){
        List<String> list_choix = new ArrayList<String>();
        String url = "jdbc:mysql://localhost:3306/gica";
        String user = "root";
        String password = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,user,password);
            Statement stmt=con.createStatement();
            String query = "select * from "+choix;
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next()) {
                list_choix.add(rs.getString(1));
            }
            con.close();
        }
        catch(ClassNotFoundException e) {
            System.out.println("ClassNotFoundException");
            e.printStackTrace();
        }
        catch(SQLException e) {
            System.out.println("SQLException");
            e.printStackTrace();
        }
        return list_choix;
    }

    public static void ajouter_choix(String choix,String valeur){
        String url = "jdbc:mysql://localhost:3306/gica";
        String user = "root";
        String password = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,user,password);
            Statement stmt=con.createStatement();
            String query = "insert into "+choix+" values (?)";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1,valeur);
            preparedStatement.execute();
            con.close();
        }
        catch(ClassNotFoundException e) {
            System.out.println("ClassNotFoundException");
            e.printStackTrace();
        }
        catch(SQLException e) {
            System.out.println("SQLException");
            e.printStackTrace();
        }
    }

    public static String list_to_sql_values(List<String> list){
        if(!list.isEmpty()){
            String string="(";
            Boolean first = true;
            for (String e:list
            ) {
                if(!first){
                    string = string + ",";
                }
                string = string +"'"+ e +"'";
                first = false;
            }
            string = string + ")";
            return string;
        }
        else
            return "";

    }

    public static void modifier_personnel(String id,String champ,String valeur){
        String url = "jdbc:mysql://localhost:3306/gica";
        String user = "root";
        String password = "";
        List<String> date_champs = new ArrayList<String>(Arrays.asList("Date_Entree"));
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,user,password);
            String query = "update `personnel` set `"+champ+"` = ? WHERE `personnel`.`Matricule` = ? ";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            if (date_champs.contains(champ)){
                preparedStatement.setDate(1, Date.valueOf(valeur));
            }else{
                preparedStatement.setString(1,valeur);
            }
            preparedStatement.setString(2,id);
            preparedStatement.execute();
            con.close();
        }
        catch(ClassNotFoundException e) {
            System.out.println("ClassNotFoundException");
            e.printStackTrace();
        }
        catch(SQLException e) {
            System.out.println("SQLException");
            e.printStackTrace();
        }
    }
    public static void modifier_action(int num,String table,String champ,String valeur){
        String url = "jdbc:mysql://localhost:3306/gica";
        String user = "root";
        String password = "";
        List<String> num_champs = new ArrayList<String>(Arrays.asList("Effectif_reel","Nbre_participation","Duree","Cout_previsionnel"));
        List<String> date_champs = new ArrayList<String>(Arrays.asList("Debut_formation"));
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt = con.createStatement();
            String query = "update `" + table + "` set `" + champ + "` = ? WHERE `" + table + "`.`N` = ? ";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            if (num_champs.contains(champ)) {
                int val = Integer.valueOf(valeur);
                preparedStatement.setInt(1, val);
            } else if (date_champs.contains(champ)) {
                preparedStatement.setDate(1, Date.valueOf(valeur));
            }
            else {
                preparedStatement.setString(1, valeur);
            }
            preparedStatement.setInt(2, num);
            preparedStatement.execute();
            con.close();
        }
        catch(ClassNotFoundException e) {
            System.out.println("ClassNotFoundException");
            e.printStackTrace();
        }
        catch(SQLException e) {
            System.out.println("SQLException");
            e.printStackTrace();
        }
    }

    public static Filtre_personnel array_to_filtre_personnel(ArrayList<ArrayList<String>> array){
        Filtre_personnel filtre_personnel = new Filtre_personnel();
        filtre_personnel.Poste.addAll(array.get(0));
        filtre_personnel.Type.addAll(array.get(1));
        filtre_personnel.Categorie.addAll(array.get(2));
        filtre_personnel.Direction.addAll(array.get(3));
        filtre_personnel.Departement.addAll(array.get(4));
        filtre_personnel.Service.addAll(array.get(5));

        return filtre_personnel;
    }
    public static Filtre_action array_to_filtre_action(ArrayList<ArrayList<String>> array,ArrayList<Filtre_entier> list){
        Filtre_action filtre_action = new Filtre_action();
        filtre_action.Structure.addAll(array.get(0));
        filtre_action.Organisme.addAll(array.get(1));
        System.out.println(filtre_action.Organisme);
        if(list.get(0)!=null){
            filtre_action.effectifMin=list.get(0).min;
            filtre_action.effectifMax=list.get(0).max;
            filtre_action.effectif = true;
        }
        if(list.get(1)!=null){
            filtre_action.nbreParticipationMin=list.get(1).min;
            filtre_action.nbreParticipationMax=list.get(1).max;
            filtre_action.nbreParticipation = true;
        }
        if(list.get(2)!=null){
            filtre_action.dureeMin=list.get(2).min;
            filtre_action.dureeMax=list.get(2).max;
            filtre_action.duree = true;
        }
        if(list.get(3)!=null){
            filtre_action.coutMax=list.get(3).min;
            filtre_action.coutMin=list.get(3).max;
            filtre_action.cout = true;
        }
        return filtre_action;
    }
    public static Filtre_suivi array_to_filtre_suivi(ArrayList<ArrayList<String>> array){
        Filtre_suivi filtre_suivi = new Filtre_suivi();
        filtre_suivi.Fonction.addAll(array.get(0));
        filtre_suivi.Direction.addAll(array.get(1));
        filtre_suivi.Categorie.addAll(array.get(2));
        filtre_suivi.Type_formation.addAll(array.get(3));
        filtre_suivi.Organisme.addAll(array.get(4));
        filtre_suivi.Lieu_formation.addAll(array.get(5));
        filtre_suivi.Lieu_formation2.addAll(array.get(6));
        filtre_suivi.Type_formation2.addAll(array.get(7));
        filtre_suivi.Planification.addAll(array.get(8));
        filtre_suivi.Attestation.addAll(array.get(9));
        filtre_suivi.Avis_eval_organisme.addAll(array.get(10));
        filtre_suivi.Avis_retour_eval.addAll(array.get(11));
        filtre_suivi.Action_eval_inssuf.addAll(array.get(10));
        return filtre_suivi;
    }

    public static  int get_sum_champ(String critaire, String lieu2, String categorie,Filtre_date filtre_date){
        String url = "jdbc:mysql://localhost:3306/gica";
        String user = "root";
        String password = "";
        int val = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,user,password);
            Statement stmt=con.createStatement();
            String query = "SELECT SUM(`"+critaire+"`) FROM (SELECT `N_Action`,`"+critaire+"` FROM `suivi_actions` WHERE `Lieu_formation_2` = ? AND `Categorie` = ? AND `Date_debut` >= ? AND `Date_fin` <= ? GROUP BY `N_Action`) as `temp_table` LIMIT 1";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1,lieu2);
            preparedStatement.setString(2,categorie);
            preparedStatement.setDate(3,filtre_date.date_debut);
            preparedStatement.setDate(4,filtre_date.date_fin);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next())
            {
                System.out.println(critaire+"|"+lieu2+"|"+categorie+"|"+filtre_date.date_debut+"|"+filtre_date.date_fin+"|"+rs.getInt(1));
                val = rs.getInt(1);
            }
            con.close();
        }
        catch(ClassNotFoundException e) {
            System.out.println("ClassNotFoundException");
            e.printStackTrace();
            return 0;
        }
        catch(SQLException e) {
            System.out.println("SQLException");
            e.printStackTrace();
            return 0;
        }
        return val;
    }
    public static  int get_sum_champ2(String critaire, String lieu2, String categorie,Filtre_date filtre_date){
        String url = "jdbc:mysql://localhost:3306/gica";
        String user = "root";
        String password = "";
        int val = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,user,password);
            Statement stmt=con.createStatement();
            String query = "SELECT SUM(`"+critaire+"`) FROM (SELECT `"+critaire+"` FROM `actions_planif` WHERE `N` IN (SELECT `N_Action` FROM `suivi_actions` WHERE `Lieu_formation_2` = ? AND `Categorie` = ? AND `Date_debut` >= ? AND `Date_fin` <= ? GROUP BY `N_Action`) UNION All SELECT `"+critaire+"` FROM `actions_non_planif` WHERE `N` IN (SELECT `N_Action` FROM `suivi_actions` WHERE `Lieu_formation_2` = ? AND `Categorie` = ? AND `Date_debut` >= ? AND `Date_fin` <= ? GROUP BY `N_Action`)) as `temp_table`";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1,lieu2);
            preparedStatement.setString(2,categorie);
            preparedStatement.setDate(3,filtre_date.date_debut);
            preparedStatement.setDate(4,filtre_date.date_fin);
            preparedStatement.setString(5,lieu2);
            preparedStatement.setString(6,categorie);
            preparedStatement.setDate(7,filtre_date.date_debut);
            preparedStatement.setDate(8,filtre_date.date_fin);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next())
            {
                System.out.println(critaire+"|"+lieu2+"|"+categorie+"|"+filtre_date.date_debut+"|"+filtre_date.date_fin+"|"+rs.getInt(1));
                val = rs.getInt(1);
            }
            con.close();
        }
        catch(ClassNotFoundException e) {
            System.out.println("ClassNotFoundException");
            e.printStackTrace();
            return 0;
        }
        catch(SQLException e) {
            System.out.println("SQLException");
            e.printStackTrace();
            return 0;
        }
        return val;
    }


    public static ObservableList<Dashboard> fill_dash_table(String critaire,Filtre_date filtre_date){
        ObservableList<Dashboard> list = FXCollections.observableArrayList();
        /**                     CFIC                   **/
        Dashboard dashboard1 = new Dashboard();
        dashboard1.setLieu_formation("CFIC");
        dashboard1.setCadre(Operateur.get_sum_champ(critaire,"CFIC","Cadre",filtre_date));
        dashboard1.setMaitrise(Operateur.get_sum_champ(critaire,"CFIC","Maitrise",filtre_date));
        dashboard1.setExecution(Operateur.get_sum_champ(critaire,"CFIC","Execution",filtre_date));
        dashboard1.setTotal_general(dashboard1.getCadre()+dashboard1.getMaitrise()+dashboard1.getExecution());
        /**                     Externe                   **/
        Dashboard dashboard2 = new Dashboard();
        dashboard2.setLieu_formation("Externe");
        dashboard2.setCadre(Operateur.get_sum_champ(critaire,"Externe","Cadre",filtre_date));
        dashboard2.setMaitrise(Operateur.get_sum_champ(critaire,"Externe","Maitrise",filtre_date));
        dashboard2.setExecution(Operateur.get_sum_champ(critaire,"Externe","Execution",filtre_date));
        dashboard2.setTotal_general(dashboard2.getCadre()+dashboard2.getMaitrise()+dashboard2.getExecution());
        /**                     Interne                   **/
        Dashboard dashboard3 = new Dashboard();
        dashboard3.setLieu_formation("Interne");
        dashboard3.setCadre(Operateur.get_sum_champ(critaire,"Interne","Cadre",filtre_date));
        dashboard3.setMaitrise(Operateur.get_sum_champ(critaire,"Interne","Maitrise",filtre_date));
        dashboard3.setExecution(Operateur.get_sum_champ(critaire,"Interne","Execution",filtre_date));
        dashboard3.setTotal_general(dashboard3.getCadre()+dashboard3.getMaitrise()+dashboard3.getExecution());
        /**                     Total                   **/
        Dashboard dashboard4 = new Dashboard();
        dashboard4.setLieu_formation("Total");
        dashboard4.setCadre(dashboard1.getCadre()+dashboard2.getCadre()+dashboard3.getCadre()+dashboard4.getCadre());
        dashboard4.setMaitrise(dashboard1.getMaitrise()+dashboard2.getMaitrise()+dashboard3.getMaitrise()+dashboard4.getMaitrise());
        dashboard4.setExecution(dashboard1.getExecution()+dashboard2.getExecution()+dashboard3.getExecution()+dashboard4.getExecution());
        dashboard4.setTotal_general(dashboard1.getTotal_general()+dashboard2.getTotal_general()+dashboard3.getTotal_general()+dashboard4.getTotal_general());
        /**                     List                   **/
        list.add(dashboard1);list.add(dashboard2);list.add(dashboard3);list.add(dashboard4);
        return list;
    }
    public static ObservableList<Dashboard> fill_dash_table2(String critaire,Filtre_date filtre_date){
        ObservableList<Dashboard> list = FXCollections.observableArrayList();
        /**                     CFIC                   **/
        Dashboard dashboard1 = new Dashboard();
        dashboard1.setLieu_formation("CFIC");
        dashboard1.setCadre(Operateur.get_sum_champ2(critaire,"CFIC","Cadre",filtre_date));
        dashboard1.setMaitrise(Operateur.get_sum_champ2(critaire,"CFIC","Maitrise",filtre_date));
        dashboard1.setExecution(Operateur.get_sum_champ2(critaire,"CFIC","Execution",filtre_date));
        dashboard1.setTotal_general(dashboard1.getCadre()+dashboard1.getMaitrise()+dashboard1.getExecution());
        /**                     Externe                   **/
        Dashboard dashboard2 = new Dashboard();
        dashboard2.setLieu_formation("Externe");
        dashboard2.setCadre(Operateur.get_sum_champ2(critaire,"Externe","Cadre",filtre_date));
        dashboard2.setMaitrise(Operateur.get_sum_champ2(critaire,"Externe","Maitrise",filtre_date));
        dashboard2.setExecution(Operateur.get_sum_champ2(critaire,"Externe","Execution",filtre_date));
        dashboard2.setTotal_general(dashboard2.getCadre()+dashboard2.getMaitrise()+dashboard2.getExecution());
        /**                     Interne                   **/
        Dashboard dashboard3 = new Dashboard();
        dashboard3.setLieu_formation("Interne");
        dashboard3.setCadre(Operateur.get_sum_champ2(critaire,"Interne","Cadre",filtre_date));
        dashboard3.setMaitrise(Operateur.get_sum_champ2(critaire,"Interne","Maitrise",filtre_date));
        dashboard3.setExecution(Operateur.get_sum_champ2(critaire,"Interne","Execution",filtre_date));
        dashboard3.setTotal_general(dashboard3.getCadre()+dashboard3.getMaitrise()+dashboard3.getExecution());
        /**                     Total                   **/
        Dashboard dashboard4 = new Dashboard();
        dashboard4.setLieu_formation("Total");
        dashboard4.setCadre(dashboard1.getCadre()+dashboard2.getCadre()+dashboard3.getCadre()+dashboard4.getCadre());
        dashboard4.setMaitrise(dashboard1.getMaitrise()+dashboard2.getMaitrise()+dashboard3.getMaitrise()+dashboard4.getMaitrise());
        dashboard4.setExecution(dashboard1.getExecution()+dashboard2.getExecution()+dashboard3.getExecution()+dashboard4.getExecution());
        dashboard4.setTotal_general(dashboard1.getTotal_general()+dashboard2.getTotal_general()+dashboard3.getTotal_general()+dashboard4.getTotal_general());
        /**                     List                   **/
        list.add(dashboard1);list.add(dashboard2);list.add(dashboard3);list.add(dashboard4);
        return list;
    }

}
