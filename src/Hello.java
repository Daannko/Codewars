import java.sql.SQLOutput;
import java.lang.StringBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hello {
    public static void main(String[] args) {
        double b = 4.4;
    }

    public List<Integer> findDuplicates(List<Integer> integers, int numberOfDuplicates) {
        Map<Integer, Integer> dupplicates = new HashMap<Integer, Integer>();
        ArrayList<Integer> output = new ArrayList<>();

        for (Integer i : integers) {
            if (i == null) continue;
            if (dupplicates.containsKey(i)) {
                int temp = dupplicates.get(i);
                dupplicates.put(i, temp + 1);
            } else {
                dupplicates.put(i, 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : dupplicates.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (value.equals(numberOfDuplicates)) {
                output.add(key);
            }
        }
        return output;
    }
}