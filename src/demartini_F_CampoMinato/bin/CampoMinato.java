package demartini_F_CampoMinato.bin;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.io.File;
import java.util.Random;

class CampoMinato {

    private final int lenCampo = 10;
    private final int nBombe = 10;
    Table<Integer, Integer, Casella> campo = HashBasedTable.create();

    public CampoMinato(Coordinate safeCoordinate) {
        initCampo();
        generateBomb(safeCoordinate);
        generateValue();
    }

    private void initCampo() {
        for (int row = 0; row < lenCampo; row++) {
            for (int column = 0; column < lenCampo; column++) {
                campo.put(row, column, new Casella(column, row));
            }
        }
    }

    private void generateBomb(Coordinate safeCoordinate) {
        //generate random bomb coord
        for (int i = 0; i < nBombe; i++) {
            Random random = new Random();
            int randomRow, randomColumn;
            do {
                randomRow = random.nextInt(lenCampo);
                randomColumn = random.nextInt(lenCampo);
            } while (campo.get(randomRow, randomColumn).isBomb() || campo.get(randomRow, randomColumn).getCoordinate().rangeOf(safeCoordinate));

            System.out.printf("Bomb at x = %d, y = %d%n", randomRow, randomColumn);

            campo.get(randomRow, randomColumn).setBomb(true);
        }
    }

    private void generateValue() {
        //geneate value for not bomb casella
        for (
                int row = 0;
                row < lenCampo; row++) {
            for (int column = 0; column < lenCampo; column++) {
                if (!campo.get(row, column).isBomb()) {
                    int bombCouter = 0;
                    for (int row2 = row - 1; row2 < row + 2; row2++) {
                        if (row2 >= 0 && row2 < lenCampo) {
                            for (int column2 = column - 1; column2 < column + 2; column2++) {
                                if (column2 >= 0 && column2 < lenCampo) {
                                    if (campo.get(row2, column2).isBomb()) {
                                        bombCouter++;
                                    }
                                }
                            }
                        }
                    }

                    campo.get(row, column).setBombCounter(bombCouter);
                }
            }
        }


    }

    public void touch(Coordinate coordinate) {
        Casella casella = campo.get(coordinate.coordY(), coordinate.coordX());
        if (casella.isBomb()) {
            endGame();
        }
        if (casella.getBombCounter() == 0) {
            for (int row = casella.getCoordinate().coordY() - 1; row <= casella.getCoordinate().coordY() + 1; row++) {

            }
        }
        campo.get(coordinate.coordY(), coordinate.coordX()).setVisible(true);


    }





    private void endGame() {
        System.out.println("Partita finita");
        System.exit(0);
    }


    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (int row = 0; row < lenCampo; row++) {
            for (int column = 0; column < lenCampo; column++) {
                output.append(campo.get(row, column).toString()).append("|");
            }
            output.append("\n");
        }
        return output.toString();
    }
}

class CampoMinatoTest {
    public static void main(String[] args) {

        System.out.println("Start");

        //		CALCOLO PATH RELATIVO UNIVERSALE
        //----------------------------------------------------------------------
        String tempPath = new File(
                String.valueOf(CampoMinato.class.getPackage()).replace("package ", "").replace(".", "/")
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

        CampoMinato campoMinato = new CampoMinato(new Coordinate(5, 5));
        System.out.println(campoMinato);

        System.out.println("End");

    }
}