import java.util.ArrayList;

public class Skoczek extends Bierka{
    public Skoczek(int x, int y, int nrGracza) {
        super(x, y, nrGracza);
        this.oznaczenie = 's';
        mozliweRuchy = new ArrayList<>();
        mozliweRuchy.add(new Pair<>(2, -1));
        mozliweRuchy.add(new Pair<>(2, 1));
        mozliweRuchy.add(new Pair<>(1, 2));
        mozliweRuchy.add(new Pair<>(1, -2));
        mozliweRuchy.add(new Pair<>(-1, -2));
        mozliweRuchy.add(new Pair<>(-1, 2));
        mozliweRuchy.add(new Pair<>(-2, 1));
        mozliweRuchy.add(new Pair<>(-2, -1));
    }
}
