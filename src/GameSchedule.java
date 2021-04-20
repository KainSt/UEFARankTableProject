public class GameSchedule {
    int qtyDayOfMatch = 6;
    
    
///генерируем группу из 4х команд
    public static String[] createGroup() {
        /// список из 4*8 = 32 команд, которые участвуют в соревновании
        String[] teamList = {"Бавария", "Севилья", "Реал Мадрид", "Ливерпуль", "Ювентус", "Пари Сен-Жермен", "Зенит", "Порту", 
                             "Барселона", "Атлетико Мадрид", "Манчестер Сити", "Манчестер Юнайтед", "Шахтёр", "Боруссия (Дортмунд)", 
                             "Челси", "Аякс", 
                             "Динамо (Киев)", "Зальцбург", "РБ Лейпциг", "Интер", "Олимпиакос", "Лацио", "Краснодар", "Аталанта", 
                             "Локомотив", "Олимпик Марсель", "Брюгге", "Боруссия (Мёнхенгладбах)", "Истанбул Башакшехир", 
                             "Мидтьюлланн", "Ренн", "Ференцварош"};
        String[] arr = new String[4];
        for (int i = 0; i < 4; i++)
            arr[i] = teamList[i * 8 + (int) (Math.random() * 9)];
        return arr;
    }

    public static String[][] makeOrderOfGame( String [] arr){
//согласно правилам УЕФА генерируем расписание пар.
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
/* номер команды с точки зрения УЕФА, номер в массиве на 1 меньше.
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
