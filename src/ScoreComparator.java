import java.util.Comparator;

public class ScoreComparator implements Comparator<ResultOfTheGame> {
    @Override
    public int compare(ResultOfTheGame o1, ResultOfTheGame o2) {
       if (o2.gameScore - o1.gameScore == 0) {
           System.out.println("equality of point!! " + o1.homeTeamName + " - " + o2.homeTeamName);
           return ((o2.goalScored- o2.goalMissed) - (o1.goalScored- o1.goalMissed));///нужно вызывать функцию, которая будет возвращать результат
           // -1/0/+1 внутренними расчетами, в зависимости от итогов игры
       }
        return o2.gameScore - o1.gameScore;
       }
}
