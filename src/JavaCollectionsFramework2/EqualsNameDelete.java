package JavaCollectionsFramework2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class EqualsNameDelete {
    public static void main(String []ars){
        Map<String ,String> map = new HashMap<>();
        map.put("Rooney", "Leo");
        map.put("Loris", "Hugo");
        map.put("Messi", "Leo");
        map.put("Ronaldo", "Cristiano");
        map.put("Mauldin2", "Paolo");
        map.put("Mauldin1", "Paolo");
        map.put("Mauldin", "Paolo");
        map.put("Mauldin3", "Paolo");
        map.put("Indigo", "Pippo");
        map.put("Del Piero", "Alessandro");
        map.put("Ballot", "Mario");
        map.put("Gotz", "Mario");
        map.put("Gomez", "Mario");

        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            String s = iterator.next().getValue();
            while (iterator.hasNext()){

                if (iterator.next().getValue().equals(s)){
                    System.out.println(s);
                }
            }
        }

    }
}
