package Class;

import java.util.ArrayList;
import java.util.List;

public class Filtre_personnel extends Filtre{

    public List<String> Poste;
    public List<String> Type;
    public List<String> Categorie;
    public List<String> Direction;
    public List<String> Departement;
    public List<String> Service;

    public Filtre_personnel(){
        this.Poste = new ArrayList<String>();
        this.Type = new ArrayList<String>();
        this.Categorie = new ArrayList<String>();
        this.Direction = new ArrayList<String>();
        this.Departement = new ArrayList<String>();
        this.Service = new ArrayList<String>();
    }

    @Override
    public String toString() {
        Boolean first = true;
        String string = "";
        if(!Poste.isEmpty()){
            if(first){
                string = "where Poste in "+Operateur.list_to_sql_values(Poste);
                first=false;
            }
            else string = string + " and Poste in "+Operateur.list_to_sql_values(Poste);
        }
        if(!Type.isEmpty()){
            if(first){
                string = "where Type_Emploi in "+Operateur.list_to_sql_values(Type);
                first=false;
            }
            else string = string + " and Type_Emploi in "+Operateur.list_to_sql_values(Type);
        }
        if(!Categorie.isEmpty()){
            if(first){
                string = "where Categorie in "+Operateur.list_to_sql_values(Categorie);
                first=false;
            }
            else string = string + " and Categorie in "+Operateur.list_to_sql_values(Categorie);
        }
        if(!Direction.isEmpty()){
            if(first){
                string = "where Direction in "+Operateur.list_to_sql_values(Direction);
                first=false;
            }
            else string = string + " and Direction in "+Operateur.list_to_sql_values(Direction);
        }
        if(!Departement.isEmpty()){
            if(first){
                string = "where Departement in "+Operateur.list_to_sql_values(Departement);
                first=false;
            }
            else string = string + " and Departement in "+Operateur.list_to_sql_values(Departement);
        }
        if(!Service.isEmpty()){
            if(first){
                string = "where Service in "+Operateur.list_to_sql_values(Service);
                first=false;
            }
            else string = string + " and Service in "+Operateur.list_to_sql_values(Service);
        }
        return string;
    }
}
