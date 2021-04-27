import javax.swing.*;

class LavandinoOtturato_01 {

  public static String input(String imput) {
    String output = JOptionPane.showInputDialog("inserire " + imput + ": ");
    output = output.toLowerCase();
    return output;
  }

  public static void main(String[] args) throws InterruptedException {

    System.out.println("Start");

    int scaricoSecondoCl = Integer.parseInt(input("scarico al secondo in cl"));
    int caricoSecondoCl = Integer.parseInt(input("carico al secondo in cl"));
    int livelloAcqua = Integer.parseInt(input("livello dell acqua iniziale cl"));
    int capacitaLavandino = Integer.parseInt(input("capacita lavandino in cl"));
    int secondi = 0;

    while (secondi < 20 && livelloAcqua < capacitaLavandino) {
      System.out.println(livelloAcqua);
      livelloAcqua += caricoSecondoCl - scaricoSecondoCl;
      Thread.sleep(1000);
      secondi++;
    }
    if (livelloAcqua >= capacitaLavandino) {
      System.out.println("straripa");
    }
    System.out.println("End");
  }
}
