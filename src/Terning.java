public class Terning {
    /**
     * 
     */
    private byte resultat = 0;

    public Terning() {

    }

    //TODO: Tag højde for, at resultatet starter med at være 0?
    public byte getResultat() {
        return resultat;
    }

    public byte nyTerningSlag() {
        int resultat  = (int) (Math.random()*6) + 1;
        this.resultat = (byte) resultat;

        return this.resultat;
    }
}
