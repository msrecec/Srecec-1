package main.java.hr.java.covidportal.model;

import java.util.Arrays;
import java.util.Scanner;

public class Glavna {
    public static final int BROJ_ZUPANIJA = 3, BROJ_SIMPTOMA = BROJ_ZUPANIJA, BROJ_BOLESTI = BROJ_ZUPANIJA, BROJ_OSOBA = BROJ_ZUPANIJA;

    //Integer.parseInt(input.nextLine());
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Zupanija[] zupanije = new Zupanija[BROJ_ZUPANIJA];
        Simptom[] simptomi = new Simptom[BROJ_SIMPTOMA];
        Bolest[] bolesti = new Bolest[BROJ_BOLESTI];

        // Unos Zupanija

        String nazivZupanije;
        int brojStanovnika;

        System.out.printf("Unesite podatke o %d zupanije:%n", BROJ_ZUPANIJA);
        for (int i = 0; i < BROJ_ZUPANIJA; ++i) {

            System.out.printf("Unesite naziv zupanije: ");
            nazivZupanije = input.nextLine();

            System.out.printf("Unesite broj stanovnika: ");
            brojStanovnika = Integer.parseInt(input.nextLine());

            zupanije[i] = new Zupanija(nazivZupanije, brojStanovnika);

        }

        // Unos Simptoma

        String nazivSimptoma;
        String vrijednostSimptoma;

        System.out.printf("Unesite podatke o %d simptoma:%n", BROJ_SIMPTOMA);

        for (int i = 0; i < BROJ_SIMPTOMA; ++i) {
            System.out.printf("Unesite naziv simptoma: ");
            nazivSimptoma = input.nextLine();

            System.out.printf("Unesite vrijednost simptoma(%s, %s, %s): ", Simptom.RIJETKO, Simptom.SREDNJE, Simptom.CESTO);
            vrijednostSimptoma = input.nextLine();

            // if(!vrijednostSimptoma.in([RIJETKO, SREDNJE, CESTO])) Provjera pojave vrijednosti simptoma

            if (!Arrays.asList(Simptom.RIJETKO, Simptom.SREDNJE, Simptom.CESTO).contains(vrijednostSimptoma)) {
                System.out.println("Pogresan unos simptoma !");
                i--;
                continue;
            }

            simptomi[i] = new Simptom(nazivSimptoma, vrijednostSimptoma);

        }

        // Unos Bolesti

        String nazivBolesti;
        int brojOdabranihSimptoma, odabraniSimptom;
        int[] odabraniSimptomi;
        Simptom[] kopiraniSimptomi;

        System.out.printf("Unesite podatke o %d bolesti:%n", BROJ_BOLESTI);

        for (int i = 0; i < BROJ_BOLESTI; ++i) {
            System.out.printf("Unesite naziv bolesti: ");
            nazivBolesti = input.nextLine();

            // Unos Broja Odabranih Simptoma

            System.out.printf("Unesite broj simptoma: ");
            brojOdabranihSimptoma = Integer.parseInt(input.nextLine());

            // Provjera unesenog Broja Odabranih Simptoma

            if (brojOdabranihSimptoma > simptomi.length || brojOdabranihSimptoma < 1) {
                System.out.println("Pogresan unos broja simptoma !");
                i--;
                continue;
            }

            // Unos odabranih simptoma

            odabraniSimptomi = new int[brojOdabranihSimptoma];

            for (int j = 0; j < brojOdabranihSimptoma; ++j) {
                System.out.printf("Odaberite %d. simptom:%n", j + 1);

                // Ispis Postojecih Simptoma

                for (int k = 0; k < simptomi.length; ++k) {
                    System.out.printf("%d. %s %s%n", k + 1, simptomi[k].getNaziv(), simptomi[k].getVrijednost());
                }

                // Biranje Postojeceg Simptoma

                odabraniSimptom = Integer.parseInt(input.nextLine());

                // Provjera ispravnog unosa Odabranog Postojeceg Simptoma

                if (odabraniSimptom > simptomi.length || odabraniSimptom < 1) {
                    System.out.println("Neispravan unos, molimo pokusajte ponovno!");
                    j--;
                    continue;
                }

                // Provjera postojanosti Odabranog Postojeceg Simptoma u prethodno Odabranim Simptomima

                for (int k = 0; k < odabraniSimptomi.length; ++k) {
                    if (odabraniSimptomi[k] == odabraniSimptom) {
                        System.out.println("Odabrani Simptom je vec unesen!");
                        j--;
                        continue;
                    }
                }

                // Dodavanje Odabranog Simptoma u polje Odabranih Simptoma

                odabraniSimptomi[j] = odabraniSimptom;

            }

            // Kopiranje Postojecih Simptoma u novo polje Kopiranih Simptoma

            kopiraniSimptomi = new Simptom[brojOdabranihSimptoma];
            for (int j = 0; j < brojOdabranihSimptoma; ++j) {
                kopiraniSimptomi[j] = new Simptom(simptomi[odabraniSimptomi[j] - 1].getNaziv(), simptomi[odabraniSimptomi[j] - 1].getVrijednost());
            }
            bolesti[i] = new Bolest(nazivBolesti, kopiraniSimptomi);
        }

        // Unos osoba

        String ime, prezime;
        Integer starost;
        Zupanija zupanija;
        Bolest zarazenBolescu;
        Osoba[] kontaktiraneOsobe;

        for(int i = 0; i < BROJ_OSOBA; ++i) {

            // Unos imena

            System.out.printf("Unesite ime %d. osobe: ", i+1);
            ime = input.nextLine();

            // Unos prezimena

            System.out.printf("Unesite prezime %d. osobe: ", i+1);
            prezime = input.nextLine();

            // Unos starosti

            System.out.printf("Unesite starost osobe: ");
            starost = Integer.parseInt(input.nextLine());

            // Unos zupanije prebivalista

            System.out.printf("Unesite zupaniju prebivalista osobe:%n");

        }

    }
}




























