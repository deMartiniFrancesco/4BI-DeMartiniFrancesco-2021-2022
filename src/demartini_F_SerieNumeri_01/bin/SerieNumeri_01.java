package demartini_F_SerieNumeri_01.bin;

import javax.swing.*;
import java.util.ArrayList;

class SerieNumeri_01 {

    public static String input(String imput) {
        String output = JOptionPane.showInputDialog("inserire " + imput + ": ");
        output = output.toLowerCase();
        return output;
    }

    public static void main(String[] args) {

        System.out.println("Start");

        ArrayList<Integer> numbers = new ArrayList<>();
        int numberInput = Integer.parseInt(input("numero serie"));
        boolean serie = true;
        while (serie) {
            numbers.add(numberInput);
            numberInput = Integer.parseInt(input("numero serie"));
            for (int number : numbers) {
                if (numberInput < number) {
                    serie = false;
                    break;
                }
            }
        }

        System.out.println(numbers.size());

        System.out.println("End");
    }
}