import java.util.ArrayList;

public abstract class Bierka {
    protected Pair<Integer, Integer> wspolrzedne;
    protected char oznaczenie;
    protected int nrGracza;
    protected ArrayList<Pair<Integer, Integer>> mozliweRuchy;

    public Bierka(int x, int y, int nrGracza) {
        this.wspolrzedne = new Pair<>(x, y);
        this.nrGracza = nrGracza;
    }

    public Pair<Integer, Integer> getWspolrzedne(){
        return wspolrzedne;
    }

    public char getOznaczenie() {
        return oznaczenie;
    }

    public boolean czyMozeSieRuszyc(char[][] jakieFigury, int[][] ktoregoGracza){
        return !dostepneRuchy(jakieFigury, ktoregoGracza).isEmpty();
    }

    //sprawdza, czy po drodze na dane pole musi przeskoczyc przez inna bierke (defaultowo falsz, override dla wiezy i hetmana)
    public boolean czyKolizja(Pair<Integer, Integer> gdzie, char[][] jakieFigury){
        return false;
    }
    //zwraca ArratListe pozycji, na ktore bierka moze sie ruszyc
    public ArrayList<Pair<Integer, Integer>> dostepneRuchy(char[][] jakieFigury, int[][] ktoregoGracza){
        ArrayList<Pair<Integer, Integer>> res = new ArrayList<>();
        for (Pair<Integer, Integer> ruch : mozliweRuchy){
            Pair<Integer, Integer> potencjalnyRuch =
                    new Pair<>(wspolrzedne.getFirst() + ruch.getFirst(), wspolrzedne.getSecond() + ruch.getSecond());
            if(potencjalnyRuch.getFirst() >= 0 && potencjalnyRuch.getFirst() <= 7 &&
                    potencjalnyRuch.getSecond() >= 0 && potencjalnyRuch.getSecond() <= 7 && !czyKolizja(potencjalnyRuch, jakieFigury)){
                if(ktoregoGracza[potencjalnyRuch.getSecond()][potencjalnyRuch.getFirst()] != nrGracza){
                    res.add(potencjalnyRuch);
                }
            }
        }
        return res;
    }
    public void zrobRuchNa(Pair<Integer, Integer> wspolrzedne){
        this.wspolrzedne.setFirst(wspolrzedne.getFirst());
        this.wspolrzedne.setSecond(wspolrzedne.getSecond());
    }
}
