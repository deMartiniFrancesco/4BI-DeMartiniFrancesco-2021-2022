package demartini_F_PersoneAmmalate_01.bin;

import javax.swing.*;

class PersoneAmmalate_01 {

    public static String input(String imput) {
        String output = JOptionPane.showInputDialog("inserire " + imput + ": ");
        output = output.toLowerCase();
        return output;
    }

    public static void main(String[] args) {
        System.out.println("Start");
        int propVirus = Integer.parseInt(input("il tasso di propagazione del virus"));
        int population = Integer.parseInt(input("numero persone popolazione"));
        int personInfect = 1;
        int days = 0;
        while (personInfect < (population / 2)) {
            personInfect *= propVirus;
            days++;
        }

        System.out.println(days);


        System.out.println("End");

    }
}