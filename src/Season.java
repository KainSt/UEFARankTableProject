import java.util.Arrays;

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


    void sortRankTable(SeasonRank seasonRank) {// сортировка с поиском строк с одинаковым кол-вом очков
      Arrays.sort(seasonRank.totalStat, new ScoreComparator());
      int[] countTable = new int[seasonRank.totalStat.length];
      for (int i = 0; i < countTable.length; i++) {
            for (int k = 0; k < countTable.length; k++) {
                if (seasonRank.totalStat[i].gameScore == seasonRank.totalStat[k].gameScore) {
                countTable[i]++;
                }
            }
        }

        for (int i = 0; i < countTable.length; i++) {
        System.out.println(countTable[i]);
        }

       for (int i = 0; i < countTable.length; i++) {
            if (countTable[i] > 1) {
                int delta = i;// показывает насколько различается положение в локальной таблице и в таблице имён команд

                String[] localTable = new String[countTable[i]];//список команд с равным кол-вом очков.
                for (int l = 0; l < countTable[delta]; l++) {
                    localTable[l] = seasonRank.totalStat[l + delta].teamName;
                }
                SeasonRank matchArrSort = new SeasonRank(localTable);
                showRankTable(matchArrSort.totalStat);

                if (i+countTable[delta]>countTable.length){
                    break;
                } else{
                    i = i+countTable[delta]-1;
                }
            }

        }
    }

    void showRankTable(TeamResult[] arr){ { // отображение турнирной таблицы
            for (int i = 0; i<arr.length; i++){
                System.out.println(" W/D/L: " +arr[i].winMatch+"-"  +arr[i].drawMatch+"-" + arr[i].looseMatch + ", ГЗ-ГП: " + arr[i].goalScored
                        + "-" + arr[i].goalMissed +  ", Score: " + arr[i].gameScore +"  " + arr[i].teamName);
            }
            System.out.println();
        }
    }

    private int[] dateMatchProtocol(Season nowSeason,String nameHome, String nameGuest){
        // находит в расписании тур и номер игры для заданных команд
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

    void refreshSeasonSchedule(Season seasonName, MatchProtocol matchProtocol){
        // обновление  SeasonRank RankTable на основе новых MatchProtocol в системе.
        int[] tour = dateMatchProtocol(seasonName, matchProtocol.homeTeamName,matchProtocol.guestTeamName);
        seasonName.seasonSchedule[tour[0]][tour[1]].discoverMatchResult(seasonName.seasonSchedule[tour[0]][tour[1]]);
        refreshSeasonRank(seasonName, matchProtocol);
    }

    void refreshSeasonRank(Season seasonName, MatchProtocol matchProtocol){
                     for (int l = 0; l < seasonName.qtyOfTeam; l++) {
                    if (seasonName.seasonRank.homeStat[l].teamName == matchProtocol.homeTeamName) {
                        seasonName.seasonRank.homeStat[l].gameScore += matchProtocol.homeGameScore;
                        seasonName.seasonRank.homeStat[l].goalScored += matchProtocol.homeTeamGoalScore;
                        seasonName.seasonRank.homeStat[l].goalMissed += matchProtocol.guestTeamGoalScore;
                        seasonName.seasonRank.homeStat[l].winMatch+= matchProtocol.homeWinMatch;
                        seasonName.seasonRank.homeStat[l].drawMatch+= matchProtocol.homeDrawMatch;
                        seasonName.seasonRank.homeStat[l].looseMatch+= matchProtocol.homeLooseMatch;
                        seasonName.seasonRank.homeStat[l].qtyYellowCard+= matchProtocol.homeTeamYellowCard;
                        seasonName.seasonRank.homeStat[l].qtyRedCard+= matchProtocol.homeTeamRedCard;
                        seasonName.seasonRank.homeStat[l].goalScoredPen+= matchProtocol.homeTeamPenScore;
                        seasonName.seasonRank.homeStat[l].goalMissedPen+= matchProtocol.guestTeamPenScore;

                        seasonName.seasonRank.totalStat[l].gameScore = seasonName.seasonRank.homeStat[l].gameScore + seasonName.seasonRank.guestStat[l].gameScore;
                        seasonName.seasonRank.totalStat[l].goalScored = seasonName.seasonRank.homeStat[l].goalScored + seasonName.seasonRank.guestStat[l].goalScored;
                        seasonName.seasonRank.totalStat[l].goalMissed = seasonName.seasonRank.homeStat[l].goalMissed + seasonName.seasonRank.guestStat[l].goalMissed;
                        seasonName.seasonRank.totalStat[l].winMatch = seasonName.seasonRank.homeStat[l].winMatch + seasonName.seasonRank.guestStat[l].winMatch;
                        seasonName.seasonRank.totalStat[l].drawMatch = seasonName.seasonRank.homeStat[l].drawMatch + seasonName.seasonRank.guestStat[l].drawMatch;
                        seasonName.seasonRank.totalStat[l].looseMatch = seasonName.seasonRank.homeStat[l].looseMatch + seasonName.seasonRank.guestStat[l].looseMatch;
                        seasonName.seasonRank.totalStat[l].qtyYellowCard = seasonName.seasonRank.homeStat[l].qtyYellowCard + seasonName.seasonRank.guestStat[l].qtyYellowCard;
                        seasonName.seasonRank.totalStat[l].qtyRedCard = seasonName.seasonRank.homeStat[l].qtyRedCard + seasonName.seasonRank.guestStat[l].qtyRedCard;
                        seasonName.seasonRank.totalStat[l].goalScoredPen = seasonName.seasonRank.homeStat[l].goalScoredPen + seasonName.seasonRank.guestStat[l].goalScoredPen;
                        seasonName.seasonRank.totalStat[l].goalMissedPen = seasonName.seasonRank.homeStat[l].goalMissedPen + seasonName.seasonRank.guestStat[l].goalMissedPen;

                    }
                    if (seasonName.seasonRank.guestStat[l].teamName == matchProtocol.guestTeamName) {
                        seasonName.seasonRank.guestStat[l].gameScore += matchProtocol.guestGameScore;
                        seasonName.seasonRank.guestStat[l].goalScored += matchProtocol.guestTeamGoalScore;
                        seasonName.seasonRank.guestStat[l].goalMissed += matchProtocol.homeTeamGoalScore;
                        seasonName.seasonRank.guestStat[l].winMatch+= matchProtocol.guestWinMatch;
                        seasonName.seasonRank.guestStat[l].drawMatch+= matchProtocol.guestDrawMatch;
                        seasonName.seasonRank.guestStat[l].looseMatch+= matchProtocol.guestLooseMatch;
                        seasonName.seasonRank.guestStat[l].qtyYellowCard+= matchProtocol.guestTeamYellowCard;
                        seasonName.seasonRank.guestStat[l].qtyRedCard+= matchProtocol.guestTeamRedCard;
                        seasonName.seasonRank.guestStat[l].goalScoredPen+= matchProtocol.guestTeamPenScore;
                        seasonName.seasonRank.guestStat[l].goalMissedPen+= matchProtocol.homeTeamPenScore;
                         }

                         seasonName.seasonRank.totalStat[l].gameScore = seasonName.seasonRank.homeStat[l].gameScore + seasonName.seasonRank.guestStat[l].gameScore;
                         seasonName.seasonRank.totalStat[l].goalScored = seasonName.seasonRank.homeStat[l].goalScored + seasonName.seasonRank.guestStat[l].goalScored;
                         seasonName.seasonRank.totalStat[l].goalMissed = seasonName.seasonRank.homeStat[l].goalMissed + seasonName.seasonRank.guestStat[l].goalMissed;
                         seasonName.seasonRank.totalStat[l].winMatch = seasonName.seasonRank.homeStat[l].winMatch + seasonName.seasonRank.guestStat[l].winMatch;
                         seasonName.seasonRank.totalStat[l].drawMatch = seasonName.seasonRank.homeStat[l].drawMatch + seasonName.seasonRank.guestStat[l].drawMatch;
                         seasonName.seasonRank.totalStat[l].looseMatch = seasonName.seasonRank.homeStat[l].looseMatch + seasonName.seasonRank.guestStat[l].looseMatch;
                         seasonName.seasonRank.totalStat[l].qtyYellowCard = seasonName.seasonRank.homeStat[l].qtyYellowCard + seasonName.seasonRank.guestStat[l].qtyYellowCard;
                         seasonName.seasonRank.totalStat[l].qtyRedCard = seasonName.seasonRank.homeStat[l].qtyRedCard + seasonName.seasonRank.guestStat[l].qtyRedCard;
                         seasonName.seasonRank.totalStat[l].goalScoredPen = seasonName.seasonRank.homeStat[l].goalScoredPen + seasonName.seasonRank.guestStat[l].goalScoredPen;
                         seasonName.seasonRank.totalStat[l].goalMissedPen = seasonName.seasonRank.homeStat[l].goalMissedPen + seasonName.seasonRank.guestStat[l].goalMissedPen;
                }

    }


    Season(){ // конструктор сезона, заполнение его полей
        qtyOfTeam = 4; // кол-во команд в данном розыгрыше
        qtyOfGroup = 1; // кол-во групп с командами по qtyOfTeam в каждой.
        teamList = createGroup (qtyOfTeam);
        seasonSchedule = new MatchProtocol[(qtyOfTeam-1)*2][qtyOfTeam/2];
        for (int i = 0; i < seasonSchedule.length; i++) { /// записываем расписание парами команд, меняем их на нулевой протокол матча.
            for (int j = 0; j <=seasonSchedule[i].length; j+=2) {
            seasonSchedule [i][j/2] = discoverMatchResult(teamList[orderOfGame[i][j]], teamList[orderOfGame[i][j+1]]);
            seasonSchedule [i][j/2].typeGame =typeOfGameInTour();//устанавливаем для команды тип игры для будущей симуляции
            }
        }
        seasonRank = new SeasonRank(teamList);
    }
}

