public class TrainingStart {

    public static void main(String args[]) {

    Season j1 = new Season();
    System.out.println(" ");
    for (int tour = 0; tour < j1.seasonSchedule.length; tour++) {
        for (int k = 0; k < j1.seasonSchedule[tour].length; k++) {
            j1.refreshSeasonSchedule(j1, j1.seasonSchedule[tour][k]);
        }
    }
    System.out.println(" ");
    j1.showRankTable(j1.seasonRank.homeStat);
    j1.showRankTable(j1.seasonRank.guestStat);
    j1.showRankTable(j1.seasonRank.totalStat);
    j1.sortRankTable(j1.seasonRank);
    j1.showRankTable(j1.seasonRank.totalStat);
    System.out.println(" ");

    }
}

