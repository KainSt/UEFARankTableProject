package UEFARank;

class SeasonRank {
    /// команда,кол-во выигранных, ничья, проигранно, ГЗ, ГП, очки, ЖК, КК, ГЗпенальти, ГПпенальти
    TeamResult[] homeStat, guestStat, totalStat;

    SeasonRank(String[] teamList) {
        homeStat = new TeamResult[teamList.length];
        guestStat = new TeamResult[teamList.length];
        totalStat = new TeamResult[teamList.length];
        for (int i = 0; i < teamList.length; i++) {
            homeStat[i] = new TeamResult(teamList[i]);
            guestStat[i] = new TeamResult(teamList[i]);
            totalStat[i] = new TeamResult(teamList[i]);
        }
    }




    }



