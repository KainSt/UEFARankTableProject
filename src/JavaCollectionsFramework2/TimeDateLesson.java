package JavaCollectionsFramework2;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

public class TimeDateLesson {
    public static void main(String[] args) {
        Date startTime = new Date(121, 11, 11, 0, 0);
        Date currentTime = new Date();
        System.out.println(
                (currentTime.getTime()-startTime.getTime())/1000/60/60 + " часов, "
                +
                        ( (currentTime.getTime()-startTime.getTime())/1000/60 -((currentTime.getTime()-startTime.getTime())/1000/60/60)*60)
                        + " минут.");


        LocalDate dateDay = LocalDate.now();
        LocalDate dateDayStart = LocalDate.of(2021, Month.JANUARY, 01);
        System.out.println(dateDay);
        System.out.println(dateDayStart);
        int i = 0;

        while (!dateDayStart.plusDays(i).equals(dateDay)){
             i++;
           // System.out.println(dateDayStart.plusDays(i));
        }
        System.out.println(i);
    }
}
