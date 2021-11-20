package JavaCollectionsFramework2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class HomeWorkArrayList {

public  static void main(String args[]) throws IOException {

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

    List<Integer> console5Array = new ArrayList<>();
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
    }

}


}
