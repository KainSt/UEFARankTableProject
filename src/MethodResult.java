public class MethodResult {
    String homeTeamName, guestTeamName, typeGame;
    int homeTeamScore, guestTeamScore, homeTeamYellowCard, homeTeamRedCard, homeTeamPenScore, guestTeamPenScore,
            guestTeamYellowCard, guestTeamRedCard;

    MethodResult(OneMatch game) {/// конструктор класса
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


    static MethodResult getValues(OneMatch game) {
        return new MethodResult(game);
    }

}


