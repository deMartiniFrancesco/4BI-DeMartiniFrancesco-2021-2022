package demartini_F_QuanteCifre_01.bin;

import javax.swing.*;

class QuanteCifre_01 {

  public static String input(String imput) {
    String output = JOptionPane.showInputDialog("inserire " + imput + ": ");
    output = output.toLowerCase();
    return output;
  }

  public static void main(String[] args) {

    System.out.println("Start");

    String cifra = input("cifra");

    System.out.println("la cifra é lunga -> " + cifra.length());

    System.out.println("End");
  }
}
