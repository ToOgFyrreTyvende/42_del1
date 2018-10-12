import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TerningTest {
    private Terning terning;

    // Der bliver eksplicit opskrevet en pr. test foranstaltning
    @org.junit.jupiter.api.BeforeEach
    public void setUpClass() {
        terning = new Terning();
    }

    /**
     * @author Hackerman ( ͡° ͜ʖ ͡°)
     * Tester ternings default resultat værdi ved getter.
     * @result Default sat værdi fra klassen, altså <code>0</code>
     */
    @Test
    void getResultat() {
        assertEquals(0, terning.getResultat());
    }

    /**
     * Tester ternings et terningkast.
     * @result den private attribute <code>resultat</code> ændres og returneres,
     *         herfra generers et tal mellem 1 og 6, og tjekkes efter med
     *         <code>getResultat()</code>
     */
    @Test
    void nyTerningSlag() {
        int slag = terning.nyTerningSlag();

        assertEquals(terning.getResultat(), slag);
        assertTrue(terning.getResultat() >= 1 && terning.getResultat() <= 6);
    }

    /**
     * Tester at alle seks værdier forekommer lige hyppigit indenfor en passende fejlmargin,
     * som i dette tilfælde er sat til +-400, ved 60000 kast.
     * @result Resultatet lever op til kravene
     */
    @Test
    void fordelingAfSlag(){
        int et = 0, to = 0, tre = 0, fire = 0, fem = 0, seks = 0;

        for (int i = 0; i < 60000; i++) {
            int nyTerningSlag = terning.nyTerningSlag();

            if(nyTerningSlag == 1){
                et = et + 1;
            }
            else if(nyTerningSlag == 2){
                to = to + 1;
            }
            else if(nyTerningSlag == 3){
                tre = tre + 1;
            }
            else if(nyTerningSlag == 4){
                fire = fire + 1;
            }
            else if(nyTerningSlag == 5){
                fem = fem + 1;
            }
            else if(nyTerningSlag == 6){
                seks = seks + 1;
            }

            if(i == 59999){
                System.out.println("1 " + et + "\n" + "2 " + to + "\n" + "3 " + tre + "\n" +
                        "4 " + fire + "\n" + "5 " + fem + "\n" + "6 " + et + "\n");
            }
        }

        assertTrue(et >= 10000 - 400 && et <= 10000 + 400);
        assertTrue(to >= 10000 - 400 && et <= 10000 + 400);
        assertTrue(tre >= 10000 - 400 && et <= 10000 + 400);
        assertTrue(fire >= 10000 - 400 && et <= 10000 + 400);
        assertTrue(fem >= 10000 - 400 && et <= 10000 + 400);
        assertTrue(seks >= 10000 - 400 && et <= 10000 + 400);
    }



}