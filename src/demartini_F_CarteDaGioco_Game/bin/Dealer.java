package demartini_F_CarteDaGioco_Game.bin;

public class Dealer {

    private final MazzoDaGioco mazzo;


    public Dealer() {
        mazzo = new MazzoDaGioco(2, false);
    }

    public MazzoDaGioco getMazzo() {
        return mazzo;
    }

    @Override
    public String toString() {
        return "Dealer{" +
                "mazzo=[" + mazzo +
                "]}";
    }
}
