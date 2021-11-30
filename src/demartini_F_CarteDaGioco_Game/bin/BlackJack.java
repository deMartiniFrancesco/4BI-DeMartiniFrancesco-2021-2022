package demartini_F_CarteDaGioco_Game.bin;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * The type Black jack.
 */
public class BlackJack {


    /**
     * Number input int.
     *
     * @param inputDioalog the input dioalog
     * @return the int
     */
    public static int numberInput(String inputDioalog) {
        int returnedNumber = -1;

        while (returnedNumber <= 0) {
            try {
                returnedNumber = Integer.parseInt(input(inputDioalog));
                if (returnedNumber <= 0) System.out.println("Inserire numero maggiore di 0");
            } catch (Exception e) { // or your specific exception
                System.out.println("inserire numero valido");
            }
        }
        return returnedNumber;
    }

    public static String input(String inputDioalog) {
        String output = JOptionPane.showInputDialog(inputDioalog);
        output = output.toLowerCase();
        return output;
    }

    public static void confirmDialog(String inputDioalog, String title) {
        JOptionPane.showConfirmDialog(null,
                inputDioalog, title, JOptionPane.DEFAULT_OPTION);
    }

    public static boolean choseDialog(String inputDioalog, String title) {
        return JOptionPane.showConfirmDialog(null,
                inputDioalog, title, JOptionPane.YES_NO_OPTION) == 0;
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) throws IOException {


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

        confirmDialog("Benvenuto in BlackJack", "BlackJack");

        if (!choseDialog("Conosci giá le regle?", "BlackJack")) {
            // show REGOLE
            try {
                BufferedReader reader = new BufferedReader(new FileReader(projectPath + resursesPath + rulesName));
                String currentLine = reader.readLine();
                while (currentLine != null) {
                    confirmDialog(currentLine, "RULES");
                    currentLine = reader.readLine();
                }

                reader.close();
            } catch (IOException e) {
                System.err.println(e);
            }
        }

        Dealer dealer = new Dealer();

        Player player = new Player(100);


        player.setPuntata(numberInput("inserire punata"));

        System.out.println(player);

        System.out.println("End");

    }
}
