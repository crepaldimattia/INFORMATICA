public class Rettangolo {
    private double base;
    private double altezza;

    //costruttore dell'oggetto rettangolo. Parametri che riceve: base e altezza del rettangolo. Scopo: definire le variabili che il rettangolo assume
    public Rettangolo(double base, double altezza) {
        this.base = base;
        this.altezza = altezza;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltezza() {
        return altezza;
    }

    public void setAltezza(double altezza) {
        this.altezza = altezza;
    }

    public double calcolaArea() {
        return base * altezza;
    }

    public int compareTo(Rettangolo altro) {
        double areaQuesto = this.calcolaArea();
        double areaAltro = altro.calcolaArea();
        return Double.compare(areaQuesto, areaAltro);
    }

    //E' utile aver i metodi di calcolo in una classe per migliorare l'incapsulamento
    public double calcolaPerimetro(){
        return (base*2)+(altezza*2);
    }
}
