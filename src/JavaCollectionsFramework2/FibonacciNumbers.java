package JavaCollectionsFramework2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;


public class FibonacciNumbers {

    public static void main(String [] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LocalTime start = LocalTime.now();
        System.out.println(fibonacci(Integer.parseInt(reader.readLine()),start));
    }

    public static int fibonacci(int n,LocalTime start){
        LocalTime now = LocalTime.now();;
        if ((now.getSecond()- start.getSecond())>10){
            System.out.println("Error");
            return 0;
        }
        if (n==1) {
            return 1;
        }
        if (n==2) {
           return 1;
       } else {
           return fibonacci(n-2,start) +fibonacci(n-1,start);
       }
    }


}
