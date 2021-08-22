public class MatchProtocol{
    String homeTeamName, guestTeamName, typeGame;
    int homeTeamGoalScore, guestTeamGoalScore, homeTeamYellowCard, homeTeamRedCard,homeTeamPenScore, guestTeamPenScore,
            guestTeamYellowCard, guestTeamRedCard;
    int homeWinMatch,  homeDrawMatch,  homeLooseMatch,  homeGameScore,
        guestWinMatch, guestDrawMatch, guestLooseMatch, guestGameScore;

    MatchProtocol(String homeTeamName, String guestTeamName, String typeGame) {
        this.homeTeamName = homeTeamName;
        this.guestTeamName = guestTeamName;
        homeTeamGoalScore = 0;
        guestTeamGoalScore = 0;
        this.typeGame = typeGame;
        homeTeamYellowCard = 0;
        homeTeamRedCard= 0;
        guestTeamYellowCard= 0;
        guestTeamRedCard = 0;
        homeTeamPenScore = 0;
        guestTeamPenScore = 0;
        homeGameScore = 0;
        guestGameScore = 0;
        homeWinMatch   = 0; guestWinMatch   = 0;
        homeDrawMatch  = 0; guestDrawMatch  = 0;
        homeLooseMatch = 0; guestLooseMatch = 0;
    /*    if (homeTeamGoalScore > guestTeamGoalScore) {
            homeWinMatch   = 1; guestWinMatch   = 0;
            homeDrawMatch  = 0; guestDrawMatch  = 0;
            homeLooseMatch = 0; guestLooseMatch = 1;

        }
        if (homeTeamGoalScore == guestTeamGoalScore) {
            homeWinMatch   = 0; guestWinMatch   = 0;
            homeDrawMatch  = 1; guestDrawMatch  = 1;
            homeLooseMatch = 0; guestLooseMatch = 0;
        }
        if (homeTeamGoalScore < guestTeamGoalScore) {
            homeWinMatch   = 0; guestWinMatch   = 1;
            homeDrawMatch  = 0; guestDrawMatch  = 0;
            homeLooseMatch = 1; guestLooseMatch = 0;
        }
        homeGameScore = homeWinMatch * 3 + homeDrawMatch;
        guestGameScore = guestWinMatch * 3 + guestDrawMatch;
             */
}

    private void simGame(MatchProtocol game, int startT, int finishT) {
        for (int x = startT; x < finishT; x++) {
            //System.out.println(x);
            for (int dexX = 0; dexX < 50; dexX = dexX + 10) {
                if (MatchProbability.isGoal()) {
                    game.homeTeamGoalScore++;
                    // System.out.println(x + ":" + dexX + " " + game.homeTeamName + " " + "GOAL!!");
                }
                if (MatchProbability.isYellowCard()) {
                    game.homeTeamYellowCard++;
                    // System.out.println(x + ":" + dexX + " " + game.homeTeamName + " " + "Yellow Card");
                }
                if (MatchProbability.isRedCard()) {
                    game.homeTeamRedCard++;
                    // System.out.println(x + ":" + dexX + " " + game.homeTeamName + " " + "Red Card");
                }
                if (MatchProbability.isGoal()) {
                    game.guestTeamGoalScore++;
                    // System.out.println(x + ":" + dexX + " " + game.guestTeamName + " " + "GOAL!!");
                }
                if (MatchProbability.isYellowCard()) {
                    game.guestTeamYellowCard++;
                    // System.out.println(x + ":" + dexX + " " + game.guestTeamName + " " + "Yellow Card");
                }
                if (MatchProbability.isRedCard()) {
                    game.guestTeamRedCard++;
                    //  System.out.println(x + ":" + dexX + " " + game.guestTeamName + " " + "Red Card");
                }
            }
        }
    }


    public void discoverMatchResult(MatchProtocol game) {
// вносит изменения в поля объекта типа OneMatch - т.е. записывает итоги матча со всеми игровыми событиями.
        switch (game.typeGame) {

            case ("Regular"):
                simGame(game, 0, 45);// первый тайм 0-45 минут

                int addT = (int) (Math.random() * 4);
                //System.out.println("Add time is  " + addT);
                simGame(game, 45, 45 + addT); // добавленное время

                simGame(game, 45, 90); // второй тайм 45-90 минут

                addT = (int) (Math.random() * 5);
                //System.out.println("Add time is  " + addT);
                simGame(game, 90, 90 + addT); // добавленное время

                System.out.println(game.homeTeamName + " - " + game.guestTeamName + "  " + game.homeTeamGoalScore + " - " + game.guestTeamGoalScore);



                break;

            case ("Extra Time"):
                System.out.println("Extra Time" );
                simGame(game, 90, 105);// первый тайм 0-45 минут

                addT = (int) (Math.random() * 4);
                //System.out.println("Add time is  " + addT);
                simGame(game, 105, 105 + addT); // добавленное время

                simGame(game, 105, 120); // второй тайм 45-90 минут

                addT = (int) (Math.random() * 4);
                //System.out.println("Add time is  " + addT);
                simGame(game, 120, 120 + addT); // добавленное время

                System.out.println(game.homeTeamName + " - " + game.guestTeamName + "  " + game.homeTeamGoalScore + " - " + game.guestTeamGoalScore);
                break;

            case ("Final"):
                game.typeGame = "Regular";
                discoverMatchResult(game);

                if (game.homeTeamGoalScore == game.guestTeamGoalScore){
                    game.typeGame = "Extra Time";
                    discoverMatchResult(game);
                }
                if (game.homeTeamGoalScore == game.guestTeamGoalScore){
                    game.typeGame = "Penalties";
                    discoverMatchResult(game);

                }
                break;

            case ("Penalties"):
                System.out.println("After Match Penalties");


                ////проверяем первую серию из 5 ударов, которая должна преваться, если нет шансов догнать соперника
                /// по кол-ву набранных очков. Шанс на гол - это кол-во оставшихся ударов.

                for (int k = 1; k <= 5; k++) {
                    /// проверка шанса на победу в серии пенальти
                    if ((game.homeTeamPenScore + 6 - k) < game.guestTeamPenScore) break;
                    /// отрабатываем первые пять ударов у каждой команды
                    if (MatchProbability.isPenaltyGoal()) {
                        game.homeTeamPenScore++;
                    }
                    if ((game.guestTeamPenScore + 6 - k) < game.homeTeamPenScore) break;
                    if (MatchProbability.isPenaltyGoal()) {
                        game.guestTeamPenScore++;
                    }

                }
                System.out.println(game.homeTeamName + " - " + game.guestTeamName + "  " + game.homeTeamGoalScore + " - " + game.guestTeamGoalScore);
                /// отрабатываем доп.удары, если кол-во забитых пенальти одинаковое
                System.out.println("(по пенальти " + game.homeTeamPenScore + "  " + game.guestTeamPenScore+" )");
                if (game.guestTeamPenScore == game.homeTeamPenScore) {
                    System.out.println("Extra After Match Penalties");

                    while (game.homeTeamPenScore == game.guestTeamPenScore) {
                        if (MatchProbability.isPenaltyGoal()) {
                            game.homeTeamPenScore++;
                        }
                        if (MatchProbability.isPenaltyGoal()) {
                            game.guestTeamPenScore++;
                        }
                    }
                    System.out.println(game.homeTeamName + " - " + game.guestTeamName + "  " + game.homeTeamGoalScore + " - " + game.guestTeamGoalScore);
                    System.out.println("(по пенальти " + game.homeTeamPenScore + "  " + game.guestTeamPenScore + " )");
                }
                break;
        }
    }
}




