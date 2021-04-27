package demartini_F_Poldo.bin;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

/**
 * @author ldecarli
 */
public class Listino {
	private ArrayList<Prodotto> menu;

	public Listino() {
        menu = new ArrayList<>();
	}


	public void addProdotto(Prodotto prodotto) {
        for (Prodotto prodottoMenu : menu) {
            if(prodottoMenu.equals(prodotto.toString())){
                return;
            }
        }
		menu.add(prodotto);
	}

	public void setMenu(ArrayList<Prodotto> menu) {
		this.menu = menu;
	}

	public ArrayList<Prodotto> getMenu() {
        ArrayList<Prodotto> returnArray = menu;
		return returnArray;
	}

	public String toString() {
        StringBuilder returnStringBuilder = new StringBuilder();
        for (Prodotto prodotto : menu) {
            returnStringBuilder.append(prodotto.getClass().getName() + prodotto.toString() + "\n\n");
        }
		return returnStringBuilder.toString();
	}
}

class ListaProva {
	public static void main(String[] args) {
        Listino listino = new Listino();

        listino.addProdotto(new Panino());
        listino.addProdotto(new Piatto());
        listino.addProdotto(new Bevanda());
        listino.addProdotto(new Panino());

        System.out.println(listino);
	}
}