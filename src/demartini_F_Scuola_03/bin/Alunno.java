package demartini_F_Scuola_03.bin;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

class Alunno {

    private int nMatricola;
    private String cognome;
    private String nome;
    private String residenza;
    private String classe;
    private String nazione;
    private Date dataNascita;
    private String cap;

    public Alunno(int nMatricola, String cognome, String nome, String residenza, String classe, String nazione, String dataNascita, String cap) {
        this.nMatricola = nMatricola;
        this.cognome = cognome;
        this.nome = nome;
        this.residenza = residenza;
        this.classe = classe;
        this.nazione = nazione;
        try {
            this.dataNascita = new SimpleDateFormat("dd/MM/yyyy").parse(dataNascita);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.cap = cap;
    }

    public Alunno(List<String> dataList) {
        this.nMatricola = Integer.parseInt(dataList.get(0));
        this.cognome = dataList.get(1);
        this.nome = dataList.get(2);
        this.residenza = dataList.get(3);
        this.classe = dataList.get(4);
        this.nazione = dataList.get(5);
        try {
            this.dataNascita = new SimpleDateFormat("dd/MM/yyyy").parse(dataList.get(6));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.cap = dataList.get(0);
    }

    public int getnMatricola() {
        return nMatricola;
    }

    public String getCognome() {
        return cognome;
    }

    public String getNome() {
        return nome;
    }

    public String getResidenza() {
        return residenza;
    }

    public String getClasse() {
        return classe;
    }

    public String getNazione() {
        return nazione;
    }

    public Date getDataNascita() {
        return dataNascita;
    }

    public String getCap() {
        return cap;
    }
}