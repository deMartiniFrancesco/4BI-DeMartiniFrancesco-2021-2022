package demartini_F_Dado.bin;

import java.util.Random;

class Dado {
    private int nFacce;
    private boolean truccato;

    public Dado() {
        nFacce = 6;
        truccato = false;
    }

    public Dado(int nFacce, boolean truccato) {
        this.nFacce = nFacce;
        this.truccato = truccato;
    }

    public int getnFacce() {
        return nFacce;
    }

    public void setnFacce(int nFacce) {
        this.nFacce = nFacce;
    }

    public boolean isTruccato() {
        return truccato;
    }

    public void setTruccato(boolean truccato) {
        this.truccato = truccato;
    }

    @Override
    public String toString() {
        return "Dado{" +
                "nFacce=" + nFacce +
                ", truccato=" + truccato +
                '}';
    }

    public int lancio() {
        if (truccato) return 3;
        return new Random().nextInt(nFacce) + 1;
    }
}