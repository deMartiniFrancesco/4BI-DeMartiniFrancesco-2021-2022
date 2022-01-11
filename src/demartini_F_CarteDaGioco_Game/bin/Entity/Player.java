package demartini_F_CarteDaGioco_Game.bin.Entity;

import demartini_F_CarteDaGioco_Game.bin.Carte.Mano;
import demartini_F_CarteDaGioco_Game.bin.Models.PlayerGameStatus;

/**
 * The type Player.
 */
public class Player extends Mano implements PlayerGameStatus {

    private PlayerStatus status;
    private int puntata;
    private int saldo;


    /**
     * Instantiates a new Player.
     */
    public Player() {
        super();
        setStatus(PlayerStatus.WAITING);
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


    @Override
    public String toString() {
        return "Player{" +
                "puntata=" + puntata +
                ", saldo=" + saldo +
                ", mano=\n" + getMano() +
                '}';
    }

    @Override
    public void setStatus(PlayerStatus status) {
        this.status = status;
    }

    @Override
    public void pass() {
        status = PlayerStatus.PASS;
    }

    @Override
    public void out() {
        status = PlayerStatus.OUT;

    }
}
