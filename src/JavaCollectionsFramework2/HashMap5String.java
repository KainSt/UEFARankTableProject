package JavaCollectionsFramework2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMap5String {

    public static void main (String args[]){
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("id1","first");
        stringStringHashMap.put("id2","second");
        stringStringHashMap.put("id3","third");
        stringStringHashMap.put("id4","fourth");

        Iterator<Map.Entry<String, String>> iterator = stringStringHashMap.entrySet().iterator();

        while (iterator.hasNext()){
            Map.Entry<String, String> element = iterator.next();
            System.out.println(element.getKey() + " - " + element.getValue());
        }
        printKeys(stringStringHashMap);
        printValues(stringStringHashMap);
    }

    static void printKeys(HashMap<String, String> map) {
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        System.out.println("printKeys");
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getKey());
        }
    }

    static void printValues(HashMap<String, String> map){
    Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        System.out.println("printValues");
            while (iterator.hasNext()){
                System.out.println(iterator.next().getValue());
            }
    }
}
