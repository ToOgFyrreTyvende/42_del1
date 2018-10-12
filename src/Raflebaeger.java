public class Raflebaeger {
    /**
     * @author xephyz
     * aka. Anders "Micky" Michaelsen
     *
     * @Hackerman tjek lige den her description xdd
     * Denne klasse er et array med 2 pladser til at holde øje med de to værdier givet fra
     * Terning.java for at se de individuelle slag's værdier for hver tur
     */
    private Terning[] terning;
    private int sum = 0;

    public Raflebaeger() {
        terning = new Terning[2];

        terning[0] = new Terning();
        terning[1] = new Terning();
    }

    public int[] slaaTerninger(){
        sum = terning[0].nyTerningSlag() + terning[1].nyTerningSlag();

        int[] returnArr = {terning[0].getResultat(), terning[1].getResultat(), sum};

        return returnArr;
    }


    // Getters + Setters Below here
    // ----------------------------
    public Terning[] getTerning() {
        return terning;
    }
}
