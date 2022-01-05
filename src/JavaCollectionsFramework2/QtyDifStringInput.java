package JavaCollectionsFramework2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class QtyDifStringInput {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> alphabetMap = new TreeMap<>();

        for (int i = 1; i < 6; i++) {
            System.out.println("Write word № " + i);
            String result = reader.readLine();


                if (alphabetMap.containsKey(result)) {
                    alphabetMap.put(result, alphabetMap.get(result) + 1);
                } else {
                    alphabetMap.put(result, 1);
                }

        }
        Iterator<Map.Entry<String, Integer>> iterator = alphabetMap.entrySet().iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
