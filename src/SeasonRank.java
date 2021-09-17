import java.util.Arrays;

class SeasonRank {
    /// команда,кол-во выигранных, ничья, проигранно, ГЗ, ГП, очки, ЖК, КК, ГЗпенальти, ГПпенальти
    TeamResult[] homeStat, guestStat, totalStat;

    SeasonRank(String[] teamList){
        homeStat = new TeamResult[teamList.length];
        guestStat = new TeamResult[teamList.length];
        totalStat = new TeamResult[teamList.length];
        for (int i = 0; i<teamList.length;i++){
            homeStat[i] = new TeamResult(teamList[i]);
            guestStat[i] = new TeamResult(teamList[i]);
            totalStat[i] = new TeamResult(teamList[i]);
        }


    }


    void showStat (TeamResult[] arr){
        for (int i = 0; i<arr.length; i++){
            System.out.println(" W/D/L: " +arr[i].winMatch+"-"  +arr[i].drawMatch+"-" + arr[i].looseMatch + ", ГЗ-ГП: " + arr[i].goalScored
                    + "-" + arr[i].goalMissed +  ", Score: " + arr[i].gameScore +"  " + arr[i].teamName);
        }
        System.out.println();
    }


}