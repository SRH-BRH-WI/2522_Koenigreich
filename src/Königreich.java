import java.util.Scanner;

public class Königreich {
    public static void main(String[] args) {
        Scanner eingabe = new Scanner(System.in);

        Hauptschleife:
        while (true) {
            System.out.print("Name des Einwohners: ");
            String name = eingabe.nextLine();
            if ( name.isEmpty() ) break;
            if ( nameEnthältSonderzeichen(name) ) {
                System.out.println("Namen dürfen keine Sonderzeichen haben");
                continue;
            }

            int einkommen = 0;
            while (true) {
                System.out.print("Einkommen des Einwohners: ");
                if ( eingabe.hasNextInt() ) {
                    einkommen = eingabe.nextInt();
                    break;
                }
                eingabe.nextLine();
            }

            System.out.print("Bevölkerungsgruppe (K, A, B, L): ");
            char gruppe = eingabe.next().toUpperCase().charAt(0);
            eingabe.nextLine(); // Rest der Zeile einlesen

            Einwohner einwohner;
            switch (gruppe) {
                case 'K': einwohner = new König(name, einkommen);
                    break;
                case 'A': einwohner = new Adel(name, einkommen);
                    break;
                case 'B': einwohner = new Bauer(name, einkommen);
                    break;
                case 'L': einwohner = new Leibeigen(name, einkommen);
                    break;
                default:
                    System.out.println("Ungültige Eingabe, Programm wird beendet");
                    break Hauptschleife;
            }

            System.out.println("Der Einwohner " + name + " zahlt " +
                    einwohner.steuer() + " Taler Steuern.");
            System.out.println();
        }
        System.out.println("Vielen Dank und auf Wiedersehen");
    }

    private static boolean nameEnthältSonderzeichen(String name) {
        for (int i=0; i < name.length(); i++) {
            char aktuellesZeichen = name.charAt(i);
            if ("'´#+*~.:,;^°<>|!/\\()[]{}&$§€@".indexOf(aktuellesZeichen) != -1)
                return true;
        }
        return false;
    }
}
