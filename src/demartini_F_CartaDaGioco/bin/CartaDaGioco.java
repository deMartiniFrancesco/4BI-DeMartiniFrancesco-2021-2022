package demartini_F_CartaDaGioco.bin;

/**
 * CartaDaGioco
 *
 * @author Francesco de' Martini
 */
public class CartaDaGioco {

    private final String[] semi = {"cuori", "fiori", "quadri", "picche", "*"};
    private int seme;
    private int valore;
    private boolean coperta;

    /**
     * Costruttore No parametri
     */
    public CartaDaGioco() {
        this.seme = 0;
        this.valore = 0;
        this.coperta = false;
    }

    /**
     * Costruttore
     *
     * @param seme    int con il seme della carta
     * @param valore  Intero con il valore della carta
     * @param coperta Boolean definisce se la carta é scoperta
     */
    public CartaDaGioco(int seme, int valore, boolean coperta) {
        set(seme, valore, coperta);
    }

    /**
     * Assegna i valori a seme e valore
     *
     * @param seme   int con il seme della carta
     * @param valore Intero con il valore della carta
     */
    public void set(int seme, int valore, boolean coperta) {
        setSeme(seme);
        setValore(valore);
        setCoperta(coperta);
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
     * Assegna i valori a seme
     *
     * @param seme int con il seme della carta
     */
    public void setSeme(int seme) {
        this.seme = seme;
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
     * Assegna i valori a valore
     *
     * @param valore Intero con il valore della carta
     */
    public void setValore(int valore) {
        this.valore = valore;
    }

    public boolean isCoperta() {
        return coperta;
    }

    public void setCoperta(boolean coperta) {
        this.coperta = coperta;
    }

    /**
     * @return Ritorna una stringa con il valore del seme e del velore della carta
     */
    public String toString() {
        return (coperta) ? "|◘|" : semi[this.seme] + "->" + this.valore;
    }

    public int carcolaPunteggio() {
        int punteggio = 0;
        int valore = this.valore;

        if (this.seme == 4) {
            punteggio = 25;
        } else {
            punteggio = Math.min(valore, 10);
        }
        return punteggio;
    }

}