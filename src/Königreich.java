import java.util.Scanner;

public class Königreich {
    public static void main(String[] args) {
        Scanner eingabe = new Scanner(System.in);

        while (true) {

            System.out.print("Name des Einwohners: ");
            String name = eingabe.nextLine();
            System.out.print("Einkommen des Einwohners: ");
            int einkommen = eingabe.nextInt();

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
                    System.out.println("Ungültige Eingabe");
                    einwohner = new Einwohner(name, einkommen); // ??
            }

            System.out.println("Der Einwohner " + name + " zahlt " +
                    einwohner.steuer() + " Taler Steuern.");
            System.out.println();
        }
    }
}
