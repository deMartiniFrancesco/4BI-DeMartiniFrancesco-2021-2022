package demartini_F_Input.bin;

import javax.swing.*;


class Input {
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

    public static void main(String[] args) {
        String strinInput = JOptionPane.showInputDialog("inserire carattere articoli: ");
        char charFinal = strinInput.charAt(0);

        System.out.println("variabile: " + charFinal);
        System.out.println(((Object) charFinal).getClass().getName());
    }
}