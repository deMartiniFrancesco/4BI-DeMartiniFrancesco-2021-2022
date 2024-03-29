package demartini_F_Oggetto_Scuola.bin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Scuola {
    private Persona[] vect;
    private int size; // numero elementi effettivamente inseriti
    private int nAlunni;
    private int nDocenti;
    private int nNonDocenti;
    private int len;

    public Scuola(String fString) {
        fromFile(fString);
    }

    public Scuola() {
        len = 20;
    }

    public static void main(String[] args) {

        //                CALCOLO PATH RELATIVO UNIVERSALE
        //----------------------------------------------------------------------
        String tempPath = new File(
                String.valueOf(Scuola.class.getPackage()).replace("package ", "").replace(".", "/")
        ).getParent();
        File uesrPath = new File(System.getProperty("user.dir"));
        String projectPath = uesrPath.getName().equals(tempPath) ?
                uesrPath.getPath() :
                new File(uesrPath.getPath() + "/src").exists() ?
                        uesrPath.getPath() + "/src/" + tempPath :
                        uesrPath.getPath() + tempPath;
        //----------------------------------------------------------------------


        // COSTANTI
        String resursesPath = "/file/";
        String elenco = "elenco.csv";

        Scuola scuola = new Scuola(projectPath + resursesPath + elenco);

        System.out.println(scuola);
        for (Persona persona : scuola.getDocenti()) {
            System.out.println(persona.toString());
        }
    }

    public int getSize() {
        return size;
    }

    Persona get(int pos) {
        if (pos >= 0 && pos < size) {
            return vect[pos];
        } else {
            return null;
        }
    }

    public Persona[] getAlunni() {
        int cont = 0;
        Persona[] alunniVect = new Persona[nAlunni];
        for (Persona persona : vect) {
            if (persona instanceof Alunno) {
                alunniVect[cont] = persona;
                cont++;
            }
        }
        return alunniVect;
    }

    public Persona[] getDocenti() {
        int cont = 0;
        Persona[] docentiVect = new Persona[nDocenti];
        for (Persona persona : vect) {
            if (persona instanceof Docente) {
                docentiVect[cont] = persona;
                cont++;
            }
        }
        return docentiVect;
    }

    public Persona[] getNonDocenti() {
        int cont = 0;
        Persona[] nonDocentiVect = new Persona[nNonDocenti];
        for (Persona persona : vect) {
            if (persona instanceof Docente) {
                nonDocentiVect[cont] = persona;
                cont++;
            }
        }
        return nonDocentiVect;
    }

    public void add(Persona p) {
        if (vect == null) {
            vect = new Persona[len]; // strategia di allocazione arbitraria
        }
        if (size < vect.length) {
            vect[size] = p;
            size++;
        } else {
        }
    }

    public void remove(int pos) {
        int cont = 0;
        Persona[] newVect = new Persona[len - 1];
        for (int i = 0; i < len; i++) {
            if (i != pos) {
                newVect[cont] = vect[i];
                cont++;
            }
        }
        vect = newVect;
    }

    public int indexOf(String s) {
        int index = 0;

        for (Persona persona : vect) {

            if (persona.getCognome().compareTo(s) == 0 || persona.getNome().compareTo(s) == 0) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public String toString() {

        StringBuilder stringa = new StringBuilder();
        for (Persona persona : vect) {
            if (persona != null) {
                stringa.append(persona).append("\n");
            }
        }

        return stringa.toString();
    }

    void fromFile(String fn) {
        len = 2000;
        vect = new Persona[len]; // scelta un po' arbiratria
        size = 0;
        BufferedReader bw;
        try {
            System.out.println(fn);
            bw = new BufferedReader(new FileReader(fn));
            String linea;
            bw.readLine();
            // int rig = 0;
            while ((linea = bw.readLine()) != null) {
                String[] campi = linea.split(",");
                switch (campi[0]) {
                    case "A" -> {
                        Alunno a = new Alunno(campi[1], campi[2], campi[3], campi[4]);
                        add(a);
                        nAlunni++;
                    }
                    case "D" -> {
                        Docente d = new Docente(campi[1], campi[2], campi[3], campi[4], campi[5]);
                        add(d);
                        nDocenti++;
                    }
                    case "N" -> {
                        NonDocente nd = new NonDocente(campi[1], campi[2], campi[3], campi[4], campi[5]);
                        add(nd);
                        nNonDocenti++;
                    }
                    default -> {
                    }
                }
            }
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Scuola.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}