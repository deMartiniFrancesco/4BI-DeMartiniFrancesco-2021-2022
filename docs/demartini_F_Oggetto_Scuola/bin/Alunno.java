import java.util.*;

public class Alunno extends Persona {
    private String classe;

    public Alunno(String cognome, String nome, Date d_nasc, String classe) {
        super(cognome, nome, d_nasc);
        this.classe = classe;
    }

    public Alunno(String cognome, String nome, String d_nasc, String classe) {
        super(cognome, nome, d_nasc);
        this.classe = classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getClasse() {
        return classe;
    }

    @Override
    public String toString() {
        return super.toString() + "," + classe;
    }

    public static void main(String[] args) {
        System.out.println("Start");
        
        Alunno a1 = new Alunno("dema", "Fra", "21/10/2003", "4bi");
        System.out.println(a1.toString());

        System.out.println("End");
        
    }

}