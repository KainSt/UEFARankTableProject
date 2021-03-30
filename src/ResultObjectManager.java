public class ResultObjectManager {

    public static void simGame(TeamInGame team1, TeamInGame team2, int t) {
        for (int x = 0; x < t; x++) {
            System.out.println(x);
            for (int dexX = 0; dexX < 50; dexX = dexX + 10) {
                if (MatchProbability.isGoal()) {
                    team1.teamScore++;
                    System.out.println(x + ":" + dexX + " " + team1.teamName + " " + "GOAL!!");
                }
                    if (MatchProbability.isGoal()) {
                        team2.teamScore++;
                        System.out.println(x + ":" + dexX + " " + team2.teamName + " " + "GOAL!!");
                    }
                }
            }
        }


            public static void discoverMatchResult (OneMatch game){
                String matchResult = game.homeTeamName + " " + game.guestTeamName;

                TeamInGame HomeTeam = new TeamInGame();
                HomeTeam.teamName = game.homeTeamName;
                HomeTeam.teamScore = game.homeTeamScore;

                TeamInGame GuestTeam = new TeamInGame();
                GuestTeam.teamName = game.guestTeamName;
                GuestTeam.teamScore = game.guestTeamScore;


                switch (game.typeGame) {
                    case ("Regular"):
                    simGame(HomeTeam, GuestTeam, 45+ (int) (Math.random()*5+1));
                    simGame(HomeTeam, GuestTeam, 45+ (int) (Math.random()*5+1));
System.out.println(matchResult + "  " + HomeTeam.teamScore + " " + GuestTeam.teamScore);
                  game.homeTeamScore = HomeTeam.teamScore;
                  game.guestTeamScore = GuestTeam.teamScore;
break;


                }
            }
        }



