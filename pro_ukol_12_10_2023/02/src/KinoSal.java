import java.util.ArrayList;
import java.util.List;

public class KinoSal {
    private int cisloSalu;
    private int pocetRad;
    private int pocetKreselVRade;
    private List<String> filmy;
    private boolean podpora3D;

    public KinoSal(int cisloSalu, int pocetRad, int pocetKreselVRade, boolean podpora3D) {
        this.cisloSalu = cisloSalu;
        this.pocetRad = pocetRad;
        this.pocetKreselVRade = pocetKreselVRade;
        this.filmy = new ArrayList<>();
        this.podpora3D = podpora3D;
    }

    public int getCisloSalu() {
        return cisloSalu;
    }

    public void setCisloSalu(int cisloSalu) {
        this.cisloSalu = cisloSalu;
    }

    public int getPocetRad() {
        return pocetRad;
    }

    public void setPocetRad(int pocetRad) {
        this.pocetRad = pocetRad;
    }

    public int getPocetKreselVRade() {
        return pocetKreselVRade;
    }

    public void setPocetKreselVRade(int pocetKreselVRade) {
        this.pocetKreselVRade = pocetKreselVRade;
    }

    public List<String> getFilmy() {
        return filmy;
    }

    public void pridatFilm(String film) {
        filmy.add(film);
    }

    public void odebratFilm(String film) {
        filmy.remove(film);
    }

    public boolean maPodporu3D() {
        return podpora3D;
    }

    public void nastavitPodporu3D(boolean podpora3D) {
        this.podpora3D = podpora3D;
    }

    public void rezervovatKreslo(String popisKresla) throws Chyba {
        int rad, cisloKresla;
        try {
            rad = popisKresla.charAt(0) - 'A' + 1;
            cisloKresla = Integer.parseInt(popisKresla.substring(1));
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            throw new Chyba("Neplatný popis křesla.");
        }

        if (rad < 1 || rad > pocetRad || cisloKresla < 1 || cisloKresla > pocetKreselVRade) {
            System.out.println(rad + ", " + pocetRad + " | " + cisloKresla + ", " + pocetKreselVRade);
            throw new Chyba("Nevhodný výběr křesla.");
        }
    }
}
