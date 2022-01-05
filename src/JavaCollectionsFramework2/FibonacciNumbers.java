package JavaCollectionsFramework2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Map;
import java.util.TreeMap;

public class FibonacciNumbers {

    public static void main(String [] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer,BigInteger> fibonacciMap = new TreeMap();
        String s= reader.readLine();
        while (!s.equals(" ")){
        fibonacciMap.put(Integer.parseInt(s),fibonacci(Integer.parseInt(s),fibonacciMap));
        System.out.println(fibonacciMap.get(Integer.parseInt(s)));
        s= reader.readLine();
        }

    }


    public static BigInteger fibonacci(int n, Map fMap){
        if (fMap.containsKey(n)){
            return (BigInteger) fMap.get(n);
        }
        if (n==1) {
            fMap.put(n,BigInteger.ZERO);
            return BigInteger.ZERO;
        }
        if (n==2) {
           fMap.put(n,BigInteger.ONE);
           return BigInteger.ONE;
       } else {
           return fibonacci(n-2,fMap).add(fibonacci(n-1,fMap));
       }
    }


}
