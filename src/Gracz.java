import java.util.ArrayList;

public abstract class Gracz {
    private final String nazwa;
    protected int numer;
    protected ArrayList<Bierka> bierki;
    protected Pair<Integer, Integer> gdzieRuszyl;
    protected Pair<Integer, Integer> skadRuszyl;
    protected char czymRuszyl;
    protected boolean czyPrzegral;
    protected boolean czyBil;
    protected char kogoBil;

    public Gracz(String nazwa, int numer){
        this.nazwa = nazwa;
        this.numer = numer;
        this.bierki = new ArrayList<>();
        this.gdzieRuszyl = new Pair<>(0, 0);
        this.skadRuszyl = new Pair<>(0, 0);
        czyPrzegral = false;
        czyBil = false;
    }

    public boolean czyBil() {
        return czyBil;
    }

    public char getKogoBil() {
        return kogoBil;
    }

    public Pair<Integer, Integer> getGdzieRuszyl() {
        return gdzieRuszyl;
    }

    public Pair<Integer, Integer> getSkadRuszyl() {
        return skadRuszyl;
    }

    public boolean czyPrzegral() {
        return czyPrzegral;
    }

    public ArrayList<Character> getWidokBierek() {
        ArrayList<Character> res = new ArrayList<>();
        for(Bierka bierka : bierki){
            res.add(bierka.getOznaczenie());
        }
        return res;
    }

    public ArrayList<Pair<Integer, Integer>> getWspolrzedneBierek() {
        ArrayList<Pair<Integer, Integer>> res = new ArrayList<>();
        for(Bierka bierka : bierki){
            res.add(bierka.getWspolrzedne());
        }
        return res;
    }

    public String getNazwa() {
        return nazwa;
    }

    public char getCzymRuszyl() {
        return czymRuszyl;
    }

    public void dodajBierke(Bierka bierka) {
        this.bierki.add(bierka);
    }

    public void uwzglednijBicie(Pair<Integer, Integer> ruchDrugiegoGracza){
        for(Bierka bierka : bierki){
            if (bierka.getWspolrzedne().equals(ruchDrugiegoGracza)){
                czymRuszyl = bierka.getOznaczenie();
                if(czymRuszyl == 'k')
                    czyPrzegral = true;
                bierki.remove(bierka);
                return;
            }
        }
    }

    public abstract boolean ruch(char[][] jakieFigury, int[][] ktoregoGracza);
}
