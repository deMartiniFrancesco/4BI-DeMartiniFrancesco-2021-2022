package demartini_F_Poldo.bin;

import java.util.Scanner;

class Poldo {
  public static void main(String args[]) {
    System.out.println("Start");

    System.out.println(
        "        ### BAR POLDO ####\n"
            + "    ---- inserire un comando---\n"
            + "---- lista comandi: 'comandi' ---"
    );

    Listino listino = new Listino();
    Scanner scanner = new Scanner(System.in);
    String input = " ";

    while (!input.equals("")) {
      input = scanner.nextLine();
      switch (input) {
        case "comandi":
          System.out.println(
              "Lista comandi:\n"
                  + "menu ---> Per vedere tutti i prodotti disponibili\n"
                  + "lista --> Mostra la lista dei prodotti aggiunti al carrello\n"
                  + "info ---> Per accedere alle info di un prodotto (inserire solo il comando info)");

        case "menu":
          {
            // for(String prodotto : listino.toString()){
            // 	System.out.println(prodotto);
            // };
          }
        case "add bevanda":
          listino.addProdotto(new Bevanda());
          break;
        case "add panino":
          listino.addProdotto(new Panino());
          break;
        case "add piatto":
          listino.addProdotto(new Piatto());
          break;

        case "":
          break;
        default:
          System.out.println(
              "Comando errato\n" + "Digita 'comandi' per avere la lista dei comandi disponibili\n");
          break;
      }
    }
    scanner.close();
    System.out.println(listino);

    System.out.println("End");
  }
}
