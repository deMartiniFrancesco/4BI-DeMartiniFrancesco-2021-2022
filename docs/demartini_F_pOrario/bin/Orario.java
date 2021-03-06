
public class Orario {
    int or;
    int mi;

    public Orario() {
        reset();
    }

    public Orario(int ora, int min) {
        or = ora;
        mi = min;
        controllo();
    }

    public void setOra(int ora) {
        or = ora;
        controllo();
    }

    public void setMin(int min) {
        mi = min;
        controllo();
    }

    public void avanza() {
        mi++;
        controllo();
    }

    public void addMin(int nMin) {
        mi += nMin;
        controllo();
    }

    public void controllo() {
        if (mi >= 60) {
            int nOre = (int) (mi / 60);
            or += nOre;
            mi -= nOre * 60;
        }
        while (or >= 24) {

            or -= 24;
        }
    }

    // Azzera l'oggetto

    public void reset() {
        or = 0;
        mi = 0;
    }

    @Override
    public String toString() {
        String res;
        // %02 due cifre zero padded [00:00]
        res = String.format("[%02d:%02d]", or, mi);
        return res;
    }
}
