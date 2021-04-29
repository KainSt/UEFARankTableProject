public class OneMatch {
    String homeTeamName, guestTeamName, typeGame;
    int homeTeamScore, guestTeamScore, homeTeamYellowCard, homeTeamRedCard,homeTeamPenScore, guestTeamPenScore,
            guestTeamYellowCard, guestTeamRedCard;


    OneMatch(String homeTeamName, String guestTeamName, String typeGame) {
        this.homeTeamName = homeTeamName;
        this.guestTeamName = guestTeamName;
        homeTeamScore = 0;
        guestTeamScore = 0;
        this.typeGame = typeGame;
        homeTeamYellowCard = 0;
        homeTeamRedCard= 0;
        guestTeamYellowCard= 0;
        guestTeamRedCard = 0;
        homeTeamPenScore = 0;
        guestTeamPenScore = 0;
    }

   }



