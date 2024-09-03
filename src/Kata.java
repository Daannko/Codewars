import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Kata {
    public static int pointsNumber(int radius)
    {
        int counter = 0;
        for(int i = -radius; i <= radius; i++){
            for (int j = -radius ; j <= radius; j++){
                if(i * i + j * j <= radius * radius){
                    counter++;
                }
            }
        }
        return counter;
    }

    public static String firstNonRepeatingLetter(String s){
        return Arrays.stream(s.split("")).filter(e -> Collections.frequency(List.of(s.toLowerCase().split("")),e.toLowerCase()) == 1).findFirst().orElse("");
    }

    public static void main(String[] args) {
        String a = firstNonRepeatingLetter("stress");
        System.out.println(a);
    }
}