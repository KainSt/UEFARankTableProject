package UEFARank;

import java.util.Comparator;

public class ScoreComparator implements Comparator<TeamResult> {
    @Override
    public int compare(TeamResult o1, TeamResult o2) {
       return o2.gameScore- o1.gameScore;
       }


}
