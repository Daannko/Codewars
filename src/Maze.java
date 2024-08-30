import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Maze {
    //https://www.codewars.com/kata/56bb9b7838dd34d7d8001b3c/train/java (Simple maze)


    public static void main(String[] args) {
        hasExit(new String[]{"###########",
                "#k        #",
                "#########"});
    }
    public static boolean hasExit(String[] maze) {


        int width = Arrays.stream(maze).map(String::length).max(Comparator.naturalOrder()).get();
        int[][] mazeInt = new int[maze.length][maze[0].length()];
        int height = maze.length;
        boolean foundKate = false;
        int[] kateCords = new int[2];
        for(int i = 0 ; i < maze.length;i++){
            mazeInt[i] = maze[i].chars().map(c -> c == '#' ? 1 : c == ' ' ? 0 : 2).toArray();
            if(mazeInt[i].length != width){
                mazeInt[i] = IntStream.concat(Arrays.stream( mazeInt[i]), IntStream.generate(() -> 0).limit(width - mazeInt[i].length)).toArray();
            }
            if(Arrays.stream(mazeInt[i]).anyMatch(e -> e == 2)){
                if(foundKate) throw new RuntimeException();
                int idx = i;
                kateCords[0] = idx;
                kateCords[1] = IntStream.range(0,mazeInt[i].length).filter(j -> mazeInt[idx][j] == 2).findFirst().orElse(-1);
                foundKate = true;
            }
        }

        if(!foundKate) throw new RuntimeException();
        List<int[]> cords = new ArrayList<>();

        int[][] moves =  new int[][]{{-1,0}, {0,-1},{0,0},{0,1},{1,0}};
        for(;;){

            if(kateCords[0] == 0
                    || kateCords[1] == 0
                    || kateCords[0] == height - 1
                    || kateCords[1] == width - 1) return true;

            for (int i = 0; i < moves.length ; i++){
                int cordY = kateCords[0] + moves[i][0];
                int cordX = kateCords[1] + moves[i][1];

                if(mazeInt[cordY][cordX] == 0){
                    cords.add(new int[]{cordY, cordX});
                    mazeInt[cordY][cordX] = 3;
                }
            }
            if(cords.isEmpty()) return false;
            kateCords = cords.remove(0);
        }

    }
}