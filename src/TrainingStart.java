public class TrainingStart {
    public static void main(String args[]) {

        new GameSchedule(4);
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
        // массив Лига - это одна за другой пары играющих команд, первая - домашняя, вторая - выездная.
        System.out.println();


        // для каждой пары из таблицы расписания генерируется результат.
        ResultOfTheGame[][] listOfGameResult = new ResultOfTheGame[GameSchedule.qtyDayOfMatch][(GameSchedule.qtyDayOfMatch/2+1)];
        //создаётся таблица по кол-ву игровых дней строчек, по кол-ву играющих пар в столбцах - расчет через кол-во туров кол-воДнейМатчей
        for (int i =0; i<GameSchedule.qtyDayOfMatch;i++){
            for (int k=0;k<league[i].length;k+=2) {
                OneMatch Game = new OneMatch(league[i][k], league[i][k + 1], "Regular");
                //создается объект, который находится сверху всех процедур и обрабатывается без передачи, просто потому что он есть.
                ResultObjectManager.discoverMatchResult(Game);/// заполняет поля объекта Game на основе симуляции игры
                listOfGameResult[i][k] = new ResultOfTheGame (Game, "Home"); /// вытаскивает то, что для домашней команды свойственно
                listOfGameResult[i][k+1] = new ResultOfTheGame (Game, "Guest"); /// вытаскивает то, что для гостевой команды свойствоено
                StatOfGames.addStat(matchArr, listOfGameResult[i][k]);  // идет запись в архив результатов, по месту дом/гости заполняется подархив с результатами
                StatOfGames.addStat(matchArr, listOfGameResult[i][k+1]); // идет запись в архив результатов, по месту дом/гости заполняется подархив с результатами

                }

        }
        //StatOfGames.showStat(matchArr.homeStat);
        //StatOfGames.showStat(matchArr.guestStat);
        //StatOfGames.showStat(matchArr.totalStat);
        TeamInQuestion.teamInQuestSort(matchArr.totalStat);
        StatOfGames.showStat(matchArr.totalStat);

    }
}

