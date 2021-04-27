package demartini_F_Vettori.bin;

public class Vettori {

  // cerca il massimo
  public static int[] maxi(final int[] vett) {
    final int[] vRis = new int[2];
    int max = 0, index = 0;
    for (int i = 0; i < vett.length; i++) {
      if (vett[i] > max) {
        max = vett[i];
        index = i;
      }
    }
    vRis[0] = max;
    vRis[1] = index;
    return vRis;
  }

  // cerca il minimo
  public static int[] mini(final int[] vett) {
    final int[] vRis = new int[2];
    int min = vett[0];
    int index = 0;
    for (int i = 0; i < vett.length; i++) {
      if (vett[i] < min) {
        min = vett[i];
        index = i;
      }
    }
    vRis[0] = min;
    vRis[1] = index;
    return vRis;
  }

  // calcola e visualizza la somma
  public static int somma(final int[] vett) {
    int somma = 0;
    for (int i = 0; i < vett.length; i++) {
      somma += vett[i];
    }
    return somma;
  }

  // calcola e visualizza somma dei numeri pari
  public static int sommaPari(final int[] vett) {
    int somma = 0;
    for (int i = 0; i < vett.length; i++) {
      if (vett[i] % 2 == 0) {
        somma += vett[i];
      }
    }
    return somma;
  }

  // conta il numero di pari e di dispari e visualizza
  public static int[] contPariDispari(final int[] vett) {
    final int[] vRis = new int[2];
    int pari = 0;
    int dispari = 0;
    for (int i = 0; i < vett.length; i++) {
      if (vett[i] % 2 == 0) {
        pari++;
      } else {
        dispari++;
      }
    }
    vRis[0] = pari;
    vRis[1] = dispari;
    return vRis;
  }

  // ordina v
  public static int[] ordina(final int[] vett) {
    final int[] vRis = new int[vett.length];
    int max;
    int index;
    for (int i = 0; i < vRis.length; i++) {
      max = maxi(vett)[0];
      index = maxi(vett)[1];
      vett[index] = -1;
      vRis[i] = max;
    }
    return vRis;
  }

  public static void main(final String[] args) {
    final int N = 20;
    final int[] v = new int[N];

    // inizializza
    for (int i = 0; i < v.length; i++) {
      v[i] = (int) (Math.random() * 100);
    }
    // visualizza
    for (int i = 0; i < v.length; i++) {
      System.out.print(v[i] + " ");
    }
    System.out.println();
    System.out.println("Il numero maggiore del vettore e': " + maxi(v)[0]);
    System.out.println("Il numero minore del vettore e': " + mini(v)[0]);
    System.out.println("La somma dei numeri del vettore e': " + somma(v));
    System.out.println("La somma dei numeri pari del vettore e': " + sommaPari(v));
    System.out.println(
        "Il numero di pari e': "
            + contPariDispari(v)[0]
            + "\tIl numero di dispari e': "
            + contPariDispari(v)[1]);
    System.out.print("Il vettore riordinato e': ");
    final int[] vRis = ordina(v);
    for (int i = 0; i < vRis.length; i++) {
      System.out.print(vRis[i] + " ");
    }
  }
}
