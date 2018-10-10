public class Raflebaeger {
    private Terning[] terning;

    public Raflebaeger() {
        terning = new Terning[2];

        terning[0] = new Terning();
        terning[1] = new Terning();
    }

    public Terning[] getTerning() {
        return terning;
    }
}
