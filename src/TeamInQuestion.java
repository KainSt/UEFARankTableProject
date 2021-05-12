import java.util.Arrays;

//этот класс должен обладать функционалом, чтобы построить таблицы по игре 2-3-n команд, названия которых известны.
// это требуестя для того, чтобы иметь возможность сравнивать команды с равными показателями.
public class TeamInQuestion {
    ResultOfTheGame[] homeStatShort, guestStatShort, totalStatShort;

    public static void teamInQuestSort(ResultOfTheGame[] arr){
        teamInQuestSortScore(arr);
        ResultOfTheGame[] totalStatShort = new ResultOfTheGame[GameSchedule.qtyOfTeam]; // нужно указать размерность массива
        for (int i=1; i< arr.length;i++){
            if (arr[i-1].gameScore==arr[i].gameScore){
                System.out.println("equality of point!! " + arr[i-1].homeTeamName + " - " + arr[i].homeTeamName);
                totalStatShort[i-1] = arr[i-1];
                totalStatShort[i] = arr[i];
            }
         //   teamInQuestSortScore(totalStatShort);
            //  StatOfGames.showStat(totalStatShort);
        }
    }

    public static void teamInQuestSortScore(ResultOfTheGame[] arr){
        Arrays.sort(arr, new ScoreComparator());

    }



}

