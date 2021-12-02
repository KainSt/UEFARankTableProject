package JavaCollectionsFramework2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class HWArrayIter {
    public static void main (String [] args) {
        /*List<String> listOfString = new ArrayList<>();
        //Arrays.asList(new String[]{"1","2","3","4","5"});
        listOfString.add("1");
        listOfString.add("2");
        listOfString.add("3");
        listOfString.add("4");
        listOfString.add("5");

        printList(listOfString);

        for (int i = 1; i <= 7; i++) {
       listOfString.add(listOfString.get(listOfString.size()-1));
            System.out.println("");
      // printList(listOfString);

       for (int k = (listOfString.size()-1); k > 0; k--){
                listOfString.set(k,listOfString.get(k-1));
                //printList(listOfString);
            }
       listOfString.set(0,listOfString.get(listOfString.size()-1));
       listOfString.remove(listOfString.size()-1);
      printList(listOfString);
        }*/

        /*List<String> listOfString = new ArrayList<>();
        listOfString.add("1");
        listOfString.add("2");
        listOfString.add("3");
        listOfString.add("4");
        listOfString.add("5");

        printList(listOfString);
        System.out.println();
        listOfString.remove(2);


       for (int k = (listOfString.size()-1); k >= 0; k--){
           System.out.print(listOfString.get(k)+" ");
           }*/
        List<String> listOfString = new ArrayList<>();

        listOfString.add("лира");
        listOfString.add("лоза");
        listOfString.add("роза");
       /* listOfString.add("поролон");
        listOfString.add("лень");
        listOfString.add("лань");
        listOfString.add("бронь");
        listOfString.add("схрон");*/


        printList(listOfString);
        System.out.println();
       fix(listOfString);
       printList(listOfString);

        }

    public static void fix(List<String> list){
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()) {
          String element = iterator.next();
          if (element.contains("р")&element.contains("л")) {
              continue;
                 }

          if (element.contains("р")) {
              iterator.remove();
              }


        }

         for(int i = 0; i< list.size();i++){
         if (list.get(i).contains("р")&list.get(i).contains("л")) {
                continue;
            }

            if (list.get(i).contains("л")) {
                list.add(i,list.get(i));
                i++;
            }


        }

         }



    public static void printList(List list){
        System.out.println();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i) + " ");
        }

    }
}
