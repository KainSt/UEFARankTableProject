package JavaCollectionsFramework2;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DateMap {
    public static void main(String []ars){
        Map<String , Date> map = new HashMap<>();

        map.put("Jhon", new Date("JUNE 1 1980"));
        map.put("Mark", new Date("JUNE 5 1999"));
        map.put("Elon", new Date("DECEMBER 13 1996"));
        map.put("Steve", new Date("JUNE 1 1980"));
        map.put("Clark", new Date("MARCH 1 1980"));




        Iterator<Map.Entry<String,Date>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println();
        iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Date> element = iterator.next();
            int month = element.getValue().getMonth();

            if ((month <=7)&(month >=5)){
                map.remove(element.getKey());
                iterator = map.entrySet().iterator();
            }
        }
        iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
