import java.util.Scanner;

class Poldo {
    public static void main(String[] args) {
        System.out.println("Start");

        System.out.println("        ### BAR POLDO ####\n" +
                "    ---- inserire un comando---\n" +
                "---- lista comandi: 'comandi' ---");

        Listino listino = new Listino();
        Scanner scanner = new Scanner(System.in);
        String input = " ";

        while (!input.equals("")) {
            input = scanner.nextLine();
            switch (input) {
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
                case "bevanda":
                    listino.addProdotto(new Bevanda());
                    break;
                case "panino":
                    listino.addProdotto(new Panino());
                    break;
                case "piatto":
                    listino.addProdotto(new Piatto());
                    break;

                default:
                    System.out.println("Comando errato\n" +
                            "Digita 'comandi' per avere la lista dei comandi disponibili");
                    break;

            }
        }
        System.out.println(listino);

        System.out.println("End");

    }
}