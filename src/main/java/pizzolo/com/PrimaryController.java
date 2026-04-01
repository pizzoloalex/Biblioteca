package pizzolo.com;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import pizzolo.com.model.*;

public class PrimaryController {

    //TODO corregere bug sul ordinamento per scaffale

    @FXML
    private TextArea infoTextArea;
    @FXML
    private TextField isbnTextArea;
    @FXML
    private ComboBox<Scaffale> comboScaffali;
    @FXML
    private ComboBox<Integer> comboPiani;
    @FXML
    private Button primaryButton;
    @FXML
    private Label errorLabel;

    private Biblioteca biblioteca;
    private ArrayList<Libro> libri;
    private ArrayList<Scaffale> scaffali;
    private ArrayList<Libro> copia;

    public void initialize() {
        copia = new ArrayList<>();
        biblioteca = new Biblioteca();
        libri = new ArrayList<>();
        scaffali = new ArrayList<>();
        libri.add(new Libro("123", "Marco vola", "Marco Rossi", "Gemelli"));
        libri.add(new Libro("12356", "Marco cade", "Gomiero Arancino", "Zemelli"));
        libri.add(new Libro("12378", "Ciao tutti", "Nicolo Nero", "Yemelli"));
        libri.add(new Libro("12388", "Il sogno", "Zizzi Giallo", "Pemelli"));
        libri.add(new Libro("12355", "Marco precipita", "Anto Viola", "Lemelli"));
        libri.add(new Libro("12332", "Carraro zumba", "Marco Blu", "Hemelli"));
        libri.add(new Libro("12321", "Ricki inteliggente", "Gomiero", "Kemelli"));
        libri.add(new Libro("12322", "Banca distrutto", "Zomiero ", "Aemelli"));
        libri.add(new Libro("12365", "Il sogno incredibile", "Giallo Rossi", "Qemelli"));
        libri.add(new Libro("123489", "Gomiero", "Tasto Incredibile", "Gemelli"));

        biblioteca.getLibri().addAll(libri);

        scaffali.add(new Scaffale("S1", 5));
        scaffali.add(new Scaffale("S2", 3));
        scaffali.add(new Scaffale("S3", 7));
        scaffali.add(new Scaffale("S4", 8));

        biblioteca.getScaffali().addAll(scaffali);

        for (Scaffale sc : biblioteca.getScaffali()) {
            comboScaffali.getItems().add(sc);
        }
    }

    public void gestionePiano() {
        comboPiani.getItems().clear();
        Scaffale scSelected = comboScaffali.getSelectionModel().getSelectedItem();
        for (int i = 0; i < scSelected.getNumPiani(); i++) {
            comboPiani.getItems().addAll(i + 1);
        }
    }

    public void assegna() {
        if (comboScaffali.getValue() == null) {
            errorLabel.setText("Scegli uno scaffale");
        } else if (comboPiani.getValue() == null) {
            errorLabel.setText("Scegli il numero del piano");
        } else {
            errorLabel.setText("");
        }
        for (Libro lb : biblioteca.getLibri()) {
            if (comboPiani.getValue() == lb.getNumPiani()) {
                errorLabel.setText("Posizione occupata - scegli un altra posizione");
                return;
            }
            if (lb.getCodiceISBN().equals(isbnTextArea.getText())) {
                copia.add(lb);
                lb.setNumPiani(comboPiani.getValue());
                lb.setScaffale(comboScaffali.getValue());
                String s = infoTextArea.getText() + lb.toString() + "\n";
                infoTextArea.setText(s);
                return;
            }

        }

    }

    public void ordinaISBN() {
        infoTextArea.clear();
        Collections.sort(copia);
        String s = "";
        for (Libro lb : copia) {
            s += infoTextArea.getText() + lb.toString() + "\n";
        }
        infoTextArea.setText(s);
    }

    public void ordinTitolo() {
        infoTextArea.clear();
        Collections.sort(copia, new OrdinamentoTitolo());
        String s = "";
        for (Libro lb : copia) {
            s += infoTextArea.getText() + lb.toString() + "\n";
        }
        infoTextArea.setText(s);
    }

    public void ordinaPosizione() {
        infoTextArea.clear();
        Collections.sort(copia, new OrdinamentoPosizione());
        String s = "";
        for (Libro lb : copia) {
            s += infoTextArea.getText() + lb.toString() + "\n";
        }
        infoTextArea.setText(s);
    }
}
