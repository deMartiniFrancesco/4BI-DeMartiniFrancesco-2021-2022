import java.util.*;

/**
 * Mazzo
 * @author Francesco de' Martini
 */
class Mazzo {

    static int nMazzi = 1, lenSetSeme = 13;
    static int nJolly = nMazzi * 2;
    static int nCarte = (lenSetSeme * 4) * nMazzi + nJolly;

    public static CartaDaGioco vince(CartaDaGioco carta1, CartaDaGioco carta2) {
        CartaDaGioco cartaVincente;

        int valoreCarta1 = carta1.getValore(), semeCarta1 = carta1.getSeme(),

                valoreCarta2 = carta2.getValore(), semeCarta2 = carta2.getSeme();

        if (valoreCarta1 == valoreCarta2) {
            if (semeCarta1 > semeCarta2) {
                cartaVincente = carta1;
            } else {
                cartaVincente = carta2;
            }
        } else {
            if (valoreCarta1 > valoreCarta2) {
                cartaVincente = carta1;
            } else {
                cartaVincente = carta2;
            }
        }
        return cartaVincente;
    }

    public static ArrayList<CartaDaGioco> pesca(ArrayList<CartaDaGioco> mazzo) {
        if (mazzo.size() > 0) {
            CartaDaGioco carta = mazzo.get(0);
            System.out.println(carta.toString());
            System.out.println(carta.carcolaPunteggio());
            mazzo.remove(0);
        } else {
            System.out.println("Fine mazzo");
        }
        return mazzo;
    }

    public static ArrayList<CartaDaGioco> shuffle(ArrayList<CartaDaGioco> mazzo) {
        Collections.shuffle(mazzo);
        return mazzo;
    }

    public static ArrayList<CartaDaGioco> initMazzo(ArrayList<CartaDaGioco> mazzo) {

        for (int i = 0; i < nCarte - nJolly; i++) {
            mazzo.add(new CartaDaGioco(i / lenSetSeme, (i % lenSetSeme) + 1));
        }
        for (int i = 0; i < nJolly; i++) {
            mazzo.add(new CartaDaGioco(4, 0));
        }
        return mazzo;
    }

    public static void printMazzo(ArrayList<CartaDaGioco> mazzo) {
        for (int i = 0; i < mazzo.size(); i++) {
            System.out.print(mazzo.get(i).toString() + "\n");

        }
    }

    public static void main(String args[]) {

        System.out.println("Start");
        Scanner pauseScanner = new Scanner(System.in);
        boolean exit = false;
        ArrayList<CartaDaGioco> mazzo = initMazzo(new ArrayList<CartaDaGioco>());
        String pause = "";
        printMazzo(mazzo);
        System.out.println();

        mazzo = shuffle(mazzo);

        printMazzo(mazzo);
        System.out.println();
        while (!exit) {
            mazzo = pesca(mazzo);
            pause = pauseScanner.nextLine().strip();
            if (pause != "") {
                exit = true;
            }
        }

        pauseScanner.close();
        System.out.println("End");

    }

}

/**
 * CartaDaGioco
 * 
 * @author Francesco de' Martini
 */
public class CartaDaGioco {

    private int seme;
    private int valore;
    private String[] semi = { "cuori", "fiori", "quadri", "picche", "*" };

    /**
     * Costruttore No parametri
     */
    public CartaDaGioco() {
        this.seme = 0;
        this.valore = 0;
    }

    /**
     * Costruttore
     * 
     * @param seme   int con il seme della carta
     * @param valore Intero con il valore della carta
     */
    public CartaDaGioco(int seme, int valore) {
        set(seme, valore);
    }

    /**
     * Assegna i valori a seme e valore
     * 
     * @param seme   int con il seme della carta
     * @param valore Intero con il valore della carta
     */
    public void set(int seme, int valore) {
        setSeme(seme);
        setValore(valore);
    }

    /**
     * Assegna i valori a seme
     * 
     * @param seme int con il seme della carta
     */
    public void setSeme(int seme) {
        this.seme = seme;
    }

    /**
     * Assegna i valori a valore
     * 
     * @param valore Intero con il valore della carta
     */
    public void setValore(int valore) {
        this.valore = valore;
    }

    /**
     * Ritorna un valore
     * 
     * @return Il valore di seme
     */
    public int getSeme() {
        return this.seme;
    }

    /**
     * Ritorna un valore
     * 
     * @return Il valore di valore
     */
    public int getValore() {
        return this.valore;
    }

    /**
     * @return Ritorna una stringa con il valore del seme e del velore della carta
     */
    public String toString() {
        String output;

        output = semi[this.seme] + "->" + this.valore;

        return output;
    }

    public int carcolaPunteggio() {
        int punteggio = 0;
        int valore = this.valore;

        if (this.seme == 4) {
            punteggio = 25;
        } else {
            if (valore > 10) {
                punteggio = 10;
            } else {
                punteggio = valore;
            }
        }
        return punteggio;
    }

}