package TestForMainProgramm;

import java.util.Comparator;
import java.util.Arrays;

public class TypeOfSort{

    public static class ScoreComparator implements Comparator<Table> {
        @Override
        public int compare(Table o1, Table o2) {
            return o2.score - o1.score;
        }
    }

    public static class GoalComparator implements Comparator<Table> {
        @Override
        public int compare(Table o1, Table o2) {
            return o2.goal - o1.goal;
        }
    }


    public static class Table{
        int score, goal;
        String teamName;



        Table (String name, int score, int goal){
            this.score = score;
            this.goal = goal;
            teamName = name;
        }

    }

    public static void main(String []args){

        Table [] list = new Table[6];
        list[0]=new Table("Milan F", 1, 2);
        list[1]=new Table("Milan C", 3, 1);
        list[2]=new Table("Milan D", 2, 4);
        list[3]=new Table("Milan B", 3, 6);
        list[4]=new Table("Milan E", 1, 7);
        list[5]=new Table("Milan A", 3, 9);


        for (Table k: list) {
            System.out.println(k.teamName + " - score: " + k.score + " goal: " + k.goal);
        }
        System.out.println();

        Arrays.sort(list, new ScoreComparator());

        for (Table k: list) {
            System.out.println(k.teamName + " - score: " + k.score + " goal: " + k.goal);
        }
        System.out.println();

        int [] countTable = new int[list.length];


        for (int i = 0; i < 6; i++){
            for (int k = 0; k< 6; k++){
                if (list[i].score == list[k].score ) {
                    countTable[i]++;
                }
            }
        }

        for (int k: countTable){
            System.out.println(k);
        }
        System.out.println();

        for (int i = 0; i< countTable.length; i++) {
            if (countTable[i] > 1){
                int delta = i;
                Table [] localTable = new Table[countTable[i]];
                for (int j = 0; j < countTable[i]; j++) {
                    localTable[j]=new Table("",0,0);
                }
                for (int l=0; l<countTable[delta];l++) {
                    localTable[l].teamName = list[l+delta].teamName;
                    localTable[l].score = list[l+delta].score;
                    localTable[l].goal = list[l+delta].goal;
                }

                for (Table k: localTable)   {
                    System.out.println(k.teamName + " - score: " + k.score + " goal: " + k.goal);
                }
                System.out.println();
                Arrays.sort(localTable, new GoalComparator());

                for (Table k: localTable)   {
                    System.out.println(k.teamName + " - score: " + k.score + " goal: " + k.goal);
                }
                System.out.println();
                for (int k: countTable){
                    System.out.println(k);
                }
                System.out.println();

                for (int l=0; l<countTable[delta];l++){
                    list[l+delta].teamName = localTable[l].teamName;
                    list[l+delta].score = localTable[l].score;
                    list[l+delta].goal = localTable[l].goal;
                }

                for (Table k: list) {
                    System.out.println(k.teamName + " - score: " + k.score + " goal: " + k.goal);
                }
                System.out.println();

                if (i+countTable[delta]>countTable.length){
                    break;
                } else{
                    i = i+countTable[delta]-1;
                };

            }

        }


    }


}
