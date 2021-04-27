import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class CSV02 {
  // cerca il max in cntNomi
  public static int[] ordV(int[] cntNomi, String[] nomi, int numNomi) {
    int len = numNomi;
    int index = 0;
    int[] posizioni = new int[len];
    for (int j = 0; j < len; j++) {
      int pMax = 0;
      for (int i = 0; i < len; i++) {
        if (cntNomi[i] > pMax) {
          pMax = cntNomi[i];
          index = i;
        }
      }
      posizioni[j] = index;
      cntNomi[index] = 0;
    }

    return posizioni;
  }

  // cerca la posizione di k in v -1 se no
  public static int indexOf(String[] v, String k, int num) {

    for (int i = 0; i < num; i++) {
      if (v[i].equals(k)) {
        return i;
      }
    }
    return -1;
  }

  public static void main(String[] args) throws FileNotFoundException, IOException {
    // restituisce il nome più ripetuto
    String linea, fileIn = "demartini_F_CSV01\\doc\\elenco.csv";
    BufferedReader br = new BufferedReader(new FileReader(fileIn));
    linea = br.readLine(); // salta prima linea
    String[] nomi = new String[2000];
    int[] cntNomi = new int[2000];
    int numNomi = 0; // nomi diversi
    while ((linea = br.readLine()) != null) {
      String[] lineaV = linea.split(",");
      String nc = lineaV[1]; // nome corrente

      int pos = indexOf(nomi, nc, numNomi);
      if (pos == -1) { // nc non esiste
        nomi[numNomi] = nc;
        cntNomi[numNomi] = 1;
        numNomi++;
      } else {
        cntNomi[pos]++;
      }
    }
    br.close();
    int[] posizioni = ordV(cntNomi, nomi, numNomi);
    for (int j : posizioni) {
      if (nomi[j] != null) {
        System.out.print(nomi[j] + cntNomi[j] + "    ");
      }
    }
    JOptionPane.showInputDialog("fine");
  }
}
