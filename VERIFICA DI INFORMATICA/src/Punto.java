import static java.lang.Math.sqrt;

public class Punto {
    private double x;
    private double y;

    //costruttore dell'oggetto punto. Parametri che riceve: x e y. Scopo: definire le coordinate che il punto assume
    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    //calcolo della distanza dei due punti. Scopo: calcolare la distanza tra i due punti.
    public double distanza(Punto altro){
        //dichiarazione variabili
        double distanzaTotale, distanzaX, distanzaY;

        //calcolo della distanza tra le coordinate x
        distanzaX=this.x-altro.getX();
        //se è negativa mi ritorna positiva
        if(distanzaX<0){
            return -distanzaX;
        }

        //calcolo della distanza tra le coordinate y
        distanzaY=this.y-altro.getY();
        //se è negativa mi ritorna positiva
        if(distanzaY<0){
            return -distanzaY;
        }

        //calcolo della distanza tra i due punti
        distanzaTotale=sqrt(distanzaX*distanzaX+distanzaY*distanzaY);

        return distanzaTotale;
    }

}
