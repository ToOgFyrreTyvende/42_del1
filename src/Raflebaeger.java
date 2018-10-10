public class Raflebaeger {
    private Terning[] terning;
    private int sum = 0;

    public Raflebaeger() {
        terning = new Terning[2];

        terning[0] = new Terning();
        terning[1] = new Terning();
    }

    public Terning[] getTerning() {
        return terning;
    }

    public int[] slaaTerninger(){
        sum = terning[0].nyTerningSlag() + terning[0].nyTerningSlag();

        int[] returnArr = {terning[0].getResultat(), terning[1].getResultat(), sum};

        return returnArr;
    }
}
