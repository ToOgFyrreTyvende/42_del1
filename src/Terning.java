public class Terning {
    private byte resultat = 0;

    public Terning() {

    }

    //TODO: implementer tilfældighed
    public byte getResultat() {
        return resultat;
    }

    public byte nyTerningSlag() {
        int resultat  = (int) (Math.random()*6) + 1;
        this.resultat = (byte) resultat;

        return this.resultat;
    }
}
