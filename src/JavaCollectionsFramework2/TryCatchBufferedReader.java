package JavaCollectionsFramework2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class TryCatchBufferedReader {
    /*
Вводить с клавиатуры числа. Код по чтению чисел с клавиатуры вынести в отдельный метод readData.
Обернуть все тело (весь код внутри readData, кроме объявления списка, где будут храниться числа и BufferedReader-а)
этого метода в try..catch.
Если пользователь ввёл какой-то текст, вместо ввода числа,
то метод должен перехватить исключение и вывести на экран все введенные числа в качестве результата.
Числа выводить с новой строки сохраняя порядок ввода.
*/


    public static void main(String[] args){
        readData();
    }

    public static void readData(){
        Set<Integer> intSet = new LinkedHashSet<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            while (true){
                intSet.add(Integer.parseInt(reader.readLine()));
            }

        } catch (NumberFormatException | IOException ex){
            Iterator<Integer> integerIterator = intSet.iterator();
            while (integerIterator.hasNext()){
                System.out.print(integerIterator.next()+" ");
            }
        }
    }
}
