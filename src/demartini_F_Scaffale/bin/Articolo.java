package demartini_F_Scaffale.bin;

import java.util.Objects;

public record Articolo(String titolo, String testo) {

    public String getTitolo() {
        return titolo;
    }

    public String getTesto() {
        return testo;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Articolo articolo = (Articolo) o;

        if (!Objects.equals(titolo, articolo.titolo)) return false;
        return Objects.equals(testo, articolo.testo);
    }


    @Override
    public String toString() {
        return "Articolo{" +
                "titolo='" + titolo + '\'' +
                ", testo='" + testo + '\'' +
                '}';
    }
}
