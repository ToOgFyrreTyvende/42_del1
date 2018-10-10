import java.util.Scanner;

public class TerningSpil {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Spil spil = new Spil();

        inputLoop(scanner, spil);

        System.out.println("Hello world!");
    }

    public static void inputLoop(Scanner scanner, Spil spil){
        boolean spilAktivt = true;
        int stadie = 0;

        System.out.println(
                "Velkommen til IOOuteractive Terning spillet!\n" +
                "Tryk Enter for at påbegynde et spil med 2 spillere ↵");

        do {
            if(scanner.hasNextLine()){

                if (spil.getVinder() == null) {
                    System.out.println(spil.naesteTur());
                }else {
                    spil.slut();
                    System.out.println(
                            "Velkommen til IOOuteractive Terning spillet!\n" +
                                    "Tryk Enter for at påbegynde et spil med 2 spillere ↵");
                }
                scanner.nextLine();

            }else{
                scanner.nextLine();
                // Vi bruger \r, eller carriage return, for at overskrive
                // samme linje hvis funktionskaldet bliver kaldt flere gange uden brugerinput
                System.out.print("\rIndtast venligst et korrekt tal: ");
            }
        }while (spilAktivt);
    }
}
