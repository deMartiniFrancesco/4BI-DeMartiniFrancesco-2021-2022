package demartini_F_Poldo.bin;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ldecarli
 */
public class ListaClasse {
	private ArrayList<ProdOrdinato> lista;
	private String classe;
	
	public ListaClasse(ArrayList<ProdOrdinato> lista, String classe){
		this.lista = lista;
		this.classe = classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public void setLista(ArrayList<ProdOrdinato> lista) {
		this.lista = lista;
	}
	
	public String getClasse() {
		return classe;
	}

	public ArrayList<ProdOrdinato> getLista() {
		return lista;
	}

}
