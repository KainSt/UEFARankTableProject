package JavaCollectionsFramework2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeWorkArrayList {

    public static void main(String args[]) throws IOException {

   /* List<Integer> console5Array = new ArrayList<>();
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    for (int i = 0; i < 5; i++) {
        console5Array.add(Integer.parseInt(reader.readLine()));
    }
    for (int s:console5Array) {
        System.out.print(s + " ");
    }
    System.out.println();
    for (int i = 0; i < console5Array.size() ; i++) {

     System.out.print( console5Array.get(i)+ " ");
    }*/

   /* List<Integer> console5Array = new ArrayList<>();
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String s;
    do{
        s =reader.readLine();
        if (s.equals(" ")) {
            break;
        } else {
            console5Array.add(Integer.parseInt(s));
        }
    } while (true);

    for (int i = 0; i < console5Array.size() ; i++) {
     System.out.print( console5Array.get(i)+ " ");
    }*/

   /* List<Integer> console5Array = new ArrayList<>();
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String s;
    do{
        s =reader.readLine();
        if (s.equals(" ")) {
            break;
        } else {
            if (Integer.parseInt(s) % 2 == 0) {
                console5Array.add(console5Array.size(),Integer.parseInt(s));
            } else {
                console5Array.add(0,Integer.parseInt(s));
            }
        }
    } while (true);

    for (int i = 0; i < console5Array.size() ; i++) {
        System.out.print( console5Array.get(i)+ " ");
    }
    int j =0;
    do {
        if (console5Array.get(j)>5){
            console5Array.remove(j);
            j=0;
        } else {
            j++;
        }
    } while (j<console5Array.size());
    System.out.println();
    for (int i = 0; i < console5Array.size() ; i++) {
        System.out.print( console5Array.get(i)+ " ");
    }*/

       /* List<Integer> console5Array = new ArrayList<>();
        List<Integer> console2 = new ArrayList<>();
        List<Integer> console3 = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        do {
            s = reader.readLine();
            if (s.equals(" ")) {
                break;
            } else {
                console5Array.add(Integer.parseInt(s));
            }
        } while (true);
        for (int i = 0; i < console5Array.size(); i++) {
            if (console5Array.get(i) % 2 == 0){
                console2.add(console5Array.get(i));
            } else {
                console3.add(console5Array.get(i));
            }
        }
        for (int i = 0; i < console5Array.size() ; i++) {
            System.out.print( console5Array.get(i)+ " ");
        }
        System.out.println();
        for (int i = 0; i < console2.size() ; i++) {
            System.out.print( console2.get(i)+ " ");
        }
        System.out.println();
        for (int i : console3) {
            System.out.print( i+ " ");
        }*/
        /*List<String> console5Array = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        do {
            s = reader.readLine();
            if (s.equals(" ")) {
                break;
            } else {
                console5Array.add(s);
            }
        } while ((true)&(console5Array.size()!=5));
        int max = console5Array.get(0).length();
        for (int i = 1; i <console5Array.size(); i++) {
          if (console5Array.get(i).length()>=max){
              max = console5Array.get(i).length();
          }
        }
        System.out.println();
        for (int i = 0; i <console5Array.size(); i++) {
            if (console5Array.get(i).length()==max){
                System.out.println(console5Array.get(i));
            }
        }*/

        List<String> console5Array = List.of("12345", "12345", "12345");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        do {
            s = reader.readLine();
            if (s.equals(" ")) {
                break;
            } else {
                console5Array.add(s);
            }
        } while ((true) & (console5Array.size() != 7));
        int min = console5Array.get(0).length();

        for (int i = 1; i < console5Array.size(); i++) {
            if (console5Array.get(i).length() <= min) {
                min = console5Array.get(i).length();
            }
        }

        System.out.println();
        for (int i = 0; i < console5Array.size(); i++) {
            if (console5Array.get(i).length() == min) {
                System.out.println(console5Array.get(i));
            }
        }
        /*List<Integer> console5Array = new ArrayList<>();
        List<Integer> console2 = new ArrayList<>();
        List<Integer> console3 = new ArrayList<>();
        List<Integer> console4 = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        do {
            s = reader.readLine();
            if (s.equals(" ")) {
                break;
            } else {
                console5Array.add(Integer.parseInt(s));
            }
        } while (console5Array.size() != 6);

        for (int i = 0; i < console5Array.size(); i++) {
            if (console5Array.get(i) % 2 == 0){
                console2.add(console5Array.get(i));
            }
            if (console5Array.get(i) % 3 == 0){
                console3.add(console5Array.get(i));
            }
            if ((console5Array.get(i) % 2 != 0)&(console5Array.get(i) % 3 != 0)){
                console4.add(console5Array.get(i));
            }

        }
        printList(console2);
        printList( console3);
        printList( console4);
    }*/
    }
        public static void printList(List list){
            System.out.println();
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }

        }

}