package br.com.all.zip.domain.address;
import java.text.Normalizer;

public class StreetReconciliationPolicy {
    public Decision decide(String localStreet, String externalStreet) {
        String l = normalize(localStreet);
        String e = normalize(externalStreet);
        if (e == null || e.isBlank()) return Decision.no("external empty");
        if (l == null || l.isBlank()) return Decision.yes(1.0, "local empty");
        if (!l.equals(e))         return Decision.yes(1.0, "have been diferent");

        return Decision.no("have not been diferent");
    }

    private String normalize(String s) {
        if (s == null) return null;
        String noAccents = Normalizer.normalize(s.trim(), Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "");
        return noAccents.toLowerCase()
                .replaceAll("\\b(rua|avenida|av|rodovia|alameda|travessa)\\.?\\b", "")
                .replaceAll("[^a-z0-9 ]", "")
                .replaceAll("\\s+", " ").trim();
    }
    public record Decision(boolean shouldUpdate, double confidence, String reason) {
        public static Decision yes(double c, String r){ return new Decision(true, c, r); }
        public static Decision no(String r){ return new Decision(false, 0.0, r); }
    }
}
