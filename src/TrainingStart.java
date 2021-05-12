public class TrainingStart {
    public static void main(String args[]) {

        String [] table = GameSchedule.createGroup();

        StatOfGames matchArr = new StatOfGames();
        for (int x =0; x < table.length;x++)   {
                    //создаем группу
          matchArr.homeStat[x].homeTeamName = table[x];
          matchArr.guestStat[x].homeTeamName = table[x];
          matchArr.totalStat[x].homeTeamName = table[x];
          System.out.println(table[x]);

        }
        String [][] league = GameSchedule.makeOrderOfMatches(table);
        System.out.println();


        // для каждой пары из таблицы расписания генерируется результат.
        ResultOfTheGame[][] listOfGameResult = new ResultOfTheGame[GameSchedule.qtyDayOfMatch][(GameSchedule.qtyDayOfMatch/2+1)];
                for (int i =0; i<GameSchedule.qtyDayOfMatch;i++){
            for (int k=0;k<league[i].length;k+=2) {
                OneMatch Game = new OneMatch(league[i][k], league[i][k + 1], "Regular");
                ResultObjectManager.discoverMatchResult(Game);/// заполняет поля объекта Game на основе симуляции игры
                listOfGameResult[i][k] = new ResultOfTheGame (Game, "Home");
                listOfGameResult[i][k+1] = new ResultOfTheGame (Game, "Guest");
                StatOfGames.addStat(matchArr, listOfGameResult[i][k]);
                StatOfGames.addStat(matchArr, listOfGameResult[i][k+1]);


                }

        }
        //StatOfGames.showStat(matchArr.homeStat);
        //StatOfGames.showStat(matchArr.guestStat);
        StatOfGames.showStat(matchArr.totalStat);
        TeamInQuestion.teamInQuestSort(matchArr.totalStat);
        StatOfGames.showStat(matchArr.totalStat);

    }
}

