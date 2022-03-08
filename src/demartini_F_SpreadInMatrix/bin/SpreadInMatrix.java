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
        ArrayList<Element> path = startPath(new ArrayList<>(List.of(getFromLocation(startLocation))));

        initMatrix();

        path.stream()
                .filter(element -> element.getValue() >= 0)
                .forEach(element ->
                        matrix[element.getLocation().row()][element.getLocation().column()]
                                .setValue(element.getValue())
                );

    }


    public ArrayList<Element> startPath(ArrayList<Element> calcLocationList) {

        if (calcLocationList.isEmpty()) {
            return null;
        }

        Element calcElement = getFromLocation(calcLocationList.get(calcLocationList.size() - 1).getLocation());

        List<Location> locations = getAround(calcElement, lenCampo);


        if (locations.contains(endLocation)) {
            calcLocationList.add(getFromLocation(endLocation));
            return calcLocationList;
        }

        for (Location loc : locations) {
            Element element = getFromLocation(loc);
            if (element.getValue() == 0) {
                element.addCost((loc.isDiagonal(calcElement.getLocation()) ? 0.75 : 1) + loc.getDistance(endLocation));
                element.setValue(Math.max(calcElement.getValue(), 0) + 1);
            }
        }

        Optional<Element> elementOptional = fromLocationToElement(locations)
                .stream()
                .filter(element -> !calcLocationList.contains(element))
                .filter(element -> element.getValue() > 0)
                .min(Comparator.comparing(Element::getCost, Double::compareTo));

        if (elementOptional.isEmpty() || calcLocationList.contains(elementOptional.get())) {
            return null;
        }
        calcLocationList.add(elementOptional.get());
        return startPath(calcLocationList);
    }

    private List<Location> getAround(Element element, int lenMax) {

        List<Location> locations = new ArrayList<>();

        Location location = element.getLocation();

        for (int row = (Math.max(location.row() - 1, 0)); row <= location.row() + 1; row++) {
            for (int col = (Math.max(location.column() - 1, 0)); col <= location.column() + 1; col++) {
                    if (element.getValue() != -3 &&
                            row >= 0 && col >= 0
                            && row < lenMax && col < lenMax) {

                        Location tempLoc = new Location(row, col);

                        if (location.isDiagonal(tempLoc)){

                        }

                        if (!tempLoc.equals(element.getLocation())) {
                            locations.add(tempLoc);
                        }
                    }
            }
        }
        return locations;
    }

    private Element getFromLocation(Location location) {
        return matrix[location.row()][location.column()];
    }

    private List<Element> fromLocationToElement(List<Location> locations) {

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

        List<Location> walls = List.of(
                new Location()
        )

        SpreadInMatrix spread = new SpreadInMatrix(0, 0, 7, 9);

        System.out.println(spread);


        System.out.println("End");

    }
}