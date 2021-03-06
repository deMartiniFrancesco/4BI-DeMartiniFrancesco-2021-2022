
import javax.swing.JOptionPane;

class PersoneAmmalate_02 {
    public static String input(String imput) {
        String output = JOptionPane.showInputDialog("inserire " + imput + ": ");
        output = output.toLowerCase();
        return output;
    }

    public static void main(String args[]) {
        System.out.println("Start");
        int infected = Integer.parseInt(input("numero infetti"));
        int healPerc = Integer.parseInt(input("numero percentuale guariti"));
        int days = 0;

        if (infected > 100) {
            while (infected > 100) {
                infected -= ((healPerc * infected) / 100);
                days++;
            }
        }
        
		System.out.println(days);

		System.out.println("End");
        
    }
}