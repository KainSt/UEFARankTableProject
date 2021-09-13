public class Season {
    int qtyOfTeam; // кол-во команд в данном розыгрыше
    int qtyOfGroup; // кол-во групп с командами по qtyOfTeam в каждой.
    String[] teamList;
    int [][] orderOfGame = {
            {1,2,3,0},{0,1,2,3},{2,0,1,3},{0,2,3,1},{2,1,0,3},{1,0,3,2}
    };
    MatchProtocol[][] seasonSchedule; // расписаниие игр, где каждая пара представлена протоколом встречи команд
    SeasonRank seasonRank; // итоговые таблицы дома/в гостях/тотал - на основе обработанных протоколов  MatchProtocol

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
        for (int j = 0; j <seasonName.seasonSchedule[tour].length; j++) {
            seasonName.seasonSchedule[tour][j].discoverMatchResult(seasonName.seasonSchedule[tour][j]);
            }


    }
    private class SeasonRank {
        /// команда,кол-во выигранных, ничья, проигранно, ГЗ, ГП, очки, ЖК, КК, ГЗпенальти, ГПпенальти
        TeamResult[] homeStat, guestStat, totalStat;

        SeasonRank(String[] teamList){
            homeStat = new TeamResult[teamList.length];
            guestStat = new TeamResult[teamList.length];
            totalStat = new TeamResult[teamList.length];
            for (int i = 0; i<teamList.length;i++){
                homeStat[i] = new TeamResult(teamList, i);
                guestStat[i] = new TeamResult(teamList, i);
                totalStat[i] = new TeamResult(teamList, i);
            }



        }

        private class TeamResult {
            /// команда,кол-во выигранных, ничья, проигранно, ГЗ, ГП, очки, ЖК, КК, ГЗпенальти, ГПпенальти
            String teamName;
            int winMatch, drawMatch, looseMatch, goalScored, goalMissed, gameScore, qtyYellowCard, qtyRedCard, goalScoredPen, goalMissedPen;

            TeamResult(String[] teamList, int i) {
                teamName = teamList[i];
                winMatch = 0;
                drawMatch = 0;
                looseMatch = 0;
                goalScored = 0;
                goalMissed = 0;
                gameScore = 0;
                qtyYellowCard = 0;
                qtyRedCard = 0;
                goalScoredPen = 0;
                goalMissedPen = 0;

            }

        }
    }


    Season(){ // конструктор сезона, заполнение его полей
        qtyOfTeam = 4; // кол-во команд в данном розыгрыше
        qtyOfGroup = 1; // кол-во групп с командами по qtyOfTeam в каждой.
        teamList = createGroup (qtyOfTeam);
        seasonSchedule = new MatchProtocol[(qtyOfTeam-1)*2][qtyOfTeam/2];
        for (int i = 0; i < seasonSchedule.length; i++) {
            for (int j = 0; j <=seasonSchedule[i].length; j+=2) {
            seasonSchedule [i][j/2] = discoverMatchResult(teamList[orderOfGame[i][j]], teamList[orderOfGame[i][j+1]]);
            seasonSchedule [i][j/2].typeGame =typeOfGameInTour();//устанавливаем для команды тип игры для будущей симуляции
            }
        }
        seasonRank = new SeasonRank(teamList);

    }







}

