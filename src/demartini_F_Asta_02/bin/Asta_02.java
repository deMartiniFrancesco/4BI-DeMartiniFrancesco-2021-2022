package demartini_F_Asta_02.bin;

import javax.swing.*;

class Asta_02 {

    public static String input(String imput) {
        String output = JOptionPane.showInputDialog("inserire " + imput + ": ");
        output = output.toLowerCase();
        return output;
    }

    public static void main(String[] args) {

        System.out.println("Start");

        int compratore1 = 0, compratore2 = 0, puntata;
        boolean asta = true;

        while (asta) {
            puntata = 0;
            System.out.println("compratore 1 -> " + compratore1 + " compratore 2 -> " + compratore2);
            while (compratore1 + puntata <= compratore2 && asta) {
                puntata = Integer.parseInt(input("rilancio comp. 1"));
                if (puntata == 0) {
                    asta = false;
                }
            }
            compratore1 += puntata;
            if (asta) {
                puntata = 0;
                System.out.println("compratore 2 -> " + compratore2 + " compratore 1 -> " + compratore1);
                while (compratore2 + puntata <= compratore1 && asta) {
                    puntata = Integer.parseInt(input("rilancio comp. 2"));
                    if (puntata == 0) {
                        asta = false;
                    }
                }
                compratore2 += puntata;
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