package demartini_F_SerieNumerica_02.bin;

import javax.swing.*;
import java.util.ArrayList;

class SerieNumerica_02 {

    public static String input(String imput) {
        String output = JOptionPane.showInputDialog("inserire " + imput + ": ");
        output = output.toLowerCase();
        return output;
    }

    public static void main(String[] args) {

        System.out.println("Start");

        ArrayList<Integer> numbers = new ArrayList<>();
        int numberInput = Integer.parseInt(input("numero serie"));
        numbers.add(numberInput);

        numberInput = Integer.parseInt(input("numero serie"));
        numbers.add(numberInput);
        boolean serie = numberInput + numbers.get(0) != 10;

        while (serie) {
            numberInput = Integer.parseInt(input("numero serie"));
            numbers.add(numberInput);
            if (numberInput == numbers.get(numbers.size() - 3) || numberInput + numbers.get(numbers.size() - 2) == 10) {
                serie = false;
            }

        }

        System.out.println("serie finita");

        System.out.println("End");
    }
}