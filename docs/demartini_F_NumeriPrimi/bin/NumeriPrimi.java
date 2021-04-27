package demartini_F_NumeriPrimi.bin;

class NumeriPrimi {
  public static void main(String[] args) {
    int N = 10000;
    boolean[] insP = new boolean[N];

    int i;
    // tutti sono primi
    for (i = 1; i < N; i++) {
      insP[i] = true;
    }

    int p = 2;
    while (p <= N / 2) {
      // se p è primo
      if (insP[p]) {
        // cancella tutti i multipli di P
        int j = p + p;
        while (j < N) {
          insP[j] = false;
          j += p;
        }
      }
      p++;
    }

    // tutto quello rimasto a True è primo
    // ogni 10 primi NL
    int cp = 0;
    for (int k = 1; k < N; k++) {
      if (insP[k]) {
        System.out.print(k + "\t");
        cp++;
        if (cp % 10 == 0) System.out.println();
      }
    }
  }
}
