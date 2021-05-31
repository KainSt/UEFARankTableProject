import java.util.Arrays;

//этот класс должен обладать функционалом, чтобы построить таблицы по игре 2-3-n команд, названия которых известны.
// это требуестя для того, чтобы иметь возможность сравнивать команды с равными показателями.
public class TeamInQuestion {
     public static void teamInQuestSort(ResultOfTheGame[] arr) {
        teamInQuestSortScore(arr);
              }



        //Метод принимает пять параметров: исходный массив, позиция в индексе (с которой необходимо начать копирование элементов),
            // новый массив, позиция в индексе для начала вставки и количество копируемых элементов:
           // System.arraycopy(arr, 2, totalStatShort, position-count-1, count + 1);



        public static void teamInQuestSortScore (ResultOfTheGame[] arr){
            Arrays.sort(arr, new ScoreComparator());
        }



}

