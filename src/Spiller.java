public class Spiller {
    private int point = 0;
    private String navn;


    public Spiller(String navn) {
        this.navn = navn;
    }

    public int getPoint() {
        return point;
    }

    public String getNavn(){
        return this.navn;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
