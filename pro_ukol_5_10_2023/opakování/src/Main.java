import java.time.*;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input;

        do {
            System.out.print(" 1 - Zjištění přestupného roku,\n 2 - Nejbližší přestupný rok,\n 3 - Přepsání z ms na čas,\n 4 - Vypočítání rozdílu od aktuálního data,\n 5 - Konec\n Vyberte úkol: ");
            input = scanner.nextInt();

            switch (input) {
                case 1:
                    Ukol1 ukol1 = new Ukol1();
                    ukol1.spustit();
                    break;
                case 2:
                    Ukol2 ukol2 = new Ukol2();
                    ukol2.spustit();
                    break;
                case 3:
                    Ukol3 ukol3 = new Ukol3();
                    ukol3.spustit();
                    break;
                case 4:
                    Ukol4 ukol4 = new Ukol4();
                    ukol4.spustit();
                    break;
                case 5:
                    System.out.println("Končím..");
                    break;
                default:
                    System.out.println("Neplatné číslo operace.");
            }
        } while (input != 5);
    }
}

class Ukol1 {
    public void spustit() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Zadej rok: ");
        int rok = sc.nextInt();

        if (rok % 4 == 0 && (rok % 100 != 0 || rok % 400 == 0)) {
            System.out.println("Tento rok je přestupný.");
            System.out.println("");
        } else {
            System.out.println("Tento rok není přestupný.");
            System.out.println("");
        }
    }
}

class Ukol2 {
    public void spustit() {
        int year = Year.now().getValue();
        if (Year.isLeap(year)) {
            System.out.println("Tento rok je přestupný.");
            System.out.println("");
        } else {
            Year nextLeapYear = Year.of(year).plusYears(1);
            System.out.println("Přestupný rok je: " + nextLeapYear);
            System.out.println("");
        }
    }
}

class Ukol3 {
    public void spustit() {
        long cas = System.currentTimeMillis();
        Date time = new Date(cas);
        System.out.println(time);
    }
}

class Ukol4 {
    public void spustit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Zadej den (1-31):");
        int den = scanner.nextInt();
        System.out.println("Zadej měsíc (1-12):");
        int mesic = scanner.nextInt();
        System.out.println("Zadej rok:");
        int rok = scanner.nextInt();
        LocalDate zadaneDatum = LocalDate.of(rok, Month.of(mesic), den);
        LocalDate dnes = LocalDate.now();
        LocalTime casNyni = LocalTime.now();
        LocalDate aktualniDatum = dnes.isBefore(zadaneDatum) ? zadaneDatum : dnes;
        Period period = Period.between(dnes, zadaneDatum);
        Duration duration = Duration.between(casNyni, LocalTime.MIDNIGHT);
        System.out.println("Zbývá " + period.getYears() + " let, " + period.getMonths() + " měsíců, "
                + period.getDays() + " dní, " + duration.toHours() + " hodin, " + duration.toMinutes()
                + " minut a " + duration.getSeconds() + " sekund do zadaného data.");
        System.out.println("");
    }
}
