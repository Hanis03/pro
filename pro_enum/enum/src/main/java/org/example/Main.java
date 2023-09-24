package org.example;
enum TypZvirete {
    Pes,
    Kočka,
    Pták,
    Ryba
}

class Zvire {
    private String jmeno;
    private int vek;
    private TypZvirete typ;
    public Zvire(String jmeno, int vek, TypZvirete typ) {
        this.jmeno = jmeno;
        this.vek = vek;
        this.typ = typ;
    }

    public void vypisInformace() {
        System.out.println("Jméno: " + jmeno);
        System.out.println("Věk: " + vek + " let");
        System.out.println("Typ: " + typ);
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Zvire zvire1 = new Zvire("Max", 3, TypZvirete.Pes);
        Zvire zvire2 = new Zvire("Mia", 2, TypZvirete.Kočka);
        Zvire zvire3 = new Zvire("Tweetie", 1, TypZvirete.Pták);

        // Výpis informací o zvířatech do konzole
        System.out.println("Informace o zvířatech:");
        zvire1.vypisInformace();
        zvire2.vypisInformace();
        zvire3.vypisInformace();
    }
}
