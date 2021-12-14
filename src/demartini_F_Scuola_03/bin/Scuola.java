package demartini_F_Scuola_03.bin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

class Scuola {

    // COSTANTI
    String resursesPath = "/file/";

    String projectPath;
    ArrayList<Alunno> scuola;

    public Scuola() {

        //		CALCOLO PATH RELATIVO UNIVERSALE
        //----------------------------------------------------------------------
        String tempPath = new File(
                String.valueOf(demartini_F_Scuola_03.bin.Scuola.class.getPackage()).replace("package ", "").replace(".", "/")
        ).getParent();
        File uesrPath = new File(System.getProperty("user.dir"));
        projectPath = uesrPath.getName().equals(tempPath) ?
                uesrPath.getPath() :
                new File(uesrPath.getPath() + "/src").exists() ?
                        uesrPath.getPath() + "/src/" + tempPath :
                        uesrPath.getPath() + tempPath;
        //----------------------------------------------------------------------


        scuola = new ArrayList<>();


    }

    public int load(String fileName) {
        int record = 0;
        try {
            FileReader fileReader = new FileReader(projectPath + resursesPath + fileName);

            BufferedReader reader = new BufferedReader(fileReader);
            String linea;
            boolean end = false;
            while (!end) {
                record++;
                linea = reader.readLine();
                if (linea == null)
                    end = true;
                else {
                    record++;
                    scuola.add(new Alunno(Arrays.asList(linea.split(","))));

                    System.out.println(scuola.get(2)); // print NOME
                }
            }
            reader.close();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return record;
    }

    public int size() {
        return scuola.size();
    }

    public String[] classi() {
        HashSet<String> classi = new HashSet<>();
        for (Alunno alunno : scuola) {
            classi.add(alunno.getClasse());
        }
        return (String[]) classi.toArray();
    }

    public Alunno get(int index) {
        return scuola.get(index);
    }

    public void add(int nMatricola, String cognome, String nome, String residenza, String classe, String nazione, String dataNascita, String cap) {
        scuola.add(new Alunno(nMatricola, cognome, nome, residenza, classe, nazione, dataNascita, cap));
    }

    public int indexOf(int matricola) {
        for (int i = 0; i < scuola.size(); i++) {
            if(scuola.get(i).getnMatricola() == matricola){
                return i;
            }
        }
        return -1;
    }

    //TODO finire funzioni

    public Boolean del(int indexOf) {
        return true;
    }

    public int save(String s) {
        return 0;
    }
}
