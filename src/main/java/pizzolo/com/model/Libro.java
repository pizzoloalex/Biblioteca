package pizzolo.com.model;

public class Libro implements Comparable<Libro> {
    private String codiceISBN;
    private String titolo;
    private String autore;
    private String editore;
    private Scaffale scaffale;
    private int numPiani;

    public Libro(String codiceISBN, String titolo, String autore, String editore) {
        this.codiceISBN = codiceISBN;
        this.titolo = titolo;
        this.autore = autore;
        this.editore = editore;
    }

    public String getCodiceISBN() {
        return codiceISBN;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getAutore() {
        return autore;
    }

    public String getEditore() {
        return editore;
    }

    public Scaffale getScaffale() {
        return scaffale;
    }

    public int getNumPiani() {
        return numPiani;
    }

    public void setScaffale(Scaffale scaffale) {
        this.scaffale = scaffale;
    }

    public void setNumPiani(int numPiani) {
        this.numPiani = numPiani;
    }

    @Override
    public String toString() {
        return
                "codiceISBN='" + codiceISBN +
                        ", titolo='" + titolo +
                        ", autore='" + autore +
                        ", editore='" + editore +
                        ", scaffale=" + scaffale +
                        ", numPiani=" + numPiani;
    }

    @Override
    public int compareTo(Libro o) {
        return this.codiceISBN.compareTo(o.codiceISBN);
    }
}
