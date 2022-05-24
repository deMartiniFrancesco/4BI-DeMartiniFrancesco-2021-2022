package demartini_F_prova.bin;

import java.util.Scanner;

// Class Declaration

public class Box {
    // Instance Variables

    public static int counter = 0;
    final int index;
    int valure = 0;

    // Constructor Declaration of Class
    public Box(int counter) {
        this.index = counter;
        Box.counter++;

    }

    public static Box[][] inizializzMatrice(Box[][] matrice, int len) {

        for (int riga = 0; riga < len; riga++) {
            for (int colonna = 0; colonna < len; colonna++) {
                matrice[riga][colonna] = new Box(Box.counter);

            }
        }
        return matrice;
    }

    public static void indexValure(Box[][] matrice, int len) {
        int index = 0;
        for (int riga = 0; riga < len; riga++) {
            for (int colonna = 0; colonna < len; colonna++) {
                matrice[riga][colonna].setValure(index);
                index++;
            }
        }
    }

    public static void visualMat(Box[][] matrice, int len) {
        for (int riga = 0; riga < len; riga++) {
            for (int colonna = 0; colonna < len; colonna++) {

                System.out.print(matrice[riga][colonna].getCounter());
                System.out.print("  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner pauseScanner = new Scanner(System.in);
        int len = 10;
        Box[][] matrice = inizializzMatrice(new Box[len][len], len);

        indexValure(matrice, len);

        visualMat(matrice, len);

        pauseScanner.nextLine();

        pauseScanner.close();

    }

    public int getValure() {
        return (this.valure);

    }

    public void setValure(int valure) {
        this.valure = valure;
    }

    public int getCounter() {
        return (this.index);

    }
}
