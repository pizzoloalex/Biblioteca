package pizzolo.com.model;

import java.util.Comparator;

public class OrdinamentoPosizione implements Comparator<Libro> {
    @Override
    public int compare(Libro o1, Libro o2) {
        return Integer.compare(o1.getScaffale().getNumPiani(), o2.getScaffale().getNumPiani());
    }
}
