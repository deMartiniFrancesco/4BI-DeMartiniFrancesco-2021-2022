package demartini_F_prova.bin;

public class Prova {

    public static void main(String[] args) {
        StringBuilder test = new StringBuilder();

        for (int i = 0; i < 10000000; i++) {

            test.append(i).append("\n");

        }

        System.out.println(test);

    }

}
