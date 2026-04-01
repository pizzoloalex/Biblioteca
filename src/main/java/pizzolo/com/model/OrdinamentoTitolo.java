package pizzolo.com.model;

import java.util.Comparator;

public class OrdinamentoTitolo implements Comparator<Libro> {

    @Override
    public int compare(Libro o1, Libro o2) {
        return o1.getTitolo().compareTo(o2.getTitolo());
    }
}
