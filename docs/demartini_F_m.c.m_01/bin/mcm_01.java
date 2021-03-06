import javax.swing.JOptionPane;

class mcm_01 {
    public static int mcd(int a, int b) {

        int r;
        while (b != 0)
        {
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static String input(String imput) {
        String output = JOptionPane.showInputDialog("inserire " + imput + ": ");
        output = output.toLowerCase();
        return output;
    }

    public static void main(String args[]) {

        System.out.println("Start");

    int a = Integer.parseInt(input("numero serie")),
        b = Integer.parseInt(input("numero serie")),
        mcm,
        mcd;

        mcd = mcd(a, b);
        mcm = (a*b)/mcd;

        System.out.println("il minimo comune denominatore é " + mcm);

        System.out.println("End");

    }
}