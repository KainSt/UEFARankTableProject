public class TrainingStart {

    public static void main(String args[]) {

        Season j1 = new Season();
        System.out.println(" ");
        for (int tour=0; tour<j1.SeasonSchedule.length;tour++) {
            j1.refreshRankTable(j1, tour);
        }
        System.out.println(" ");

    }
}

