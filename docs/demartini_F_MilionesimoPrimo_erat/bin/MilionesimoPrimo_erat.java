class MilionesimoPrimo_erat {

    public static void main(String[] args) {
        int N = 20000000; // 20 000 000   15485857;
        boolean insP[] = new boolean[N+1];
        int i;
        // tutti sono primi
        for (i = 1; i <= N; i++) {
            insP[i] = true;
        }

        int p = 2;
        while (p <= N / 2) {
            // se p è primo
            if (insP[p]) {
                // cancella tutti i multipli di P 
                int j = p + p;
                while (j <= N) {
                    insP[j] = false;
                    j += p;
                }
            }
            p++;
        }

        // tutto quello rimasto a True è primo
        // ogni 10 primi NL

        int cp=0;
        int ultimok=0;
        for (int k = 1; k <= N; k++) {
            if (insP[k]) {
                ultimok=k;
                cp++;
                if (cp==1000000)
                    System.out.println(k);

            }
        }
        System.out.println("nei primi "+N+" ci sono "+ cp+ " numeri primi");
    }
}
