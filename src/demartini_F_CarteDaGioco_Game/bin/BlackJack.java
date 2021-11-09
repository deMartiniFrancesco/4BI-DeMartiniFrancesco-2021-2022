package demartini_F_CarteDaGioco_Game.bin;

import javax.swing.*;

public class BlackJack {


    public static int numberInput(String inputDioalog) {
        int returnedNumber = -1;

        while (returnedNumber <= 0) {

            try {
                returnedNumber = Integer.parseInt(input(inputDioalog));
                if (returnedNumber <= 0) System.out.println("Inserire numero maggiore di 0");
            } catch (Exception e) { // or your specific exception
                System.out.println("inserire numero valido");
            }

        }
        return returnedNumber;
    }

    public static String input(String inputDioalog) {
        String output = JOptionPane.showInputDialog(inputDioalog);
        output = output.toLowerCase();
        return output;
    }

    public static void main(String[] args) {


        System.out.println("Start");


        Dealer dealer = new Dealer();

        Player player = new Player(100);


        player.setPuntata(numberInput("inserire punata"));

        System.out.println(player);

        System.out.println("End");

    }
}
