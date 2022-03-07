package demartini_F_SpreadInMatrix.bin;

public record Location(int row, int column) {


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return row == location.row && column == location.column;
    }


    public boolean isDiagonal(Location loc){
        return loc.row - row != 0 && loc.column - column != 0;
    }

    public int getDistance(Location target){
        return Math.abs(target.row() - row) + Math.abs(target.column() - column);
    }

    @Override
    public String toString() {
        return "Location{" +
                "row=" + row +
                ", column=" + column +
                '}';
    }
}
