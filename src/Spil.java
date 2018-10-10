import java.util.ArrayList;

public class Spil {
    private Spiller[] spillere;
    // I starten af et spil findes ingen vindere, dette angives eksplicit
    private Spiller vinder;
    private Spiller aktivSpiller;

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

    public void naesteTur(){
        int[] slag      = raflebaeger.slaaTerninger();
        int[] tempRunde = {slag[0], slag[1], slag[2]};
        int nuIndex   = java.util.Arrays.asList(spillere).indexOf(aktivSpiller);
        int nyIndex    = nuIndex == 1?0:1;

        aktivSpiller.setPoint(aktivSpiller.getPoint() + slag[2]);
        runder.add(new Runde(tempRunde, aktivSpiller));
        checkRunde(nuIndex);
        this.aktivSpiller = spillere[nyIndex];
    }

    public void checkRunde(int spillerIndex){
        if (spillerIndex == 1){
            Spiller muligVinder = spillerMedScore(40);
            if(muligVinder != null){
                this.vinder = muligVinder;
            }
        }
    }

    public Spiller spillerMedScore(int score){
        int fundet = 0;
        int res    = 0;

        for(int i = 0; i < spillere.length; i++) {
            if (spillere[i].getPoint() >= score) {
                fundet += 1;
                res     = i;
            }
        }
        if (fundet == 1)
            return spillere[res];
        else
            return null;
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

    public Spiller getAktivSpiller() {
        return aktivSpiller;
    }

    // SETTERS/"ADDERS" (til at tilføje enkelte værdier)
    public void setVinder(Spiller vinder) {
        this.vinder = vinder;
    }

    public void tilfoejRunde(Runde runde) {
        this.runder.add(runde);
    }


}
