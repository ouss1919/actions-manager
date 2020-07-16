package Class;

import java.sql.*;

public class Suivi{
    private int N;
    private String id; //from personnel
    private int act;
    private String nom; //from personnel
    private String prenom; //from personnel
    private String fonction; //from personnel
    private String direction; //from personnel
    private String categorie; //from personnel
    private String intitule;
    private Date date_debut;
    private Date date_fin;
    private int cout; //from action //TODO clarification concernant les données saisies automatiquement
    private int nbr_jrs; //from action
    private int nbr_hr;
    private String type_formation;
    private String organisme; //from action
    private String lieu_formation;
    private String lieu_formation2;
    private String type_formation2;
    private String planification;
    private String periode_eval; //from action
    private String attestation_recue;
    private String avis_eval_organisme;
    private String avis_retour_eval;
    private String action_eval_inssuf;
    private int prevision_effectif;
    private int prevision_cout;
    private Date prevision_date;
    private int prevision_nbr_jour;
    private int prevision_nbr_hr;


    public Suivi() {
    }

    // --------------------------------

    public int getN() {
        return N;
    }

    public void setN(int n) {
        N = n;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAct() {
        return act;
    }

    public void setAct(int act) {
        this.act = act;
    }

    public String getType_formation2() {
        return type_formation2;
    }

    public void setType_formation2(String type_formation2) {
        this.type_formation2 = type_formation2;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direcection) {
        this.direction = direcection;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public int getCout() {
        return cout;
    }

    public void setCout(int cout) {
        this.cout = cout;
    }

    public int getNbr_jrs() {
        return nbr_jrs;
    }

    public void setNbr_jrs(int nbr_jrs) {
        this.nbr_jrs = nbr_jrs;
    }

    public int getNbr_hr() {
        return nbr_hr;
    }

    public void setNbr_hr(int nbr_hr) {
        this.nbr_hr = nbr_hr;
    }

    public String getType_formation() {
        return type_formation;
    }

    public void setType_formation(String type_formation) {
        this.type_formation = type_formation;
    }

    public String getOrganisme() {
        return organisme;
    }

    public void setOrganisme(String organisme) {
        this.organisme = organisme;
    }

    public String getLieu_formation() {
        return lieu_formation;
    }

    public void setLieu_formation(String lieu_formation) {
        this.lieu_formation = lieu_formation;
    }

    public String getLieu_formation2() {
        return lieu_formation2;
    }

    public void setLieu_formation2(String lieu_formation2) {
        this.lieu_formation2 = lieu_formation2;
    }

    public String getPlanification() {
        return planification;
    }

    public void setPlanification(String planification) {
        this.planification = planification;
    }

    public String getPeriode_eval() {
        return periode_eval;
    }

    public void setPeriode_eval(String periode_eval) {
        this.periode_eval = periode_eval;
    }

    public String getAttestation_recue() {
        return attestation_recue;
    }

    public void setAttestation_recue(String attestation_recue) {
        this.attestation_recue = attestation_recue;
    }

    public String getAvis_eval_organisme() {
        return avis_eval_organisme;
    }

    public void setAvis_eval_organisme(String avis_eval_organisme) {
        this.avis_eval_organisme = avis_eval_organisme;
    }

    public String getAvis_retour_eval() {
        return avis_retour_eval;
    }

    public void setAvis_retour_eval(String avis_retour_eval) {
        this.avis_retour_eval = avis_retour_eval;
    }

    public String getAction_eval_inssuf() {
        return action_eval_inssuf;
    }

    public void setAction_eval_inssuf(String action_eval_inssuf) {
        this.action_eval_inssuf = action_eval_inssuf;
    }

    public int getPrevision_effectif() {
        return prevision_effectif;
    }

    public void setPrevision_effectif(int prevision_effectif) {
        this.prevision_effectif = prevision_effectif;
    }

    public int getPrevision_cout() {
        return prevision_cout;
    }

    public void setPrevision_cout(int prevision_cout) {
        this.prevision_cout = prevision_cout;
    }

    public Date getPrevision_date() {
        return prevision_date;
    }

    public void setPrevision_date(Date prevision_date) {
        this.prevision_date = prevision_date;
    }

    public int getPrevision_nbr_jour() {
        return prevision_nbr_jour;
    }

    public void setPrevision_nbr_jour(int prevision_nbr_jour) {
        this.prevision_nbr_jour = prevision_nbr_jour;
    }

    public int getPrevision_nbr_hr() {
        return prevision_nbr_hr;
    }

    public void setPrevision_nbr_hr(int prevision_nbr_hr) {
        this.prevision_nbr_hr = prevision_nbr_hr;
    }

    public void auto_fill_from_action(int num){
        String url = "jdbc:mysql://localhost:3306/gica";
        String user = "root";
        String password = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,user,password);
            Statement stmt=con.createStatement();
            String query = "select * from actions_planif where N = '"+num+"'";
            ResultSet rs=stmt.executeQuery(query);
            if(rs==null) {
                query = "select * from actions_non_planif where N = '" + num + "'";
                rs = stmt.executeQuery(query);
            }
            while(rs.next()) {
                this.setAct(rs.getInt(1));
                this.setIntitule(rs.getString(2));
                this.setNbr_jrs(rs.getInt(7));
                this.setNbr_hr(this.getNbr_jrs()*6);
                this.setCout(rs.getInt(9));
                this.setOrganisme(rs.getString(10));
                this.setPeriode_eval(rs.getString(12));
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
    }

    public void auto_fill_from_personnel(String matricule){
        String url = "jdbc:mysql://localhost:3306/gica";
        String user = "root";
        String password = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,user,password);
            Statement stmt=con.createStatement();
            String query = "select * from personnel where Matricule = '"+matricule+"'";
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next()) {
                this.setId(rs.getString(1));
                this.setNom(rs.getString(2));
                this.setPrenom(rs.getString(3));
                this.setFonction(rs.getString(5));
                this.setCategorie(rs.getString(7));
                this.setDirection(rs.getString(8));
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
    }

}