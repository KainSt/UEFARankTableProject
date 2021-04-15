public class GameSchedule {

    public static String[] createGroup() {
        String[] teamList = {"Ливерпуль", "Челси", "Барселона", "Бавария", "Ювентус", "Манчестер Сити",
                "Пари Сен-Жермен","Зенит", "Реал Мадрид", "Атлетико Мадрид", "Боруссия Дортмунд",
                "Наполи", "Шахтёр", "Тоттенхэм Хотспур", "Аякс", "Бенфика", "Олимпик Лион", "Байер 04",
                "Зальцбург", "Олимпиакос", "Брюгге", "Валенсия", "Интернационале","Динамо (Загреб)",
                "Локомотив", "Генк", "Галатасарай", "РБ Лейпциг", "Славия (Прага)", "Црвена Звезда",
                "Аталанта", "Лилль"};
        String[] arr = new String[4];
        for (int i = 0; i < 4; i++)
            arr[i] = teamList[i * 8 + (int) (Math.random() * 9)];
        return arr;
    }

    public static String[][] makeOrderOfGame( String [] arr){

        String [] listOfTeam = arr;
        String [][] orderOfGame = {
                {listOfTeam[1],listOfTeam[2], listOfTeam[3],listOfTeam[0]},
                {listOfTeam[0],listOfTeam[1], listOfTeam[2],listOfTeam[3]},
                {listOfTeam[2],listOfTeam[0], listOfTeam[1],listOfTeam[3]},
                {listOfTeam[0],listOfTeam[2], listOfTeam[3],listOfTeam[1]},
                {listOfTeam[2],listOfTeam[1], listOfTeam[0],listOfTeam[3]},
                {listOfTeam[1],listOfTeam[0], listOfTeam[3],listOfTeam[2]},
        };
        System.out.println();
        for (int i = 0; i < orderOfGame.length; i++) {
            {
                System.out.print("'"+orderOfGame[i][0]+"'" + "-"+"'"+orderOfGame[i][1]+"' "+
                        "/ '"+orderOfGame[i][2]+"'" + "-"+"'"+orderOfGame[i][3]+"'"+"\t");
            }
            System.out.println();
        }
/*
2 v 3 4 v 1
1 v 2 3 v 4
3 v 1 2 v 4
1 v 3 4 v 2
3 v 2 1 v 4
2 v 1 4 v 3

 */

        return orderOfGame;
    }
}
