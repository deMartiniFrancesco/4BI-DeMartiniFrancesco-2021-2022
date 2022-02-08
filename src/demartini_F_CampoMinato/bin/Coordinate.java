package demartini_F_CampoMinato.bin;

public record Coordinate(
        int coordX,
        int coordY
) {

    @Override
    public String toString() {
        return "Coordinate{" +
                "coordX=" + coordX +
                ", coordY=" + coordY +
                '}';
    }
}
