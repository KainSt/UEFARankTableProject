package JavaCollectionsFramework2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class SortWords5 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        Set<String> stringTreeSet = new TreeSet<>();

        do {
            System.out.println("Write word № " + (stringTreeSet.size()+1));
            stringTreeSet.add(reader.readLine());
        } while (stringTreeSet.size() != 5);

        for (String string : stringTreeSet) {
            System.out.println(string +" ");
        }
        System.out.println();




    }
}
