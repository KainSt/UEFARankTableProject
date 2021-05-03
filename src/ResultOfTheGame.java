public class ResultOfTheGame {
    String homeTeamName, guestTeamName, typeGame, placeOfMatch;
    int homeTeamGoalScore, guestTeamGoalScore, homeTeamYellowCard, homeTeamRedCard, homeTeamPenScore, guestTeamPenScore,
            guestTeamYellowCard, guestTeamRedCard;
    int winMatch, drawMatch, looseMatch, goalScored, goalMissed, gameScore, qtyYellowCard, qtyRedCard, goalScoredPen, goalMissedPen;

    ResultOfTheGame(OneMatch game, String placeOfMatch) {/// конструктор класса
        /// команда, игр, выигранных, ничья, проигранно, ГЗ, ГП, очки, ЖК, КК, ГЗпенальти, ГПпенальти
        this.placeOfMatch = placeOfMatch;
        homeTeamName = game.homeTeamName;
        guestTeamName = game.guestTeamName;
        homeTeamPenScore = game.homeTeamPenScore;
        guestTeamPenScore = game.guestTeamPenScore;
        guestTeamYellowCard = game.guestTeamYellowCard;
        guestTeamRedCard = game.guestTeamRedCard;
        homeTeamGoalScore = game.homeTeamGoalScore;
        guestTeamGoalScore = game.guestTeamGoalScore;
        homeTeamYellowCard = game.homeTeamYellowCard;
        homeTeamRedCard = game.homeTeamRedCard;
        typeGame = game.typeGame;


        switch (placeOfMatch) {
            case ("Start"):
                winMatch = 0;
                drawMatch = 0;
                looseMatch = 0;
        goalScored = homeTeamGoalScore;
        goalMissed = guestTeamGoalScore;
        gameScore = winMatch * 3 + drawMatch * 1;
        qtyYellowCard = homeTeamYellowCard;
        qtyRedCard = homeTeamRedCard;
        goalScoredPen = homeTeamPenScore;
        goalMissedPen = guestTeamPenScore;
        break;
            case ("Home"):
                if (homeTeamGoalScore > guestTeamGoalScore) {
                    winMatch = 1;
                    drawMatch = 0;
                    looseMatch = 0;

                }
                if (homeTeamGoalScore == guestTeamGoalScore) {
                    winMatch = 0;
                    drawMatch = 1;
                    looseMatch = 0;
                }
                if (homeTeamGoalScore < guestTeamGoalScore) {
                    winMatch = 0;
                    drawMatch = 0;
                    looseMatch = 1;
                }
                goalScored = homeTeamGoalScore;
                goalMissed = guestTeamGoalScore;
                gameScore = winMatch * 3 + drawMatch * 1;
                qtyYellowCard = homeTeamYellowCard;
                qtyRedCard = homeTeamRedCard;
                goalScoredPen = homeTeamPenScore;
                goalMissedPen = guestTeamPenScore;
                break;

            case ("Guest"):
                if (guestTeamGoalScore > homeTeamGoalScore) {
                    winMatch = 1;
                    drawMatch = 0;
                    looseMatch = 0;

                }
                if (homeTeamGoalScore == guestTeamGoalScore) {
                    winMatch = 0;
                    drawMatch = 1;
                    looseMatch = 0;
                }
                if (homeTeamGoalScore > guestTeamGoalScore) {
                    winMatch = 0;
                    drawMatch = 0;
                    looseMatch = 1;
                }
                goalScored = guestTeamGoalScore;
                goalMissed = homeTeamGoalScore;
                gameScore = winMatch * 3 + drawMatch * 1;
                qtyYellowCard = guestTeamYellowCard;
                qtyRedCard = guestTeamRedCard;
                goalScoredPen = guestTeamPenScore;
                goalMissedPen = homeTeamPenScore;

                break;
        }



    }
}


