package UEFARank;

import java.util.Arrays;

public class Season {
    int qtyOfTeam; // кол-во команд в данном розыгрыше
    int qtyOfGroup; // кол-во групп с командами по qtyOfTeam в каждой.
    String[] teamList;
    int [][] orderOfGame = {
            {1,2,3,0},{0,1,2,3},{2,0,1,3},{0,2,3,1},{2,1,0,3},{1,0,3,2}
    };
    MatchProtocol[][] seasonSchedule; // расписаниие игр, где каждая пара представлена протоколом встречи команд
    SeasonRank seasonRank; // итоговые таблицы дома/в гостях/тотал - на основе обработанных протоколов  UEFARank.MatchProtocol

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

    private SeasonRank refreshSeasonRank (MatchProtocol[][] seasonSchedule, String[] teamList){
        SeasonRank arr =new SeasonRank(teamList);
        for (int tour = 0; tour < seasonSchedule.length; tour++) {
            for (int k = 0; k < seasonSchedule[tour].length; k++) {
                if (existA(seasonSchedule[tour][k].homeTeamName, teamList)&(existA(seasonSchedule[tour][k].guestTeamName, teamList))){
                    refreshSeasonRank(arr,seasonSchedule[tour][k]);
                }
            }
        }
    return arr;
    }

    private boolean existA(String a, String[] massStringA) {
        for (String s : massStringA) {
            if (a.equals(s)) {
                return true;
            }
        }
        return false;
    }

    private int[] countTableArr(SeasonRank seasonRank) {
        int[] countTable = new int[seasonRank.totalStat.length];

        for (int i = 0; i < countTable.length; i++) { // таблица, которая отражает сколько раз это кол-во очков встречается в таблице
            for (int k = 0; k < countTable.length; k++) {
                if (seasonRank.totalStat[i].gameScore == seasonRank.totalStat[k].gameScore) {
                    countTable[i]++;
                }
            }
        }
        return countTable;
    }

    private boolean isEqualScore (int[] arr){ // возвращает true если в таблице встречается больше одного раза одно кол-во очков.

        int sum = 0;
        for (int k: arr){
            sum += arr[k];
        }
        return  (sum > arr.length);
    }

    void sortRankTable(Season seasonName) {// сортировка с поиском строк с одинаковым кол-вом очков
      Arrays.sort(seasonName.seasonRank.totalStat, new ScoreComparator());
        int[] countTable = countTableArr(seasonName.seasonRank);
        if (isEqualScore (countTable)) {
            for (int i = 0; i < countTable.length; i++) {
                if (countTable[i] > 1) {
                    int delta = i;// показывает насколько различается положение в локальной таблице и в таблице имён команд
                    String[] localTable = new String[countTable[i]];//список команд с равным кол-вом очков.
                    for (int l = 0; l < countTable[delta]; l++) {
                        localTable[l] = seasonRank.totalStat[l + delta].teamName;
                    }

                    SeasonRank matchArrSort = refreshSeasonRank(seasonName.seasonSchedule, localTable);
                    Arrays.sort(matchArrSort.totalStat, new ScoreComparator());



                    // заполняется данными по итогам игр, чтобы отсортировать вновь полученный массив
                    showRankTable(matchArrSort.totalStat);
                    // вставить в массив имена команд в правильном порядке, перед выходом обновить таблицу
                    if (i + countTable[delta] > countTable.length) {
                        break;
                    } else {
                        i = i + countTable[delta] - 1;
                    } // выход из перебора, чтобы не выходить за пределы диапазона
                }

            }
        }
    }

