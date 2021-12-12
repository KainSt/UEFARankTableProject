package JavaCollectionsFramework2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class NumberReverse {

    public static void main(String[] args) throws IOException {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input integer :");
        String stringNum = reader.readLine();

        int straightNum = (Integer.parseInt(stringNum));

        List<Integer> straightNumList = new ArrayList<>();

        for (int i = 0; i <stringNum.length() ; i++) {
         straightNumList.add(straightNum % 10);
            straightNum = (straightNum - (straightNum % 10)) / 10;
            }

        int reverseNum = 0;
        for (int i = 0; i < straightNumList.size() ; i++) {
            reverseNum = reverseNum + (int)(straightNumList.get(i)*Math.pow(10,straightNumList.size()-i-1));
        }

        System.out.println("straightNum - " + stringNum + ", reverseNum - "+reverseNum);
    }
   }


