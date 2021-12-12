package JavaCollectionsFramework2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class LightString {

    public static void main(String [] args) throws IOException {
        Set<String> stringSet = new HashSet<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        do {
            System.out.println("Write string:");
            String s = reader.readLine();
            if (s.equals("end")) {
                break;
            } else {
                stringSet.add(s);
            }
        } while (true);
        System.out.println();
        for (String s : stringSet) {
            System.out.println(s);
        }
    }
}
