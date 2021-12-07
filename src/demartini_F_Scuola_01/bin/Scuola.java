package demartini_F_Scuola_01.bin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

class Scuola {
    public static void main(String[] args) {

        System.out.println("Start");

        //		CALCOLO PATH RELATIVO UNIVERSALE
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
        String csvPath = "export.csv";

        try {
            FileReader fileReader = new FileReader(projectPath + resursesPath + csvPath);

            BufferedReader reader = new BufferedReader(fileReader);
            String linea;
            boolean end = false;
            while (!end) {
                linea = reader.readLine();
                if (linea == null)
                    end = true;
                else {

                    ArrayList<String> strings = new ArrayList<>(Arrays.asList(linea.split(",")));

                    System.out.println(strings.get(2)); // print NOME
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("End");
    }
}