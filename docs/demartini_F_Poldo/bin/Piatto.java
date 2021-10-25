/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ldecarli
 */
public class Piatto extends Prodotto {
	private boolean veg;
	private boolean cong;

	public Piatto() {
		super(11.0, "Piatto di carbonara", false, true);
		this.veg = false;
		this.cong = false;
	}

	public Piatto(double prezzo, String descr, boolean asporto, boolean disponibile, boolean veg, boolean cong) {
		super(prezzo, descr, asporto, disponibile);
		this.veg = veg;
		this.cong = cong;
	}

	public void setCong(boolean cong) {
		this.cong = cong;
	}
	public void setVeg(boolean veg) {
		this.veg = veg;
	}

	public String toString() {
		return super.toString() + "\nVegeteriano -> " + veg + "\nCongelato -> " + cong;
	}
}

/**
 * ProvaPiatto
 */
class ProvaPiatto {
	public static void main(String[] args) {
		Piatto piatto = new Piatto();
		System.out.println(piatto.toString());

	}
	
}


