package JavaCollectionsFramework2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class NumberMonth {


    public static void main(String []args) throws IOException {
        Map<String, Integer> map = new HashMap<>();
        map.put("jan",1);
        map.put("feb",2);
        map.put("mar",3);
        map.put("apr",4);
        map.put("may",5);
        map.put("jun",6);
        map.put("jul",7);
        map.put("aug",8);
        map.put("sep",9);
        map.put("oct",10);
        map.put("nov",11);
        map.put("dec",12);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while (true) {

            do {
                s = reader.readLine();
                if (s.equals(" ")){
                    break;
                }
            } while (!map.containsKey(s));
            if (!s.equals(" ")){
                System.out.println(s + " is " + map.get(s) + " month.");
            } else {
                break;
            }

        }
    }



}
