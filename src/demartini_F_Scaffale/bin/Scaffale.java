package demartini_F_Scaffale.bin;

import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.Optional;

class Scaffale {

    private Articolo[] articoliList = new Articolo[5];
    private int articoloIndex = 0;

    public Scaffale() {

    }

    public boolean pieno() {
        return articoloIndex == articoliList.length - 1;
    }

    public boolean vuoto() {
        return articoloIndex == 0;
    }

    private void expand() {
        Articolo[] newArticoloList = new Articolo[articoliList.length + 5];
        System.arraycopy(articoliList, 0, newArticoloList, 0, articoliList.length);
        articoliList = newArticoloList;
    }


    public void add(Articolo articolo) {
        if (pieno()) {
            expand();
        }
        articoliList[articoloIndex] = articolo;
        articoloIndex++;
    }

    public void remove(Articolo articolo) {
        indexOf(articolo).ifPresent(
                indexArtricolo -> {
                    Articolo[] newArticoloList = new Articolo[articoliList.length];
                    int index = 0;
                    for (int i = 0; i < articoloIndex; i++) {
                        if (i == indexArtricolo) {
                            continue;
                        }
                        newArticoloList[index] = articoliList[i];
                        index++;
                    }

                    articoliList = newArticoloList;
                    articoloIndex--;
                }
        );
    }

    public Optional<Articolo> get(int index) {
        if (index <= articoloIndex) {
            return Optional.ofNullable(articoliList[index]);
        }
        return Optional.empty();
    }

    public Optional<Integer> indexOf(Articolo articolo) {
        for (int i = 0; i < articoloIndex; i++) {
            if (articoliList[i].equals(articolo)) {
                return Optional.of(i);
            }
        }
        return Optional.empty();
    }

    public int getLengthOfArticoli() {
        return articoloIndex;
    }

    @Override
    public String toString() {
        return "Scaffale{" +
                "articoliList=" + Arrays.toString(articoliList) +
                ", articoloIndex=" + articoloIndex +
                '}';
    }
}

class ScaffaleTest {
    public static void main(String[] args) {

        System.out.println("Start");

        //		CALCOLO PATH RELATIVO UNIVERSALE
        //----------------------------------------------------------------------
        String tempPath = new File(
                String.valueOf(Scaffale.class.getPackage()).replace("package ", "").replace(".", "/")
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

        Scaffale scaffale = new Scaffale();

        Articolo articolo = new Articolo("Super titolo", "che bel testo");

        scaffale.add(articolo);
        scaffale.add(new Articolo("Articolo 1", "prova articolo"));
        scaffale.add(null);
        scaffale.add(new Articolo("Articolo 3", "prova prova prova prova prova "));

        System.out.println(scaffale);

        scaffale.indexOf(articolo).flatMap(scaffale::get).ifPresent(System.out::println);

        scaffale.get(2).ifPresent(System.out::println);

        System.out.println(scaffale.getLengthOfArticoli());

        System.out.println("End");

    }

}