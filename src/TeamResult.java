    class TeamResult {
        /// команда,кол-во выигранных, ничья, проигранно, ГЗ, ГП, очки, ЖК, КК, ГЗпенальти, ГПпенальти
        String teamName;
        int winMatch, drawMatch, looseMatch, goalScored, goalMissed, gameScore, qtyYellowCard, qtyRedCard, goalScoredPen, goalMissedPen;

        TeamResult(String team) {
            teamName = team;
            winMatch = 0;
            drawMatch = 0;
            looseMatch = 0;
            goalScored = 0;
            goalMissed = 0;
            gameScore = 0;
            qtyYellowCard = 0;
            qtyRedCard = 0;
            goalScoredPen = 0;
            goalMissedPen = 0;

        }

    }

