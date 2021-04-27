package demartini_F_Oggetto_Scuola.bin;

import java.util.Date;

public class Docente extends Persona {
  private String contratto;
  private String cls_concorso;

  public Docente(
      String cognome, String nome, String string, String contratto, String cls_concorso) {
    super(cognome, nome, string);
    this.contratto = contratto;
    this.cls_concorso = cls_concorso;
  }

  public Docente(String cognome, String nome, Date d_nasc) {
    super(cognome, nome, d_nasc);
    this.contratto = "";
    this.cls_concorso = "";
  }

  public static void main(String[] args) {
    System.out.println("Start");

    Docente d1 = new Docente("Sette", "Antonio", "21/10/2003", "bello", "il migliore");
    System.out.println(d1.toString());

    System.out.println("End");
  }

  public void set(
      String cognome, Date data_nasc, String nome, String contratto, String cls_concorso) {
    super.set(cognome, data_nasc, nome);
    this.contratto = contratto;
    this.cls_concorso = cls_concorso;
  }

  @Override
  public String getCognome() {
    return super.getCognome();
  }

  @Override
  public void setCognome(String cognome) {
    super.setCognome(cognome);
  }

  @Override
  public Date getData_nasc() {
    return super.getData_nasc();
  }

  @Override
  public void setData_nasc(Date data_nasc) {
    super.setData_nasc(data_nasc);
  }

  @Override
  public String getNome() {
    return super.getNome();
  }

  @Override
  public void setNome(String nome) {
    super.setNome(nome);
  }

  public String getContratto() {
    return contratto;
  }

  public void setContratto(String contratto) {
    this.contratto = contratto;
  }

  public String getCls_concorso() {
    return cls_concorso;
  }

  public void setCls_concorso(String cls_concorso) {
    this.cls_concorso = cls_concorso;
  }

  @Override
  public String toString() {
    return super.toString() + "," + contratto + "," + cls_concorso;
  }
}
