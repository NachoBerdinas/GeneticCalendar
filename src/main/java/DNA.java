import java.util.Random;

/**
 * Created by Ignacio on 1/23/2017.
 */
public class DNA {
    private char[] letters;
    public static String phrase;
    private int score;

    public DNA(int size){
        letters = new char[size];
        for(int i = 0; i< size;i++){
            letters[i] = (char)((int)(30+Math.random()*95));
        }
        calculateScore();
    }

    public DNA(DNA father, DNA mother){
        letters = new char[father.getSize()];
        for(int i = 0;i< letters.length;i++){
            if(i%2==0){
                letters[i] = father.getLetters()[i];
            }else {
                letters[i] = mother.getLetters()[i];
            }
        }
        mutate();
        calculateScore();
    }

    public void mutate(){
        if(Math.random()<0.3){
            letters[(int)(Math.random()*getSize())] = (char)((int)(30+Math.random()*95));
        }
    }

    public int getStrength(){
        return (int)Math.pow(score,2);
    }

    private void calculateScore() {
        for(int i = 0; i< phrase.length();i++){
            if(phrase.charAt(i) == letters[i]){
                score++;
            }
        }
    }

    public char[] getLetters() {
        return letters;
    }

    public String getPhrase(){
        return new String (letters);
    }

    public int getSize(){
        return letters.length;
    }
}
