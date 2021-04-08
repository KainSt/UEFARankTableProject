public class MethodResult {
    String homeTeamName, guestTeamName, typeGame;
    int homeTeamScore, guestTeamScore, homeTeamYellowCard, homeTeamRedCard,
            guestTeamYellowCard, guestTeamRedCard;

    MethodResult(OneMatch game) {/// конструктор класса
        // Команда, Игр, Выигранные, Ничья, Проигравнные, ГЗ, ГП, очки, ЖК, КК.
        homeTeamName = game.homeTeamName;
        //homeGameResult [1] =
        //homeGameResult [2] =
        //homeGameResult [3] =
        //homeGameResult [4] =
        homeTeamScore = game.homeTeamScore;
        guestTeamScore  = game.guestTeamScore;
        // homeGameResult [7]=
        homeTeamYellowCard = game.homeTeamYellowCard;
        homeTeamRedCard = game.homeTeamRedCard;
    }

   /* String getName() {return name;}
    int getCount() {return count;}
    String getName2() {return name2;}
*/
    static MethodResult getValues(OneMatch game) {
        return new MethodResult(game);
    }

}


