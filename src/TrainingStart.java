public class TrainingStart {
    public static void main(String args[]) {
        System.out.println("matchResult");
        //System.out.println(ResultManager.discoverMatchResult("Inter","PSV","mainTime"));
        System.out.println("Generate object OneMatch");

        OneMatch Game1 = new OneMatch("Roma","Chelsea","Regular");
        ResultObjectManager.discoverMatchResult(Game1);





       /// System.out.println( Game1.homeTeamScore);
        // System.out.println( Game1.guestTeamScore);
    }
}

