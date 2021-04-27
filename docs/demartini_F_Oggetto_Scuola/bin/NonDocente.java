import java.util.Date;

public class NonDocente extends Persona {
  private String contratto;
  private String incarico;

  public NonDocente(String cognome, String nome, String string, String contratto, String incarico) {
    super(cognome, nome, string);
    this.contratto = contratto;
    this.incarico = incarico;
  }

  public NonDocente(String cognome, String nome, Date d_nasc) {
    super(cognome, nome, d_nasc);
    this.contratto = "";
    this.incarico = "";
  }

  public static void main(String[] args) {
    System.out.println("Start");

    NonDocente nd1 = new NonDocente("IO", "bho", "31/02/2851", "forse", "si");
    System.out.println(nd1.toString());

    System.out.println("End");
  }

  public void set(String cognome, Date data_nasc, String nome, String contratto, String incarico) {
    super.set(cognome, data_nasc, nome);
    this.contratto = contratto;
    this.incarico = incarico;
  }

  public void setincarico(String incarico) {
    this.incarico = incarico;
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

  public String getincarico() {
    return incarico;
  }

  @Override
  public String toString() {
    return super.toString() + "," + contratto + "," + incarico;
  }
}
