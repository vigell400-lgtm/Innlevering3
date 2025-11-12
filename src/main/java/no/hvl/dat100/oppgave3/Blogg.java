package no.hvl.dat100.oppgave3;

import no.hvl.dat100.oppgave1.Innlegg;

public class Blogg {

    // objektvariable
    private Innlegg[] samling;
    private int antall;

    // standard: kapasitet 20
    public Blogg() {
        this(20);
    }

    public Blogg(int lengde) {
        samling = new Innlegg[lengde];
        antall = 0;
    }

    public int getAntall() {
        return antall;
    }

    public Innlegg[] getSamling() {
        return samling;
    }

    public int finnInnlegg(Innlegg innlegg) {
        for (int i = 0; i < antall; i++) {
            if (samling[i].erLik(innlegg)) {
                return i;
            }
        }
        return -1;
    }

    public boolean finnes(Innlegg innlegg) {
        return finnInnlegg(innlegg) != -1;
    }

    public boolean ledigPlass() {
        return antall < samling.length;
    }

    public boolean leggTil(Innlegg innlegg) {
        if (finnes(innlegg)) return false;
        if (!ledigPlass()) return false;
        samling[antall] = innlegg;
        antall++;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(antall).append("\n");
        for (int i = 0; i < antall; i++) {
            sb.append(samling[i].toString());
        }
        return sb.toString();
    }

    // valgfrie oppgaver

    public void utvid() {
        Innlegg[] ny = new Innlegg[samling.length * 2];
        for (int i = 0; i < antall; i++) ny[i] = samling[i];
        samling = ny;
    }

    public boolean leggTilUtvid(Innlegg innlegg) {
        if (finnes(innlegg)) return false;
        if (!ledigPlass()) utvid();
        samling[antall++] = innlegg;
        return true;
    }

    public boolean slett(Innlegg innlegg) {
        int i = finnInnlegg(innlegg);
        if (i == -1) return false;
        // flytt venstre og null ut siste
        for (int j = i; j < antall - 1; j++) samling[j] = samling[j+1];
        samling[antall - 1] = null;
        antall--;
        return true;
    }

    public int[] search(String keyword) {
        // Returnerer id-ene til innlegg som inneholder keyword i tekstfeltet (Tekst/Bilde)
        int treff = 0;
        for (int i = 0; i < antall; i++) {
            if (samling[i] instanceof no.hvl.dat100.oppgave2.Tekst t) {
                if (t.getTekst().contains(keyword)) treff++;
            }
        }
        int[] ids = new int[treff];
        int k = 0;
        for (int i = 0; i < antall; i++) {
            if (samling[i] instanceof no.hvl.dat100.oppgave2.Tekst t) {
                if (t.getTekst().contains(keyword)) ids[k++] = samling[i].getId();
            }
        }
        return ids;
    }
}
