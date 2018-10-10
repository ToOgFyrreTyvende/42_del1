import static org.junit.jupiter.api.Assertions.*;


class TerningTest {
    private Terning terning;

    // Der bliver eksplicit opskrevet
    @org.junit.jupiter.api.BeforeEach
    public void setUpClass() {
        terning = new Terning();
    }

    /**
     * @author Hackerman ( ͡° ͜ʖ ͡°)
     * Tester ternings default resultat værdi ved getter.
     * @result Default sat værdi fra klassen, altså <code>0</code>
     */
    @org.junit.jupiter.api.Test
    void getResultat() {
        assertEquals(0, terning.getResultat());
    }

    /**
     * Tester ternings et terningkast.
     * @result den private attribute <code>resultat</code> ændres og returneres,
     *         herfra generers et tal mellem 1 og 6, og tjekkes efter med
     *         <code>getResultat()</code>
     */
    @org.junit.jupiter.api.Test
    void nyTerningSlag() {
        int slag = terning.nyTerningSlag();

        assertEquals(terning.getResultat(), slag);
        assertTrue(terning.getResultat() >= 1 && terning.getResultat() <= 6);
    }
}