
import javax.swing.JOptionPane;

class PaninoPastina_01 {

    public static String input(String imput) {
        String output = JOptionPane.showInputDialog("inserire " + imput + ": ");
        output = output.toLowerCase();
        return output;
    }

    public static void main(String args[]) {

        System.out.println("Start");

        double money = Integer.parseInt(input("numero soldi"));
        double pastina = 1;
        double panino = 1.5;
        int days = 0;
        while (money > 1) {
            switch (input("cosa vuoi mangiare\npastina o panino")) {
                case "pastina":
                    if (money > pastina) {
                        money -= pastina;
                    } else {
                        System.out.println("No money");
                    }
                    days++;
                    System.out.println(money);
                    break;

                case "panino":
                    if (money > panino) {
                        money -= panino;
                    } else {
                        System.out.println("No money");
                    }
                    days++;
                    System.out.println(money);

                    break;

                default:
                    System.out.println("Non é aquistabile");
                    break;
            }
        }

        System.out.println(days);

        System.out.println("End");
    }
}