import org.jetbrains.annotations.NotNull;

public class StatOfGames {
    //таблица итогов игр, заполняется по итогам каждого тура
      ResultOfTheGame[] homeStat, guestStat, totalStat;

      StatOfGames(){/// это нужно для того, чтобы массивы не были пустыми, без данной процедуры null не позволяет присваивать новые значения

      OneMatch Game = new OneMatch( "Home", "Guest", "Start");

      homeStat = new ResultOfTheGame[GameSchedule.qtyOfTeam];
      for (int i=0; i<GameSchedule.qtyOfTeam; i++){
          homeStat[i] = new ResultOfTheGame (Game, "Start");// заполняем нулями.
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
                        arr.homeStat[l].winMatch+= stat.winMatch;
                        arr.homeStat[l].drawMatch+= stat.drawMatch;
                        arr.homeStat[l].looseMatch+= stat.looseMatch;
                        arr.homeStat[l].qtyYellowCard+= stat.qtyYellowCard;
                        arr.homeStat[l].qtyRedCard+= stat.qtyRedCard;
                        arr.homeStat[l].goalScoredPen+= stat.goalScoredPen;
                        arr.homeStat[l].goalMissedPen+= stat.goalMissedPen;
                    }
                }
                break;
            case ("Guest"):
                for (int l = 0; l < GameSchedule.qtyOfTeam; l++) {
                    if (arr.guestStat[l].homeTeamName == stat.guestTeamName) {
                        arr.guestStat[l].gameScore += stat.gameScore;
                        arr.guestStat[l].goalScored += stat.goalScored;
                        arr.guestStat[l].goalMissed += stat.goalMissed;
                        arr.guestStat[l].winMatch+= stat.winMatch;
                        arr.guestStat[l].drawMatch+= stat.drawMatch;
                        arr.guestStat[l].looseMatch+= stat.looseMatch;
                        arr.guestStat[l].qtyYellowCard+= stat.qtyYellowCard;
                        arr.guestStat[l].qtyRedCard+= stat.qtyRedCard;
                        arr.guestStat[l].goalScoredPen+= stat.goalScoredPen;
                        arr.guestStat[l].goalMissedPen+= stat.goalMissedPen;
                    }
                }
                break;


        }
        for (int l = 0; l < GameSchedule.qtyOfTeam; l++) {
            arr.totalStat[l].gameScore = arr.homeStat[l].gameScore + arr.guestStat[l].gameScore;
            arr.totalStat[l].goalScored = arr.homeStat[l].goalScored + arr.guestStat[l].goalScored;
            arr.totalStat[l].goalMissed = arr.homeStat[l].goalMissed + arr.guestStat[l].goalMissed;
            arr.totalStat[l].winMatch = arr.homeStat[l].winMatch + arr.guestStat[l].winMatch;
            arr.totalStat[l].drawMatch = arr.homeStat[l].drawMatch + arr.guestStat[l].drawMatch;
            arr.totalStat[l].looseMatch = arr.homeStat[l].looseMatch + arr.guestStat[l].looseMatch;
            arr.totalStat[l].qtyYellowCard = arr.homeStat[l].qtyYellowCard + arr.guestStat[l].qtyYellowCard;
            arr.totalStat[l].qtyRedCard = arr.homeStat[l].qtyRedCard + arr.guestStat[l].qtyRedCard;
            arr.totalStat[l].goalScoredPen = arr.homeStat[l].goalScoredPen + arr.guestStat[l].goalScoredPen;
            arr.totalStat[l].goalMissedPen = arr.homeStat[l].goalMissedPen + arr.guestStat[l].goalMissedPen;

        }
    }

    static void showStat (ResultOfTheGame[] arr){
          for (int i = 0; i<arr.length; i++){
              System.out.println(" W/D/L: " +arr[i].winMatch+"-"  +arr[i].drawMatch+"-" + arr[i].looseMatch + ", ГЗ-ГП: " + arr[i].goalScored
                      + "-" + arr[i].goalMissed +  ", Score: " + arr[i].gameScore +"  " + arr[i].homeTeamName);
          }
        System.out.println();
    }

}





