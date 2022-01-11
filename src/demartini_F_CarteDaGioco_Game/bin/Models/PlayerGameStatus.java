package demartini_F_CarteDaGioco_Game.bin.Models;

public abstract interface PlayerGameStatus {
    enum PlayerStatus {
        WAITING,
        PASS,
        OUT,
        DONE,
        DOING
    }


    void setStatus(PlayerStatus status);
    void pass();
    void out();


}
