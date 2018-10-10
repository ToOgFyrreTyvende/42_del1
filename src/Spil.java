import java.util.ArrayList;

public class Spil {
    // I starten af et spil findes ingen vindere, dette angives eksplicit
    private Spiller vinder = null;

    private ArrayList<Runde> runder = new ArrayList<>();


    public Spil() {
    }

    public Spiller getVinder() {
        return vinder;
    }

    public void setVinder(Spiller vinder) {
        this.vinder = vinder;
    }

    public ArrayList<Runde> getRunder() {
        return runder;
    }

    public Runde getRunde(int index) {
        return runder.get(index);
    }

    public void tilfoejRunde(Runde runde) {
        this.runder.add(runde);
    }
}
