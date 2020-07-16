package Class;

import java.sql.Date;

public class Action{

    private int num;
    private String act;
    private String obj_rech;
    private String structure;
    private int eff_real_forme;
    private int nbr_participants;
    private int duree_jour;
    private Date debut_formation;
    private int cout;
    private String organisme_formation;
    private String lieu_formation;
    private String periode_devaluation;
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getAct() {
        return act;
    }

    public String getPeriode_devaluation() {
        return periode_devaluation;
    }

    public void setPeriode_devaluation(String periode_devaluation) {
        this.periode_devaluation = periode_devaluation;
    }

    public String getLieu_formation() {
        return lieu_formation;
    }

    public void setLieu_formation(String lieu_formation) {
        this.lieu_formation = lieu_formation;
    }

    public String getOrganisme_formation() {
        return organisme_formation;
    }

    public void setOrganisme_formation(String organisme_formation) {
        this.organisme_formation = organisme_formation;
    }

    public int getCout() {
        return cout;
    }

    public void setCout(int cout) {
        this.cout = cout;
    }

    public Date getDebut_formation() {
        return debut_formation;
    }

    public void setDebut_formation(Date debut_formation) {
        this.debut_formation = debut_formation;
    }

    public int getDuree_jour() {
        return duree_jour;
    }

    public void setDuree_jour(int duree_jour) {
        this.duree_jour = duree_jour;
    }

    public int getNbr_participants() {
        return nbr_participants;
    }

    public void setNbr_participants(int nbr_participants) {
        this.nbr_participants = nbr_participants;
    }

    public int getEff_real_forme() {
        return eff_real_forme;
    }

    public void setEff_real_forme(int eff_real_forme) {
        this.eff_real_forme = eff_real_forme;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public String getObj_rech() {
        return obj_rech;
    }

    public void setObj_rech(String obj_rech) {
        this.obj_rech = obj_rech;
    }

    public void setAct(String act) {
        this.act = act;
    }


}
