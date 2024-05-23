import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static int sumMultipesOf3And5(int number){

        Set<Integer> mult = new HashSet<>();
        for(int i = 3; i < number; i += 3) mult.add(i);
        for(int i = 5; i < number; i += 5) mult.add(i);

        return mult.stream().mapToInt(Integer::intValue).sum();
    }
    public static void main(String[] args) {

        System.out.println( sumMultipesOf3And5(10));

    }

}