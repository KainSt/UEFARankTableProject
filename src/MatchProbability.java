public class MatchProbability {
    public static boolean isPenaltyGoal()  {
        ///Вероятность взятия ворот при исполнении пенальти оценивается от 72 % до 86 %
        ///x =  a + (int)(Math.random()*((b - a) + 1)).
        //
        //Получим случайное число x в диапазоне: 10 ≤  x ≤  20 (a=10, b=20).
        if (Math.random()<(0.72+Math.random()*0.14)) {
            System.out.println("GOAL!");
        return true;}
        System.out.println("NO GOAL!");
        return false;
    }
   // public static int chanceToPenaltiesWin(int scoreHomeTeam , int chanceToGoalHomeTeam)
   // {
   //     return scoreHomeTeam + chanceToGoalHomeTeam;
   // }

    public static boolean isYellowCard()  {
        ///Среднее значение желтых карточек в футбольном матче составляет 3,5 на обе команды
        /// значит за минуту вероятность = 3,5/2/(90*5) - каждые 10 секунд матча что-то происходит = 0,003888
        if (Math.random()<0.0038) {
            //System.out.println("YellowCard");
            return true;}
        return false;
    }
    public static boolean isRedCard()  {
        /// просто выдумываю
        ///Среднее значение красных карточек в футбольном матче составляет 0,5 на обе команды
        /// значить за минуту вероятность = 0,5/2/(90*5) - каждые 10 секунд матча что-то происходит = 0,00055

        if (Math.random()<0.00055) {
            //System.out.println("RedCard");
            return true;}
        return false;
    }
    public static boolean isGoal()  {
        /// на сегодня сыграно 14494 матча, забито 17 827 голов
        ///Среднее значение голов в футбольном матче составляет 1,2299 на обе команды
        /// значить за минуту вероятность = 1,2299/2/(90*5) - каждые 10 секунд матча что-то происходит = 0,00136

        if (Math.random()<0.00136) {
            //System.out.println("Goal");
            return true;}
        return false;
    }
}
