package Class;

import java.sql.Date;

public class Personnel{
    private String id;
    private String nom;
    private String prenom;
    private Date date_dentree;
    private String poste;
    private String type_demploi;
    private String categorie;
    private String direction;
    private String departement;
    private String service;

    public Personnel()
    {

    }

    public Personnel(String id, String nom, String prenom, Date date_dentree, String poste, String type_demploi, String categorie, String direction, String departement, String service) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.date_dentree = date_dentree;
        this.poste = poste;
        this.type_demploi = type_demploi;
        this.categorie = categorie;
        this.direction = direction;
        this.departement = departement;
        this.service = service;
    }
    public String getId() {
        return id;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getType_demploi() {
        return type_demploi;
    }

    public void setType_demploi(String type_demploi) {
        this.type_demploi = type_demploi;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public Date getDate_dentree() {
        return date_dentree;
    }

    public void setDate_dentree(Date date_dentree) {
        this.date_dentree = date_dentree;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setId(String id) {
        this.id = id;
    }
}