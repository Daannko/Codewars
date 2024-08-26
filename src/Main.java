import java.util.*;

public class Main {

    public static int sumMultipesOf3And5(int number){

        Set<Integer> mult = new HashSet<>();
        for(int i = 3; i < number; i += 3) mult.add(i);
        for(int i = 5; i < number; i += 5) mult.add(i);

        return mult.stream().mapToInt(Integer::intValue).sum();
    }
    public static void main(String[] args) {

        System.out.println(fromRoman("MCMI"));

    }




    public static String toRoman(int n) {
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] symbol ={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        String output = "";

        int i = 0;
        while(n != 0){
            if(n < values[i]) i++;
            else{
                output += symbol[i];
                n -= values[i];
            }
        }
        return output;
    }

    public static int fromRoman(String romanNumeral) {
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        List<String> symbols = new ArrayList<>(List.of("M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"));
        int output = 0;
        for(int i = 0; i < romanNumeral.length();i++){

            if(     i < romanNumeral.length() - 1 &&
                    (symbols.indexOf(String.valueOf(romanNumeral.charAt(i))) > symbols.indexOf(String.valueOf(romanNumeral.charAt(i + 1))))){
                output += values[symbols.indexOf(String.valueOf(romanNumeral.charAt(i)) + romanNumeral.charAt(i))];
                i++;
            }else{
                output += values[symbols.indexOf(String.valueOf(romanNumeral.charAt(i)))];
            }
        }
        return output;
    }


}