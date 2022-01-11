package demartini_F_CarteDaGioco_Game.bin.Models;

import demartini_F_CarteDaGioco_Game.bin.Carte.Mano;
import demartini_F_CarteDaGioco_Game.bin.Carte.Mazzo;
import demartini_F_CarteDaGioco_Game.bin.Carte.MazzoDaGioco;
import demartini_F_CarteDaGioco_Game.bin.Models.GUIs.Frame;
import demartini_F_CarteDaGioco_Game.bin.Utils.DialogUtil;

public class PlayerModels extends Thread implements Mano, PlayerGameStatus, Interface {

    private Mazzo mano = new Mazzo();
    protected PlayerGameStatus.PlayerStatus status;
    private final Frame frame;

    public PlayerModels() {
        setStatus(PlayerStatus.WAITING);
        frame = new Frame();
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


    @Override
    public void showInterface() {
        frame.setVisibility(true);
    }

    @Override
    public void cloaseInterface() {
        frame.setVisibility(false);

    }
}
