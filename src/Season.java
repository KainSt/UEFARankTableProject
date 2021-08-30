public class Season {
    int qtyOfTeam; // кол-во команд в данном розыгрыше
    int qtyOfGroup; // кол-во групп с командами по qtyOfTeam в каждой.
    String[] teamList;
    int [][] orderOfGame = {
            {1,2,3,0},
            {0,1,2,3},
            {2,0,1,3},
            {0,2,3,1},
            {2,1,0,3},
            {1,0,3,2}
    };
    MatchProtocol[][] SeasonSchedule; // расписаниие игр, где каждая пара представлена протоколом встречи команд
    SeasonRank RankTable; // итоговые таблицы дома/в гостях/тотал - на основе обработанных протоколов  MatchProtocol

    String[] createGroup (int qtyOfTeam){
        /// список из 4*8 = 32 команд, которые участвуют в соревновании
        String[] teamList = {"Челси Англия","Вильярреал Испания", "Атлетико Мадрид Испания","Манчестер Сити Англия",
                "Бавария Германия","Интер Италия", "Лилль Франция","Спортинг Португалия","Реал Мадрид Испания",
                "Барселона Испания","Ювентус Италия","Манчестер Юнайтед Англия","Пари Сен-Жермен Франция",
                "Ливерпуль Англия","Севилья Испания","Боруссия (Дортмунд) Германия","Порту Португалия",
                "Аякс Нидерланды","Шахтер Донецк Украина","РБ Лейпциг Германия","Зальцбург Австрия",
                "Бенфика Португалия","Аталанта Италия","Зенит Россия","Бешикташ Турция","Динамо (Киев) Украина",
                "Брюгге Бельгия","Янг Бойз Швейцария","Милан Италия","Мальмё Швеция","Вольфсбург Германия",
                "Шериф Молдавия"};
        String[] arr = new String[qtyOfTeam];
        for (int i = 0; i < qtyOfTeam; i++)
            arr[i] = teamList[i * 8 + (int) (Math.random() * 8)];
        return arr;
    }



    MatchProtocol discoverMatchResult(String homeTeamName, String guestTeamName){
                return  new MatchProtocol( homeTeamName, guestTeamName, "Start");
    }

    void sortRankTable() // правило сортировки
    {

    }

    void showRankTable() // отображение турнирной таблицы
    {

    }

    void refreshRankTable() // обновление  SeasonRank RankTable на основе новых MatchProtocol в системе.
    {

    }

    Season(){ // конструктор сезона, заполнение его полей
        qtyOfTeam = 4; // кол-во команд в данном розыгрыше
        qtyOfGroup = 1; // кол-во групп с командами по qtyOfTeam в каждой.
        teamList = createGroup (qtyOfTeam);
        SeasonSchedule = new MatchProtocol[(qtyOfTeam-1)*2][qtyOfTeam/2];
        for (int i = 0; i<qtyOfTeam;i++){
            SeasonSchedule [i][0] = discoverMatchResult(teamList[orderOfGame[i][0]], teamList[orderOfGame[i][1]]);
            SeasonSchedule [i][1] = discoverMatchResult(teamList[orderOfGame[i][2]], teamList[orderOfGame[i][3]]);
        }



    }







}

