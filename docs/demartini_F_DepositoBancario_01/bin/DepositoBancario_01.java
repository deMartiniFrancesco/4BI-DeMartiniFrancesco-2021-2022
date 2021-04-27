package demartini_F_DepositoBancario_01.bin;

import javax.swing.*;

class DepositoBancario_01 {
  public static String input(String imput) {
    String output = JOptionPane.showInputDialog("inserire " + imput + ": ");
    output = output.toLowerCase();
    return output;
  }

  public static void main(String[] args) {

    System.out.println("Start");

    int saldo = Integer.parseInt(input("saldo iniziale"));
    int interessiPerc = Integer.parseInt(input("percentuale interessi"));
    int soglia = Integer.parseInt(input("percentuale interessi"));
    int year = 0;

    while (saldo < soglia) {
      saldo += (saldo * interessiPerc) / 100;

      year++;
    }
    System.out.println(year);

    System.out.println("End");
  }
}
