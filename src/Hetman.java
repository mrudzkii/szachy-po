import java.util.ArrayList;

public class Hetman extends Bierka{
    public Hetman(int x, int y, int nrGracza) {
        super(x, y, nrGracza);
        this.oznaczenie = 'h';
        mozliweRuchy = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            mozliweRuchy.add(new Pair<>(i, 0));
            mozliweRuchy.add(new Pair<>(-i, 0));
            mozliweRuchy.add(new Pair<>(0, i));
            mozliweRuchy.add(new Pair<>(0, -i));
            mozliweRuchy.add(new Pair<>(i, i));
            mozliweRuchy.add(new Pair<>(-i, i));
            mozliweRuchy.add(new Pair<>(i, i));
            mozliweRuchy.add(new Pair<>(i, -i));
        }
    }

    @Override
    public boolean czyKolizja(Pair<Integer, Integer> gdzie, char[][] jakieFigury) {
        if(wspolrzedne.getFirst().equals(gdzie.getFirst())){
            for (int i = wspolrzedne.getSecond() - 1; i > gdzie.getSecond(); i--) {
                if(jakieFigury[i][wspolrzedne.getFirst()] != 0)
                    return true;
            }
            for (int i = wspolrzedne.getSecond() + 1; i < gdzie.getSecond(); i++) {
                if(jakieFigury[i][wspolrzedne.getFirst()] != 0)
                    return true;
            }
        }

        if(wspolrzedne.getSecond().equals(gdzie.getSecond())){
            for (int i = wspolrzedne.getFirst() - 1; i > gdzie.getFirst(); i--) {
                if(jakieFigury[wspolrzedne.getSecond()][i] != 0)
                    return true;
            }
            for (int i = wspolrzedne.getFirst() + 1; i < gdzie.getFirst(); i++) {
                if(jakieFigury[wspolrzedne.getSecond()][i] != 0)
                    return true;
            }
        }

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
