import java.util.*;



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