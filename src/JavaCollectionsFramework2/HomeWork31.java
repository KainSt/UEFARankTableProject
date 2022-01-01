package JavaCollectionsFramework2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HomeWork31 {

    public static void main(String[] args) throws IOException {
        /* int [] arrayLesson =  {1, 2, 3, 1, 4, 5, 7, 5, 6, 2, 4, 7, 6};
        for (int r:arrayLesson
             ) {
            System.out.print(r +" ");
        }
        System.out.println();
        for (int i = 0; i < arrayLesson.length; i++) {
           boolean doubleArray = true;
            for (int j = 0; j < arrayLesson.length; j++) {
                if ( (arrayLesson[i]==arrayLesson[j])&&(i!=j)) {
                    doubleArray =false;
                }
                           }
            if (doubleArray) {
                System.out.println(arrayLesson[i]);
            }
        }
*/
      /*  int[] array5 = new int[5];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < array5.length; i++) {
           array5[i] = Integer.parseInt(reader.readLine());
        }
        Arrays.sort(array5);
        for (int r : array5
        ) {
            System.out.print(r + " ");
        }
        System.out.println();
        System.out.println("Минимальное значение - " + minArrElement(array5) + ", максимальное значение - " + maxArrElement(array5));
*/

        int [] arrayLostInt = new int[(int) (Math.random()*25)];

        for (int i = 1; i < arrayLostInt.length; i++) {
            arrayLostInt[i]=i;
            System.out.print(arrayLostInt[i] + "-");
           }
        System.out.println();
        arrayLostInt[(int) (Math.random()*(arrayLostInt.length))] = 0;
        for (int i = 1; i < arrayLostInt.length; i++) {

            System.out.print(arrayLostInt[i] + "-");
        }
        System.out.println();
        for (int i = 2; i < arrayLostInt.length; i++) {
            if(-arrayLostInt[i-1]+arrayLostInt[i]!=1){
                System.out.println(arrayLostInt[i-1]+1);
                break;
            }
        }
    }

    static int maxArrElement(int[] arr) {
        int max = arr[0];
        for (int k = 1; k < arr.length; k++) {
            if (arr[k] > max) {
                max = arr[k];
            }
        }
        return max;
    }

    static int minArrElement(int[] arr) {
        int min = arr[0];
        for (int k = 1; k < arr.length; k++) {
            if (arr[k] < min) {
                min = arr[k];
            }
        }
        return min;
    }
}

