package demartini_F_Poldo.bin;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author ldecarli
 */
public class Panino extends Prodotto {
    private String igredienti;
    private Boolean caldo;

    public Panino() {
        super(9.70, "Panino mare e terra", false, true);
        this.igredienti = "Vitello tonnato, Maionese, Rucola, Salmone affumicato, Pane di segale, Semi di sesamo";
        this.caldo = false;
    }

    public Panino(double prezzo, String descr, boolean asporto, boolean disponibile, String igredienti, boolean caldo) {
        super(prezzo, descr, asporto, disponibile);
        this.igredienti = igredienti;
        this.caldo = caldo;
    }

    public void setCaldo(Boolean caldo) {
        this.caldo = caldo;
    }

    public void setIgredienti(String igredienti) {
        this.igredienti = igredienti;
    }

    public String toString() {
        return super.toString() + '\n' + "Igredienti -> '" + igredienti + '\n' + "Caldo -> " + caldo;
    }
    
    @Override
    public boolean equals(Object obj) {
        return toString().equals(obj.toString());
    }
}

/**
 * ProvaPanino
 */
class ProvaPanino {
    public static void main(String[] args) {
        Panino panino = new Panino();
        System.out.println(panino);
    }
}
