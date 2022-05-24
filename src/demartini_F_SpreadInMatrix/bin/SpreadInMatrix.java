package demartini_F_SpreadInMatrix.bin;

import java.io.File;
import java.util.*;

class SpreadInMatrix {
    final int lenCampo;

    final Location startLocation;
    final Location endLocation;

    final Element[][] matrix;


    final List<Element> toCheckList = new ArrayList<>();
    final List<Element> checkedList = new ArrayList<>();

    final List<Element> pathElement = new ArrayList<>();


    public SpreadInMatrix(int lenCampo, Location startLocation, Location endLocation, List<Element> obstacoles) {
        this.lenCampo = lenCampo;
        matrix = new Element[lenCampo][lenCampo];

        this.startLocation = startLocation;
        this.endLocation = endLocation;


        initMatrix(obstacoles);

        checkedList.add(getElementFromLocation(startLocation));

        startPath();

        initMatrix(obstacoles);

        getCheckedElementFromLocation(endLocation).ifPresent(
                element -> {
                    while (element.getParentElement() != null) {
                        element = element.getParentElement();
                        pathElement.add(element);
                    }
                });

    }

    public void addPathToMatrix() {
        for (Element element : pathElement) {
            Location eleLocation = element.getLocation();
            matrix[eleLocation.row()][eleLocation.column()] = element;
        }
    }

    public List<Element> getPathLocation() {
        return pathElement;
    }

    public void startPath() {

        if (checkedList.isEmpty()) {
            return;
        }

        Element calcElement = checkedList.get(checkedList.size() - 1);

        List<Element> aroundElements = getAround(calcElement);

        for (Element element : aroundElements) {

            toCheckList.add(element);

            if (endLocation.equals(element.getLocation())) {
                element.setParentElement(calcElement);
                checkedList.add(element);
                return;
            }

            int elementCost = (element.getLocation().isDiagonal(calcElement.getLocation()) ? 14 : 10) +
                    element.getLocation().getDistance(endLocation) * 10;

            if (element.getCost() == 0 || elementCost <= element.getCost()) {
                element.setCost(elementCost);
                element.setParentElement(calcElement);
                element.setValue(Math.max(calcElement.getValue(), 0) + 1);
            }
        }

        Optional<Element> elementOptional = toCheckList
                .stream()
                .filter(element -> !checkedList.contains(element))
                .filter(element -> element.getValue() > 0)
                .min(Comparator.comparing(Element::getCost, Integer::compareTo));

        if (elementOptional.isEmpty() || checkedList.contains(elementOptional.get())) {
            return;
        }


        checkedList.add(elementOptional.get());
        startPath();
    }

    private List<Element> getAround(Element element) {

        List<Element> locations = new ArrayList<>();

        Location elementLocation = element.getLocation();

        for (int row = (Math.max(elementLocation.row() - 1, 0)); row <= elementLocation.row() + 1; row++) {
            for (int col = (Math.max(elementLocation.column() - 1, 0)); col <= elementLocation.column() + 1; col++) {
                if (element.getValue() != -3 &&
                        row >= 0 &&
                        col >= 0 &&
                        row < lenCampo &&
                        col < lenCampo) {

                    Location tempLoc = new Location(row, col);

                    if (checkedList.stream()
                            .map(Element::getLocation)
                            .anyMatch(location -> location.equals(tempLoc))
                    ) {
                        continue;
                    }

                    if (elementLocation.isDiagonal(tempLoc)) {

                        Location senLocation = new Location(tempLoc.row() + (elementLocation.row() - tempLoc.row()), tempLoc.column());
                        Location cosLocation = new Location(tempLoc.row(), tempLoc.column() + (elementLocation.column() - tempLoc.column()));

                        if (matrix[senLocation.row()][senLocation.column()].getValue() == -3 &&
                                matrix[cosLocation.row()][cosLocation.column()].getValue() == -3) {
                            continue;
                        }

                    }

                    if (!tempLoc.equals(element.getLocation())) {
                        locations.add(matrix[tempLoc.row()][tempLoc.column()]);
                    }
                }
            }
        }
        return locations;
    }

    private Optional<Element> getCheckedElementFromLocation(Location location) {
        return checkedList.stream()
                .filter(element -> element.getLocation().equals(location))
                .findFirst();
    }

    private Element getElementFromLocation(Location location) {
        return matrix[location.row()][location.column()];
    }


    private void initMatrix(List<Element> obstacoles) {
        for (int row = 0; row < lenCampo; row++) {
            for (int col = 0; col < lenCampo; col++) {

                Location tempLoc = new Location(row, col);

                if (startLocation.equals(tempLoc)) {
                    matrix[row][col] = new Element(-1, row, col);
                } else if (endLocation.equals(tempLoc)) {
                    matrix[row][col] = new Element(-2, row, col);
                } else if (obstacoles != null &&
                        obstacoles.stream().map(Element::getLocation).anyMatch(location -> location.equals(tempLoc))) {
                    matrix[row][col] = new Element(-3, row, col);
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


        int lenCampo = 10;

        List<Element> walls = new ArrayList<>();

        walls.addAll(
                new SpreadInMatrix(
                        lenCampo,
                        new Location(3, 3),
                        new Location(6, 4),
                        null)
                        .getPathLocation()
        );
        walls.addAll(
                new SpreadInMatrix(
                        lenCampo,
                        new Location(7, 5),
                        new Location(2, 4),
                        null)
                        .getPathLocation()
        );


        SpreadInMatrix spread = new SpreadInMatrix(
                lenCampo,
                new Location(0, 0),
                new Location(9, 9),
                walls
        );
        spread.addPathToMatrix();

        System.out.println(spread);


        System.out.println("End");

    }
}