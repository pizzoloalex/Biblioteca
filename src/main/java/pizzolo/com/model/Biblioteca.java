package pizzolo.com.model;

import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Libro> libri;
    private ArrayList<Scaffale> scaffali;

    public Biblioteca() {
        libri = new ArrayList<>();
        scaffali = new ArrayList<>();
    }

    public ArrayList<Libro> getLibri() {
        return libri;
    }

    public ArrayList<Scaffale> getScaffali() {
        return scaffali;
    }


}
