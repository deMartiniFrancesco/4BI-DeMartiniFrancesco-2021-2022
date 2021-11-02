package demartini_F_Poldo.bin;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Arrays;

/**
 * @author ldecarli
 */
public class Listino {
    private Prodotto[] lista;
    private String[] menu;
    private int index;

    public Listino() {
        this.lista = new Prodotto[10];
        this.menu = new String[3];
        index = 0;
    }

    public void initMenu() {
        Bevanda bevanda = new Bevanda();
        Panino panino = new Panino();
        Piatto piatto = new Piatto();

        if (bevanda.getDisponibile()) {
            menu[0] = bevanda.getDescr();
        }
        if (panino.getDisponibile()) {
            menu[1] = panino.getDescr();
        }
        if (piatto.getDisponibile()) {
            menu[2] = piatto.getDescr();
        }
    }

    public void addProdotto(Prodotto prodotto) {
        if (!isFull()) {
            lista[index] = prodotto;
            index++;
        } else {
            Prodotto[] newLista = new Prodotto[lista.length + 10];
            System.arraycopy(lista, 0, newLista, 0, lista.length);
            setLista(newLista);
        }
    }

    public void setLista(Prodotto[] lista) {
        this.lista = lista;
    }

    public String[] getMenu() {
        return menu;
    }

    public void setMenu(String[] menu) {
        this.menu = menu;
    }

    public String toString() {
        return "lista=" + Arrays.toString(lista);
    }

    public boolean isFull() {
        return index == lista.length;
    }
}

class ListaProva {
    public static void main(String[] args) {
        Listino listino = new Listino();
        System.out.println(listino);
    }
}