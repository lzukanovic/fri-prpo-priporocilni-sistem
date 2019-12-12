package si.fri.prpo.nakupovalniseznami.priporocila.api.v1.dtos;

public class Artikel {

    private String naziv;

    public Artikel() {}

    public Artikel(String naziv) {this.naziv = naziv;}

    public String getNaziv() { return naziv; }

    public void setNaziv(String naziv) { this.naziv = naziv; }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !obj.getClass().isAssignableFrom(Artikel.class)) {
            return false;
        }

        return this.getNaziv().equals(((Artikel) obj).getNaziv());
    }

    @Override
    public int hashCode() {
        return this.naziv.hashCode();
    }

    @Override
    public String toString() {
        return String.format(this.getNaziv());
    }
}
