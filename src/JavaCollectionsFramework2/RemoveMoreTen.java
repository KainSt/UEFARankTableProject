package JavaCollectionsFramework2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class RemoveMoreTen {
    public static void main(String[] args){

        Set<Integer> numberSet = new HashSet<>();
        do {
            numberSet.add((int) (25*Math.random()));
        } while (numberSet.size()!=5);

        for (Integer a: numberSet) {
            System.out.println(a);
        }
        System.out.println();
        removeAllNumbersMoreThan10(numberSet);


        for (Integer a: numberSet) {
            System.out.println(a);
        }
    }

    static void removeAllNumbersMoreThan10(Set<Integer> integerSet){
        Iterator<Integer> iterator = integerSet.iterator();
        while (iterator.hasNext()){

            int l = iterator.next();
          if  (l>10){
              integerSet.remove(l);
              iterator = integerSet.iterator();
          }
        }
    }


}
