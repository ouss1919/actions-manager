package Class;

import java.util.ArrayList;
import java.util.List;

public class Filtre_action extends Filtre {
    public List<String> Structure;
    public List<String> Organisme;
    public boolean effectif;
    public boolean nbreParticipation;
    public boolean cout;
    public boolean duree;
    public int effectifMax;
    public int effectifMin;
    public int nbreParticipationMax;
    public int nbreParticipationMin;
    public int dureeMax;
    public int dureeMin;
    public int coutMax;
    public int coutMin;

    public Filtre_action(){
        this.Structure = new ArrayList<String>();
        this.Organisme = new ArrayList<String>();
        this.effectifMax=this.nbreParticipationMax=this.coutMax=this.dureeMax=2147483600;
        this.effectifMin=this.coutMin=this.dureeMin=this.nbreParticipationMin=0;
        this.effectif=this.nbreParticipation=this.duree=this.cout=false;
    }

    @Override
    public String toString() {
        Boolean first = true;
        String string = "";
        if(!Structure.isEmpty()){
            if(first){
                string = "where Structure in "+ Operateur.list_to_sql_values(Structure);
                first=false;
            }
            else string = string + " and Structure in "+ Operateur.list_to_sql_values(Structure);
        }
        if(!Organisme.isEmpty()){
            if(first){
                string = "where Organisme_formation in "+ Operateur.list_to_sql_values(Organisme);
                first=false;
            }
            else string = string + " and Organisme_formation in "+ Operateur.list_to_sql_values(Organisme);
        }
        if(effectif){
            if(first){
                string = "where Effectif_reel between "+effectifMin+" and "+effectifMax+"";
                first=false;
            }
            else string = string + " and Effectif_reel between "+effectifMin+" and "+effectifMax+"";
        }
        if(nbreParticipation){
            if(first){
                string = "where Nbre_participation between "+nbreParticipationMin+" and "+nbreParticipationMax+"";
                first=false;
            }
            else string = string + " and Nbre_participation between "+nbreParticipationMin+" and "+nbreParticipationMax+"";
        }
        if(duree){
            if(first){
                string = "where Duree between "+dureeMin+" and "+dureeMax+"";
                first=false;
            }
            else string = string + " and Duree between "+dureeMin+" and "+dureeMax+"";
        }if(cout){
            if(first){
                string = "where Cout_previsionnel between "+coutMin+" and "+coutMax+"";
                first=false;
            }
            else string = string + " and Cout_previsionnel between "+coutMin+" and "+coutMax+"";
        }
        return string;
    }
}
