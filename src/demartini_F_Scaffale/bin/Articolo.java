package demartini_F_Scaffale.bin;

import jdk.nashorn.internal.objects.annotations.Getter;

import java.util.Objects;

public class Articolo {
    private final String titolo;
    private final String testo;


    public Articolo(String titolo, String testo) {
        this.titolo = titolo;
        this.testo = testo;
    }

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
