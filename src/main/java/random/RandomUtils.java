package random;

import java.util.Random;

/**
 * Created by Ignacio on 1/23/2017.
 */
public class RandomUtils {
    private static Random random = new Random();

    public static int getInt(int start,int finish){
        return start + random.nextInt(finish-start);
    }
}
