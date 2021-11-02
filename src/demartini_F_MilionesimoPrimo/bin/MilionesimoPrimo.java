class MilionesimoPrimo {

    public static boolean isPrimo(final int n) {
        if (n < 3)
            return true;
        int rad;
        rad = (int) Math.sqrt(n);
        for (int div = 2; div <= rad; div++)
            if (n % div == 0)
                return false;
        return true;
    }

    public static void main(final String[] args) {
        int i, cp;
        // tutti sono primi

        i = 0;
        cp = 0;
        while (cp < 1000000) {
            i++;
            if (isPrimo(i))
                cp++;
        }
        System.out.println("nei primi " + i + " ci sono " + cp + " numeri primi");
    }

}
