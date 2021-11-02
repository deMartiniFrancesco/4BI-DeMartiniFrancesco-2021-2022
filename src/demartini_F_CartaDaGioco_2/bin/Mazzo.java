package demartini_F_CartaDaGioco_2.bin;


import java.util.Arrays;

public class Mazzo {

    //MAzzo di carte  
    // il più banale , fatto con vettore
    // il vettore è riempito nei primi elementi (numc)
    // in caso di riempimento si rialloca 
    // si inserisce ed estrae sempre dal fondo, in casi diversi 
    // si shifta
    // errori in estrazione --> false

    private Carta[] mazzo;
    private int numc; // numc effetti

    public Mazzo() {
        mazzo = new Carta[10];
        numc = 0;
    }

    public int size() {
        return numc;
    }

    // rialloca il vettore m 
    private void estendi() {
        Carta[] t = new Carta[mazzo.length * 2];
        if (numc >= 0) System.arraycopy(mazzo, 0, t, 0, numc);
        this.mazzo = t;

    }

    public void add(Carta c) {
        if (numc >= mazzo.length) {
            estendi();
        }
        mazzo[numc] = c;
        numc++;
    }

    public void add(Carta c, int pos) {
        if (pos >= 0 && pos <= numc) {
            if (numc >= mazzo.length) {
                estendi();
            }
            // da numc a pos shifta dx           
            if (numc + 1 - pos >= 0) System.arraycopy(mazzo, pos - 1, mazzo, pos, numc + 1 - pos);

            mazzo[pos] = c;
            numc++;
        }
    }

    // da fare rem ....
    public Carta rem() {
        if (numc <= 0) {
            return null;
        }
        numc--;
        Carta returnCarta = mazzo[0];
        Carta[] copiaMazzo = new Carta[mazzo.length - 1];
        System.arraycopy(mazzo, 1, copiaMazzo, 0, copiaMazzo.length);
        System.out.println(Arrays.toString(mazzo));
        mazzo = copiaMazzo;
        return returnCarta;
    }

    public Carta rem(int pos) {
        if (pos < 0 && pos > numc || numc <= 0) return null;

        numc--;
        Carta returnCarta = mazzo[pos];
        Carta[] copiaMazzo = new Carta[mazzo.length - 1];
        int index = 0;
        for (int i = 0; i < mazzo.length; i++) {
            if (i == pos) continue;
            copiaMazzo[index] = mazzo[i];
            index++;
        }
        mazzo = copiaMazzo;
        return returnCarta;
    }

    public Carta get(int pos) {
        return mazzo[pos];
    }

    public void mescola() {
        // mescola il mazzo
        for (int i = 0; i < numc * 10; i++) {
            int p1, p2;
            p1 = (int) (Math.random() * numc);
            p2 = (int) (Math.random() * numc);
            Carta c;
            c = mazzo[p1];
            mazzo[p1] = mazzo[p2];
            mazzo[p2] = c;


        }
    }

    //inizializza 52 carte
    public void init52() {
        numc = 0;
        mazzo = new Carta[52];
        for (char c : "CQFP".toCharArray())
            for (int i = 1; i <= 13; i++)
                add(new Carta(i, c));

    }

    public void cover() {
        for (int i = 0; i < numc; i++)
            mazzo[i].setNascosta(true);
    }

    public void show() {
        for (int i = 0; i < numc; i++)
            mazzo[i].setNascosta(false);
    }

    public String toString() {
        StringBuilder t = new StringBuilder();
        t.append("[");
        if (numc > 0) {
            t.append(mazzo[0]);
            for (int i = 1; i < numc; i++) {
                t.append(",");
                t.append(mazzo[i]);
            }
        }
        t.append("]");
        return t.toString();
    }
}

class TestMazzo {
    public static void main(String[] args) {
        Mazzo maz = new Mazzo();

        System.out.println(maz);
        maz.add(new Carta(1, 'Q'));
        System.out.println(maz);
        maz.add(new Carta(3, 'P'));
        System.out.println(maz);
        maz.add(new Carta(8, 'C'), 1);
        System.out.println(maz);
        maz.add(new Carta(9, 'C'), 3);
        System.out.println(maz);
        System.out.println("-------------");
        System.out.println(maz.rem());
        System.out.println(maz);
        System.out.println("-------------");
        System.out.println(maz.rem(2));
        System.out.println(maz);


        maz.cover();
        System.out.println(maz);

    }

}
