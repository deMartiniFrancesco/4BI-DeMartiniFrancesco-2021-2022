import javax.swing.JOptionPane;


class Input {
	public static String input(String imput) {
        String output = JOptionPane.showInputDialog("inserire " + imput + ": ");
        output = output.toLowerCase();
        return output;
    }
	public static void main(String[] args) {
			String strinInput = JOptionPane.showInputDialog("inserire carattere articoli: ");
			char charFinal = strinInput.charAt(0);
			
			System.out.println("variabile: " + charFinal);
			System.out.println(((Object)charFinal).getClass().getName());
		}
}