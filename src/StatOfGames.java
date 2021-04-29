public class StatOfGames {
    //таблица итогов игр, заполняется по итогам каждого тура
    ResultOfTheGame[] homeStat, guestStat, totalStat;

  /*  StatOfGames(){
      homeStat = new ResultOfTheGame[GameSchedule.qtyOfTeam];
      guestStat = new ResultOfTheGame[GameSchedule.qtyOfTeam];
      totalStat = new ResultOfTheGame[GameSchedule.qtyOfTeam];
      String [] arr = GameSchedule.createGroup();
        for (int i = 0; i<GameSchedule.qtyOfTeam; i++){
            homeStat[i].homeTeamName = arr[i];
            guestStat[i].homeTeamName = arr[i];
            totalStat[i].homeTeamName = arr[i];
        }
           }

*/
    static void addStat (ResultOfTheGame[] arr, ResultOfTheGame stat  /*  String nameOfPlace*/){
        for (int l = 0; l < GameSchedule.qtyOfTeam; l++){
            if (arr[l].homeTeamName == stat.homeTeamName){
                arr[l].gameScore += stat.gameScore;
                arr[l].goalScored += stat.goalScored;

            }
        }
    }

}



