package Class;

public class Dashboard {
    private String Lieu_formation;
    private int Cadre;
    private int Maitrise;
    private int Execution;
    private int Total_general;
    public String getLieu_formation() {
        return Lieu_formation;
    }

    public void setLieu_formation(String lieu_formation) {
        Lieu_formation = lieu_formation;
    }

    public int getCadre() {
        return Cadre;
    }

    public void setCadre(int cadre) {
        Cadre = cadre;
    }

    public int getMaitrise() {
        return Maitrise;
    }

    public void setMaitrise(int maitrise) {
        Maitrise = maitrise;
    }

    public int getExecution() {
        return Execution;
    }

    public void setExecution(int execution) {
        Execution = execution;
    }

    public int getTotal_general() {
        return Total_general;
    }

    public void setTotal_general(int total_general) {
        Total_general = total_general;
    }

    public Dashboard() {
    }

    public Dashboard(String lieu_formation, int cadre, int maitrise, int execution, int total_general) {
        Lieu_formation = lieu_formation;
        Cadre = cadre;
        Maitrise = maitrise;
        Execution = execution;
        Total_general = total_general;
    }
}
