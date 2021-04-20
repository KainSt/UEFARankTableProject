public class ResultObjectManager {

    public static void simGame(OneMatch game, int startT, int finishT) {
        for (int x = startT; x < finishT; x++) {
            //System.out.println(x);
            for (int dexX = 0; dexX < 50; dexX = dexX + 10) {
                if (MatchProbability.isGoal()) {
                    game.homeTeamScore++;
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
                    game.guestTeamScore++;
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


    public static void discoverMatchResult(OneMatch game) {
        /*String matchResult = game.homeTeamName + " " + game.guestTeamName;

              TeamInGame HomeTeam = new TeamInGame();
                HomeTeam.teamName = game.homeTeamName;
                HomeTeam.teamScore = game.homeTeamScore;

                TeamInGame GuestTeam = new TeamInGame();
                GuestTeam.teamName = game.guestTeamName;
                GuestTeam.teamScore = game.guestTeamScore;

*/
        switch (game.typeGame) {
            case ("Regular"):
                simGame(game, 0, 45);// первый тайм 0-45 минут

                int addT = (int) (Math.random() * 4);
                //System.out.println("Add time is  " + addT);
                simGame(game, 45, 45 + addT); // добавленное время

                simGame(game, 45, 90); // второй тайм 45-90 минут

                addT = (int) (Math.random() * 4);
                //System.out.println("Add time is  " + addT);
                simGame(game, 90, 90 + addT); // добавленное время

                System.out.println(game.homeTeamName + " - " + game.guestTeamName + "  " + game.homeTeamScore + " - " + game.guestTeamScore);

                ResultOfTheGame.getValues(game);

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

                System.out.println(game.homeTeamName + " - " + game.guestTeamName + "  " + game.homeTeamScore + " - " + game.guestTeamScore);

                ResultOfTheGame.getValues(game);

                break;

            case ("Final"):
                game.typeGame = "Regular";
                ResultObjectManager.discoverMatchResult(game);

             if (game.homeTeamScore == game.guestTeamScore){
                 game.typeGame = "Extra Time";
                 ResultObjectManager.discoverMatchResult(game);
             }
                if (game.homeTeamScore == game.guestTeamScore){
                    game.typeGame = "Penalties";
                    ResultObjectManager.discoverMatchResult(game);

                }
                break;

            case ("Penalties"):
                System.out.println("After Match Penalties");

                //System.out.println(matchResult);
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
                System.out.println(game.homeTeamName + " - " + game.guestTeamName + "  " + game.homeTeamScore + " - " + game.guestTeamScore);
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
                    System.out.println(game.homeTeamName + " - " + game.guestTeamName + "  " + game.homeTeamScore + " - " + game.guestTeamScore);
                    System.out.println("(по пенальти " + game.homeTeamPenScore + "  " + game.guestTeamPenScore + " )");
                }
                break;
        }
    }
}



