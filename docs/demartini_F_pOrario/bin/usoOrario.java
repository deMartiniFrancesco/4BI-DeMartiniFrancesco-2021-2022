
public class usoOrario {
    public static void main(String[] args) {
        Orario ora01;
        ora01 = new Orario(23, 59);
        System.out.println(ora01);
        ora01.addMin(1442);
        System.out.println(ora01);
        ora01.setMin(25);
        System.out.println(ora01);
        ora01.addMin(20);

        System.out.println(ora01);
        ora01.setOra(3);
        System.out.println(ora01);
        ora01.setMin(5);
        System.out.println(ora01);
        ora01.addMin(200);
        System.out.println(ora01);
        ora01.reset();
        for (int i = 0; i < 100; i++) {
            ora01.avanza();
            System.out.println(ora01);
        }

    }
}
