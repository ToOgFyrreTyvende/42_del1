public class Terning {
    /**
     * Denne klasse bruges til at simulere en "terning"
     * Bruges primært til at udgive et resultat af terningslaget
     * @author 42
     */
    private int resultat = 0;

    public Terning() {

    }

    //TODO: Tag højde for, at resultatet starter med at være 0?
    public int getResultat() {
        return resultat;
    }

    public int nyTerningSlag() {
        int resultat  = (int) (Math.random()*6) + 1;
        this.resultat = resultat;

        return this.resultat;
    }
}
