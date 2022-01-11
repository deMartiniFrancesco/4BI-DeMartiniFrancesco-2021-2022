package demartini_F_CarteDaGioco_Game.bin;

import demartini_F_CarteDaGioco_Game.bin.Entity.Dealer;
import demartini_F_CarteDaGioco_Game.bin.Entity.Player;
import demartini_F_CarteDaGioco_Game.bin.Utils.DialogUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {


        System.out.println("Start");

        //                CALCOLO PATH RELATIVO UNIVERSALE
        //----------------------------------------------------------------------
        String tempPath = new File(
                String.valueOf(BlackJack.class.getPackage()).replace("package ", "").replace(".", "/")
        ).getParent();
        File uesrPath = new File(System.getProperty("user.dir"));
        String projectPath = uesrPath.getName().equals(tempPath) ?
                uesrPath.getPath() :
                new File(uesrPath.getPath() + "/src").exists() ?
                        uesrPath.getPath() + "/src/" + tempPath :
                        uesrPath.getPath() + tempPath;
        //----------------------------------------------------------------------


        // COSTANTI
        String resursesPath = "/file/";
        String rulesName = "rules.txt";

        // Create a Logger with class name BlackJack
        Logger logger = Logger.getLogger(Main.class.getName());

        // BENVENUTO
        DialogUtil.confirmDialog("Benvenuto in BlackJack", "BlackJack");

        // REGOLE
        if (!DialogUtil.choseDialog("Conosci giá le regle?", "BlackJack")) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(projectPath + resursesPath + rulesName));
                String currentLine = reader.readLine();
                while (currentLine != null) {
                    DialogUtil.confirmDialog(currentLine, "RULES");
                    currentLine = reader.readLine();
                }

                reader.close();
            } catch (IOException e) {
                logger.log(Level.WARNING, e.toString());
            }
        }

        BlackJack game = new BlackJack();

        Dealer dealer = new Dealer();

        game.getPlayers().add(new Player(100));

        // DARE LE CARTE INIZIALI
        dealer.initGame(game.getPlayers());

        // SHOW THE CARDS IN GAME
        //todo
        // creare funzione per vedere le carte
        // Udo dei tread per gestione di piú player

        // PUNTATA PER OGNI PLAYER
        for (Player player :
                game.getPlayers()) {
            player.setPuntata(DialogUtil.numberInput(String.format("inserire punata.\nSaldo attuale: %d", player.getSaldo())));
        }



        for (Player player :
                game.getPlayers()) {

            System.out.println(player);
        }

        System.out.println("End");

    }
}
