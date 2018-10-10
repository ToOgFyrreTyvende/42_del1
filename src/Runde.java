import java.util.ArrayList;

public class Runde {
    /**
     * @author Micky
     * Denne klasse bruges til at holde øje med hvilke værdier der bliver sat ind i hver tur
     * Bruges primært til at tjekke efter evt. vindere og midlertidig score
     */
    private int[] tur;

    //TODO: Lav GETTER og SETTER for nødvendige funktioner
    public Runde(int[] tur) {
        this.tur = tur;
    }

    public int[] getTur() {
        return tur;
    }

    public void setTur(int[] tur) {
        this.tur = tur;
    }
}
