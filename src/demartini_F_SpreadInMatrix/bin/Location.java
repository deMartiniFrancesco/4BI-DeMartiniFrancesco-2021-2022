package demartini_F_SpreadInMatrix.bin;

import java.util.ArrayList;
import java.util.List;

public record Location(int row, int column) {


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return row == location.row && column == location.column;
    }


    public boolean isDiagonal(){
        return row != 0 && column != 0;
    }

    @Override
    public String toString() {
        return "Location{" +
                "row=" + row +
                ", column=" + column +
                '}';
    }
}
