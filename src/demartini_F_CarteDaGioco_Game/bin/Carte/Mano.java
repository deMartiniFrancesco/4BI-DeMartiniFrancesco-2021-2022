package demartini_F_CarteDaGioco_Game.bin.Carte;

import demartini_F_CarteDaGioco_Game.bin.Carte.Mazzo;
import demartini_F_CarteDaGioco_Game.bin.Carte.MazzoDaGioco;

public class Mano {

    private Mazzo mano;

    public Mano() {
        this.mano = new Mazzo();
    }

    /**
     * Gets mano.
     *
     * @return the mano
     */
    public Mazzo getMano() {
        return mano;
    }

    /**
     * Sets mano.
     *
     * @param mano the mano
     */
    public void setMano(Mazzo mano) {
        this.mano = mano;
    }

    /**
     * Pesca carta.
     *
     * @param mazzo the mazzo
     */
    public void pescaCarta(MazzoDaGioco mazzo) {
        mano.addCard(mazzo.pescaCarta());
    }
}
