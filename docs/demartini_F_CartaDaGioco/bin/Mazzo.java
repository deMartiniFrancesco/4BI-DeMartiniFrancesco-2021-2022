import java.util.*;

/**
 * Mazzo
 * @author Francesco de' Martini
 */
public class Mazzo {
    private ArrayList<CartaDaGioco> mazzo = new ArrayList<>();
    private int nMazzi = 1, lenSetSeme = 13;
    private int nJolly = nMazzi * 2;
    private int nCarte = (lenSetSeme * 4) * nMazzi + nJolly;

    public Mazzo() {
        initMazzo();
    }

    public Mazzo(ArrayList<CartaDaGioco> mazzo) {
        this.mazzo = mazzo;
    }

    public ArrayList<CartaDaGioco> getMazzo() {
        return mazzo;
    }

    public void setMazzo(ArrayList<CartaDaGioco> mazzo) {
        this.mazzo = mazzo;
    }

    public int getnMazzi() {
        return nMazzi;
    }

    public void setnMazzi(int nMazzi) {
        this.nMazzi = nMazzi;
    }

    public int getLenSetSeme() {
        return lenSetSeme;
    }

    public void setLenSetSeme(int lenSetSeme) {
        this.lenSetSeme = lenSetSeme;
    }

    public int getnJolly() {
        return nJolly;
    }

    public void setnJolly(int nJolly) {
        this.nJolly = nJolly;
    }

    public int getnCarte() {
        return nCarte;
    }

    public void setnCarte(int nCarte) {
        this.nCarte = nCarte;
    }

    public CartaDaGioco vince(CartaDaGioco carta1, CartaDaGioco carta2) {
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

    public void pesca() {
        if (mazzo.size() > 0) {
            CartaDaGioco carta = mazzo.get(0);
            System.out.println(carta.toString());
            System.out.println(carta.carcolaPunteggio());
            mazzo.remove(0);
        } else {
            System.out.println("Fine mazzo");
        }
    }

    public void shuffle() {
        Collections.shuffle(mazzo);
    }

    public void initMazzo() {

        for (int i = 0; i < nCarte - nJolly; i++) {
            mazzo.add(new CartaDaGioco(i / lenSetSeme, (i % lenSetSeme) + 1));
        }
        for (int i = 0; i < nJolly; i++) {
            mazzo.add(new CartaDaGioco(4, 0));
        }
    }

    public String toString() {
        String returnedString = new String();
        for (int i = 0; i < mazzo.size(); i++) {
            returnedString += (mazzo.get(i).toString() + "\n");
        }
        return returnedString;
    }

}


class Test {

	public static void main(String args[]) {

        System.out.println("Start");
        Scanner pauseScanner = new Scanner(System.in);
        boolean exit = false;
        Mazzo mazzo = new Mazzo();
        String pause;
        System.out.println(mazzo);
        System.out.println();

        mazzo.shuffle();

        System.out.println(mazzo);
        System.out.println();
        while (!exit) {
            mazzo.pesca();
            pause = pauseScanner.nextLine().trim();
            System.out.printf("'%s'", pause);
            if (pause != "") {
                exit = true;
            }
        }

        pauseScanner.close();
        System.out.println("End");

    }
}