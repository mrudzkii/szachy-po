import java.util.ArrayList;

public class Krol extends Bierka{
    public Krol(int x, int y, int nrGracza) {
        super(x, y, nrGracza);
        this.oznaczenie = 'k';
        mozliweRuchy = new ArrayList<>();
        mozliweRuchy.add(new Pair<>(1, 1));
        mozliweRuchy.add(new Pair<>(1, 0));
        mozliweRuchy.add(new Pair<>(1, -1));
        mozliweRuchy.add(new Pair<>(0, -1));
        mozliweRuchy.add(new Pair<>(0, 1));
        mozliweRuchy.add(new Pair<>(-1, 1));
        mozliweRuchy.add(new Pair<>(-1, 0));
        mozliweRuchy.add(new Pair<>(-1, -1));
    }
}
