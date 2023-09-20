import java.util.ArrayList;
import java.util.HashMap;

public class Szachownica {
    private char[][] jakieFigury;
    private int[][] ktoregoGracza;

    private final HashMap<Character, Character> symboleBiale, symboleCzarne;

    private void uzupelnijHashMape(){
        symboleBiale.put('p', '♙');
        symboleBiale.put('s', '♘');
        symboleBiale.put('g', '♗');
        symboleBiale.put('w', '♖');
        symboleBiale.put('h', '♕');
        symboleBiale.put('k', '♔');

        symboleCzarne.put('p', '♟');
        symboleCzarne.put('s', '♞');
        symboleCzarne.put('g', '♝');
        symboleCzarne.put('w', '♜');
        symboleCzarne.put('h', '♛');
        symboleCzarne.put('k', '♚');
    }

    public Szachownica(){
       jakieFigury = new char[8][8];
       ktoregoGracza = new int[8][8];
       symboleBiale = new HashMap<>();
       symboleCzarne = new HashMap<>();
       uzupelnijHashMape();
    }

    public char[][] getJakieFigury() {
        return jakieFigury;
    }

    public int[][] getKtoregoGracza() {
        return ktoregoGracza;
    }

    public void zaktualizujWidok(ArrayList<Character> bierki1, ArrayList<Character> bierki2,
                  ArrayList<Pair<Integer, Integer>> wspolrzedne1, ArrayList<Pair<Integer, Integer>> wspolrzedne2){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                jakieFigury[i][j] = 0;
                ktoregoGracza[i][j] = 0;
            }
        }

        for(int i = 0; i < bierki1.size(); i++){
            jakieFigury[wspolrzedne1.get(i).getSecond()][wspolrzedne1.get(i).getFirst()] = bierki1.get(i);
            ktoregoGracza[wspolrzedne1.get(i).getSecond()][wspolrzedne1.get(i).getFirst()] = 1;
        }
        for(int i = 0; i < bierki2.size(); i++){
            jakieFigury[wspolrzedne2.get(i).getSecond()][wspolrzedne2.get(i).getFirst()] = bierki2.get(i);
            ktoregoGracza[wspolrzedne2.get(i).getSecond()][wspolrzedne2.get(i).getFirst()] = 2;
        }
    }

    public void wypiszPlansze(){
        System.out.println("    A  B  C  D  E  F  G  H");
        for (int i = 0; i < 8; i++) {
            System.out.print((i+1) + ": ");
            for (int j = 0; j < 8; j++) {
                if(jakieFigury[i][j] == 0)
                    System.out.print(" . ");
                else if (ktoregoGracza[i][j] == 1) {
                    System.out.print(" " + symboleBiale.get(jakieFigury[i][j]) + " ");
                }else{
                    System.out.print(" " + symboleCzarne.get(jakieFigury[i][j]) + " ");
                }
            }
            System.out.print('\n');
        }
        System.out.print('\n');
    }
}
