package JavaCollectionsFramework2;


import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class DataHomeWork {
    static public void main(String[] args) {

        List<String> setArr = new ArrayList();
        for (int i = 1; i < 10000; i++) {
            setArr.add(" ");
        }
        Date startDate = new Date();
        for (int i = 1000; i < 6000; i++) {
            setArr.set(500, "{}");
        }
        Date finishDate = new Date();
        System.out.println(finishDate.getTime() - startDate.getTime());


        List<String> setArr2 = new LinkedList();
        for (int i = 1; i < 10000; i++) {
            setArr2.add(" ");
        }
        Date startDate2 = new Date();
        for (int i = 1000; i < 6000; i++) {
            setArr2.set(500, "{}");
        }
        Date finishDate2 = new Date();
        System.out.println(finishDate2.getTime()-startDate2.getTime());


        List<String> setArr3 = new ArrayList();
        for (int i = 1; i < 10000; i++) {
            setArr3.add(" ");
        }
        Date startDate3 = new Date();
        for (int i = 0; i < 5000; i++) {
            setArr3.remove(500);
        }
        Date finishDate3 = new Date();
        System.out.println(finishDate3.getTime() - startDate3.getTime());


        List<String> setArr4 = new LinkedList();
        for (int i = 1; i < 10000; i++) {
            setArr4.add(" ");
        }
        Date startDate4 = new Date();
        for (int i = 0; i < 5000; i++) {
            setArr4.remove(500);
        }
        Date finishDate4 = new Date();
        System.out.println(finishDate4.getTime() - startDate4.getTime());
    }


}

