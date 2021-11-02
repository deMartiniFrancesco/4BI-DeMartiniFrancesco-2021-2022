package demartini_F_Eserc.bin;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Eserc {

    /**
     * Legge un file di testo, restituisce il contenuto come vettore di stringhe
     * linea per linea
     *
     * @param fileIn nome del file da leggere
     * @return vettore di stringhe (anche vuoto)
     */
    public static String[] fileToString(String fileIn) {
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(fileIn));
            return br.lines().toArray(String[]::new);
        } catch (FileNotFoundException ex) {
            return new String[0];
        }
    }

    /**
     * Nel vettore di stringhe restituisce la posizione del valore minore (in modo
     * lessicografico) se il vettore è vuoto la funzione restituisce -1
     *
     * @param v vettore oggetto della ricerca
     * @return posizione del valore minore, -1 se il vettore è vuoto
     */
    public static int posMin(String[] v) {
        // Restituisce la posizione del valore minore. (non il valore !!)
        return -1;
    }

    /**
     * Verifica se gli elementi del vettore sono tutti diversi.
     *
     * @param v vettore aoggetto della verifica
     * @return true se tutti gli elementi del vettore sono dversi fra di loro false
     * altrimenti, se il vettore è vuoto il metodo restituisce true
     */
    public static boolean dup(String[] v) {
        // Restituisce true se il vettore non ha elementi duplicati.
        return true;
    }

    /**
     * Conta il numero di righe che contengono un certo pattern il pattern può
     * essere in qualsiasi posizione
     *
     * @param v
     * @param str
     * @return numero di righe trovate
     */
    public static int cntSubstr(String[] v, String str) {
        // Restituisce il numero di righe che contengono str
        return -1;
    }

    /**
     * @param v
     * @return il nuovo vettore senza righe consecutive uguali
     */
    public static String[] uniq(String[] v) {
        // Restituisce il vettore senza righe contigue uguali

        return null;
    }

    public static void main(String[] args) {
        String[] v = fileToString("elenrco.txt");
        System.out.println("Il file ha " + v.length + " linee");
        for (String s : v) {
            System.out.println(s);
        }
        if (v == null) {
            System.out.println("Lettura file fallita");
            return;
        }

        int p = posMin(v);
        if (p > 0) {
            System.out.println("min ->" + v[p]);
        }
        if (dup(v)) {
            System.out.println("Il vettore non ha righe duplicate");
        } else {
            System.out.println("il vettore ha righe duplicate");
        }

        String t = "ciao";
        System.out.println("numero di righe contententi " + t + "--> " + cntSubstr(v, t));
        String[] res = uniq(v);
        System.out.println("vettore senza ripetizioni");
        for (String s : res) {
            System.out.println(s);
        }
    }
}
