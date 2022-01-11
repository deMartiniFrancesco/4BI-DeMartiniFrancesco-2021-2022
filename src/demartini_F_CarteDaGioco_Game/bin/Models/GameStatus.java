package demartini_F_CarteDaGioco_Game.bin.Models;

public abstract interface GameStatus {
    enum GameStatusType {
        START,
        PAUSE,
        END
    }
    void startGame();
    void pauseGame();
    void endGame();

}
