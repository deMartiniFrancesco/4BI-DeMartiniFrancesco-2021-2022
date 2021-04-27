package demartini_F_Mat01.bin;

import java.util.Random;

public class Mat01 {

  public static void sottoMatrSomma(int[][] matrice, int len) {
    len--;
    int sommaMin = 1000;
    int somma = 0;
    int colonna = 0;
    int riga = 0;

    for (int i = 0; i < len; i++) {
      for (int j = 0; j < len; j++) {
        somma += matrice[i][j];
        somma += matrice[i][j + 1];
        somma += matrice[i + 1][j];
        somma += matrice[i + 1][j + 1];
        if (somma < sommaMin) {
          sommaMin = somma;
          riga = i;
          colonna = j;
        }
        somma = 0;
      }
    }
    int[][] sottoMatr = new int[2][2];
    sottoMatr[0][0] = matrice[riga][colonna];
    sottoMatr[0][1] = matrice[riga][colonna + 1];
    sottoMatr[1][0] = matrice[riga + 1][colonna];
    sottoMatr[1][1] = matrice[riga + 1][colonna + 1];

    visualMat(sottoMatr, 2);
  }

  public static void sommaRiga(int[][] matrice, int len) {
    int sommaMax = 0;
    int somma = 0;
    int riga = 0;
    for (int i = 0; i < len; i++) {
      for (int j = 0; j < len; j++) {
        somma += matrice[i][j];
      }
      if (somma > sommaMax) {
        sommaMax = somma;
        riga = i;
      }
      somma = 0;
    }
    System.out.println("riga somma maggiore -> " + riga);
  }

  public static void visualMat(int[][] matrice, int len) {
    for (int i = 0; i < len; i++) {
      for (int j = 0; j < len; j++) {
        System.out.print(matrice[i][j] + "  ");
      }
      System.out.println();
    }
  }

  public static int[][] inizializzMatrice(int[][] matrice, int len) {
    Random numero = new Random();
    for (int i = 0; i < len; i++) {
      for (int j = 0; j < len; j++) {
        matrice[i][j] = numero.nextInt(99);
      }
    }
    return matrice;
  }

  public static void main(String[] args) {

    int len = 10;
    int[][] matrice = new int[len][len];
    matrice = inizializzMatrice(matrice, len);

    visualMat(matrice, len);
    System.out.println();

    sommaRiga(matrice, len);
    System.out.println();

    sottoMatrSomma(matrice, len);
  }
}
