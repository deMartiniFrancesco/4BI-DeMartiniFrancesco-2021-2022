package demartini_F_prova.bin;

import java.util.Scanner;

class Prova2 {

    public static char[][] createMatChar(int len) {

        return new char[len][len];
    }

    public static int[][] createMatInt(int len) {

        return new int[len][len];
    }

    public static void printMat(int[][] a) {

        for (int[] ints : a) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        System.out.println("\n");
    }

    public static void printMat(char[][] a) {

        for (char[] chars : a) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }
        System.out.println("\n");
    }

    public static int[][] randomMat(int[][] matr) {

        for (int riga = 0; riga < matr.length; riga++) {
            for (int colonna = 0; colonna < matr[riga].length; colonna++) {
                int x = (int) (Math.random() * 8);
                matr[riga][colonna] = x;
            }
        }
        return matr;
    }

    public static char[][] triangoloMat(char[][] matr) {

        for (int riga = 0; riga < matr.length; riga++) {
            for (int colonna = 0; colonna < matr[riga].length; colonna++) {
                if (colonna <= riga) {
                    matr[riga][colonna] = '*';
                }
            }
        }
        return matr;
    }

    public static char[][] triangoloRovesciatoMat(char[][] matr) {

        for (int riga = 0; riga < matr.length; riga++) {
            for (int colonna = 0; colonna < matr[riga].length; colonna++) {
                if (colonna < matr[riga].length - riga) {
                    matr[riga][colonna] = '*';
                }
            }
        }
        return matr;
    }

    public static char[][] colonnaMat(char[][] matr, int nColonne) {

        for (int riga = 0; riga < matr.length; riga++) {
            for (int colonna = 0; colonna < nColonne; colonna++) {
                matr[riga][colonna] = '#';
            }
        }
        return matr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Inserisci grandezza matrice: ");
        int len = sc.nextInt();

        System.out.print("Inserisci grandezza colonna: ");
        int nColonne = sc.nextInt();

        while (nColonne >= len) {
            System.out.print("Reinserisci grandezza colonna (minore di " + len + " ): ");
            nColonne = sc.nextInt();
        }

        int[][] matr = randomMat(createMatInt(len));
        char[][] matr2 = triangoloMat(createMatChar(len));
        char[][] matr3 = triangoloRovesciatoMat(createMatChar(len));
        char[][] matr4 = colonnaMat(createMatChar(len), nColonne);

        printMat(matr);
        printMat(matr2);
        printMat(matr3);
        printMat(matr4);

        sc.close();
    }
}
