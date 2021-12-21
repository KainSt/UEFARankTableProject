package JavaCollectionsFramework2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SortMaxPrint5 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        Set<Integer> intSet = new TreeSet<>();

        do {
            System.out.println("Write integer № " + (intSet.size()+1));
            intSet.add(Integer.parseInt(reader.readLine()));
        } while (intSet.size() != 10);

        for (Integer integer : intSet) {
            System.out.print(integer +" ");
        }
        System.out.println();

        Iterator<Integer> intSetItr = intSet.iterator();
        for (int i = 0; i < 10; i++) {

            if (i >= 5) {
            System.out.println(intSetItr.next());
            } else {
                intSetItr.next();
            }
        }


    }
}

