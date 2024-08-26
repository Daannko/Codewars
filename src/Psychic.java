import java.util.ArrayList;
import java.util.Random;

public class Psychic {

    public static void main(String[] args) {
        System.out.println(guess() == Math.random());
        return ;
    }

    public static double guess() {

        double nextDouble = Math.random();
        long numerator = (long)(nextDouble * (1L << 53));
        int nextN = (int)(numerator >>> 27);
        int nextM = (int)(numerator & ((1L << 27) - 1));

        int n = 26,m = 27;

        final long multiplier = 0x5DEECE66DL;
        final long addend = 0xBL;
        final long mask = (1L << 48) - 1;

        long upperMOf48Mask = ((1L << m) - 1) << (48 - m);
        long oldSeedUpperN = ((long)nextN << (48 - n)) & mask;
        long newSeedUpperM = ((long)nextM << (48 - m)) & mask;

        ArrayList<Long> possibleSeeds = new ArrayList<Long>();
        for (long oldSeed = oldSeedUpperN; oldSeed <= (oldSeedUpperN | ((1L << (48 - n)) - 1)); oldSeed++) {
            long newSeed = (oldSeed * multiplier + addend) & mask;
            if ((newSeed & upperMOf48Mask) == newSeedUpperM) {
                possibleSeeds.add(newSeed);
            }
        }

        Random random = new Random(possibleSeeds.get(0) ^ multiplier);
        return random.nextDouble();
    }

}
