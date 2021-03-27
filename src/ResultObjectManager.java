public class ResultObjectManager {

    public static String discoverMatchResult(OneMatch game) {
        String matchResult = game.homeTeamName + " " + game.guestTeamName;
        int homeTeamScore = game.homeTeamScore, guestTeamScore = game.guestTeamScore;
        int homeTeamYellowCard = 0;
        int guestTeamYellowCard = 0;
        int homeTeamRedCard = 0;
        int guestTeamRedCard = 0;
        int timeForPlay = game.basicTime;

        for (int t = 0; t <= timeForPlay; t++) {
            for (int dexT = 10; dexT <= 50; dexT = dexT + 10) {
                if (MatchProbability.isYellowCard()) {
                    homeTeamYellowCard++;
                    System.out.println(t + ":" + dexT + " " + game.homeTeamName + " " + "Yellow Card");
                }
                if (MatchProbability.isRedCard()) {
                    homeTeamRedCard++;
                    System.out.println(t + ":" + dexT + " " + game.homeTeamName + " " + "Red Card");
                }
                if (MatchProbability.isGoal()) {
                    homeTeamScore++;
                    System.out.println(t + ":" + dexT + " " + game.homeTeamName + " " + "GOAL!!");
                }
                if (MatchProbability.isYellowCard()) {
                    guestTeamYellowCard++;
                    System.out.println(t + ":" + dexT + " " + game.guestTeamName + " " + "Yellow Card");
                }
                if (MatchProbability.isRedCard()) {
                    guestTeamRedCard++;
                    System.out.println(t + ":" + dexT + " " + game.guestTeamName + " " + "Red Card");
                }
                if (MatchProbability.isGoal()) {
                    guestTeamScore++;
                    System.out.println(t + ":" + dexT + " " + game.guestTeamName + " " + "GOAL!!");
                }
            }
        }

            System.out.println(game.homeTeamName + ". Yellow Card: " + homeTeamYellowCard + "; " + "Red Card: " + homeTeamRedCard + ".");
            System.out.println(game.guestTeamName + ". Yellow Card: " + guestTeamYellowCard + "; " + "Red Card: " + guestTeamRedCard + ".");
            matchResult = matchResult + "  " + homeTeamScore + " " + guestTeamScore;


      /*
                System.out.println("After Match Penalties");
                System.out.println(matchResult);
                ////проверяем первую серию из 5 ударов, которая должна преваться, если нет шансов догнать соперника
                /// по кол-ву набранных очков. Шанс на гол - это кол-во оставшихся ударов.

                for (int k = 1; k <= 5; k++) {
                    /// проверка шанса на победу в серии пенальти
                    if ((homeTeamScore+6-k)<guestTeamScore) break;
                    /// отрабатываем первые пять ударов у каждой команды
                    if (MatchProbability.isPenaltyGoal()) {
                        homeTeamScore++;
                    }
                    if ((guestTeamScore+6-k)<homeTeamScore) break;
                    if (MatchProbability.isPenaltyGoal()) {
                        guestTeamScore++;
                    }

                }
                /// отрабатываем доп.удары, если кол-во забитых пенальти одинаковое
                System.out.println("Extra After Match Penalties");
                while (homeTeamScore == guestTeamScore){
                    if (MatchProbability.isPenaltyGoal()) {
                        homeTeamScore++;
                    }
                    if (MatchProbability.isPenaltyGoal()) {
                        guestTeamScore++;
                    }

                }
                matchResult = matchResult + "  " + homeTeamScore + " " + guestTeamScore;
                break;
        }
*/
            return matchResult;
        }

    }


