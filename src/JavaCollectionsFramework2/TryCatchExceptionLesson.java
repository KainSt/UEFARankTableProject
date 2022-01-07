package JavaCollectionsFramework2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TryCatchExceptionLesson {
    public static void main(String[] args){
      try {
      int a = 42/0;
      } catch (ArithmeticException ex){
          System.out.println("a = 42/0  - ArithmeticException");
          System.out.println(ex);
          }
        System.out.println();
        String s = null;
        try {
            String m = s.toLowerCase();
             } catch (NullPointerException ex){
            System.out.println("m = s.toLowerCase()  - NullPointerException");
        }
        System.out.println();
        int[] m = new int[2];
        try {
            m[8] = 5;
        } catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("m[8] = 5  - ArrayIndexOutOfBoundsException");
        }
        System.out.println();
        List<String> list = new ArrayList<>();
        try {
            String sExc = list.get(18);
        } catch (IndexOutOfBoundsException ex){
            System.out.println("String sExc = list.get(18)  - IndexOutOfBoundsException");
        }

        System.out.println();
        try {
            Map<String, String> map = new HashMap<>(null);
            map.remove(null);
            map.put(null, null);
        } catch (NullPointerException ex){
            System.out.println("new HashMap<>(null) - NullPointerException");
        }


    }
}
