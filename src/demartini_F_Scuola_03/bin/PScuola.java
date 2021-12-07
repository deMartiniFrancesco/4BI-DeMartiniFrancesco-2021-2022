
package demartini_F_Scuola_03.bin;

public class PScuola {

    public static void main(String[] args) {

        Scuola scuola = new Scuola();
        int record = scuola.load("file000.csv");
        System.out.println("letti " + record + " record");  //  chk 1  atteso 21
        System.out.println("sono presenti " + scuola.size() + "scuola");   // chk2 atteso 21
        String[] classiScolastiche;
        classiScolastiche = scuola.classi();
        System.out.println("numero classi presenti " + classiScolastiche.length);  //chk 3 atteso 18
        for (String s : classiScolastiche) {
            System.out.println(s);
        }       // chk 4 nell elenco di 18 classi diverse

        scuola.add(21314, "De Carli", "Lorenzo",
                "Verona", "4BI", "ITALIANA",
                "11/09/1931", "37137");
        System.out.println("sono presenti " + scuola.size() + "scuola");  //chk 5 atteso 22

        classiScolastiche = scuola.classi();
        System.out.println("classi presenti " + classiScolastiche.length); //chk 6  atteso 19
        for (String s : classiScolastiche) {
            System.out.println(s);
        }
        // chk 7 nell elenco di 18 classi diverse
        //indexOf   della matricola restituisce la posizione
        int pos = scuola.indexOf(21314);
        System.out.println("posizione alunno " + pos);  // chk 8 posizione <> -1
        String classe = scuola.get(pos).getClasse();   // chk 9 Classe dell' alunno 21314   atteso 4BI
        pos = scuola.indexOf(0);
        System.out.println(pos != -1);  // chk 10 esiste l'launno 0 ?Atteso False

        //del cancella un alunno     true se corretto fale altrimenti
        Boolean check = scuola.del(scuola.indexOf(21314));
        System.out.println(check);  // chk 11 atteso true
        check = scuola.del(20000);
        System.out.println(check);  // chk 12 atteso false

        record = scuola.save("file000.csv");
        System.out.println("salvate " + record + " linee"); // chk 13 il file deve avere 22 linee

    }

}
