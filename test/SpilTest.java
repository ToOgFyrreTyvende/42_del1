import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class SpilTest {
    private Spil spil;

    // Der bliver eksplicit opskrevet en pr. test foranstaltning
    @org.junit.jupiter.api.BeforeEach
    public void setUpClass() {
        spil = new Spil();
    }


    @Test
    void naesteTur() {
        assertEquals(spil.getSpillere()[0], spil.getAktivSpiller());
        spil.naesteTur();
        assertEquals(spil.getAktivSpiller(), spil.getSpillere()[1]);
        spil.naesteTur();
        assertEquals(spil.getAktivSpiller(), spil.getSpillere()[0]);

        assertEquals(2, spil.getRunder().size());
    }

    @Test
    void spillerMedScore() {

        spil.getSpillere()[0].setPoint(10);
        spil.getSpillere()[1].setPoint(20);

        assertEquals(spil.getSpillere()[1], spil.spillerMedScore(20));

        spil.getSpillere()[0].setPoint(30);
        spil.getSpillere()[1].setPoint(25);

        assertEquals(spil.getSpillere()[0], spil.spillerMedScore(27));

    }

    @Test
    void checkRunde() {
        spil.getSpillere()[0].setPoint(10);
        spil.getSpillere()[1].setPoint(20);

        spil.checkRunde(1);
        assertEquals(null, spil.getVinder());

        spil.getSpillere()[0].setPoint(40);

        spil.checkRunde(1);
        assertEquals( spil.getSpillere()[0], spil.getVinder());
    }

    @Test
    void getVinder() {
        spil.getSpillere()[0].setPoint(40);

        spil.checkRunde(1);
        assertEquals( spil.getSpillere()[0], spil.getVinder());
    }

    @Test
    void getAktivSpiller() {
        assertEquals(spil.getSpillere()[0], spil.getAktivSpiller());
    }

    @Test
    void tilfoejRunde() {
        int[] rundeVaerdier = {3,2};
        spil.tilfoejRunde(new Runde(rundeVaerdier, spil.getSpillere()[0]));
        spil.tilfoejRunde(new Runde(rundeVaerdier, spil.getSpillere()[0]));

        assertEquals(rundeVaerdier, spil.getRunde(0).getTur());

        assertEquals(rundeVaerdier, spil.getRunder().get(1).getTur());
    }
}