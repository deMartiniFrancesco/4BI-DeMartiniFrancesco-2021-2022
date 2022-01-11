package demartini_F_CarteDaGioco_Game.bin.Models.GUIs;

import javax.swing.*;

public class Frame extends JFrame {

    private static final long serialVersionUID = 1L;

    public Frame() { // definiamone un costruttore

        super("Player Frame"); // richiama il costruttore della superclasse Jframe passando come parametro la
        // stringa da visualizzare sulla barra del titolo

        setSize(500, 300); // impostiamo le dimensioni del frame LARGHEZZA , ALTEZZA in pixel

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // associamo l'evento di chiusura al solito bottone di chiusura
    }

    public void setVisibility(boolean visible){
        setVisible(visible);
    }



}

