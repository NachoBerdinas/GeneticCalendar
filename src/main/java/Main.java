import java.util.ArrayList;
import java.util.List;

public class Main{

    public static int CHILDS = 1000;

    public static void main(String[] args) {
        List<DNA> childs = new ArrayList<DNA>();
        String phrase = "the quick brown fox jumps over the lazy dog";
        DNA.phrase = phrase;
        int perfect = (int)Math.pow(phrase.length(),3);

        for (int i = 0; i < CHILDS; i++) {
            childs.add(new DNA(phrase.length()));
        }

        for (int k = 0 ; k < 10000;k++) {
            List<DNA> matingPool = new ArrayList<DNA>();
            DNA best = childs.get(0);
            for(DNA child: childs){
                if(child.getStrength()>best.getStrength()) best = child;
            }

            System.out.println("Score   "+ best.getStrength() + "   Phrase:   " + best.getPhrase());

            for (DNA child : childs) {
                if(child.getStrength() < best.getStrength()/5) continue;
                for (int j = 0; j < child.getStrength(); j++) {
                    matingPool.add(child);
                }
            }
            System.out.println(k+ " Mating pool lenght: " + matingPool.size());

            childs.clear();
            for (int i = 0; i < CHILDS; i++) {
                int a = (int) (Math.random() * matingPool.size());
                int b = (int) (Math.random() * matingPool.size());
                childs.add(new DNA(matingPool.get(a), matingPool.get(b)));
            }
            matingPool.clear();
        }

        DNA best = childs.get(0);
        for(DNA child: childs){
            if(child.getStrength()>best.getStrength()) best = child;
        }

        int bestScore = best.getStrength();
        System.out.println("Score   "+ bestScore+ "   Phrase:   " + best.getPhrase());



    }
}