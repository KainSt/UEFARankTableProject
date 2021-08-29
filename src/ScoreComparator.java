import java.util.Comparator;

public class ScoreComparator implements Comparator<MatchProtocol> {
    @Override
    public int compare(MatchProtocol o1, MatchProtocol o2) {
       if (o2.homeTeamGoalScore - o1.homeTeamGoalScore == 0) {
           System.out.println("equality of point!! " + o1.homeTeamName + " - " + o2.homeTeamName);

           return ((o2.homeGameScore- o2.homeGameScore) - (o1.homeGameScore- o1.homeGameScore));///нужно вызывать функцию, которая будет возвращать результат
           // -1/0/+1 внутренними расчетами, в зависимости от итогов игры
       }
        return o2.homeTeamGoalScore - o1.homeTeamGoalScore;
       }
}
