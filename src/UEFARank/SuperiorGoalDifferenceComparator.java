package UEFARank;

import java.util.Comparator;

public class SuperiorGoalDifferenceComparator implements Comparator<TeamResult> {
        @Override
        public int compare(TeamResult o1, TeamResult o2) {
          return (o2.goalScored - o2.goalMissed) - (o1.goalScored - o1.goalMissed);

        }


    }

