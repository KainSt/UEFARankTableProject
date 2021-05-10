public class ResultOfTheGame {
    String homeTeamName, guestTeamName, typeGame, placeOfMatch;
    int winMatch, drawMatch, looseMatch, goalScored, goalMissed, gameScore, qtyYellowCard, qtyRedCard, goalScoredPen, goalMissedPen;

    ResultOfTheGame(OneMatch game, String placeOfMatch) {/// конструктор класса
        /// команда, игр, выигранных, ничья, проигранно, ГЗ, ГП, очки, ЖК, КК, ГЗпенальти, ГПпенальти
        this.placeOfMatch = placeOfMatch;
        homeTeamName = game.homeTeamName;
        guestTeamName = game.guestTeamName;
        typeGame = game.typeGame;


        switch (placeOfMatch) {
            case ("Start"):
                winMatch = 0;
                drawMatch = 0;
                looseMatch = 0;
        goalScored = game.homeTeamGoalScore;
        goalMissed = game.guestTeamGoalScore;
        gameScore = 0;
        qtyYellowCard = game.homeTeamYellowCard;
        qtyRedCard = game.homeTeamRedCard;
        goalScoredPen = game.homeTeamPenScore;
        goalMissedPen = game.guestTeamPenScore;
        break;
            case ("Home"):
                if (game.homeTeamGoalScore > game.guestTeamGoalScore) {
                    winMatch = 1;
                    drawMatch = 0;
                    looseMatch = 0;
                }
                if (game.homeTeamGoalScore == game.guestTeamGoalScore) {
                    winMatch = 0;
                    drawMatch = 1;
                    looseMatch = 0;
                }
                if (game.homeTeamGoalScore < game.guestTeamGoalScore) {
                    winMatch = 0;
                    drawMatch = 0;
                    looseMatch = 1;
                }
                goalScored = game.homeTeamGoalScore;
                goalMissed = game.guestTeamGoalScore;
                gameScore = winMatch * 3 + drawMatch;
                qtyYellowCard = game.homeTeamYellowCard;
                qtyRedCard = game.homeTeamRedCard;
                goalScoredPen = game.homeTeamPenScore;
                goalMissedPen = game.guestTeamPenScore;
                break;

            case ("Guest"):
                if (game.guestTeamGoalScore > game.homeTeamGoalScore) {
                    winMatch = 1;
                    drawMatch = 0;
                    looseMatch = 0;

                }
                if (game.homeTeamGoalScore == game.guestTeamGoalScore) {
                    winMatch = 0;
                    drawMatch = 1;
                    looseMatch = 0;
                }
                if (game.homeTeamGoalScore > game.guestTeamGoalScore) {
                    winMatch = 0;
                    drawMatch = 0;
                    looseMatch = 1;
                }
                goalScored = game.guestTeamGoalScore;
                goalMissed = game.homeTeamGoalScore;
                gameScore = winMatch * 3 + drawMatch;
                qtyYellowCard = game.guestTeamYellowCard;
                qtyRedCard = game.guestTeamRedCard;
                goalScoredPen = game.guestTeamPenScore;
                goalMissedPen = game.homeTeamPenScore;
                break;
        }



    }


}




