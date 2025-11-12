package no.hvl.dat100.oppgave4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import no.hvl.dat100.oppgave3.Blogg;

public class SkrivBlogg {

    public static boolean skriv(Blogg samling, String mappe, String filnavn) {
        String sti = (mappe == null || mappe.isEmpty()) ? filnavn : (mappe + "/" + filnavn);
        try (PrintWriter out = new PrintWriter(sti)) {
            out.print(samling.toString());
            return true;
        } catch (FileNotFoundException e) {
            return false;
        }
    }
}
