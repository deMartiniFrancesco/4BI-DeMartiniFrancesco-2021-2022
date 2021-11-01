package demartini_F_Punto.bin;

class Punto {
    private double x;
    private double y;

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Punto{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public double distanzaOrigine(){
        return Math.hypot(x, y);
    }

    public double distanzaPunto(Punto punto){
        return Math.hypot(this.x - punto.getX(), this.y - punto.getY());
    }

    public Punto piuVicinoO(Punto punto){
        return (distanzaOrigine() >= punto.distanzaOrigine()) ? this : punto;
    }
}

class PuntoTest {
    public static void main(String[] args) {

        System.out.println("Start");

        Punto punto1 = new Punto(15,6);
        Punto punto2 = new Punto(8,4);


        System.out.println(punto1.distanzaOrigine());

        System.out.println("End");

    }
}
