package demartini_F_CarteDaGioco_Game.bin.Entity;

import demartini_F_CarteDaGioco_Game.bin.Models.PlayerModels;
import demartini_F_CarteDaGioco_Game.bin.Utils.DialogUtil;

/**
 * The type Player.
 */
public class Player extends PlayerModels {

    private int puntata;
    private int saldo;


    /**
     * Instantiates a new Player.
     */
    public Player() {
        super();
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
        start();
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
    public void run() {
        do {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        while (this.status != PlayerStatus.DOING);
        setPuntata(DialogUtil.numberInput(String.format("inserire punata.\nSaldo attuale: %d", getSaldo())));
    }


    @Override
    public String toString() {
        return "Player{" +
                "puntata=" + puntata +
                ", saldo=" + saldo +
                ", mano=\n" + getMano() +
                '}';
    }
}
