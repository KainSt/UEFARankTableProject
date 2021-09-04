public class Season {
    int qtyOfTeam; // кол-во команд в данном розыгрыше
    int qtyOfGroup; // кол-во групп с командами по qtyOfTeam в каждой.
    String[] teamList;
    int [][] orderOfGame = {
            {1,2,3,0},{0,1,2,3},{2,0,1,3},{0,2,3,1},{2,1,0,3},{1,0,3,2}
    };
    MatchProtocol[][] SeasonSchedule; // расписаниие игр, где каждая пара представлена протоколом встречи команд
    SeasonRank RankTable; // итоговые таблицы дома/в гостях/тотал - на основе обработанных протоколов  MatchProtocol

    String[] createGroup (int qtyOfTeam){
        /// список из 4*8 = 32 команд, которые участвуют в соревновании
        String[] teamList = {"Челси","Вильярреал", "Атлетико Мадрид","Манчестер Сити",
                "Бавария","Интер", "Лилль","Спортинг","Реал Мадрид",
                "Барселона","Ювентус","Манчестер Юнайтед","Пари Сен-Жермен",
                "Ливерпуль","Севилья","Боруссия (Дортмунд)","Порту",
                "Аякс","Шахтер Донецк","РБ Лейпциг","Зальцбург",
                "Бенфика","Аталанта","Зенит","Бешикташ","Динамо (Киев)",
                "Брюгге","Янг Бойз","Милан","Мальмё","Вольфсбург",
                "Шериф"};
        String[] arr = new String[qtyOfTeam];
        for (int i = 0; i < qtyOfTeam; i++)
            arr[i] = teamList[i * 8 + (int) (Math.random() * 8)];
        return arr;
    }

    String typeOfGameInTour (){
        return "Regular";
    }



    MatchProtocol discoverMatchResult(String homeTeamName, String guestTeamName){
    return  new MatchProtocol( homeTeamName, guestTeamName, "Start");
    }


    void sortRankTable() {// правило сортировки


    }

    void showRankTable(){ // отображение турнирной таблицы


    }

    void refreshRankTable(Season seasonName, int tour){ // обновление  SeasonRank RankTable на основе новых MatchProtocol в системе.
        for (int j = 0; j <seasonName.SeasonSchedule[tour].length; j++) {
            seasonName.SeasonSchedule[tour][j].discoverMatchResult(seasonName.SeasonSchedule[tour][j]);
            }

    }



    Season(){ // конструктор сезона, заполнение его полей
        qtyOfTeam = 4; // кол-во команд в данном розыгрыше
        qtyOfGroup = 1; // кол-во групп с командами по qtyOfTeam в каждой.
        teamList = createGroup (qtyOfTeam);
        SeasonSchedule = new MatchProtocol[(qtyOfTeam-1)*2][qtyOfTeam/2];
        for (int i = 0; i < SeasonSchedule.length; i++) {
            for (int j = 0; j <=SeasonSchedule[i].length; j+=2) {
            SeasonSchedule [i][j/2] = discoverMatchResult(teamList[orderOfGame[i][j]], teamList[orderOfGame[i][j+1]]);
            SeasonSchedule [i][j/2].typeGame =typeOfGameInTour();//устанавливаем для команды тип игры для будущей симуляции
            }
        }

    }







}

