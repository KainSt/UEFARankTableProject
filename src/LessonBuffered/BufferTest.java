package LessonBuffered;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferTest {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
     while (true){
    String s0 = reader.readLine();
         System.out.println(s0);
         if (s0.equals("End")){
           break;
         }
    }


            }


        }


