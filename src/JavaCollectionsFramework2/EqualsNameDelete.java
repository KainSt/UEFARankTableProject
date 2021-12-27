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
            Map.Entry<String, String> element = iterator.next();
            String s = element.getValue();
            if (getCountTheSameFirstName(map, s)>1){
              cleanElement (map, s);
                iterator = map.entrySet().iterator();
            }

        }

        iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

    static int getCountTheSameFirstName(Map<String, String> map, String name){
        int count = 0;
        Iterator<Map.Entry<String,String>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            if (iterator.next().getValue().equals(name)) {
                count++;
            }
        }
        return  count;
    }

    static void cleanElement (Map<String, String> map, String name){
        Iterator<Map.Entry<String,String>> iterator2 = map.entrySet().iterator();


        while (iterator2.hasNext()) {
        Map.Entry<String,String> elementDelete = iterator2.next();

            if (elementDelete.getValue().equals(name)){
                map.remove(elementDelete.getKey());
                iterator2 = map.entrySet().iterator();
            }

        }

    }
}
