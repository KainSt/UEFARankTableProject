package JavaCollectionsFramework2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class FiveSortArray {

    public static void main(String [] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        Set<Integer> intSet = new TreeSet<>();

        for (int i = 0; i < 5; i++) {
            System.out.println("Write integer № "+(i+1)+":");
            intSet.add(Integer.parseInt(reader.readLine()));
        }

        Iterator<Integer> intSetItr = intSet.iterator();
        int min = intSetItr.next();
        while (true){
            int max = intSetItr.next();
            if(intSetItr.hasNext()==false) {
                System.out.println("макс- " +max +", мин- "+ min);
                break;
            }
        }


    }
}
