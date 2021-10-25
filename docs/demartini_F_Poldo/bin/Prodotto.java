
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ldecarli
 */
public class Prodotto {
	private double prezzo;
	private String descr;
	private boolean asporto;
	private boolean disponibile;

	public Prodotto() {
		this.prezzo = 0.0;
		this.descr = "";
		this.asporto = false;
		this.disponibile = false;
	}

	public Prodotto(double prezzo, String descr, boolean asporto, boolean disponibile) {
		this.prezzo = prezzo;
		this.descr = descr;
		this.asporto = asporto;
		this.disponibile = disponibile;
	}

	public void setAsporto(boolean asporto) {
		this.asporto = asporto;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public void setDisponibile(boolean disponibile) {
		this.disponibile = disponibile;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public String getDescr() {
		return descr;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public boolean  getDisponibile() {
		return disponibile;
	}

	public String toString() {
		return "\nPrezzo -> "+ prezzo + "\nDescrizione -> " + descr + "\nAsportato -> " + asporto + "\nDisponibile -> " + disponibile;
	}
}
