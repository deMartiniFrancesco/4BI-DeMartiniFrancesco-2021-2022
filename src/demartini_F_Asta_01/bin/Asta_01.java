package demartini_F_Asta_01.bin;

import javax.swing.*;

class Asta_01 {

    public static String input(String imput) {
        String output = JOptionPane.showInputDialog("inserire " + imput + ": ");
        output = output.toLowerCase();
        return output;
    }

    public static void main(String[] args) {

        System.out.println("Start");

        int compratore1 = -2, compratore2 = -1;
        boolean asta = true;

        while (asta) {
            while (compratore1 <= compratore2 && compratore1 != 0) {
                compratore1 = Integer.parseInt(input("offerta comp. 1"));
            }
            if (compratore1 != 0) {
                System.out.println("compratore 1 -> " + compratore1);

                while (compratore2 <= compratore1 && compratore2 != 0) {
                    compratore2 = Integer.parseInt(input(("offerta comp. 2")));
                }

                if (compratore2 == 0) {
                    asta = false;
                } else {
                    System.out.println("compratore 2 -> " + compratore2);
                }
            } else {
                asta = false;
            }


        }

        System.out.print("Vince ");

        if (compratore1 > compratore2) {
            System.out.println("compratore 1 -> " + compratore1);
        } else {
            System.out.println("compratore 2 -> " + compratore2);
        }

        System.out.println("End");
    }
}