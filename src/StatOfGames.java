public class StatOfGames {
    //таблица итогов игр, заполняется по итогам каждого тура
   ResultOfTheGame[] homeStat, guestStat, totalStat;

      StatOfGames(){
      homeStat = new ResultOfTheGame[GameSchedule.qtyOfTeam];
      OneMatch Game = new OneMatch( "Home", "Guest", "Start");
      for (int i=0; i<GameSchedule.qtyOfTeam; i++){
          homeStat[i] = new ResultOfTheGame (Game, "Start");
      }
     // System.out.println( "Проверка");
          guestStat = new ResultOfTheGame[GameSchedule.qtyOfTeam];
          guestStat = homeStat;
          totalStat = new ResultOfTheGame[GameSchedule.qtyOfTeam];
          totalStat = homeStat;
           }


    static void addStat (ResultOfTheGame[] arr, ResultOfTheGame stat){
        for (int l = 0; l < GameSchedule.qtyOfTeam; l++){
            if (arr[l].homeTeamName == stat.homeTeamName){
                arr[l].gameScore += stat.gameScore;
                arr[l].goalScored += stat.goalScored;

            }
        }
    }

}



