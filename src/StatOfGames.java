public class StatOfGames {
    // Команда, Игр, Выигранные, Ничья, Проигравнные, ГЗ, ГП, очки, ЖК, КК.
    Object[] homeGameResult = new Object[10];
    Object[] guestGameResult = new Object[10];
    Object[] allGameResult = new Object[10];

    StatOfGames (OneMatch game){
        homeGameResult [0] = game.homeTeamName;
        //homeGameResult [1] =
        //homeGameResult [2] =
        //homeGameResult [3] =
        //homeGameResult [4] =
        homeGameResult [5] = game.homeTeamScore;
        homeGameResult [6] = game.guestTeamScore;
        // homeGameResult [7]=
        homeGameResult [8]= game.homeTeamYellowCard;
        homeGameResult [9]= game.homeTeamRedCard;



    }

}
