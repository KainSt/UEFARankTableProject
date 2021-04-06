public class ResultObjectManager {

    public static void simGame(OneMatch game, int startT, int finishT) {
        for (int x = startT; x < finishT; x++) {
            //System.out.println(x);
            for (int dexX = 0; dexX < 50; dexX = dexX + 10) {
                if (MatchProbability.isGoal()) {
                    game.homeTeamScore++;
                    System.out.println(x + ":" + dexX + " " + game.homeTeamName + " " + "GOAL!!");
                }
                if (MatchProbability.isYellowCard()) {
                    game.homeTeamYellowCard++;
                    System.out.println(x + ":" + dexX + " " + game.homeTeamName + " " + "Yellow Card");
                }
                if (MatchProbability.isRedCard()) {
                    game.homeTeamRedCard++;
                    System.out.println(x + ":" + dexX + " " + game.homeTeamName + " " + "Red Card");
                }
                    if (MatchProbability.isGoal()) {
                        game.guestTeamScore++;
                        System.out.println(x + ":" + dexX + " " + game.guestTeamName + " " + "GOAL!!");
                    }
                if (MatchProbability.isYellowCard()) {
                    game.guestTeamYellowCard++;
                    System.out.println(x + ":" + dexX + " " + game.guestTeamName + " " + "Yellow Card");
                }
                if (MatchProbability.isRedCard()) {
                    game.guestTeamRedCard++;
                    System.out.println(x + ":" + dexX + " " + game.guestTeamName + " " + "Red Card");
                }
                }
            }
        }


            public static void discoverMatchResult (OneMatch game){
                String matchResult = game.homeTeamName + " " + game.guestTeamName;

              /*TeamInGame HomeTeam = new TeamInGame();
                HomeTeam.teamName = game.homeTeamName;
                HomeTeam.teamScore = game.homeTeamScore;

                TeamInGame GuestTeam = new TeamInGame();
                GuestTeam.teamName = game.guestTeamName;
                GuestTeam.teamScore = game.guestTeamScore;

*/
                switch (game.typeGame) {
                    case ("Regular"):
                    simGame(game, 0, 45);// первый тайм 0-45 минут

                    int addT = (int)(Math.random() * 4);
                    System.out.println("Add time is  " + addT);
                    simGame(game, 45, 45 + addT); // добавленное время

                    simGame(game, 45,90); // второй тайм 45-90 минут

                    addT = (int)(Math.random() * 4);
                    System.out.println("Add time is  " + addT);
                    simGame(game, 90,90+addT); // добавленное время

System.out.println(matchResult + "  " + game.homeTeamScore + " " + game.guestTeamScore);

                break;


                }
            }
        }



