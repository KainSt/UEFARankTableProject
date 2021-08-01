import java.util.Arrays;

//этот класс должен обладать функционалом, чтобы построить таблицы по игре 2-3-n команд, названия которых известны.
// это требуестя для того, чтобы иметь возможность сравнивать команды с равными показателями.
public class TeamInQuestion {
     public static void teamInQuestSort(ResultOfTheGame[] arr) {
        teamInQuestSortScore(arr);
        //нужно написать модуль, который будет вытаскивать имена повторяющихся команд с одинковым кол-вом очков, чтобы далее
         int [] countTable = new int[GameSchedule.qtyOfTeam];

         for (int i = 0; i < countTable.length; i++){
             for (int k = 0; k<countTable.length;k++){
                 if (arr[i].gameScore == arr[k].gameScore ) {
                     countTable[i]++;
                 }
             }
         }

       for (int i = 0; i<countTable.length;i++){
             System.out.println(countTable[i]);
         }

       for (int i = 0; i< countTable.length; i++){
            if (countTable[i] > 1){
                int f = i;
                new GameSchedule(countTable[i]);
                String [] localTable = new String[countTable[i]];
                for (int l=0; l<countTable[i];l++) {
                    localTable[l] = arr[i].homeTeamName;
                    i++;
                }
                StatOfGames matchArrSort = new StatOfGames();
                for (int x =0; x < localTable.length;x++)   {
                    //создаем группу
                    matchArrSort.homeStat[x].homeTeamName = localTable[x];
                    matchArrSort.guestStat[x].homeTeamName = localTable[x];
                    matchArrSort.totalStat[x].homeTeamName = localTable[x];
                    System.out.println(localTable[x]);

                }
                i = f+countTable[f];
                }
            }
        }


         // из листофГеймРезалт собрать только по ним массив, размер которого будет ограничен кол-вом повторюше
         // этот массив заполнить через StatOfGames.addStat(matchArr, listOfGameResult[i][k]);
         // отсортировать полученный массив по всем правилам (если больше 3х команд повторителей, то еще раз повторить выборку для создания массива
         // вывести на экран итог по командам
         // произвести замену блоков в массиве, НЕ меняя значения!!!!
//}



        //Метод принимает пять параметров: исходный массив, позиция в индексе (с которой необходимо начать копирование элементов),
            // новый массив, позиция в индексе для начала вставки и количество копируемых элементов:
           // System.arraycopy(arr, 2, totalStatShort, position-count-1, count + 1);



        public static void teamInQuestSortScore (ResultOfTheGame[] arr){
            Arrays.sort(arr, new ScoreComparator());
        }



}

