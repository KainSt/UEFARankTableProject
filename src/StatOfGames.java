public class StatOfGames {
    //таблица итогов игр, заполняется по итогам каждого тура
      ResultOfTheGame[] homeStat, guestStat, totalStat;

      StatOfGames(){

      OneMatch Game = new OneMatch( "Home", "Guest", "Start");

      homeStat = new ResultOfTheGame[GameSchedule.qtyOfTeam];
      for (int i=0; i<GameSchedule.qtyOfTeam; i++){
          homeStat[i] = new ResultOfTheGame (Game, "Start");
      }

      guestStat = new ResultOfTheGame[GameSchedule.qtyOfTeam];
      for (int i=0; i<GameSchedule.qtyOfTeam; i++){
          guestStat[i] = new ResultOfTheGame (Game, "Start");
      }

      totalStat = new ResultOfTheGame[GameSchedule.qtyOfTeam];
      for (int i=0; i<GameSchedule.qtyOfTeam; i++){
          totalStat[i] = new ResultOfTheGame (Game, "Start");
      }
      }


    static void addStat (StatOfGames arr, ResultOfTheGame stat) {
        switch (stat.placeOfMatch) {
            case ("Home"):
                for (int l = 0; l < GameSchedule.qtyOfTeam; l++) {
                    if (arr.homeStat[l].homeTeamName == stat.homeTeamName) {
                        arr.homeStat[l].gameScore += stat.gameScore;
                        arr.homeStat[l].goalScored += stat.goalScored;
                        arr.homeStat[l].goalMissed += stat.goalMissed;
                    }
                }
                break;
            case ("Guest"):
                for (int l = 0; l < GameSchedule.qtyOfTeam; l++) {
                    if (arr.guestStat[l].homeTeamName == stat.guestTeamName) {
                        arr.guestStat[l].gameScore += stat.gameScore;
                        arr.guestStat[l].goalScored += stat.goalScored;
                        arr.guestStat[l].goalMissed += stat.goalMissed;
                    }
                }
                break;


        }
        for (int l = 0; l < GameSchedule.qtyOfTeam; l++) {
            arr.totalStat[l].gameScore = arr.homeStat[l].gameScore + arr.guestStat[l].gameScore;
            arr.totalStat[l].goalScored = arr.homeStat[l].goalScored + arr.guestStat[l].goalScored;
            arr.totalStat[l].goalMissed = arr.homeStat[l].goalMissed + arr.guestStat[l].goalMissed;
        }
    }

    static void showStat (ResultOfTheGame[] arr){
          for (int i = 0; i<GameSchedule.qtyOfTeam; i++){
              System.out.println(arr[i].homeTeamName + " ГЗ-" + arr[i].goalScored
                      + ", ГП-" + arr[i].goalMissed +  ", Score: " + arr[i].gameScore);
          }
        System.out.println();
    }

}





