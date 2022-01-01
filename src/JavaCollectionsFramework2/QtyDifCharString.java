package JavaCollectionsFramework2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;


public class QtyDifCharString {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<Character, Integer> alphabetMap = new TreeMap<>();

        for (int i = 1; i < 6; i++) {
            System.out.println("Write word № " + i);
            char[] result = reader.readLine().toCharArray();

            for (int k = 0; k < result.length; k++) {
               if (alphabetMap.containsKey(result[k])) {
                    alphabetMap.put(result[k], alphabetMap.get(result[k]) + 1);
                } else {
                    alphabetMap.put(result[k], 1);
                }
            }
        }
        Iterator<Map.Entry<Character, Integer>> iterator = alphabetMap.entrySet().iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}

