package demartini_F_CarteDaGioco_Game.bin.Entity;

import demartini_F_CarteDaGioco_Game.bin.Carte.Mano;
import demartini_F_CarteDaGioco_Game.bin.Carte.Mazzo;
import demartini_F_CarteDaGioco_Game.bin.Carte.MazzoDaGioco;

import java.util.ArrayList;

public class Dealer implements Mano {

    private Mazzo mano = new Mazzo();
    private final MazzoDaGioco mazzo;
    private final int nStartCard;

    public Dealer() {
        super();
        mazzo = new MazzoDaGioco(2, false);
        nStartCard = 2;
    }

    public MazzoDaGioco getMazzo() {
        return mazzo;
    }

    public void initGame(ArrayList<Player> players) {

        mazzo.shuffle();

        for (Player player : players) {
            for (int i = 0; i < nStartCard; i++) {
                player.getMano().addCard(mazzo.pescaCarta());
            }
        }

        for (int i = 0; i < nStartCard + 1; i++) {
            getMano().addCard(mazzo.pescaCarta().setCoperta(true));
        }
    }

    @Override
    public String toString() {
        return "Dealer{" +
                "mazzo=[" + mazzo +
                "]}";
    }


    @Override
    public Mazzo getMano() {
        return mano;
    }

    @Override
    public void setMano(Mazzo mano) {
        this.mano = mano;
    }

    @Override
    public void pescaCarta(MazzoDaGioco mazzo) {
        mano.addCard(mazzo.pescaCarta());
    }
}
