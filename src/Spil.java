import java.util.ArrayList;

public class Spil {
    private Spiller[] spillere;
    // I starten af et spil findes ingen vindere, dette angives eksplicit
    private Spiller vinder = null;
    private Spiller aktivSpiller = null;

    private ArrayList<Runde> runder;

    private Raflebaeger raflebaeger;


    public Spil() {
        spillere    = new Spiller[2];
        spillere[0] = new Spiller("Spiller 1");
        spillere[1] = new Spiller("Spiller 2");

        runder      = new ArrayList<>();

        raflebaeger = new Raflebaeger();

        aktivSpiller = spillere[0];

    }

    public void NaesteRunde(){
        int[] slag = raflebaeger.slaaTerninger();

        aktivSpiller.setPoint(aktivSpiller.getPoint() + slag[2]);

        int[] tempRunde = {slag[0], slag[1], slag[2]};
        runder.add(new Runde(tempRunde));

        aktivSpiller =
    }

    // GETTERS
    public Spiller getVinder() {
        return vinder;
    }

    public Runde getRunde(int index) {
        return runder.get(index);
    }

    public ArrayList<Runde> getRunder() {
        return runder;
    }

    public Spiller[] getSpillere() {
        return spillere;
    }

    // SETTERS/"ADDERS" (til at tilføje enkelte værdier)
    public void setVinder(Spiller vinder) {
        this.vinder = vinder;
    }

    public void tilfoejRunde(Runde runde) {
        this.runder.add(runde);
    }


}
