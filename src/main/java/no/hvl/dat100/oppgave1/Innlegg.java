package no.hvl.dat100.oppgave1;

public abstract class Innlegg {

    // Objektvariabler
    private int id;
    private String bruker;
    private String dato;
    private int likes;

    public Innlegg() {
        // tom default-konstruktør (kan være nyttig for senere bruk/testing)
    }

    public Innlegg(int id, String bruker, String dato) {
        this.id = id;
        this.bruker = bruker;
        this.dato = dato;
        this.likes = 0;
    }

    public Innlegg(int id, String bruker, String dato, int likes) {
        this.id = id;
        this.bruker = bruker;
        this.dato = dato;
        this.likes = likes;
    }

    public String getBruker() {
        return bruker;
    }

    public void setBruker(String bruker) {
        this.bruker = bruker;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public int getId() {
        return id;
    }

    public int getLikes() {
        return likes;
    }

    public void doLike() {
        likes++;
    }

    public boolean erLik(Innlegg innlegg) {
        // Lik dersom samme id
        return this.id == innlegg.getId();
    }

    @Override
    public String toString() {
        // Standard tekstformat brukt videre i oppgavene
        // (hver verdi på egen linje, avsluttet med linjeskift)
        return id + "\n" + bruker + "\n" + dato + "\n" + likes + "\n";
    }

    // Valgfri oppgave 6 – enkel HTML-representasjon
    public String toHTML() {
        return "<div class=\"innlegg\">\n"
                + "  <div class=\"id\">" + id + "</div>\n"
                + "  <div class=\"bruker\">" + bruker + "</div>\n"
                + "  <div class=\"dato\">" + dato + "</div>\n"
                + "  <div class=\"likes\">" + likes + "</div>\n"
                + "</div>";
    }
}

