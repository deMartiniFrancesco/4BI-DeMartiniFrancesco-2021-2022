/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ldecarli
 */
public class Bevanda extends Prodotto{
    private int cl; 
    private boolean caldo;
    
    public Bevanda() {
		super(3.0, "Spremuta", false, true);
		this.cl = 555;
		this.caldo = false;
	}

	public Bevanda(double prezzo, String descr, boolean asporto, boolean disponibile, int cl, boolean caldo) {
		super(prezzo, descr, asporto, disponibile);
		this.cl = cl;
		this.caldo = caldo;
	}

	public void setCaldo(Boolean caldo) {
        this.caldo = caldo;
    }
	public void setcl(int cl) {
        this.cl = cl;
    }

	@Override
	public String toString() {
		return	"cl=" + cl +
				", caldo=" + caldo +
				super.toString();
	}
}

/**
 * ProvaBevan
 */
class ProvaBevanda {
	public static void main(String[] args) {
		Bevanda Bevanda = new Bevanda();
		System.out.println(Bevanda.toString());
	}
}
