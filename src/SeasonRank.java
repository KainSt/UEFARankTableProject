class SeasonRank {
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