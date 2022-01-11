package demartini_F_CarteDaGioco_Game.bin;

/**
 * The type Player.
 */
public class Player {

    private int puntata;
    private int saldo;

    private Mazzo mano;

    /**
     * Instantiates a new Player.
     */
    public Player() {
        mano = new Mazzo();
        saldo = 0;
        puntata = 0;
    }

    /**
     * Instantiates a new Player.
     *
     * @param saldo the saldo
     */
    public Player(int saldo) {
        this();
        this.saldo = saldo;
    }

    /**
     * Gets puntata.
     *
     * @return the puntata
     */
    public int getPuntata() {
        return puntata;
    }

    /**
     * Sets puntata.
     *
     * @param puntata the puntata
     */
    public void setPuntata(int puntata) {
        saldo -= puntata;
        this.puntata = puntata;
    }

    /**
     * Gets saldo.
     *
     * @return the saldo
     */
    public int getSaldo() {
        return saldo;
    }

    /**
     * Sets saldo.
     *
     * @param saldo the saldo
     */
    public void setSaldo(int saldo) {
        this.saldo = saldo;
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

    @Override
    public String toString() {
        return "Player{" +
                "puntata=" + puntata +
                ", saldo=" + saldo +
                ", mano=" + mano +
                '}';
    }
}
