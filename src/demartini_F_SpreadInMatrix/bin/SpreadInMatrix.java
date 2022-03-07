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


        startPath(new ArrayList<>(List.of(getFromLocation(startLocation))));

    }


    public void startPath(ArrayList<Element> calcLocationList) {

        if (calcLocationList.isEmpty()){
            return;
        }

        Element calcElement = getFromLocation(calcLocationList.get(0).getLocation());

        List<Location> locations = calcElement.getAround(lenCampo);

//        System.out.println(locations);

        for (Location loc : locations) {

            Element element = getFromLocation(loc);
            System.out.printf("%s isDiagonal : %s%n", loc, loc.isDiagonal(calcElement.getLocation()));
            if (element.getValue() == 0) {
                element.addCost((loc.isDiagonal(calcElement.getLocation()) ? 0.75 : 1) + loc.getDistance(endLocation));
                element.setValue(Math.max(calcElement.getValue(), 0) + 1);
//                System.out.println(loc + "  " + element);
            }
        }

        Optional<Element> elementOptional = fromLocationToElement(locations)
                .stream()
                .filter(element -> !calcLocationList.contains(element))
                .filter(element -> element.getValue() > 0)
                .min(Comparator.comparing(Element::getCost, Double::compareTo));
//
        System.out.println(elementOptional + " " + (elementOptional.isPresent() ? elementOptional.get().getLocation() : "" ));

        if (elementOptional.isEmpty()|| calcLocationList.contains(elementOptional.get())){
            return;
        }
        calcLocationList.add(0, elementOptional.get());

        System.out.println(this);
        startPath(calcLocationList);

    }


    private Element getFromLocation(Location location){
        return matrix[location.row()][location.column()];
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

        SpreadInMatrix spread = new SpreadInMatrix(0, 0, 7, 5);

        System.out.println(spread);


        System.out.println("End");

    }
}