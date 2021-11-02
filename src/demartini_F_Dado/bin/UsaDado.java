package demartini_F_Dado.bin;

import java.util.Random;
import java.util.Scanner;

public class UsaDado {


    public static void main(String[] args) {
        Scanner pauseScanner = new Scanner(System.in);
        boolean exit = false;
        String pause;
        int sopra10 = 0;
        int sotto10 = 0;
        int nFacceSopra10 = 0;
        while (!exit) {
            Dado dado = new Dado(new Random().nextInt(15) + 6, new Random().nextBoolean());

            System.out.println(dado);
            int lancio = dado.lancio();
            System.out.println(lancio);
            pause = pauseScanner.nextLine().trim();
            if (!pause.equals("")) {
//            if (dado.getnFacce() > 10) nFacceSopra10++;
//
//            if (lancio >= 10) sopra10++;
//            else sotto10++;
//
//            if (lancio == 20) {
//                System.out.printf("sopra 10 => %d, sotto 10 => %d, n Facce Sopra 10 => %d", sopra10, sotto10, nFacceSopra10);
                exit = true;

            }
        }

    }
}
