import java.util.ArrayList;
import java.util.List;

public class Main{

    public static int CHILDS = 10000;

    public static void main(String[] args) {
        List<DNA> childs = new ArrayList<DNA>();
        String phrase = "to be or not to be";
        DNA.phrase = phrase;

        for (int i = 0; i < CHILDS; i++) {
            childs.add(new DNA(phrase.length()));
        }


        int k = 0;

        while (true){
            List<DNA> matingPool = new ArrayList<DNA>();

            for (DNA child : childs) {
                for (int j = 0; j < child.getStrength(); j++) {
                    matingPool.add(child);
                }
            }

            childs.clear();
            for (int i = 0; i < CHILDS; i++) {
                int a = (int) (Math.random() * matingPool.size());
                int b = (int) (Math.random() * matingPool.size());
                childs.add(new DNA(matingPool.get(a), matingPool.get(b)));
            }

            DNA best = childs.get(0);
            for(DNA child: childs){
                //System.out.println("Child strenght " +child.getStrength());
                if(child.getStrength()>best.getStrength()) best = child;
            }

            int bestScore = best.getStrength();
            System.out.println(k++ +"  Score   "+ bestScore+ "   Phrase:   " + best.getPhrase() + " Mating pool size "+ matingPool.size());

            matingPool.clear();
        }


    }
}