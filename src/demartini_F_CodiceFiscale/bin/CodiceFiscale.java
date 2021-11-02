import javax.swing.*;

public class CodiceFiscale {

    public static String input(String imput) {
        String output = JOptionPane.showInputDialog("inserire " + imput + ": ");
        output = output.toUpperCase();
        return output;
    }

    public static String consonanti(String imput) {
        String consonanti = "QWRTYPSDFGHJKLZXCVBNM",
                output = "";
        for (int i = 0; i < imput.length(); i++) {
            if (consonanti.indexOf(imput.charAt(i)) >= 0) {
                output += imput.charAt(i);
            }
        }
        return output;
    }

    public static String lettere(String imput) {
        String vocali = "AEIOU",
                output = "";

        output += consonanti(imput);

        for (int i = 0; i < imput.length(); i++) {
            if (vocali.indexOf(imput.charAt(i)) >= 0) {
                output += imput.charAt(i);
            }
        }
        output += "XXX";

        return output;
    }


    public static String Nome(String imput) {
        String lett = lettere(imput);

        if (consonanti(imput).length() > 3) {
            return ("" + lett.charAt(0) + lett.charAt(2) + lett.charAt(3));
        }
        return (lett.substring(0, 3));
    }

    public static String data(String dataNascita, String sex) {  // data gg/mm/aa  AAMGG
        String mesi = "ABCDEHLMPRST";
        if (sex.charAt(0) == 'M') {
            return dataNascita.substring(6, 8)
                    + mesi.charAt(Integer.parseInt(dataNascita.substring(3, 5)) - 1)
                    + dataNascita.substring(0, 2);
        } else {
            return dataNascita.substring(6, 8)
                    + mesi.charAt(Integer.parseInt(dataNascita.substring(3, 5)) - 1)
                    + (char) (dataNascita.charAt(0) + 4) + dataNascita.charAt(1);
        }

    }

    public static char cin(String s) {
        int[] disp = {1, 0, 5, 7, 9, 13, 15, 17, 19, 21, 1, 0, 5, 7, 9, 13, 15, 17, 19, 21, 2, 4, 18, 20, 11, 3, 6, 8, 12, 14, 16, 10, 22, 25, 24, 23};
        int[] pari = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};
        int codice = 0;
        int i;
        for (i = 0; i < s.length(); i++) {
            int p;
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                p = c - '0';  // l'intero corrispondente '0'  -> 0     '4' -->4
            } else {
                p = c - 'A' + 10;    // c-'A'   'D' -> 3
            }
            if ((i + 1) % 2 == 0) {
                codice += pari[p];
            } else {
                codice += disp[p];
            }
        }
        return (char) ('A' + (codice % 26));
    }


    public static void main(String[] args) {
        String nome = input("nome"),
                cognome = input("cognome"),
                codiceFiscale = "",
                dataNascita = input("data di nascita\nes: (21 10 2003)"),
                sesso = input("sesso M/F"),
                comune = input("codice comune");

        codiceFiscale = lettere(cognome).substring(0, 3) + Nome(nome) + data(dataNascita, sesso) + comune;
        codiceFiscale += cin(codiceFiscale);
        System.out.print(codiceFiscale + "\n");
    }
}