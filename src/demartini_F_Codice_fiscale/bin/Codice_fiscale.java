package demartini_F_Codice_fiscale.bin;

import javax.swing.*;

class Codice_fiscale {

    public static String input(String imput) {
        String output = JOptionPane.showInputDialog("inserire " + imput + ": ");
        output = output.toUpperCase();
        return output;
    }

    public static String consonanti(String str) {
        StringBuilder output = new StringBuilder();
        String vocali = "AEIOU ";
        String cons = "QWRTYPSDFGHJKLZXCVBNM";

        for (int i = 0; i < str.length(); i++) {
            if (cons.indexOf(str.charAt(i)) >= 0) {
                output.append(str.charAt(i));
            }
        }

        for (int i = 0; i < str.length(); i++) {
            if (vocali.indexOf(str.charAt(i)) >= 0) {
                output.append(str.charAt(i));
            }
        }
        output.append("xxx");

        return output.substring(0, 3);
    }

    public static String data(String str, String sesso) {
        String[] vetStringDate = str.split("/ ");
        String vetMesi = "ABCDEHLMPRST";
        int i = 0;

        char charAt = vetMesi.charAt(Integer.parseInt(str.substring(3, 5)) - 1);
        if (sesso.charAt(0) == 'M') {
            return str.substring(6, 8)
                    + charAt
                    + str.substring(0, 2);
        } else {
            return str.substring(6, 8)
                    + charAt
                    + (char) (str.charAt(0) + 4) + str.charAt(1);
        }
    }

    public static void main(String[] args) {
        String nome = input("nome"),
                cognome = input("cognome"),
                codiceFiscale = "",
                dataNascita = input("data di nascita\nes: (21 10 2003)"),
                sesso = input("sesso M/F");


        codiceFiscale += consonanti(cognome);
        codiceFiscale += consonanti(nome);
        codiceFiscale += data(dataNascita, sesso);

        System.out.println(codiceFiscale);

    }

}
