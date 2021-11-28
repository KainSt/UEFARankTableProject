package JavaCollectionsFramework2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HWArrayIter {
    public static void main (String [] args) {
        List<String> listOfString = new ArrayList<>();
        //Arrays.asList(new String[]{"1","2","3","4","5"});
        listOfString.add("1");
        listOfString.add("2");
        listOfString.add("3");
        listOfString.add("4");
        listOfString.add("5");

        printList(listOfString);

        for (int i = 1; i < 5; i++) {
       listOfString.add(listOfString.get(listOfString.size()-1));
            printList(listOfString);

            for (int k = (listOfString.size()-2); k > 0; k--){
                listOfString.set(k,listOfString.get(k-1));
                printList(listOfString);
            }
            listOfString.remove(listOfString.size()-1);
            printList(listOfString);
        }

    }

    public static void printList(List list){
        System.out.println();
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

    }
}
