import java.util.Comparator;

public class ScoreComparator implements Comparator<TeamResult> {
    @Override
    public int compare(TeamResult o1, TeamResult o2) {
       if (o2.gameScore- o1.gameScore == 0) {
           System.out.println("equality of point!! " + o1.teamName + " - " + o2.teamName);

           return (o2.goalScored- o1.goalScored);///нужно вызывать функцию, которая будет
           // возвращать результат
           // -1/0/+1 внутренними расчетами, в зависимости от итогов игры
       }
        return o2.gameScore- o1.gameScore;
       }
}
