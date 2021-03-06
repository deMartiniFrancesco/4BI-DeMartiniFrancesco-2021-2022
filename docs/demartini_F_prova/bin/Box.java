import java.util.Scanner;

// Class Declaration

public class Box {
	// Instance Variables

	int valure = 0;
	int index;
	public static int counter = 0;

	// Constructor Declaration of Class
	public Box(int counter) {
		this.index = counter;
		Box.counter++;

	}

	public void setValure(int valure) {
		this.valure = valure;
	}

	public int getValure() {
		return (this.valure);

	}

	public int getCounter() {
		return (this.index);

	}

	public static Box[][] inizializzMatrice(Box[][] matrice, int len) {

		for (int riga = 0; riga < len; riga++) {
			for (int colonna = 0; colonna < len; colonna++) {
				matrice[riga][colonna] = new Box(Box.counter);

			}
		}
		return matrice;
	}

	public static Box[][] indexValure(Box[][] matrice, int len) {
		int index = 0;
		for (int riga = 0; riga < len; riga++) {
			for (int colonna = 0; colonna < len; colonna++) {
				matrice[riga][colonna].setValure(index);
				index++;
			}
		}
		return matrice;
	}

	public static void visualMat(Box[][] matrice, int len) {
		for (int riga = 0; riga < len; riga++) {
			for (int colonna = 0; colonna < len; colonna++) {

				System.out.print(matrice[riga][colonna].getCounter());
				System.out.print("  ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner pauseScanner = new Scanner(System.in);
		int len = 10;
		Box matrice[][] = inizializzMatrice(new Box[len][len], len);

		matrice = indexValure(matrice, len);

		visualMat(matrice, len);

		pauseScanner.nextLine();

		pauseScanner.close();

	}
}
