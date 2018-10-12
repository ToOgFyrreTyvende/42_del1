import java.util.ArrayList;

public class Runde {
    /**
     * @author xephyz
     * aka. Anders "Micky" Michaelsen
     *
     * Denne klasse bruges til at holde øje med hvilke værdier der bliver sat ind i hver tur
     * Bruges primært til at tjekke efter evt. vindere og midlertidig score
     */
    private ArrayList<int[]> ture;
    private Spiller spiller;

    //TODO: Lav GETTER og SETTER for nødvendige funktioner
    public Runde() {
        ture = new ArrayList<>();
    }

    public int[] getTur(int index) {
        return ture.get(index);
    }

    public ArrayList<int[]> getTure() {
        return ture;
    }

    public void addTur(int[] tur) {
        ture.add(tur);
    }

}
