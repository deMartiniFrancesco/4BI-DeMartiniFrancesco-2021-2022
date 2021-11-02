package demartini_F_ClasseScolastica.bin;

public class Studente {
    private static int id;
    private int numeroMatricola;
    private String nome;
    private String cognome;

    public Studente() {
        numeroMatricola = ++id;
        nome = "";
        cognome = "";
    }

    public Studente(int numeroMatricola, String nome, String cognome) {
        this.numeroMatricola = numeroMatricola;
        this.nome = nome;
        this.cognome = cognome;
    }

    public int getNumeroMatricola() {
        return numeroMatricola;
    }

    public void setNumeroMatricola(int numeroMatricola) {
        this.numeroMatricola = numeroMatricola;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }


    @Override
    public String toString() {
        return "\nStudente{" +
                "numeroMatricola=" + numeroMatricola +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                '}';
    }
}

class Test {
    public static void main(String[] args) {

        Studente studente1 = new Studente();
        Studente studente2 = new Studente();
        Studente studente3 = new Studente();
        Studente studente4 = new Studente();
        System.out.println(studente1.getNumeroMatricola());
        System.out.println(studente2.getNumeroMatricola());
        System.out.println(studente3.getNumeroMatricola());
        System.out.println(studente4.getNumeroMatricola());

    }
}