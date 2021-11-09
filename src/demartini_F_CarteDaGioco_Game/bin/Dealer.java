package demartini_F_CarteDaGioco_Game.bin;

public class Dealer {

    private MazzoDaGioco mazzo;


    public Dealer() {
        mazzo = new MazzoDaGioco(2, false);
    }

    public MazzoDaGioco getMazzo() {
        return mazzo;
    }

    public void initGame(){



    }

    @Override
    public String toString() {
        return "Dealer{" +
                "mazzo=[" + mazzo +
                "]}";
    }
}
