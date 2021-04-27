package demartini_F_m.c.m_01.bin;

import java.util.Scanner;

class Main {
  public static int mcd(int a, int b) {
    int resto;
    while (b != 0) {
      resto = a % b;
      a = b;
      b = resto;
    }
    return a;
  }

  public static void main(String[] args) {

    System.out.println("Start");
    Scanner scanner = new Scanner(System.in);
    int a, b, mcm, mcd;

    do {
      System.out.print("inserire numero a: ");
      a = scanner.nextInt();
    } while (a < 1);

    do {
      System.out.print("inserire numero b: ");
      b = scanner.nextInt();
    } while (b < 1);

    mcd = mcd(a, b);
    mcm = (a * b) / mcd;

    System.out.println("il massimo comune divisore é " + mcd);
    System.out.println("il minimo comune multiplo é " + mcm);
    scanner.close();

    System.out.println("End");
  }
}
