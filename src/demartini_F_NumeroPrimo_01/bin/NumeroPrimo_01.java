package demartini_F_NumeroPrimo_01.bin;

import javax.swing.*;

class NumeroPrimo_01 {

    public static String input(String imput) {
        String output = JOptionPane.showInputDialog("inserire " + imput + ": ");
        output = output.toLowerCase();
        return output;
    }

    public static void main(String[] args) {

        System.out.println("Start");

        int numero = Integer.parseInt(input("numero"));


        System.out.println("End");

    }
}