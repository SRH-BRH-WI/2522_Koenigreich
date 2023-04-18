public class Einwohner {
    private String name;
    private int einkommen;

    public Einwohner(String name, int einkommen) {
        this.name = name;
        this.einkommen = einkommen;
    }

    public int zuVersteuern() {
        return einkommen;
    }

    public int steuer() {
        int gesamtesEinkommen = zuVersteuern();   // <- jetzt richtig
        int abzugeben = gesamtesEinkommen * 10 / 100;
        if (abzugeben < 1) abzugeben = 1;
        return abzugeben;
    }
}
