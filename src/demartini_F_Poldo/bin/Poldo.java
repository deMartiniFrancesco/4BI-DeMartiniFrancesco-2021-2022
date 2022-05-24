package demartini_F_Poldo.bin;

import java.util.Scanner;

class Poldo {
    public static void main(String[] args) {
        System.out.println("Start");

        System.out.println("""
                        ### BAR POLDO ####
                    ---- inserire un comando---
                ---- lista comandi: 'comandi' ---""");

        Listino listino = new Listino();
        Scanner scanner = new Scanner(System.in);
        String input = " ";

        while (!input.equals("")) {
            input = scanner.nextLine();
            switch (input) {
// TODO
//                case "comandi" -> System.out.println("""
//                        Lista comandi:
//                        menu ---> Per vedere tutti i prodotti disponibili
//                        info ---> Per accedere alle info di un prodotto (inserire solo il comando info)""");
//                case "info" -> {
//                    input = scanner.nextLine();
//                    while (!input.equals("esc")) {
//
//                    }
//                }
                case "bevanda" -> listino.addProdotto(new Bevanda());
                case "panino" -> listino.addProdotto(new Panino());
                case "piatto" -> listino.addProdotto(new Piatto());
                default -> System.out.println("Comando errato\n" +
                        "Digita 'comandi' per avere la lista dei comandi disponibili");
            }
        }
        System.out.println(listino);

        System.out.println("End");

    }
}