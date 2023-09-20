import java.util.ArrayList;

public class Pionek  extends Bierka{

    private boolean czyJuzRuszylSie;
    public Pionek(int x, int y, int nrGracza) {
        super(x, y, nrGracza);
        this.oznaczenie = 'p';
        this.czyJuzRuszylSie = false;
    }

    @Override
    public boolean czyMozeSieRuszyc(char[][] jakieFigury, int[][] ktoregoGracza) {
        ArrayList<Pair<Integer, Integer>> dostepneRuchy = dostepneRuchy(jakieFigury, ktoregoGracza);
        return dostepneRuchy.size() > 0;
    }

    @Override
    public void zrobRuchNa(Pair<Integer, Integer> wspolrzedne) {
        super.zrobRuchNa(wspolrzedne);
        czyJuzRuszylSie = true;
    }

    @Override
    public ArrayList<Pair<Integer, Integer>> dostepneRuchy(char[][] jakieFigury, int[][] ktoregoGracza) {
        ArrayList<Pair<Integer, Integer>> res = new ArrayList<>();
        if(nrGracza == 1) {
            if (wspolrzedne.getFirst() > 0 && wspolrzedne.getSecond() > 0)
                if (ktoregoGracza[wspolrzedne.getSecond() - 1][wspolrzedne.getFirst() - 1] != nrGracza
                 && ktoregoGracza[wspolrzedne.getSecond() - 1][wspolrzedne.getFirst() - 1] != 0)
                    res.add(new Pair<>(wspolrzedne.getFirst() - 1, wspolrzedne.getSecond()-1));
            if (wspolrzedne.getFirst() < 7 && wspolrzedne.getSecond() > 0)
                if (ktoregoGracza[wspolrzedne.getSecond()-1][wspolrzedne.getFirst() + 1] != nrGracza
                 && ktoregoGracza[wspolrzedne.getSecond()-1][wspolrzedne.getFirst() + 1] != 0)
                    res.add(new Pair<>(wspolrzedne.getFirst() + 1, wspolrzedne.getSecond()-1));
            if (wspolrzedne.getSecond() > 0 && ktoregoGracza[wspolrzedne.getSecond() - 1][wspolrzedne.getFirst()] == 0) {
                res.add(new Pair<>(wspolrzedne.getFirst(), wspolrzedne.getSecond() - 1));
                if (!czyJuzRuszylSie && wspolrzedne.getSecond() != 1 && ktoregoGracza[wspolrzedne.getSecond() - 2][wspolrzedne.getFirst()] == 0)
                    res.add(new Pair<>(wspolrzedne.getFirst(), wspolrzedne.getSecond() - 2));
            }
        }else{
            if (wspolrzedne.getFirst() > 0 && wspolrzedne.getSecond() < 7)
                if (ktoregoGracza[wspolrzedne.getSecond()+1][wspolrzedne.getFirst() - 1] != nrGracza
                 && ktoregoGracza[wspolrzedne.getSecond()+1][wspolrzedne.getFirst() - 1] != 0)
                    res.add(new Pair<>(wspolrzedne.getFirst() - 1, wspolrzedne.getSecond() + 1));
            if (wspolrzedne.getFirst() < 7 && wspolrzedne.getSecond() < 7)
                if (ktoregoGracza[wspolrzedne.getSecond()+1][wspolrzedne.getFirst() + 1] != nrGracza
                 && ktoregoGracza[wspolrzedne.getSecond()+1][wspolrzedne.getFirst() + 1] != 0)
                    res.add(new Pair<>(wspolrzedne.getFirst() + 1, wspolrzedne.getSecond() + 1));
            if (wspolrzedne.getSecond() < 7 && ktoregoGracza[wspolrzedne.getSecond() + 1][wspolrzedne.getFirst()] == 0) {
                res.add(new Pair<>(wspolrzedne.getFirst(), wspolrzedne.getSecond() + 1));
                if (!czyJuzRuszylSie && wspolrzedne.getSecond() < 6 && ktoregoGracza[wspolrzedne.getSecond() + 2][wspolrzedne.getFirst()] == 0)
                    res.add(new Pair<>(wspolrzedne.getFirst(), wspolrzedne.getSecond() + 2));
            }
        }
        return res;
    }
}
