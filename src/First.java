import java.io.FileNotFoundException;

public class First {



    public static void main (String[] args)
    {
        String[] array = {"1.txt","2.txt","3.txt"};
        int rows = 0;
        long timeBefore = System.currentTimeMillis();
        for (String s : array) {
            try {
                Files file = new Files(s);
                file.countRows();
                System.out.println(file.getNewLineCounter());
            } catch (FileNotFoundException e) {
                System.out.println("Nie ma pliku o nazwie " + s);
            }
        }
        long timeAfter = System.currentTimeMillis();
        long time = timeAfter - timeBefore;
        System.out.println("Time: " + time);
    }
}
