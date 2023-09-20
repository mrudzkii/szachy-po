import java.util.ArrayList;
import java.util.Random;

public class Losowy extends Gracz{

    public Losowy(String nazwa, int numer) {
        super(nazwa, numer);
    }

    @Override
    public boolean ruch(char[][] jakieFigury, int[][] ktoregoGracza) {
        ArrayList<Bierka> ruszalne = new ArrayList<>();
        for(Bierka bierka : bierki){
            if(bierka.czyMozeSieRuszyc(jakieFigury, ktoregoGracza))
                ruszalne.add(bierka);
        }
        if(ruszalne.size() == 0) return false;
        else {
            Random random = new Random();
            Bierka wybrana = ruszalne.get(random.nextInt(0, ruszalne.size()));
            this.skadRuszyl.setFirst(wybrana.getWspolrzedne().getFirst());
            this.skadRuszyl.setSecond(wybrana.getWspolrzedne().getSecond());
            czymRuszyl = wybrana.getOznaczenie();
            ArrayList<Pair<Integer, Integer>> dostepneRuchy = wybrana.dostepneRuchy(jakieFigury, ktoregoGracza);
            gdzieRuszyl = dostepneRuchy.get(random.nextInt(0, dostepneRuchy.size()));
            if(ktoregoGracza[gdzieRuszyl.getSecond()][gdzieRuszyl.getFirst()] != 0
                    && ktoregoGracza[gdzieRuszyl.getSecond()][gdzieRuszyl.getFirst()] != this.numer) {
                czyBil = true;
                kogoBil = jakieFigury[gdzieRuszyl.getSecond()][gdzieRuszyl.getFirst()];
            } else {
                czyBil = false;
            }
            wybrana.zrobRuchNa(gdzieRuszyl);
            return true;
        }
    }
}
