public class ResultManager {

    public static String discoverMatchResult (String homeTeamName, String guestTeamName, String matchType) {
        String matchResult = homeTeamName + " " + guestTeamName;
        int homeTeamScore = 0, guestTeamScore = 0;
        int homeTeamYellowCard =0; int guestTeamYellowCard = 0;
        int homeTeamRedCard = 0; int guestTeamRedCard = 0;

        int addTime = 0;
        switch (matchType) {
            case ("mainTime"):
                System.out.println("Main Time 1st Half");
                for (int t=0; t <=44+addTime; t++) {
                    for (int dexT = 10; dexT <= 50; dexT = dexT + 10) {
                        if (MatchProbability.isYellowCard()) {
                            homeTeamYellowCard++;
                            System.out.println(t + ":" + dexT + " " + homeTeamName + " " + "Yellow Card");
                        }
                        if (MatchProbability.isRedCard()) {
                            homeTeamRedCard++;
                            System.out.println(t + ":" + dexT + " " + homeTeamName + " " + "Red Card");
                        }
                        if (MatchProbability.isGoal()) {
                            homeTeamScore++;
                            System.out.println(t + ":" + dexT + " " + homeTeamName + " " + "GOAL!!");
                        }
                        if (MatchProbability.isYellowCard()) {
                            guestTeamYellowCard++;
                            System.out.println(t + ":" + dexT + " " + guestTeamName + " " + "Yellow Card");
                        }
                        if (MatchProbability.isRedCard()) {
                            guestTeamRedCard++;
                            System.out.println(t + ":" + dexT + " " + guestTeamName + " " + "Red Card");
                        }
                        if (MatchProbability.isGoal()) {
                            guestTeamScore++;
                            System.out.println(t + ":" + dexT + " " + guestTeamName + " " + "GOAL!!");
                        }
                    }

                    if (t == 44) {
                        addTime = (int) (Math.random() * 5)+1;
                        System.out.println(addTime);

                    }
                }
                System.out.println(homeTeamName + ". Yellow Card: " + homeTeamYellowCard + "; " + "Red Card: " + homeTeamRedCard + ".");
                System.out.println(guestTeamName + ". Yellow Card: " + guestTeamYellowCard + "; " + "Red Card: " + guestTeamRedCard + ".");

                System.out.println("Main Time 2st Half");
                for (int t=45; t <=90+addTime; t++) {
                    for (int dexT = 10; dexT <= 50; dexT = dexT + 10) {
                        if (MatchProbability.isYellowCard()) {
                            homeTeamYellowCard++;
                            System.out.println(t + ":" + dexT + " " + homeTeamName + " " + "Yellow Card");
                        }
                        if (MatchProbability.isRedCard()) {
                            homeTeamRedCard++;
                            System.out.println(t + ":" + dexT + " " + homeTeamName + " " + "Red Card");
                        }
                        if (MatchProbability.isGoal()) {
                            homeTeamScore++;
                            System.out.println(t + ":" + dexT + " " + homeTeamName + " " + "GOAL!!");
                        }
                        if (MatchProbability.isYellowCard()) {
                            guestTeamYellowCard++;
                            System.out.println(t + ":" + dexT + " " + guestTeamName + " " + "Yellow Card");
                        }
                        if (MatchProbability.isRedCard()) {
                            guestTeamRedCard++;
                            System.out.println(t + ":" + dexT + " " + guestTeamName + " " + "Red Card");
                        }
                        if (MatchProbability.isGoal()) {
                            guestTeamScore++;
                            System.out.println(t + ":" + dexT + " " + guestTeamName + " " + "GOAL!!");
                        }
                    }

                    if (t == 89) {
                        addTime = (int) (Math.random() * 5)+1;
                        System.out.println(addTime);

                    }
                }
                System.out.println(homeTeamName + ". Yellow Card: " + homeTeamYellowCard + "; " + "Red Card: " + homeTeamRedCard + ".");
                System.out.println(guestTeamName + ". Yellow Card: " + guestTeamYellowCard + "; " + "Red Card: " + guestTeamRedCard + ".");
                matchResult = matchResult + "  " + homeTeamScore + " " + guestTeamScore;
                if (homeTeamScore == guestTeamScore) discoverMatchResult(homeTeamName,guestTeamName, "penalties");
                break;

            case ("extraTime"):
                System.out.println("Extra Time");
                break;

            case ("penalties"):
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

        return matchResult;
    }

}
