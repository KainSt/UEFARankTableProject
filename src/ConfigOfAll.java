public class ConfigOfAll {
    int qtyOfTeam; // кол-во команд в данном розыгрыше
    int qtyOfGroup; // кол-во групп с командами по qtyOfTeam в каждой.


    ConfigOfAll(int qtyOfTeam) {
        this.qtyOfTeam = qtyOfTeam;
        qtyOfGroup = 1;


    }
}