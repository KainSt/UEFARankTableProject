class ConfigOfAll {
    int qtyOfTeam; // кол-во команд в данном розыгрыше
    int qtyOfGroup; // кол-во групп с командами по qtyOfTeam в каждой.
    GameSchedule MajorSchedule;
    StatOfGames matchArr;
    String [][] league; // массив Лига - это одна за другой пары играющих команд, первая - домашняя, вторая - выездная.
    ResultOfTheGame[][] listOfGameResult; // для каждой пары из таблицы расписания генерируется результат.


    ConfigOfAll(int qtyOfTeam) {
        this.qtyOfTeam = qtyOfTeam;
        qtyOfGroup = 1;
        MajorSchedule = new GameSchedule(qtyOfTeam);
        MajorSchedule.table = MajorSchedule.createGroup(this.qtyOfTeam);
        matchArr = new StatOfGames();
        for (int x =0; x < MajorSchedule.table.length;x++)   {
            //создаем группу
            matchArr.homeStat[x].homeTeamName = MajorSchedule.table[x];
            matchArr.guestStat[x].homeTeamName = MajorSchedule.table[x];
            matchArr.totalStat[x].homeTeamName = MajorSchedule.table[x];
            System.out.println(MajorSchedule.table[x]);
        }
        league = MajorSchedule.makeOrderOfMatches(MajorSchedule.table);
        // массив Лига - это одна за другой пары играющих команд, первая - домашняя, вторая - выездная.
        System.out.println();

        // для каждой пары из таблицы расписания генерируется результат.
        listOfGameResult = new ResultOfTheGame[MajorSchedule.qtyDayOfMatch][(MajorSchedule.qtyDayOfMatch/2+1)];
        //создаётся таблица по кол-ву игровых дней строчек, по кол-ву играющих пар в столбцах - расчет через кол-во туров кол-воДнейМатчей
        for (int i =0; i<MajorSchedule.qtyDayOfMatch;i++){
            for (int k=0;k<league[i].length;k+=2) {
                OneMatch Game = new OneMatch(league[i][k], league[i][k + 1], "Regular");
                //создается объект, который находится сверху всех процедур и обрабатывается без передачи, просто потому что он есть.
                Game.discoverMatchResult(Game);/// заполняет поля объекта Game на основе симуляции игры
               MatchProtocol j1= new MatchProtocol(Game.homeTeamName, Game.guestTeamName,"Regular");
               System.out.println(j1.homeTeamGoalScore);
                listOfGameResult[i][k] = new ResultOfTheGame (Game, "Home"); /// вытаскивает то, что для домашней команды свойственно
                listOfGameResult[i][k+1] = new ResultOfTheGame (Game, "Guest"); /// вытаскивает то, что для гостевой команды свойствоено
                StatOfGames.addStat(matchArr, listOfGameResult[i][k]);  // идет запись в архив результатов, по месту дом/гости заполняется подархив с результатами
                StatOfGames.addStat(matchArr, listOfGameResult[i][k+1]); // идет запись в архив результатов, по месту дом/гости заполняется подархив с результатами

            }

        }
    }
}
