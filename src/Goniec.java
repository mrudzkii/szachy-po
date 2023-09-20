import java.util.ArrayList;

public class Goniec extends Bierka{
    public Goniec(int x, int y, int nrGracza) {
        super(x, y, nrGracza);
        this.oznaczenie = 'g';
        mozliweRuchy = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            mozliweRuchy.add(new Pair<>(i, i));
            mozliweRuchy.add(new Pair<>(-i, i));
            mozliweRuchy.add(new Pair<>(i, i));
            mozliweRuchy.add(new Pair<>(i, -i));
        }
    }

    @Override
    public boolean czyKolizja(Pair<Integer, Integer> gdzie, char[][] jakieFigury) {
        if(gdzie.getSecond() < wspolrzedne.getSecond() && gdzie.getFirst() < wspolrzedne.getFirst()){
            for (int i = 1; wspolrzedne.getSecond()-i > gdzie.getSecond(); i++){
                if(jakieFigury[wspolrzedne.getSecond()-i][wspolrzedne.getFirst()-1] != 0)
                    return true;
            }
        }

        if(gdzie.getSecond() > wspolrzedne.getSecond() && gdzie.getFirst() > wspolrzedne.getFirst()){
            for (int i = 1; i + wspolrzedne.getSecond() < gdzie.getSecond(); i++){
                if(jakieFigury[wspolrzedne.getSecond()+i][wspolrzedne.getFirst()+1] != 0)
                    return true;
            }
        }

        if(gdzie.getSecond() < wspolrzedne.getSecond() && gdzie.getFirst() > wspolrzedne.getFirst()){
            for (int i = 1; wspolrzedne.getSecond() - i > gdzie.getSecond(); i++){
                if(jakieFigury[wspolrzedne.getSecond()-i][wspolrzedne.getFirst()+1] != 0)
                    return true;
            }
        }

        if(gdzie.getSecond() > wspolrzedne.getSecond() && gdzie.getFirst() < wspolrzedne.getFirst()){
            for (int i = 1; wspolrzedne.getSecond() + i < gdzie.getSecond(); i++){
                if(jakieFigury[wspolrzedne.getSecond()+i][wspolrzedne.getFirst()-1] != 0)
                    return true;
            }
        }

        return false;
    }
}
