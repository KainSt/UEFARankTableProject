package JavaCollectionsFramework2;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class DictionaryMap {
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

        System.out.println("Hugo " + getCountTheSameFirstName(map,"Hugo"));
        System.out.println("Paolo " + getCountTheSameFirstName(map,"Paolo"));
        System.out.println("Mauldin3 " + getCountTheSameLastName(map,"Mauldin3"));
        System.out.println("Mauldin4 " + getCountTheSameLastName(map,"Mauldin4"));
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

    static int getCountTheSameLastName(Map<String, String> map, String lastName){
        int count = 0;
        Iterator<Map.Entry<String,String>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            if (iterator.next().getKey().equals(lastName)) {
                count++;
            }
        }
        return  count;
    }

}
