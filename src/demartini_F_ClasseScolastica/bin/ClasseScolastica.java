import java.util.ArrayList;

public class ClasseScolastica {
    private String sezione;
    private ArrayList<Studente> registro = new ArrayList<>();
    private int numeroBanchi;

    public ClasseScolastica() {
        sezione = "";
        numeroBanchi = 0;
    }

    public ClasseScolastica(String sezione, int numeroBanchi, ArrayList<Studente> registro) {
        this.sezione = sezione;
        this.numeroBanchi = numeroBanchi;
        this.registro.addAll(registro);
    }

    public String getSezione() {
        return sezione;
    }

    public void setSezione(String sezione) {
        this.sezione = sezione;
    }

    public int getNumeroBanchi() {
        return numeroBanchi;
    }

    public void setNumeroBanchi(int numeroBanchi) {
        this.numeroBanchi = numeroBanchi;
    }

    public ArrayList<Studente> getRegistro() {
        return registro;
    }

    public void setRegistro(ArrayList<Studente> registro) {
        this.registro = registro;
    }


    public void aggiungiStudente(Studente studente) {
        this.registro.add(studente);
    }

    public void rimuoviStudente(Studente studente) {
        registro.remove(studente);
    }

}

class Test2 {
    public static void main(String[] args) {
        Studente studente1 = new Studente(18587, "Alessandro", "Cicchellero");
        Studente studente2 = new Studente(18606, "Francesco", "de'Martini di Valle Aperta");
        Studente studente0 = new Studente();

        ArrayList<Studente> registroProvvisorio = new ArrayList<>();
        registroProvvisorio.add(studente1);
        registroProvvisorio.add(studente2);
        registroProvvisorio.add(studente0);


        ClasseScolastica bi4 = new ClasseScolastica("4bi", 27, registroProvvisorio);
        System.out.println(bi4.getRegistro());

        Studente studente3 = new Studente(15328, "Genoveffo", "Gagliardi");
        bi4.aggiungiStudente(studente3);
        System.out.println(bi4.getRegistro());

        bi4.rimuoviStudente(studente0);
        System.out.println(bi4.getRegistro());
    }
}