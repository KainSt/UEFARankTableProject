package JavaCollectionsFramework2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;


public class NumberHomeWork {
    public static void main(String[] args) throws IOException {
        Set<Integer> intSet = new LinkedHashSet<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        for (int i = 0; i < 7; i++) {
           System.out.println("Write int number:");
           intSet.add(Integer.parseInt(reader.readLine()));
            }

        for (int s : intSet) {
            System.out.print(s+"  ");
        }
        System.out.println();


        for (int i = 0; i < intSet.size(); i++) {
            Iterator<Integer> itOfIntSet = intSet.iterator();
           for (int j = 0; j < intSet.size()-i; j++) {
                int k = itOfIntSet.next();
               if(j+1==intSet.size()-i) {
                   System.out.print(k+"  ");
               }

           }

        }

    }




    }

