public abstract class VeicoloAMotore {
    public int marcia;
    public int serbatoio;
    public String modello;
    public int cilindrata;
    public boolean ststoMotore;
    public String targa;

    public abstract void avviaMotore();

    public abstract int rifornimento(int b);
}
