public class Gra {
    private final Szachownica plansza;
    private final Gracz gracz1;
    private final Gracz gracz2;
    private int nrTury;

    public Gra(String nazwa1, String nazwa2) {
        this.plansza = new Szachownica();
        this.gracz1 = new Losowy(nazwa1, 1);
        this.gracz2 = new Losowy(nazwa2, 2);
        this.nrTury = 1;
        for (int i = 0; i < 8; i++) {
            Pionek pionekBialy = new Pionek(i, 6, 1);
            gracz1.dodajBierke(pionekBialy);
            Pionek pionekCzarny = new Pionek(i, 1, 2);
            gracz2.dodajBierke(pionekCzarny);
        }
        gracz1.dodajBierke(new Wieza(0 , 7,  1));
        gracz1.dodajBierke(new Skoczek(1 , 7,  1));
        gracz1.dodajBierke(new Goniec(2 , 7,  1));
        gracz1.dodajBierke(new Krol(3 , 7,  1));
        gracz1.dodajBierke(new Hetman(4 , 7,  1));
        gracz1.dodajBierke(new Goniec(5 , 7,  1));
        gracz1.dodajBierke(new Skoczek(6 , 7,  1));
        gracz1.dodajBierke(new Wieza(7 , 7,  1));

        gracz2.dodajBierke(new Wieza(0 , 0,  2));
        gracz2.dodajBierke(new Skoczek(1 , 0,  2));
        gracz2.dodajBierke(new Goniec(2 , 0,  2));
        gracz2.dodajBierke(new Krol(3 , 0,  2));
        gracz2.dodajBierke(new Hetman(4 , 0,  2));
        gracz2.dodajBierke(new Goniec(5 , 0,  2));
        gracz2.dodajBierke(new Skoczek(6 , 0,  2));
        gracz2.dodajBierke(new Wieza(7 , 0,  2));

        plansza.zaktualizujWidok(gracz1.getWidokBierek(), gracz2.getWidokBierek(),
                gracz1.getWspolrzedneBierek(), gracz2.getWspolrzedneBierek());
    }

    private boolean tura(){
        System.out.println("Tura " + nrTury + ":");
        //Ruch gracza pierwszego
        if(!gracz1.ruch(plansza.getJakieFigury(), plansza.getKtoregoGracza())){
            System.out.println("Gracz 1 o nazwie '" + gracz1.getNazwa() + "' przegral z powodu braku mozliwosci wykonania ruchu (frajer hehe)");
            return false;
        }
        //Wypisuje ruch gracza, to odejmowanie i dodawanie liter 'a' jest po to, zeby symbol figury pierwszego gracza
        //byl napisany wielkimi literami (toUpperCase dziala tylko na typie Character, a nie char afaik)
        System.out.print("Ruch " + (char)(gracz1.getCzymRuszyl()-'a'+'A') + " z " + (char)(gracz1.getSkadRuszyl().getFirst() + 'A') +
                (gracz1.getSkadRuszyl().getSecond()+1)+ " na "
                + (char)(gracz1.getGdzieRuszyl().getFirst() + 'A') +
                (gracz1.getGdzieRuszyl().getSecond()+1));
        if(gracz1.czyBil()){
            System.out.print(" bicie figury: " + gracz1.getKogoBil() + '\n');
        }else{
            System.out.print(" bez bicia\n");
        }
        gracz2.uwzglednijBicie(gracz1.getGdzieRuszyl());
        plansza.zaktualizujWidok(gracz1.getWidokBierek(), gracz2.getWidokBierek(),
                gracz1.getWspolrzedneBierek(), gracz2.getWspolrzedneBierek());
        plansza.wypiszPlansze();
        if(gracz2.czyPrzegral()){
            System.out.println("Gracz 2 przegral na skutek straty krola");
            return false;
        }

        //Ruch gracza drugiego
        if(!gracz2.ruch(plansza.getJakieFigury(), plansza.getKtoregoGracza())){
            System.out.println("Gracz 2 o nazwie '" + gracz2.getNazwa() + "' przegral z powodu braku mozliwosci wykonania ruchu (frajer hehe)");
            return false;
        }
        System.out.print("Ruch " + (gracz2.getCzymRuszyl()) + " z " + (char)(gracz2.getSkadRuszyl().getFirst() + 'A') +
                (gracz2.getSkadRuszyl().getSecond()+1)+ " na "
                + (char)(gracz2.getGdzieRuszyl().getFirst() + 'A') +
                (gracz2.getGdzieRuszyl().getSecond()+1));
        if(gracz2.czyBil()){
            System.out.print(" bicie figury: " + gracz2.getKogoBil() + '\n');
        }else{
            System.out.print(" bez bicia\n");
        }
        gracz1.uwzglednijBicie(gracz2.getGdzieRuszyl());
        plansza.zaktualizujWidok(gracz1.getWidokBierek(), gracz2.getWidokBierek(),
                gracz1.getWspolrzedneBierek(), gracz2.getWspolrzedneBierek());
        plansza.wypiszPlansze();
        if(gracz1.czyPrzegral()){
            System.out.println("Gracz 1 przegral na skutek straty krola");
            return false;
        }
        return true;
    }

    public void rozegraj(){
        boolean czyRozgrywac = true;
        System.out.println("Nazwy graczy: ");
        System.out.println("Gracz 1: " + gracz1.getNazwa());
        System.out.println("Gracz 2: " + gracz2.getNazwa());
        System.out.println();
        plansza.wypiszPlansze();
        while (nrTury <= 50 && czyRozgrywac){
            czyRozgrywac = tura();
            nrTury++;
        }

        if (czyRozgrywac)
            System.out.println("Gra zakonczyla sie remisem po rozegraniu 50 tur");
    }
}
