import java.util.ArrayList;

public class Spil {
    private Spiller[] spillere;
    // I starten af et spil findes ingen vindere, dette angives eksplicit
    private Spiller vinder;
    private Spiller aktivSpiller;

    private ArrayList<Runde> runder;
    private Runde aktivRunde;

    private Raflebaeger raflebaeger;

    private boolean afsluttet;



    public Spil() {
        spillere     = new Spiller[2];
        spillere[0]  = new Spiller("Spiller 1");
        spillere[1]  = new Spiller("Spiller 2");

        runder       = new ArrayList<>();
        runder.add(new Runde());

        raflebaeger  = new Raflebaeger();

        aktivSpiller = spillere[0];
        aktivRunde   = runder.get(runder.size() - 1);

        afsluttet = false;
    }

    public String naesteTur(){
        if (!afsluttet) {
            int nuIndex = java.util.Arrays.asList(spillere).indexOf(aktivSpiller);
            int nyIndex = nuIndex == 1 ? 0 : 1;
            int[] slag = raflebaeger.slaaTerninger();
            int[] tempTur = {slag[0], slag[1], slag[2], nuIndex};

            Spiller _aktivSpiller = aktivSpiller;

            aktivSpiller.setPoint(aktivSpiller.getPoint() + slag[2]);
            aktivRunde.addTur(tempTur);
            checkRunde(nuIndex);
            this.aktivSpiller = spillere[nyIndex];

            return String.format("%s rullede en %der og en %der. %ss point: %d",
                    _aktivSpiller.getNavn(), slag[0], slag[1], _aktivSpiller.getNavn(), _aktivSpiller.getPoint());
        }else{
            return "Det nuværende spil er afsluttet.";
        }
    }

    public void checkRunde(int spillerIndex){
        if (spillerIndex == 1){
            Spiller muligVinder = spillerMedScore(40);
            if(muligVinder != null)
                setVinder(muligVinder);
            else {
                this.runder.add(new Runde());
                this.aktivRunde   = runder.get(runder.size() - 1);
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

    public void slut(){
        this.afsluttet = true;
    }

    public String toString(){
        return String.format(
                "Nuværende spil: %s har %d point, %s har %d point.",
                spillere[0].getNavn(), spillere[0].getPoint(), spillere[1].getNavn(), spillere[1].getPoint()

        );
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

    public int getSidsteSum(int index){
        return 0;
    }

    public Spiller getAktivSpiller() {
        return aktivSpiller;
    }

    public Runde getNuRunde() {
        return aktivRunde;
    }

    public boolean getAfsluttet(){
        return afsluttet;
    }


    // SETTERS/"ADDERS" (til at tilføje enkelte værdier)
    public void setVinder(Spiller vinder) {
        this.vinder = vinder;
    }

    public void tilfoejRunde(Runde runde) {
        this.runder.add(runde);
        this.aktivRunde = runder.get(runder.size() - 1);
    }

    public void tilfoejTur(int[] tur) {
        this.aktivRunde.addTur(tur);
    }


}
