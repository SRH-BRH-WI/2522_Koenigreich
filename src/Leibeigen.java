public class Leibeigen extends Bauer {
    public Leibeigen(String name, int einkommen) {
        super(name, einkommen);
    }

    @Override
    public int zuVersteuern() {
        int gesamtesEinkommen = super.zuVersteuern();
        gesamtesEinkommen -= 12;
        if (gesamtesEinkommen < 0) gesamtesEinkommen = 0;
        return gesamtesEinkommen;
    }
}
