package demartini_F_CSV01.bin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

class CSV01 {
  public static ArrayList<String> sort(HashMap<String, Integer> nomi) {

    ArrayList<String> sortNomi = new ArrayList<>();

    for (String nome : nomi.keySet()) {
      sortNomi.add(nome);
    }

    int max = 0;
    for (Integer frequenza : nomi.values()) {}

    return sortNomi;
  }

  public static HashMap<String, Integer> frequency(HashMap<String, Integer> nomi, String nome) {

    boolean isKeyPresent = nomi.containsKey(nome);
    if (isKeyPresent) {
      Integer key = nomi.get(nome);
      key++;
      nomi.put(nome, key);
    } else {
      nomi.put(nome, 1);
    }
    return nomi;
  }

  public static void main(String[] args) throws IOException {
    String percorso = "demartini_F_CSV01\\doc\\elenco.csv";
    BufferedReader buffer = new BufferedReader(new FileReader(percorso));
    String linea = buffer.readLine(), nome;

    HashMap<String, Integer> nomi = new HashMap<>();

    while ((linea = buffer.readLine()) != null) {
      String[] vetLinea = linea.split(",");
      nome = vetLinea[1];
      nomi = frequency(nomi, nome);
    }
    buffer.close();

    System.out.println(sort(nomi));

    System.out.println();
  }
}
