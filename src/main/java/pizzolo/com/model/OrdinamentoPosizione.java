package pizzolo.com.model;

import java.util.Comparator;

public class OrdinamentoPosizione implements Comparator<Libro> {
    @Override
    public int compare(Libro o1, Libro o2) {
        if (o1.getScaffale().getCodice().equals(o2.getScaffale().getCodice())){
            return Integer.compare(o1.getNumPiani(),  o2.getNumPiani());
        }
        return o1.getScaffale().getCodice().compareTo(o2.getScaffale().getCodice());
    }
}
