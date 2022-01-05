package JavaCollectionsFramework2;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BinarySearch {
    public static void main(String[] args) throws IOException {
        int[] intSet = new int[1000];
        for (int i = 0; i < 1000; i++) {
            intSet[i] = i;
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(reader.readLine());
        binSearch (intSet,0,999,s);


    }
    public static void binSearch(int[] arrSearch,int start, int finish, int s ){
        int middle = (int)((start+finish)/2);
        System.out.println("Start- "+ start + " / " + middle+" / "+ finish + " finish.");
        if(arrSearch[middle]==s){
            System.out.println( middle);
            System.out.println(arrSearch[middle]);
        } else {
            if (arrSearch[middle]<s){
                binSearch (arrSearch,middle,finish,s);
            } else {
                binSearch (arrSearch,start,middle,s);
            }

        }

    }
}
