import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PokerHand implements Comparable<PokerHand>
{

    @Override
    public int compareTo(PokerHand o) {
        Result result = compareWith(o);
        if(result.equals(Result.WIN)) return 1;
        else if(result.equals(Result.LOSS)) return -1;
        return 0;
    }

    public enum Result { TIE, WIN, LOSS }
    private List<String> values;
    private List<String> colors;
    private final ArrayList<String> allValues = new ArrayList<>(List.of("2","3","4","5","6","7","8","9","T","J","Q","K","A"));


    PokerHand(String hand)
    {
        List<String> sortedHand = new ArrayList<>();
        for (String value : allValues){
            sortedHand.addAll(Arrays.stream(hand.split(" ")).filter(s -> s.contains(value)).collect(Collectors.toList()));
        }

        this.values = sortedHand.stream().map(s -> s.substring(0,1)).collect(Collectors.toList());
        this.colors = sortedHand.stream().map(s -> s.substring(1)).collect(Collectors.toList());
    }


    public Result compareWith(PokerHand hand) {
        int myRank = getRank(this);
        int playerRank = getRank(hand);
        if(myRank > playerRank) return Result.WIN;
        else if (myRank < playerRank) return Result.LOSS;
        else {
            if(myRank == 3 || myRank == 2){
                String myBiggestPair = this.values.stream().filter(i -> Collections.frequency(this.values,i) > 1).max(Comparator.naturalOrder()).get();
                String playerBiggestPair = hand.values.stream().filter(i -> Collections.frequency(hand.values,i) > 1).max(Comparator.naturalOrder()).get();

                if( this.allValues.indexOf(myBiggestPair) >  this.allValues.indexOf(playerBiggestPair)) return Result.WIN;
                else if (this.allValues.indexOf(myBiggestPair) <  this.allValues.indexOf(playerBiggestPair)) return Result.LOSS;

                this.values.removeIf(e -> Collections.frequency(this.values, e) > 1);
                hand.values.removeIf(e -> Collections.frequency(hand.values, e) > 1);

            }

            while(this.allValues.indexOf(this.values.get(this.values.size() - 1)) == hand.allValues.indexOf(hand.values.get(hand.values.size() - 1))){
                this.values.remove(this.values.size() - 1);
                hand.values.remove(hand.values.size() - 1);
                if(this.values.size() == 0) return Result.TIE;
            }
            int myIndexOfHighestCard = this.allValues.indexOf(this.values.get(this.values.size() - 1));
            int playerIndexOfHighestCard = hand.allValues.indexOf(hand.values.get(hand.values.size() - 1));
            if(myIndexOfHighestCard > playerIndexOfHighestCard) return Result.WIN;
            else if (myIndexOfHighestCard < playerIndexOfHighestCard) return Result.LOSS;
        }

        return Result.TIE;
    }

    private static int getRank(PokerHand hand){

        boolean isStraight = straight(hand);
        if(hand.colors.stream().distinct().count() == 1){ // The same suit
            if(new HashSet<>(hand.values)
                    .containsAll(List.of("T","J","Q","K","A"))) return 10;
            if(isStraight) return 9;
            return 6; // <- flush
        }
        if(isStraight) return 5;
        switch ((int) hand.values.stream().distinct().count()){
            case 2:
                if(hand.values.get(0).contains(hand.values.get(1))
                        && hand.values.get(3).contains(hand.values.get(4))) return 7; // checks if there are at least 2 duplicates <- full house
                return 8; // four of kind
            case 3:
                if(hand.values.parallelStream().anyMatch(e -> Collections.frequency(hand.values,e) == 3))  return 4; // Checks if there are 3 same cards
                return 3;
            case 4:
                return 2;
        }
       return 1;
    }

    private static boolean straight(PokerHand hand){
        if( new HashSet<>(hand.values).containsAll(List.of("A","2","3","4","5"))) return true;  // Ace down case

        int idx = hand.allValues.indexOf(hand.values.get(0));
        if(idx > 8) return false; //Because the smallest value would be something more than 10 and thats not straight
        for(int i = 0; i < 5; i++){
            if(!hand.allValues.get(idx + i).contains(hand.values.get(i))) return false;

        }
        return true;
    }
    public static void main(String[] args) {
        PokerHand player = new PokerHand("3S 8S 9S 5S KS");
        PokerHand opponent = new PokerHand("3D 2H 3H 2C 2D");
        System.out.println(player.compareWith(opponent));
        return ;
    }



}