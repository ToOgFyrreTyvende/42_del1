import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

class TerningTest {
    private Terning terning;

    // Der bliver eksplicit opskrevet en pr. test foranstaltning
    @org.junit.jupiter.api.BeforeEach
    public void setUpClass() {
        terning = new Terning();
    }

    /**
     * @author Hackerman
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

    /**
     * Tester at et slag med to terninger, giver en sum der er normaltfordelt.
     */
    @Test
    void testAfRaflebaeger(){
        int[] slag = new int[11];

        Raflebaeger raflebaeger = new Raflebaeger();

        for (int i = 0; i <= 1000; i++) {

            int nyTerningSlag = raflebaeger.slaaTerninger()[2];
            slag[nyTerningSlag - 2]++;
        }

        System.out.println(Arrays.toString(slag));
        for(int i = 0; i < slag.length - 1; i++){
            System.out.println((i + 1) + " : " + slag[i] + " ");
        }

        assertTrue(slag[0] >= ((1000*1/36)-40) && slag[0] <= ((1000*1/36)+40));
        assertTrue(slag[1] >= ((1000*2/36)-40) && slag[1] <= ((1000*2/36)+40));
        assertTrue(slag[2] >= ((1000*3/36)-40) && slag[2] <= ((1000*3/36)+40));
        assertTrue(slag[3] >= ((1000*4/36)-40) && slag[3] <= ((1000*4/36)+40));
        assertTrue(slag[4] >= ((1000*5/36)-40) && slag[4] <= ((1000*5/36)+40));
        assertTrue(slag[5] >= ((1000*6/36)-40) && slag[5] <= ((1000*6/36)+40));
        assertTrue(slag[6] >= ((1000*5/36)-40) && slag[6] <= ((1000*5/36)+40));
        assertTrue(slag[7] >= ((1000*4/36)-40) && slag[7] <= ((1000*4/36)+40));
        assertTrue(slag[8] >= ((1000*3/36)-40) && slag[8] <= ((1000*3/36)+40));
        assertTrue(slag[9] >= ((1000*2/36)-40) && slag[9] <= ((1000*2/36)+40));
        assertTrue(slag[10] >= ((1000*1/36)-40) && slag[10] <= ((1000*1/36)+40));




    }




}