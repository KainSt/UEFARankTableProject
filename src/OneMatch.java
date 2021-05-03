public class OneMatch {
    String homeTeamName, guestTeamName, typeGame;
    int homeTeamGoalScore, guestTeamGoalScore, homeTeamYellowCard, homeTeamRedCard,homeTeamPenScore, guestTeamPenScore,
            guestTeamYellowCard, guestTeamRedCard;


    OneMatch(String homeTeamName, String guestTeamName, String typeGame) {
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
    }

   }



