public class TrainingStart {
    public static void main(String args[]) {

        String [] table = GameSchedule.createGroup(); //создаем группу
        for (int x =0; x < table.length;x++)   {System.out.println(table[x]);}
        String [][] league = GameSchedule.makeOrderOfMatches(table);
        System.out.println(" ");

        //System.out.println("matchResult");
        //System.out.println(ResultManager.discoverMatchResult("Inter","PSV","mainTime"));
        //System.out.println("Generate object OneMatch");

        // для каждой пары из таблицы расписания генерируется результат.
        for (int i =0; i<GameSchedule.qtyDayOfMatch;i++){
            for (int k=0;k<league[i].length;k+=2) {
                OneMatch Game = new OneMatch(league[i][k], league[i][k + 1], "Regular");
                ResultObjectManager.discoverMatchResult(Game);
                ResultOfTheGame Home = new ResultOfTheGame (Game, "Home");
                System.out.println( Home.gameScore);
                ResultOfTheGame Guest = new ResultOfTheGame (Game, "Guest");
                System.out.println( Guest.gameScore);


                }


        }
        //OneMatch Game1 = new OneMatch("Roma","Chelsea","Final");
        //OneMatch Game2 = new OneMatch("ЦСКА","УФА","Regular");
        // OneMatch Game3 = new OneMatch("Inter","Milan","Penalties");
        //ResultObjectManager.discoverMatchResult(Game1);
        //ResultObjectManager.discoverMatchResult(Game2);
        //ResultObjectManager.discoverMatchResult(Game3);
       /// System.out.println( Game1.homeTeamScore);
        // System.out.println( Game1.guestTeamScore);

    }
}

