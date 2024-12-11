public class Circonferenza {
    private double raggio;

    //costruttore dell'oggetto circonferenza. Parametri che riceve: raggio. Scopo: definire il raggio che la circonferenza assume
    public Circonferenza(double raggio) {
        this.raggio = raggio;
    }

    public double getRaggio() {
        return raggio;
    }

    public void setRaggio(double raggio) {
        this.raggio = raggio;
    }

    //E' utile aver i metodi di calcolo in una classe per migliorare l'incapsulamento
    public double calcolaArea() {
        return Math.PI * raggio * raggio;
    }

    public int compareTo(Circonferenza altro) {
        double areaQuesto = this.calcolaArea();
        double areaAltro = altro.calcolaArea();
        return Double.compare(areaQuesto, areaAltro);
    }
}
