package demartini_F_PosizioneCifra_01.bin;

import javax.swing.*;

class PosizioneCifra_01 {
    public static String input(String imput) {
        String output = JOptionPane.showInputDialog("inserire " + imput + ": ");
        output = output.toLowerCase();
        return output;
    }

    public static void main(String[] args) {

        System.out.println("Start");

        String cifra = input("cifra");
        boolean proprieta = true;

        for (int i = 0; i < cifra.length(); i++) {
            int numero = (int) (cifra.charAt(i)) - 48;
            if (numero < i) {
                proprieta = false;
            }
        }

        System.out.println(proprieta);


        System.out.println("End");

    }
}