import java.util.Arrays;

//этот класс должен обладать функционалом, чтобы построить таблицы по игре 2-3-n команд, названия которых известны.
// это требуестя для того, чтобы иметь возможность сравнивать команды с равными показателями.
public class TeamInQuestion {
   ResultOfTheGame[] homeStatShort, guestStatShort, totalStatShort;

    public static void teamInQuestSort(ResultOfTheGame[] arr) {
        teamInQuestSortScore(arr);
        int count = 0;
        int position = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1].gameScore == arr[i].gameScore) {
                count++;
                position++;
              }
        }
        System.out.println("count " + count);
        if (count > 0) {
            ResultOfTheGame[] totalStatShort = new ResultOfTheGame[count + 1]; // нужно указать размерность массива
            //Метод принимает пять параметров: исходный массив, позиция в индексе (с которой необходимо начать копирование элементов),
            // новый массив, позиция в индексе для начала вставки и количество копируемых элементов:
            System.arraycopy(arr, 2, totalStatShort, position-count-1, count + 1);
            StatOfGames.showStat(totalStatShort);
            teamInQuestSortScore(totalStatShort);
            StatOfGames.showStat(totalStatShort);
        }
    }

        public static void teamInQuestSortScore (ResultOfTheGame[] arr){
            Arrays.sort(arr, new ScoreComparator());

        }



}

