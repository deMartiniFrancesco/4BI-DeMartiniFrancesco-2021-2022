package demartini_F_CarteDaGioco_Game.bin.Entity;

import demartini_F_CarteDaGioco_Game.bin.Carte.MazzoDaGioco;
import demartini_F_CarteDaGioco_Game.bin.Carte.Mano;

import java.util.ArrayList;

public class Dealer extends Mano {

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
}