    void sortSeasonRankTable(SeasonRank seasonRank, MatchProtocol[][] seasonSchedule, String stepOfSort) {// сортировка с поиском строк с одинаковым кол-вом очков
        switch (stepOfSort) {
            case ("A"):
                Arrays.sort(seasonRank.totalStat, new ScoreComparator());
                if (isEqualScore(countTableArr(seasonRank))) {
                    int[] countTable = countTableArr(seasonRank);
                    for (int i = 0; i < countTable.length; i++) {
                        if (countTable[i] > 1) {
                            int delta = i;// показывает насколько различается положение в локальной таблице и в таблице имён команд
                            String[] localTable = new String[countTable[i]];//список команд с равным кол-вом очков.
                            for (int l = 0; l < countTable[delta]; l++) {
                                localTable[l] = seasonRank.totalStat[l + delta].teamName;
                            }

                           sortSeasonRankTable(refreshSeasonRank(seasonSchedule, localTable),seasonSchedule,"B");



                            if (i + countTable[delta] > countTable.length) {
                                break;
                            } else {
                                i = i + countTable[delta] - 1;
                            } // выход из перебора, чтобы не выходить за пределы диапазона
                        }

                    }

                }
        else break;

        case ("B"):
        Arrays.sort(seasonRank.totalStat, new ScoreComparator());
        break;

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
                if((nowSeason.seasonSchedule[i][k].homeTeamName == nameHome)&&
                        (nowSeason.seasonSchedule[i][k].guestTeamName == nameGuest)){
                    arr = new int[]{i, k};
                }
            }
        }
        return arr;

    }

    void refreshSeasonSchedule(Season seasonName, MatchProtocol matchProtocol){
        // обновление  UEFARank.SeasonRank RankTable на основе поданных на вход UEFARank.MatchProtocol в системе.
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

    void refreshSeasonRank(SeasonRank seasonRankName, MatchProtocol matchProtocol){
        for (int l = 0; l < seasonRankName.guestStat.length; l++) {
            if (seasonRankName.homeStat[l].teamName == matchProtocol.homeTeamName) {
                seasonRankName.homeStat[l].gameScore += matchProtocol.homeGameScore;
                seasonRankName.homeStat[l].goalScored += matchProtocol.homeTeamGoalScore;
                seasonRankName.homeStat[l].goalMissed += matchProtocol.guestTeamGoalScore;
                seasonRankName.homeStat[l].winMatch+= matchProtocol.homeWinMatch;
                seasonRankName.homeStat[l].drawMatch+= matchProtocol.homeDrawMatch;
                seasonRankName.homeStat[l].looseMatch+= matchProtocol.homeLooseMatch;
                seasonRankName.homeStat[l].qtyYellowCard+= matchProtocol.homeTeamYellowCard;
                seasonRankName.homeStat[l].qtyRedCard+= matchProtocol.homeTeamRedCard;
                seasonRankName.homeStat[l].goalScoredPen+= matchProtocol.homeTeamPenScore;
                seasonRankName.homeStat[l].goalMissedPen+= matchProtocol.guestTeamPenScore;

                seasonRankName.totalStat[l].gameScore = seasonRankName.homeStat[l].gameScore + seasonRankName.guestStat[l].gameScore;
                seasonRankName.totalStat[l].goalScored = seasonRankName.homeStat[l].goalScored + seasonRankName.guestStat[l].goalScored;
                seasonRankName.totalStat[l].goalMissed = seasonRankName.homeStat[l].goalMissed + seasonRankName.guestStat[l].goalMissed;
                seasonRankName.totalStat[l].winMatch = seasonRankName.homeStat[l].winMatch + seasonRankName.guestStat[l].winMatch;
                seasonRankName.totalStat[l].drawMatch = seasonRankName.homeStat[l].drawMatch + seasonRankName.guestStat[l].drawMatch;
                seasonRankName.totalStat[l].looseMatch = seasonRankName.homeStat[l].looseMatch + seasonRankName.guestStat[l].looseMatch;
                seasonRankName.totalStat[l].qtyYellowCard = seasonRankName.homeStat[l].qtyYellowCard + seasonRankName.guestStat[l].qtyYellowCard;
                seasonRankName.totalStat[l].qtyRedCard = seasonRankName.homeStat[l].qtyRedCard + seasonRankName.guestStat[l].qtyRedCard;
                seasonRankName.totalStat[l].goalScoredPen = seasonRankName.homeStat[l].goalScoredPen + seasonRankName.guestStat[l].goalScoredPen;
                seasonRankName.totalStat[l].goalMissedPen = seasonRankName.homeStat[l].goalMissedPen + seasonRankName.guestStat[l].goalMissedPen;

            }
            if (seasonRankName.guestStat[l].teamName == matchProtocol.guestTeamName) {
                seasonRankName.guestStat[l].gameScore += matchProtocol.guestGameScore;
                seasonRankName.guestStat[l].goalScored += matchProtocol.guestTeamGoalScore;
                seasonRankName.guestStat[l].goalMissed += matchProtocol.homeTeamGoalScore;
                seasonRankName.guestStat[l].winMatch+= matchProtocol.guestWinMatch;
                seasonRankName.guestStat[l].drawMatch+= matchProtocol.guestDrawMatch;
                seasonRankName.guestStat[l].looseMatch+= matchProtocol.guestLooseMatch;
                seasonRankName.guestStat[l].qtyYellowCard+= matchProtocol.guestTeamYellowCard;
                seasonRankName.guestStat[l].qtyRedCard+= matchProtocol.guestTeamRedCard;
                seasonRankName.guestStat[l].goalScoredPen+= matchProtocol.guestTeamPenScore;
                seasonRankName.guestStat[l].goalMissedPen+= matchProtocol.homeTeamPenScore;
            }

            seasonRankName.totalStat[l].gameScore = seasonRankName.homeStat[l].gameScore + seasonRankName.guestStat[l].gameScore;
            seasonRankName.totalStat[l].goalScored = seasonRankName.homeStat[l].goalScored + seasonRankName.guestStat[l].goalScored;
            seasonRankName.totalStat[l].goalMissed = seasonRankName.homeStat[l].goalMissed + seasonRankName.guestStat[l].goalMissed;
            seasonRankName.totalStat[l].winMatch = seasonRankName.homeStat[l].winMatch + seasonRankName.guestStat[l].winMatch;
            seasonRankName.totalStat[l].drawMatch = seasonRankName.homeStat[l].drawMatch + seasonRankName.guestStat[l].drawMatch;
            seasonRankName.totalStat[l].looseMatch = seasonRankName.homeStat[l].looseMatch + seasonRankName.guestStat[l].looseMatch;
            seasonRankName.totalStat[l].qtyYellowCard = seasonRankName.homeStat[l].qtyYellowCard + seasonRankName.guestStat[l].qtyYellowCard;
            seasonRankName.totalStat[l].qtyRedCard = seasonRankName.homeStat[l].qtyRedCard + seasonRankName.guestStat[l].qtyRedCard;
            seasonRankName.totalStat[l].goalScoredPen = seasonRankName.homeStat[l].goalScoredPen + seasonRankName.guestStat[l].goalScoredPen;
            seasonRankName.totalStat[l].goalMissedPen = seasonRankName.homeStat[l].goalMissedPen + seasonRankName.guestStat[l].goalMissedPen;
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