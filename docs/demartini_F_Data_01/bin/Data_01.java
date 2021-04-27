package demartini_F_Data_01.bin;

import javax.swing.*;

public class Data_01 {

  public static int[] validility(String data) {
    String[] strOutput = data.split("/");
    int[] output = new int[strOutput.length];
    int i = 0;
    for (String str : strOutput) {

      i++;
    }

    return output;
  }

  public static String input(String imput) {
    String output = JOptionPane.showInputDialog("inserire " + imput + ": ");
    output = output.toLowerCase();
    return output;
  }

  public static void main(String[] args) {
    String data = input("data");

    System.out.println(data.matches("(\\d\\d)/(\\d\\d)/(\\d\\d\\d\\d)"));
  }
}
