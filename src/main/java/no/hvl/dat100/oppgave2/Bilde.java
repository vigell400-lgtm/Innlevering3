package no.hvl.dat100.oppgave2;

public class Bilde extends Tekst {

    // objektvariabel
    private String url;

    public Bilde(int id, String bruker, String dato, String tekst, String url) {
        super(id, bruker, dato, tekst);
        this.url = url;
    }

    public Bilde(int id, String bruker, String dato, int likes, String tekst, String url) {
        super(id, bruker, dato, likes, tekst);
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        // DAT100-format: type-linje + super + spesifikke felt
        return "BILDE\n" + super.toString() + url + "\n";
    }

    // Valgfri oppgave 6
    public String toHTML() {
        return ""; // implementeres kun hvis du tar oppgave 6
    }
}
