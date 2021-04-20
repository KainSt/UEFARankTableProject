public class TrainingStart {
    public static void main(String args[]) {

        String [] table = GameSchedule.createGroup();
        for (int x =0; x < table.length;x++)   {System.out.println(table[x]);}
        String [][] league = GameSchedule.makeOrderOfGame(table);

        //System.out.println("matchResult");
        //System.out.println(ResultManager.discoverMatchResult("Inter","PSV","mainTime"));
        //System.out.println("Generate object OneMatch");
        for (int i =0; i<6;i++){
            OneMatch Game1 = new OneMatch(league[i][0], league[i][1],"Regular");
            ResultObjectManager.discoverMatchResult(Game1);

            OneMatch Game2 = new OneMatch(league[i][2], league[i][3],"Regular");
            ResultObjectManager.discoverMatchResult(Game2);
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

