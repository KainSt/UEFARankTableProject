public class MatchProtocol extends OneMatch{
    int homeWinMatch,  homeDrawMatch,  homeLooseMatch,  homeGameScore,
        guestWinMatch, guestDrawMatch, guestLooseMatch, guestGameScore;

    MatchProtocol(String homeTeamName, String guestTeamName, String typeGame) {
        super(homeTeamName, guestTeamName, typeGame);
        if (super.homeTeamGoalScore > super.guestTeamGoalScore) {
            homeWinMatch   = 1; guestWinMatch   = 0;
            homeDrawMatch  = 0; guestDrawMatch  = 0;
            homeLooseMatch = 0; guestLooseMatch = 1;

        }
        if (super.homeTeamGoalScore == super.guestTeamGoalScore) {
            homeWinMatch   = 0; guestWinMatch   = 0;
            homeDrawMatch  = 1; guestDrawMatch  = 1;
            homeLooseMatch = 0; guestLooseMatch = 0;
        }
        if (super.homeTeamGoalScore < super.guestTeamGoalScore) {
            homeWinMatch   = 0; guestWinMatch   = 1;
            homeDrawMatch  = 0; guestDrawMatch  = 0;
            homeLooseMatch = 1; guestLooseMatch = 0;
        }
        homeGameScore = homeWinMatch * 3 + homeDrawMatch;
        guestGameScore = guestWinMatch * 3 + guestDrawMatch;
}


}
