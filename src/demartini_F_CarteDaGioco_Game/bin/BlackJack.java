package demartini_F_CarteDaGioco_Game.bin;

import demartini_F_CarteDaGioco_Game.bin.Entity.Player;
import demartini_F_CarteDaGioco_Game.bin.Models.GameStatus;

import java.util.ArrayList;

/**
 * The type Black jack.
 */
public class BlackJack implements GameStatus {

    private GameStatusType status;
    private final ArrayList<Player> players;

    public BlackJack() {
        this.status = GameStatusType.START;
        players = new ArrayList<>();
    }


    public ArrayList<Player> getPlayers() {
        return players;
    }


    @Override
    public void startGame() {
        status = GameStatusType.START;
    }

    @Override
    public void pauseGame() {
        status = GameStatusType.PAUSE;

    }

    @Override
    public void endGame() {
        status = GameStatusType.END;
    }
}
