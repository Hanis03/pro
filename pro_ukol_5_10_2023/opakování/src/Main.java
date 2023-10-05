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
                    new Ukol1().spustit();
                    break;
                case 2:
                    new Ukol2().spustit();
                    break;
                case 3:
                    new Ukol3().spustit();;
                    break;
                case 4:
                    new Ukol4().spustit();
                    break;
                case 5:
                    System.out.println("");System.out.println("Končím..");
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
        while (true) {
            if (Year.isLeap(year)) {
                System.out.println("Přestupný rok je: " + year);
                break;
            }
            year++;
        }
        System.out.println("");
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
        LocalDateTime aktualniCasDatum = LocalDateTime.of(dnes, casNyni);
        LocalDateTime zadaneCasDatum = LocalDateTime.of(zadaneDatum, LocalTime.MIDNIGHT);
        Duration duration = Duration.between(aktualniCasDatum, zadaneCasDatum);
        long celkoveSekundy = duration.getSeconds();
        long sekundy = celkoveSekundy % 60;
        long minuty = (celkoveSekundy / 60) % 60;
        long hodiny = (celkoveSekundy / 3600) % 24;
        long roky = (long) ((celkoveSekundy / 31536000 ) % 365.25);
        long dny = (long) ((celkoveSekundy / 86400) - roky * 365.25);

        System.out.println("Zbývají "+ roky + " rok(y)/ let, " + dny + " dní, " + hodiny + " hodin, " + minuty + " minut a " + sekundy + " sekund do zadaného data.");
        System.out.println("");
    }
}






