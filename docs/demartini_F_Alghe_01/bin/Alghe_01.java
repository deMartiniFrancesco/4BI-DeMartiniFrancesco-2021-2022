
import javax.swing.JOptionPane;

class Alghe_01 {
    
    public static String input(String imput) {
        String output = JOptionPane.showInputDialog("inserire " + imput + ": ");
        output = output.toLowerCase();
        return output;
    }
    public static void main(String[] args){
        
        System.out.println("Start");

        int population = Integer.parseInt(input("popolazione iniziale alghe")); 
        int popGoal = Integer.parseInt(input("popolazione da raggiungere")); 
        int days = 0;

        while (population < popGoal) {
            if (days % 2 == 0) {
                population *= 2;
            } else {
                population -= (population / 3);
            }
        days ++;
        }
        System.out.println(days);

        System.out.println("End");
    }
}