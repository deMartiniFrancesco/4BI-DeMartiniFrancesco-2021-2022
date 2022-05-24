package demartini_F_prova.bin;

import java.util.ArrayList;
import java.util.List;

public class Prova {

    public static void main(String[] args) {
        List<String> work = new ArrayList<>(List.of(
                "ARDUINI MIRKO_411027_assignsubmission_file_",
                "BONIZZI ENRICO_411019_assignsubmission_file_",
                "BRAZZOLI MARICA_411008_assignsubmission_file_"
        ));


        for (String cartella : work) {
            work.add("cartella");
            System.out.println(cartella);
        }

    }

}
