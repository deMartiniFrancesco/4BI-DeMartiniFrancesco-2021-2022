package demartini_F_Poldo.bin;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ldecarli
 */
public class ProdOrdinato {
	private Prodotto prodotto;
	private int quantita;
	private int quantitaServita;

	public ProdOrdinato(Prodotto prodotto, int quantita, int quantitaServita) {
		this.prodotto = prodotto;
		this.quantita = quantita;
		this.quantitaServita = quantitaServita;
	}


	public Prodotto getProdotto() {
		return prodotto;
	}
	public int getQuantita() {
		return quantita;
	}
	public int getQuantitaServita() {
		return quantitaServita;
	}
	

	public String toString() {
		return String.format(
			"Prodotto -> %s\nQuantita -> %d\nQuantita servita -> %d", 
			prodotto.toString(), 
			quantita, 
			quantitaServita
		);
	}

}
