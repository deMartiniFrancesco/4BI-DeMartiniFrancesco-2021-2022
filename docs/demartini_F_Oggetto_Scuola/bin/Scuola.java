package demartini_F_Oggetto_Scuola.bin;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
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
    String file = "demartini_F_Oggetto_Scuola\\file\\elenco.csv";

    Scuola scuola = new Scuola(file);

    System.out.println(scuola.toString());
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

  public boolean add(Persona p) {
    if (vect == null) {
      vect = new Persona[len]; // strategia di allocazione arbitraria
    }
    if (size < vect.length) {
      vect[size] = p;
      size++;
      return true;
    } else {
      return false;
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

    String stringa = "";
    for (Persona persona : vect) {
      if (persona != null) {
        stringa += persona + "\n";
      }
    }

    return stringa;
  }

  void fromFile(String fn) {
    len = 2000;
    vect = new Persona[len]; // scelta un po' arbiratria
    size = 0;
    BufferedReader bw;
    try {
      bw = new BufferedReader(new FileReader(fn));
      String linea;
      linea = bw.readLine();
      // int rig = 0;
      while ((linea = bw.readLine()) != null) {
        String[] campi = linea.split(",");
        switch (campi[0]) {
          case "A":
            Alunno a = new Alunno(campi[1], campi[2], campi[3], campi[4]);
            add(a);
            nAlunni++;
            break;
          case "D":
            Docente d = new Docente(campi[1], campi[2], campi[3], campi[4], campi[5]);
            add(d);
            nDocenti++;
            break;
          case "N":
            NonDocente nd = new NonDocente(campi[1], campi[2], campi[3], campi[4], campi[5]);
            add(nd);
            nNonDocenti++;
            break;
          default:
            break;
        }
      }
      bw.close();
    } catch (FileNotFoundException ex) {
      Logger.getLogger(Scuola.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(Scuola.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}
