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
    }// установка типа игры в зависимости от даты или расписания.



    MatchProtocol discoverMatchResult(String homeTeamName, String guestTeamName){
    return  new MatchProtocol( homeTeamName, guestTeamName, "Start");
    }


    void sortRankTable() {// правило сортировки
    }

    void showRankTable(){ // отображение турнирной таблицы
    }

    private int[] dateMatchProtocol(Season nowSeason,String nameHome, String nameGuest){
        int[] arr = new int[]{0, 0};
        for (int i=0; i<nowSeason.seasonSchedule.length;i++){
            for (int k=0; k<nowSeason.seasonSchedule[i].length;k++){
                if((nowSeason.seasonSchedule[i][k].homeTeamName==nameHome)&&
                        (nowSeason.seasonSchedule[i][k].guestTeamName==nameGuest)){
                    arr = new int[]{i, k};
                }
            }
        }
        return arr;

    }

    void refreshSeasonSchedule(Season seasonName, MatchProtocol matchProtocol){ // обновление  SeasonRank RankTable на основе новых MatchProtocol в системе.
        int[] tour = dateMatchProtocol(seasonName, matchProtocol.homeTeamName,matchProtocol.guestTeamName);
        seasonName.seasonSchedule[tour[0]][tour[1]].discoverMatchResult(seasonName.seasonSchedule[tour[0]][tour[1]]);



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

