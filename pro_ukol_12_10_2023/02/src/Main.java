import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Filmy f1 = new Filmy("After: Odloučení", "12", "Castille Landon", false);
        Filmy f2 = new Filmy("Bod obnovy", "12", "Robert Hloz", false);
        Filmy f3 = new Filmy("Esa z pralesa 2: Světové dobrodružství DABING", "0", "Laurent Bru, Yannick Moulin, Benoît Somville", false);
        Filmy f4 = new Filmy("Jak přežít svého muže","12", "Rudolf Merkner", false);
        Filmy f5 = new Filmy("Ledové království","0", "Neill Blomkamp", false);
        Filmy f6 = new Filmy("Lví král","0", "Roger Allers, Rob Minkoff", false);
        Filmy f7 = new Filmy("Mezi živly","0", "Peter Sohn", false);
        Filmy f8 = new Filmy("Saw X","15", "Kevin Greutert", false);
        Filmy f9 = new Filmy("Sestra II","15", "Michael Chaves", false);

        List<Filmy> filmy = new ArrayList<>();
        filmy.add(f1);
        filmy.add(f2);
        filmy.add(f3);
        filmy.add(f4);
        filmy.add(f5);
        filmy.add(f6);
        filmy.add(f7);
        filmy.add(f8);
        filmy.add(f9);

        KinoSal ks1 = new KinoSal(1, 10,30, false);
        KinoSal ks2 = new KinoSal(2, 15,30, true);
        KinoSal ks3 = new KinoSal(3, 20,30, false);

        ks1.pridatFilm(f1.getNazevFilmu());
        ks1.pridatFilm(f3.getNazevFilmu());
        ks1.pridatFilm(f5.getNazevFilmu());
        ks1.pridatFilm(f2.getNazevFilmu());

        ks2.pridatFilm(f2.getNazevFilmu());
        ks2.pridatFilm(f4.getNazevFilmu());
        ks2.pridatFilm(f6.getNazevFilmu());
        ks2.pridatFilm(f8.getNazevFilmu());

        ks3.pridatFilm(f1.getNazevFilmu());
        ks3.pridatFilm(f3.getNazevFilmu());
        ks3.pridatFilm(f7.getNazevFilmu());
        ks3.pridatFilm(f9.getNazevFilmu());

        List<KinoSal> saly = new ArrayList<>();
        saly.add(ks1);
        saly.add(ks2);
        saly.add(ks3);

        System.out.println("Dostupné filmy:");
        for (Filmy film : filmy) {
            System.out.println(film.getNazevFilmu() + " (" + film.getPristupnost() + "+)");
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Vyberte si film podle názvu: ");
        String vybranyFilm = scanner.nextLine();

        Filmy vybranyFilmObj = null;
        for (Filmy film : filmy) {
            if (film.getNazevFilmu().equals(vybranyFilm)) {
                vybranyFilmObj = film;
                break;
            }
        }

        if (vybranyFilmObj == null) {
            System.out.println("Vybraný film nebyl nalezen.");
            return;
        }

        System.out.println("Dostupné sály pro film " + vybranyFilmObj.getNazevFilmu() + ":");
        boolean jeSal = false;
        for (KinoSal s : saly) {
            if (s.getFilmy().contains(vybranyFilmObj.getNazevFilmu())) {
                System.out.println("Sál č. " + s.getCisloSalu());
                jeSal = true;
            }
        }
        if (!jeSal){
            System.out.println("Omlouváme se ale pro tento film není k dispozici žádný sál.");
            return;
        }

        System.out.print("Vyberte si sál podle čísla: ");
        int vybranySal = scanner.nextInt();

        KinoSal vybranySalObj = null;
        for (KinoSal s : saly) {
            if (s.getCisloSalu() == vybranySal) {
                vybranySalObj = s;
                break;
            }
        }

        if (vybranySalObj == null) {
            System.out.println("Vybraný sál nebyl nalezen.");
            return;
        }

        System.out.println("Rozložení křesel v sálu č. " + vybranySalObj.getCisloSalu() + ":");
        for (int radek = 1; radek <= vybranySalObj.getPocetRad(); radek++) {
            for (int kreslo = 1; kreslo <= vybranySalObj.getPocetKreselVRade(); kreslo++) {
                char rad = (char) (radek + 'A' - 1);
                System.out.print(rad + "" + kreslo + " ");
            }
            System.out.println();
        }


        System.out.print("Vyberte si křeslo podle popisu (např. G4): ");
        String vybraneKreslo = scanner.next();

        try {
            vybranySalObj.rezervovatKreslo(vybraneKreslo);
            System.out.println("Rezervace proběhla úspěšně. Děkujeme za návštěvu!");
        } catch (Chyba e) {
            System.out.println("Chyba: " + e.getMessage());
        }
    }
}

class Chyba extends Exception {
    public Chyba(String message) {
        super(message);
    }
}
