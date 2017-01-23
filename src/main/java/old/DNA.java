package old;

/**
 * Created by Ignacio on 1/23/2017.
 */
public class DNA {
    private char[] letters;
    private int score;
    public static String phrase;

    public DNA(int size){
        score = 1;
        letters = new char[size];
        for(int i = 0; i< size;i++){
            letters[i] = (char)((int)(97+Math.random()*26));
        }
        calculateScore();
    }

    public DNA(DNA father, DNA mother){
        score = 1;
        letters = new char[father.getSize()];
        for(int i = 0;i< letters.length;i++){
            if(i<letters.length/2){
                letters[i] = father.getLetters()[i];
            }else {
                letters[i] = mother.getLetters()[i];
            }
        }
        calculateScore();
        mutate();
    }

    private void mutate(){
        int original = score;
        if(Math.random()<0.01){
            int position = (int)(Math.random()*getSize());
            char old = letters[position];
            letters[position] = (char)((int)(97+Math.random()*26));
            calculateScore();
            if(score < original) letters[position] = old;
        }
        calculateScore();
    }

    public int getStrength(){
        return score;
    }

    private void calculateScore() {
        score = 1;
        for (int i = 0; i < letters.length ; i++) {
            if(letters[i] == phrase.charAt(i)){
                score *= 2;
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
