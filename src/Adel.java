public class Adel extends Einwohner {
    public Adel(String name, int einkommen) {
        super(name, einkommen);
    }

    @Override
    public int steuer() {
        int abzugeben = super.steuer();
        if (abzugeben < 20) abzugeben = 20;
        return abzugeben;
    }
}
