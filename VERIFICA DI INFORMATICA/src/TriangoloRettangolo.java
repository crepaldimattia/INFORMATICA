public class TriangoloRettangolo {
    private double base;
    private double altezza;

    //costruttore dell'oggetto triangoloRettangolo. Parametri che riceve: base e altezza del triangolo. Scopo: definire le variabili che il triangolo assume
    public TriangoloRettangolo(double base, double altezza) {
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

    //E' utile aver i metodi di calcolo in una classe per migliorare l'incapsulamento
    public double calcolaArea() {
        return (base * altezza) / 2;
    }

    public int compareTo(TriangoloRettangolo altro) {
        double areaQuesto = this.calcolaArea();
        double areaAltro = altro.calcolaArea();
        return Double.compare(areaQuesto, areaAltro);
    }
}
