public class StatOfGames {
    //таблица итогов игр, заполняется по итогам каждого тура
      ResultOfTheGame[] homeStat, guestStat, totalStat;

      StatOfGames(){
      homeStat = new ResultOfTheGame[GameSchedule.qtyOfTeam];
      OneMatch Game = new OneMatch( "Home", "Guest", "Start");
      for (int i=0; i<GameSchedule.qtyOfTeam; i++){
          homeStat[i] = new ResultOfTheGame (Game, "Start");
      }
          guestStat = new ResultOfTheGame[GameSchedule.qtyOfTeam];
          guestStat = homeStat;
          totalStat = new ResultOfTheGame[GameSchedule.qtyOfTeam];
          totalStat = homeStat;
           }


    static void addStat (ResultOfTheGame[] arr, ResultOfTheGame stat){
        switch ( stat.placeOfMatch) {
            case ("Home"):
            for (int l = 0; l < GameSchedule.qtyOfTeam; l++) {
                if (arr[l].homeTeamName == stat.homeTeamName) {
                    arr[l].gameScore += stat.gameScore;
                    arr[l].goalScored += stat.goalScored;
                    arr[l].goalMissed += stat.goalMissed;
                    }
            }
                break;
                case ("Guest"):
                    for (int l = 0; l < GameSchedule.qtyOfTeam; l++) {
                        if (arr[l].guestTeamName == stat.guestTeamName) {
                            arr[l].gameScore += stat.gameScore;
                            arr[l].goalScored += stat.goalScored;
                            arr[l].goalMissed += stat.goalMissed;
                        }
                    }
                        break;

            }
        }
    static void showStat (ResultOfTheGame[] arr){
          for (int i = 0; i<GameSchedule.qtyOfTeam; i++){
              System.out.println(arr[i].homeTeamName + /*" ГЗ-" + arr[i].goalScored
                      + ", ГП-" + arr[i].goalMissed +  */", Score: " + arr[i].gameScore);
          }
        System.out.println();
    }

}





