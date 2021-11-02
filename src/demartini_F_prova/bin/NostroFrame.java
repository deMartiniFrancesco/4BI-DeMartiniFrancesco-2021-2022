package demartini_F_prova.bin;

import javax.swing.*;

public class NostroFrame extends JFrame { // Creiamo una sottoclasse di Jframe

    private static final long serialVersionUID = 1L;

    public NostroFrame() { // definiamone un costruttore

        super("Titolo del frame"); // richiama il costruttore della superclasse Jframe passando come parametro la
        // stringa da visualizzare sulla barra del titolo

        setSize(500, 300); // impostiamo le dimensioni del frame LARGHEZZA , ALTEZZA in pixel

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // associamo l'evento di chiusura al solito bottone di chiusura

        setVisible(true); // rendiamo il frame visibile dato che per default non lo è!

    }

    public static void main(String[] argv) {

        NostroFrame nf = new NostroFrame(); // Creiamo un'istanza del nostro frame

    }
}