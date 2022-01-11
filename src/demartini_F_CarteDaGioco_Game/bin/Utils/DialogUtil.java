package demartini_F_CarteDaGioco_Game.bin.Utils;

import javax.swing.*;

public class DialogUtil {

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

}
