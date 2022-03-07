package demartini_F_SpreadInMatrix.bin;

import java.io.File;
import java.util.*;

class SpreadInMatrix {
    int lenCampo = 10;

    Location startLocation;
    Location endLocation;

    Element[][] matrix = new Element[lenCampo][lenCampo];


    public SpreadInMatrix(int startRow, int startColumn, int endRow, int endColumn) {


        startLocation = new Location(startRow, startColumn);
        endLocation = new Location(endRow, endColumn);


        initMatrix();


        startPath(getFromLocation(startLocation));

    }


    public void startPath(Element calcLocation) {

        Element calcElement = getFromLocation(calcLocation.getLocation());

        List<Location> locations = calcElement.getAround(lenCampo);

        for (Location loc : locations) {

            Element element = getFromLocation(loc);
            if (element.getValue() == 0) {
                element.addCost(loc.isDiagonal() ? 0.75 : 1);
                element.setValue(Math.max(calcElement.getValue(), 0) + 1);
            }
        }

        Optional<Element> elementOptional = fromLocationToElement(locations)
                .stream()
                .filter(element -> element.getValue() == 0)
                .min(Comparator.comparing(Element::getCost, Double::compareTo));

        System.out.println(elementOptional);

        if (elementOptional.isEmpty()){
            return;
        }
//        startPath(elementOptional.get());


    }


    private Element getFromLocation(Location location){
        return matrix[location.row()][location.row()];
    }

    private List<Element> fromLocationToElement(List<Location> locations){

        List<Element> elements = new ArrayList<>();

        for (Location loc : locations) {
            elements.add(matrix[loc.row()][loc.column()]);
        }
        return elements;
    }


    private void initMatrix() {
        for (int row = 0; row < lenCampo; row++) {
            for (int col = 0; col < lenCampo; col++) {

                if (startLocation.equals(new Location(row, col))) {
                    matrix[row][col] = new Element(-1, row, col);

                } else if (endLocation.equals(new Location(row, col))) {
                    matrix[row][col] = new Element(-2, row, col);

                } else {
                    matrix[row][col] = new Element(0, row, col);
                }
            }
        }
    }

    @Override
    public String toString() {
        String line = "---------------------------------------------------------\n";
        StringBuilder output = new StringBuilder(line);
        for (int row = 0; row < lenCampo; row++) {
            output.append(Arrays.toString(matrix[row]));
            output.append("\n");
        }
        output.append(line);
        return output.toString();
    }
}

class SpreadInMatrixTest {
    public static void main(String[] args) {

        System.out.println("Start");

        //		CALCOLO PATH RELATIVO UNIVERSALE
        //----------------------------------------------------------------------
        String tempPath = new File(
                String.valueOf(SpreadInMatrix.class.getPackage()).replace("package ", "").replace(".", "/")
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

        SpreadInMatrix spread = new SpreadInMatrix(0, 0, 5, 5);

        System.out.println(spread);


        System.out.println("End");

    }
}