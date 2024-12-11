public class Poligono {
    private int numeroLati;
    private double lunghezzaLato;

    //costruttore dell'oggetto poligono. Parametri che riceve: numeroLati e lunghezzaLato. Scopo: definire il n umero dei lati e la lunghezza di un lato che l'oggetto assume
    public Poligono(int numeroLati, double lunghezzaLato) {
        this.numeroLati = numeroLati;
        this.lunghezzaLato = lunghezzaLato;
    }

    public int getNumeroLati() {
        return numeroLati;
    }
    public double getLunghezzaLato() {
        return lunghezzaLato;
    }
    public void setNumeroLati(int numeroLati) {
        this.numeroLati = numeroLati;
    }
    public void setLunghezzaLato(double lunghezzaLato) {
        this.lunghezzaLato = lunghezzaLato;
    }

    //calcolo del perimetro: lunghezza del lato moltiplicata per il nuemro di lati del poligono
    public double calcolaPerimetro(){
        return lunghezzaLato*numeroLati;
    }

    public String toString(){
        return String.format("Poligono con %d lati di lunghezza %.1f, perimetro: %.1f", numeroLati, lunghezzaLato, calcolaPerimetro());
    }
}
