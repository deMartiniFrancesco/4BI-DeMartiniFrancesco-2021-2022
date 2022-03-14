package demartini_F_SpreadInMatrix.bin;

public class Element {

    private int value;
    private int cost = 0;
    private Location location;
    private Element parentElement;



    public Element(int value, int row, int column) {
        this.value = value;
        location = new Location(row, column);
        parentElement = null;
    }

    @Override
    public String toString() {

        return switch (value) {
            case -1 -> "○";
            case -2 -> "▢";
            case -3 -> "▮";
            case 0 -> " ";
            default -> String.valueOf(cost);

        };
    }

    public Element getParentElement() {
        return parentElement;
    }

    public void setParentElement(Element parentElement) {
        this.parentElement = parentElement;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void addCost(int cost) {
        setCost(getCost() + cost);
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Element element)) return false;

        if (value != element.value) return false;
        if (cost != element.cost) return false;
        return location.equals(element.location);
    }

    @Override
    public int hashCode() {
        int result = value;
        result = 31 * result + cost;
        result = 31 * result + location.hashCode();
        return result;
    }
}
