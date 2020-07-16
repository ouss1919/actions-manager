package Class;
public class Filtre_entier {
    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int min;
    public int max;

    public Filtre_entier() {
    }
    public Filtre_entier(int min, int max) {
        this.min = min;
        this.max = max;
    }
}

