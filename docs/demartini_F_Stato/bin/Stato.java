package demartini_F_Stato.bin;

class Stato {
    private String nome;
    private double superfice;
    /**
     * Milioni di abitanti
     */
    private double popolazione;

    public Stato(String nome, double superfice, double popolazione) {
        this.nome = nome;
        this.superfice = superfice;
        this.popolazione = popolazione;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSuperfice() {
        return superfice;
    }

    public void setSuperfice(int superfice) {
        this.superfice = superfice;
    }

    public double getPopolazione() {
        return popolazione;
    }

    public void setPopolazione(int popolazione) {
        this.popolazione = popolazione;
    }

    public String toString() {
        return "Stato{" +
                "nome='" + nome + '\'' +
                ", superfice=" + superfice +
                ", popolazione=" + popolazione +
                '}';
    }

    public double densita() {
        return popolazione * 1000000 / superfice;
    }

    /**
     * Confronta la densita di this e stato
     * @param stato Stato da metere a confronto
     * @return true se this maggiore di stato
     */
    public boolean densitaMaggiore(Stato stato) {
        return stato.densita() < densita();
    }

    public double confronta(Stato stato) {
        return stato.densita() - densita();
    }

    /**
     * calcola se la densita é nel range dato (non compresi)
     */
    public boolean confronta(double start, double end) {
        double densita = densita();
        return densita < start && densita > end;
    }


}

class StatoTest {
    public static void main(String[] args) {

        System.out.println("Start");

        Stato italia = new Stato("Italia", 302073, 60.36);
        Stato francia = new Stato("Francia ", 675417, 68.30);

        System.out.printf("%s  densitá %f \n%s  densitá %f\n", italia, italia.densita(), francia, francia.densita());

        System.out.printf("Densitá maggiore = %f p/km2  %s\n",
                (italia.densitaMaggiore(francia)) ?
                        italia.densita() :
                        francia.densita(),

                (italia.densitaMaggiore(francia)) ?
                        italia.getNome() :
                        francia.getNome());

        System.out.printf("%s\n",
                (francia.confronta(0, 100)) ?
                        francia.getNome() + " é nel range" :
                        francia.getNome() + " non é nel range");

        System.out.println("End");

    }
}