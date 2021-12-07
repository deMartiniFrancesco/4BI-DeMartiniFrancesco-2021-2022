package demartini_F_SerieNumerica_01.bin;

import javax.swing.*;

class SerieNumerica_01 {

    public static String input(String imput) {
        String output = JOptionPane.showInputDialog("inserire " + imput + ": ");
        output = output.toLowerCase();
        return output;
    }

    public static void main(String[] args) {

        System.out.println("Start");

        int numberInput = Integer.parseInt(input("numero serie")),
                numPrecedente = 0;

        while (numberInput != numPrecedente) {
            numPrecedente = numberInput;
            numberInput = Integer.parseInt(input("numero serie"));

        }
        System.out.println("Serie finita");

        System.out.println("End");
    }
}