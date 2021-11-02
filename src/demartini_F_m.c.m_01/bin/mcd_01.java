import java.util.Scanner;

class mcd_01 {
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

        System.out.println("il minimo comune denominatore é " + mcm);

        scanner.nextLine();

        scanner.close();

        System.out.println("End");
    }
}
