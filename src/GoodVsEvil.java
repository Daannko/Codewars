import java.util.Arrays;
import java.util.stream.IntStream;

public class GoodVsEvil {

    public static void main(String[] args) {
        System.out.println(battle("1 1 1 1 1 1", "1 1 1 1 1 1 1"));
    }
    public static String battle(String goodAmounts, String evilAmounts) {
        final int[] goodStrength = {1,2,3,3,4,10};
        final int[] badStrength = {1,2,2,2,3,5,10};
        int[] goodAmountsArray =  Arrays.stream(goodAmounts.split(" ")).mapToInt(Integer::valueOf).toArray();
        int[] badAmountsArray =  Arrays.stream(evilAmounts.split(" ")).mapToInt(Integer::valueOf).toArray();
        int goodStr = IntStream.range(0,goodStrength.length).map(i -> goodStrength[i] * goodAmountsArray[i]).sum();
        int badStr = IntStream.range(0,badStrength.length).map(i -> badStrength[i] * badAmountsArray[i]).sum();

        if(goodStr > badStr) return "Battle Result: Good triumphs over Evil";
        else if(goodStr == badStr) return "Battle Result: No victor on this battle field";
        return "Battle Result: Evil eradicates all trace of Good";
    }
}
