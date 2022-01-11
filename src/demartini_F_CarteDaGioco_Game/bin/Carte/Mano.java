package demartini_F_CarteDaGioco_Game.bin.Carte;

public interface Mano {
    /**
     * Gets mano.
     *
     * @return the mano
     */
    Mazzo getMano();

    /**
     * Sets mano.
     *
     * @param mano the mano
     */
    void setMano(Mazzo mano);

    /**
     * Pesca carta.
     *
     * @param mazzo the mazzo
     */
    void pescaCarta(MazzoDaGioco mazzo);
}
