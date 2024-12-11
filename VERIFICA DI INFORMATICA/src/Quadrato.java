public class Quadrato {
    private double lato;

    //costruttore dell'oggetto quadrato. Parametri che riceve: misura del alto. Scopo: definire le la misura del lato del quadrato
    public Quadrato(double lato) {
        this.lato = lato;
    }

    public double getLato() {
        return lato;
    }

    public void setLato(double lato) {
        this.lato = lato;
    }

    //E' utile aver i metodi di calcolo in una classe per migliorare l'incapsulamento
    public double calcolaArea() {
        return lato * lato;
    }

    public int compareTo(Quadrato altro) {
        double areaQuesto = this.calcolaArea();
        double areaAltro = altro.calcolaArea();
        return Double.compare(areaQuesto, areaAltro);
    }
}
