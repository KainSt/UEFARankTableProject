public class ResultOfTheGame {
    String homeTeamName, guestTeamName, typeGame;
    int homeTeamScore, guestTeamScore, homeTeamYellowCard, homeTeamRedCard, homeTeamPenScore, guestTeamPenScore,
            guestTeamYellowCard, guestTeamRedCard;

    ResultOfTheGame(OneMatch game) {/// конструктор класса
        // Команда, Игр, Выигранные, Ничья, Проигранные, ГЗ, ГП, очки, ЖК, КК.

        homeTeamName = game.homeTeamName;
        guestTeamName = game.guestTeamName;
        homeTeamPenScore = game.homeTeamPenScore;
        guestTeamPenScore = game.guestTeamPenScore;
        guestTeamYellowCard = game.guestTeamYellowCard;
        guestTeamRedCard = game.guestTeamRedCard;
        homeTeamScore = game.homeTeamScore;
        guestTeamScore  = game.guestTeamScore;
        homeTeamYellowCard = game.homeTeamYellowCard;
        homeTeamRedCard = game.homeTeamRedCard;


    }


    static ResultOfTheGame getValues(OneMatch game) {
        return new ResultOfTheGame(game);
    }

}


