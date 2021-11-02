package demartini_F_PromessiSposi.bin;

import java.io.*;
import java.util.HashMap;

class PromessiSposi {
    private static final HashMap<String, Integer> dizionarioParole = new HashMap<>();

    public static void frequency(String[] parole) {
        for (String parola : parole) {
            dizionarioParole.put(parola, dizionarioParole.getOrDefault(parola, 0) + 1);
        }
    }

    public static void main(String[] args) {
        try {
            File file =
                    new File(
                            "D:\\Documenti\\School\\INI\\Git_INI\\docs\\demartini_F_PromessiSposi\\bin\\i_promessi sposi.txt");

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String replaceChar = "\n'.,/?!";
            System.out.println(replaceChar);
            String data = reader.readLine();
            while (data != null) {
                frequency(data.toLowerCase().replaceAll(replaceChar, " ").split(" "));
                data = reader.readLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not exist");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(dizionarioParole);
    }
}
