package JavaCollectionsFramework2;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class StringWork {
    public static void main(String[] args) throws IOException {
        Set<String> stringSet = new HashSet<>();
        Set<String> dblStringSet = new HashSet<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        do{
            System.out.println("Write string:");
            String s = reader.readLine();
            if (s.equals(" ")) {
                break;
            } else {
                stringSet.add(s);
            }
        } while (true);

        for (String s : stringSet) {
            System.out.println(s);
        }

        doubleSet(stringSet, dblStringSet);
        System.out.println();
        for (String s : dblStringSet) {
            System.out.println(s);
        }
    }


    static void doubleSet(Set<String> setList,Set<String> dblSetList){

        for (String s : setList) {
            if (s.length() % 2==0) {
                dblSetList.add( s + " " + s);
            } else {
                dblSetList.add(s+ " " +s+ " " + s);
            }


        }
    }


}
