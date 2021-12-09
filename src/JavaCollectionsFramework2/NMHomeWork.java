package JavaCollectionsFramework2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class NMHomeWork {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Write N number:");
        int n = (Integer.parseInt(reader.readLine()));
        System.out.println("Write M number:");
        int m = (Integer.parseInt(reader.readLine()));

        Set<String> stringSet = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            System.out.println("Write string № "+(i+1)+":");
            stringSet.add(reader.readLine());
        }

       // Iterator<String> itOfStringSet = stringSet.iterator();
        for (String s : stringSet) {
            System.out.print(s +" ");
        }
        System.out.println();
        for (int i = 0; i < m; i++) {
            Iterator<String> itOfStringSet = stringSet.iterator();
            String s = itOfStringSet.next();
            stringSet.remove(s);
            stringSet.add(s);

        }

        for (String s : stringSet) {
            System.out.print(s +" ");
        }

    }
}
