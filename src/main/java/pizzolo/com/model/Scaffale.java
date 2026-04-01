package pizzolo.com.model;

public class Scaffale {
    private String codice;
    private int numPiani;

    public Scaffale(String codice, int numPiani) {
        this.codice = codice;
        this.numPiani = numPiani;
    }

    public String getCodice() {
        return codice;
    }

    @Override
    public String toString() {
        return codice;
    }

    public int getNumPiani() {
        return numPiani;
    }
}
