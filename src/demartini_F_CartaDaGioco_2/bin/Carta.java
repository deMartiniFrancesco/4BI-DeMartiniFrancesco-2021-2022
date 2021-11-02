package demartini_F_CartaDaGioco_2.bin;

public class Carta {

    final String[] ts = {"", "A ", "2 ", "3 ", "4 ", "5 ", "6 ", "7 ", "8 ", "9 ", "10", "J ", "Q ", "K "};
    final int[] punti = {0, 13, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
    boolean nascosta;
    private int val; //1 13
    private char sem; // CQFP

    public Carta() {
        this(1, 'C');
    }

    public Carta(int val, char seme) {
        setVal(val);
        setSem(seme);
        nascosta = false;
    }

    public Carta(Carta c) {
        val = c.val;
        sem = c.sem;
        nascosta = c.nascosta;
    }

    public boolean uguale(Carta z) {
        return sem == z.sem && val == z.val;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Carta other = (Carta) obj;
        if (this.val != other.val) {
            return false;
        }
        return this.sem == other.sem;
    }


    @Override
    public String toString() {
        return nascosta ? "XXX" : "" + ts[val] + sem;
    }

    public char getSem() {
        return sem;
    }

    public void setSem(char sem) {
        //toupper
        if (sem >= 'a' && sem <= 'z')
            sem -= ('a' - 'A');

        if (sem == 'C' || sem == 'Q' || sem == 'F' || sem == 'P')
            this.sem = sem;
        else
            this.sem = 'C';
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        if (val >= 1 && val <= 13)
            this.val = val;
        else
            this.val = 1;
    }

    public boolean isNascosta() {
        return nascosta;
    }

    public void setNascosta(boolean nascosta) {
        this.nascosta = nascosta;
    }

    public int getPunti() {
        return punti[val];
    }

    boolean vince(Carta c) {
        // in caso di semi diversi vince this
        if (this.sem != c.sem)
            return true;
        else {
            return getPunti() >= c.getPunti();
        }
    }
}


class TestCarta {

    public static void main(String[] args) {
        Carta c1;
        Carta c2, c4;
        c1 = new Carta();
        c2 = new Carta(10, 'C');
        System.out.println(c1);
        System.out.println(c2);
        Carta c3 = new Carta(c2);
        System.out.println(c3);
        c4 = c3;
        System.out.println(c4);

    }
}
