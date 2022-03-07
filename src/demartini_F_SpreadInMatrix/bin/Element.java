package demartini_F_SpreadInMatrix.bin;

import java.util.ArrayList;
import java.util.List;

public class Element {

    private int value;
    private double cost = 0;
    private Location location;



    public Element(int value, int row, int column) {
        this.value = value;
        location = new Location(row, column);
    }

    @Override
    public String toString() {

        return switch (value) {
            case -1 -> "○";
            case -2 -> "▢";
            default -> String.valueOf(cost);

        };
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void addCost(double cost) {
        setCost(getCost() + cost);
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Location> getAround(int lenMax) {

        List<Location> locations = new ArrayList<>();

        for (int row = (Math.max(location.row() - 1, 0)); row <= location.row() + 1; row++) {
            for (int col = (Math.max(location.column() - 1, 0)); col <= location.column() + 1; col++) {
                if (row >= 0 && col >= 0 && row < lenMax && col < lenMax) {

                    Location tempLoc = new Location(row, col);

                    if (!tempLoc.equals(location)) {
                        locations.add(tempLoc);
                    }
                }
            }
        }
        return locations;
    }
}
