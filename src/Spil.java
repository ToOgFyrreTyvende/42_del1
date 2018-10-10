import java.util.ArrayList;

public class Spil {
    private Spiller[] spillere;

    // I starten af et spil findes ingen vindere, dette angives eksplicit
    private Spiller vinder = null;

    private ArrayList<Runde> runder;

    private Raflebaeger raflebaeger;


    public Spil() {
        spillere    = new Spiller[2];
        spillere[0] = new Spiller();
        spillere[1] = new Spiller();

        runder      = new ArrayList<>();

        raflebaeger = new Raflebaeger();
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

    public Spiller[] getSpillere() {
        return spillere;
    }

    public void setRunder(ArrayList<Runde> runder) {
        this.runder = runder;
    }
}
