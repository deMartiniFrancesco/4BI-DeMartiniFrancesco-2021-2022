package demartini_F_CarteDaGioco_Game.bin.Carte;

import java.util.ArrayList;

/**
 * Mazzo
 *
 * @author Francesco de' Martini
 */
public class Mazzo {
    /**
     * The Mazzo.
     */
    protected ArrayList<CartaDaGioco> mazzo;

    /**
     * Instantiates a new Mazzo.
     */
    public Mazzo() {
        mazzo = new ArrayList<>();
    }

    /**
     * Instantiates a new Mazzo.
     *
     * @param mazzo the mazzo
     */
    public Mazzo(ArrayList<CartaDaGioco> mazzo) {
        this.mazzo = mazzo;
    }

    /**
     * Gets mazzo.
     *
     * @return the mazzo
     */
    public ArrayList<CartaDaGioco> getMazzo() {
        return mazzo;
    }

    /**
     * Sets mazzo.
     *
     * @param mazzo the mazzo
     */
    public void setMazzo(ArrayList<CartaDaGioco> mazzo) {
        this.mazzo = mazzo;
    }


    /**
     * Pesca carta carta da gioco.
     *
     * @return the carta da gioco
     */
    public CartaDaGioco pescaCarta() {
        CartaDaGioco cartaDaGioco = null;
        if (mazzo.size() > 0) {
            cartaDaGioco = mazzo.get(0);
            mazzo.remove(0);
        }
        return cartaDaGioco;
    }

    /**
     * Add card.
     *
     * @param cartaDaGioco the carta da gioco
     * @return
     */
    public Mazzo addCard(CartaDaGioco cartaDaGioco) {
        mazzo.add(cartaDaGioco);
        return this;
    }

    public String toString() {
        StringBuilder returnedString = new StringBuilder();
        for (CartaDaGioco cartaDaGioco : mazzo) {
            returnedString.append(cartaDaGioco.toString()).append("\n");
        }
        return returnedString.toString();
    }
}
