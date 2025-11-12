package no.hvl.dat100.oppgave5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import no.hvl.dat100.oppgave1.Innlegg;
import no.hvl.dat100.oppgave2.Bilde;
import no.hvl.dat100.oppgave2.Tekst;
import no.hvl.dat100.oppgave3.Blogg;

public class LesBlogg {

    private static String TEKST = "TEKST";
    private static String BILDE = "BILDE";

    public static Blogg les(String mappe, String filnavn) {
        String sti = (mappe == null || mappe.isEmpty()) ? filnavn : (mappe + "/" + filnavn);

        try (BufferedReader br = new BufferedReader(new FileReader(sti))) {
            int antall = Integer.parseInt(br.readLine());
            Blogg blogg = new Blogg(antall);

            for (int i = 0; i < antall; i++) {
                String type = br.readLine(); // "TEKST" eller "BILDE"

                int id = Integer.parseInt(br.readLine());
                String bruker = br.readLine();
                String dato = br.readLine();
                int likes = Integer.parseInt(br.readLine());
                String tekst = br.readLine();

                Innlegg inn;
                if (TEKST.equals(type)) {
                    inn = new Tekst(id, bruker, dato, likes, tekst);
                } else if (BILDE.equals(type)) {
                    String url = br.readLine();
                    inn = new Bilde(id, bruker, dato, likes, tekst, url);
                } else {
                    // ukjent type – hopp/avbryt
                    return null;
                }

                blogg.leggTil(inn);
            }
            return blogg;

        } catch (IOException | NumberFormatException e) {
            return null;
        }
    }
}

