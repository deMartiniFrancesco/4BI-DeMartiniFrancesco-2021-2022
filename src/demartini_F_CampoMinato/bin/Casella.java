package demartini_F_CampoMinato.bin;

public class Casella {
    private boolean isBomb;
    private boolean visible;
    private int bombCounter;
    private final Coordinate coordinate;


    public Casella(int column, int row) {
        coordinate = new Coordinate(column, row);
        isBomb = false;
        visible = true;
    }

    public boolean isBomb() {
        return isBomb;
    }

    public void setBomb(boolean bomb) {
        isBomb = bomb;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public int getBombCounter() {
        return bombCounter;
    }

    public void setBombCounter(int bombCounter) {
        this.bombCounter = bombCounter;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    @Override
    public String toString() {
        return String.valueOf(isBomb ? "X" : bombCounter == 0 ? " " : bombCounter);
    }
}
