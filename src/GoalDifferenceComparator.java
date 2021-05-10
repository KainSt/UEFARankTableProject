import java.util.Comparator;

public class GoalDifferenceComparator implements Comparator<ResultOfTheGame> {

    @Override
    public int compare(ResultOfTheGame o1, ResultOfTheGame o2) {
        if((o1.goalScored- o1.goalMissed) == (o2.goalScored- o2.goalMissed)){
            System.out.println("equality of point!! " + o1.homeTeamName + " - " + o2.homeTeamName);
            return 0;}
        else if((o1.goalScored- o1.goalMissed) == (o2.goalScored- o2.goalMissed))
            return -1;
        else
            return 1;
    }
}
