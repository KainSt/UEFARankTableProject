public class TrainingStart {

    public static void main(String args[]) {

        // new GameSchedule(4);
        //String [] table = GameSchedule.createGroup();

          ConfigOfAll Season1 = new ConfigOfAll(4);
        //StatOfGames.showStat(matchArr.homeStat);
        //StatOfGames.showStat(matchArr.guestStat);
        //StatOfGames.showStat(matchArr.totalStat);
        TeamInQuestion.teamInQuestSort(Season1.matchArr.totalStat);
        StatOfGames.showStat(Season1.matchArr.totalStat);

    }
}

