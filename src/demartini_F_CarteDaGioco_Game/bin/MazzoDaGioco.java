package demartini_F_CarteDaGioco_Game.bin;

import java.util.Collections;

/**
 * The type Mazzo da gioco.
 */
public class MazzoDaGioco extends Mazzo {

    private final int lenSetSeme = 13;
    private final int nJolly;
    private final int nCarte;
    private final boolean jolly;
    private int nMazzi;

    /**
     * Instantiates a new Mazzo da gioco.
     */
    public MazzoDaGioco(int nMazzi, boolean jolly) {
        super();
        this.nMazzi = nMazzi;
        this.jolly = jolly;
        nJolly = jolly ? nMazzi * 2 : 0;
        nCarte = (lenSetSeme * 4) * nMazzi + nJolly;
        initMazzo();
    }

    /**
     * Gets mazzi.
     *
     * @return the mazzi
     */
    public int getnMazzi() {
        return nMazzi;
    }

    /**
     * Sets mazzi.
     *
     * @param nMazzi the n mazzi
     */
    public void setnMazzi(int nMazzi) {
        this.nMazzi = nMazzi;
        initMazzo();
    }

    /**
     * Gets len set seme.
     *
     * @return the len set seme
     */
    public int getLenSetSeme() {
        return lenSetSeme;
    }

    /**
     * Gets jolly.
     *
     * @return the jolly
     */
    public int getnJolly() {
        return nJolly;
    }

    /**
     * Gets carte.
     *
     * @return the carte
     */
    public int getnCarte() {
        return nCarte;
    }

    /**
     * Init mazzo.
     */
    public void initMazzo() {

        for (int i = 0; i < nCarte - nJolly; i++) {
            mazzo.add(new CartaDaGioco(i / lenSetSeme % 4, (i % lenSetSeme) + 1, false));
        }
        if (jolly) {
            for (int i = 0; i < nJolly; i++) {
                mazzo.add(new CartaDaGioco(4, 0, false));
            }
        }

    }

    /**
     * Shuffle.
     */
    public void shuffle() {
        Collections.shuffle(mazzo);
    }


    //TODO sistema vincente

    /**
     * Vince carta da gioco.
     *
     * @param carta1 the carta 1
     * @param carta2 the carta 2
     * @return the carta da gioco
     */
    public CartaDaGioco vince(CartaDaGioco carta1, CartaDaGioco carta2) {
        CartaDaGioco cartaVincente;

        int valoreCarta1 = carta1.getValore(), semeCarta1 = carta1.getSeme(),

                valoreCarta2 = carta2.getValore(), semeCarta2 = carta2.getSeme();

        if (valoreCarta1 == valoreCarta2) {
            if (semeCarta1 > semeCarta2) {
                cartaVincente = carta1;
            } else {
                cartaVincente = carta2;
            }
        } else {
            if (valoreCarta1 > valoreCarta2) {
                cartaVincente = carta1;
            } else {
                cartaVincente = carta2;
            }
        }
        return cartaVincente;
    }
}
