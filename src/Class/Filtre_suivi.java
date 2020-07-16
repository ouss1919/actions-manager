package Class;

import java.util.*;

public class Filtre_suivi extends Filtre{
    public List<String> Fonction; // poste
    public List<String> Direction;
    public List<String> Categorie;
    public List<String> Type_formation;
    public List<String> Organisme;
    public List<String> Lieu_formation;
    public List<String> Lieu_formation2;
    public List<String> Type_formation2;
    public List<String> Planification;
    public List<String> Attestation;
    public List<String> Avis_eval_organisme;
    public List<String> Avis_retour_eval;
    public List<String> Action_eval_inssuf;

    public Filtre_suivi(){
        this.Fonction = new ArrayList<String>();
        this.Direction = new ArrayList<String>();
        this.Categorie = new ArrayList<String>();
        this.Type_formation = new ArrayList<String>();
        this.Organisme = new ArrayList<String>();
        this.Lieu_formation = new ArrayList<String>();
        this.Lieu_formation2 = new ArrayList<String>();
        this.Type_formation2 = new ArrayList<String>();
        this.Planification = new ArrayList<String>();
        this.Attestation = new ArrayList<String>();
        this.Avis_eval_organisme = new ArrayList<String>();
        this.Avis_retour_eval = new ArrayList<String>();
        this.Action_eval_inssuf = new ArrayList<String>();

    }

    @Override
    public String toString() {
        Boolean first = true;
        String string = "";
        if(!Fonction.isEmpty()){
            if(first){
                string = "where Fonction in "+Operateur.list_to_sql_values(Fonction);
                first=false;
            }
            else string = string + " and Fonction in "+Operateur.list_to_sql_values(Fonction);
        }
        if(!Direction.isEmpty()){
            if(first){
                string = "where Direction_affectation in "+Operateur.list_to_sql_values(Direction);
                first=false;
            }
            else string = string + " and Direction_affectation in "+Operateur.list_to_sql_values(Direction);
        }
        if(!Categorie.isEmpty()){
            if(first){
                string = "where Categorie in "+Operateur.list_to_sql_values(Categorie);
                first=false;
            }
            else string = string + " and Categorie in "+Operateur.list_to_sql_values(Categorie);
        }
        if(!Type_formation.isEmpty()){
            if(first){
                string = "where Type_formation in "+Operateur.list_to_sql_values(Type_formation);
                first=false;
            }
            else string = string + " and Type_formation in "+Operateur.list_to_sql_values(Type_formation);
        }
        if(!Organisme.isEmpty()){
            if(first){
                string = "where Organisme_formation in "+Operateur.list_to_sql_values(Organisme);
                first=false;
            }
            else string = string + " and Organisme_formation in "+Operateur.list_to_sql_values(Organisme);
        }
        if(!Lieu_formation.isEmpty()){
            if(first){
                string = "where Lieu_formation in "+Operateur.list_to_sql_values(Lieu_formation);
                first=false;
            }
            else string = string + " and Lieu_formation in "+Operateur.list_to_sql_values(Lieu_formation);
        }
        if(!Lieu_formation2.isEmpty()){
            if(first){
                string = "where Lieu_formation_2 in "+Operateur.list_to_sql_values(Lieu_formation2);
                first=false;
            }
            else string = string + " and Lieu_formation_2 in "+Operateur.list_to_sql_values(Lieu_formation2);
        }
        if(!Type_formation2.isEmpty()){
            if(first){
                string = "where Type_formation_2 in "+Operateur.list_to_sql_values(Type_formation2);
                first=false;
            }
            else string = string + " and Type_formation_2 in "+Operateur.list_to_sql_values(Type_formation2);
        }
        if(!Planification.isEmpty()){
            if(first){
                string = "where Planification in "+Operateur.list_to_sql_values(Planification);
                first=false;
            }
            else string = string + " and Planification in "+Operateur.list_to_sql_values(Planification);
        }
        if(!Attestation.isEmpty()){
            if(first){
                string = "where Attestation_reçue in "+Operateur.list_to_sql_values(Attestation);
                first=false;
            }
            else string = string + " and Attestation_reçue in "+Operateur.list_to_sql_values(Attestation);
        }
        if(!Avis_eval_organisme.isEmpty()){
            if(first){
                string = "where Avis_evaluation_organisme in "+Operateur.list_to_sql_values(Avis_eval_organisme);
                first=false;
            }
            else string = string + " and Avis_evaluation_organisme in "+Operateur.list_to_sql_values(Avis_eval_organisme);
        }
        if(!Avis_retour_eval.isEmpty()){
            if(first){
                string = "where Avis_retou_evaluation in "+Operateur.list_to_sql_values(Avis_retour_eval);
                first=false;
            }
            else string = string + " and Avis_retou_evaluation in "+Operateur.list_to_sql_values(Avis_retour_eval);
        }
        if(!Action_eval_inssuf.isEmpty()){
            if(first){
                string = "where Action_evaluation_insufisante in "+Operateur.list_to_sql_values(Action_eval_inssuf);
                first=false;
            }
            else string = string + " and Action_evaluation_insufisante in "+Operateur.list_to_sql_values(Action_eval_inssuf);
        }
        return string;
    }
}
