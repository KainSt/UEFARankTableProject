public class ResultOfTheGame {
    String homeTeamName, guestTeamName, typeGame, placeOfMatch;
    int homeTeamScore, guestTeamScore, homeTeamYellowCard, homeTeamRedCard, homeTeamPenScore, guestTeamPenScore,
            guestTeamYellowCard, guestTeamRedCard;
    int winMatch, drawMatch, looseMatch, goalScored, goalMissed, gameScore, qtyYellowCard, qtyRedCard, goalScoredPen, goalMissedPen;

    ResultOfTheGame(OneMatch game, String placeOfMatch) {/// конструктор класса
        /// команда, игр, выигранных, ничья, проигранно, ГЗ, ГП, очки, ЖК, КК, ГЗпенальти
        this.placeOfMatch = placeOfMatch;
        homeTeamName = game.homeTeamName;
        guestTeamName = game.guestTeamName;
        homeTeamPenScore = game.homeTeamPenScore;
        guestTeamPenScore = game.guestTeamPenScore;
        guestTeamYellowCard = game.guestTeamYellowCard;
        guestTeamRedCard = game.guestTeamRedCard;
        homeTeamScore = game.homeTeamScore;
        guestTeamScore = game.guestTeamScore;
        homeTeamYellowCard = game.homeTeamYellowCard;
        homeTeamRedCard = game.homeTeamRedCard;
        typeGame = game.typeGame;


        switch (placeOfMatch) {
            case ("Home"):
                if (homeTeamScore > guestTeamScore) {
                    winMatch = 1;
                    drawMatch = 0;
                    looseMatch = 0;

                }
                if (homeTeamScore == guestTeamScore) {
                    winMatch = 0;
                    drawMatch = 1;
                    looseMatch = 0;
                }
                if (homeTeamScore < guestTeamScore) {
                    winMatch = 0;
                    drawMatch = 0;
                    looseMatch = 1;
                }
                goalScored = homeTeamScore;
                goalMissed = guestTeamScore;
                gameScore = winMatch * 3 + drawMatch * 1;
                qtyYellowCard = homeTeamYellowCard;
                qtyRedCard = homeTeamRedCard;
                goalScoredPen = homeTeamPenScore;
                goalMissedPen = guestTeamPenScore;
                break;

            case ("Guest"):
                if (guestTeamScore > homeTeamScore) {
                    winMatch = 1;
                    drawMatch = 0;
                    looseMatch = 0;

                }
                if (homeTeamScore == guestTeamScore) {
                    winMatch = 0;
                    drawMatch = 1;
                    looseMatch = 0;
                }
                if (homeTeamScore > guestTeamScore) {
                    winMatch = 0;
                    drawMatch = 0;
                    looseMatch = 1;
                }
                goalScored = guestTeamScore;
                goalMissed = homeTeamScore;
                gameScore = winMatch * 3 + drawMatch * 1;
                qtyYellowCard = guestTeamYellowCard;
                qtyRedCard = guestTeamRedCard;
                goalScoredPen = guestTeamPenScore;
                goalMissedPen = homeTeamPenScore;

                break;
        }


   /* static ResultOfTheGame getValues(OneMatch game) {
        return new ResultOfTheGame(game);
    }
*/

    }
}


