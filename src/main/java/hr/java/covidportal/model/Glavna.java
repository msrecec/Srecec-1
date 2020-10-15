package main.java.hr.java.covidportal.model;

import java.util.Scanner;

public class Glavna {
    public static final int BROJ_ZUPANIJA = 3, BROJ_SIMPTOMA = BROJ_ZUPANIJA, BROJ_BOLESTI = BROJ_ZUPANIJA, BROJ_OSOBA = BROJ_ZUPANIJA;

    //Integer.parseInt(input.nextLine());
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Zupanija[] zupanije = new Zupanija[BROJ_ZUPANIJA];
        Simptom[] simptomi = new Simptom[BROJ_SIMPTOMA];

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

        String nazivSimptoma;
        String vrijednostSimptoma;

        for (int i = 0; i < BROJ_SIMPTOMA; ++i) {
            System.out.printf("Unesite naziv simptoma: ");
            nazivSimptoma = input.nextLine();

            System.out.printf("Unesite vrijednost simptoma(%s, %s, %s): ", Simptom.RIJETKO, Simptom.SREDNJE, Simptom.CESTO);
            vrijednostSimptoma = input.nextLine();

            simptomi[i] = new Simptom(nazivSimptoma, vrijednostSimptoma);

        }

        String nazivBolesti;
        int brojSimptoma;



    }
}
