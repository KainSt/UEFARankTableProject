public class Season {
    int qtyOfTeam; // кол-во команд в данном розыгрыше
    int qtyOfGroup; // кол-во групп с командами по qtyOfTeam в каждой.
    String[] teamList /*= {"Бавария", "Севилья", "Реал Мадрид", "Ливерпуль", "Ювентус", "Пари Сен-Жермен", "Зенит", "Порту", // список команд
            "Барселона", "Атлетико Мадрид", "Манчестер Сити", "Манчестер Юнайтед", "Шахтёр", "Боруссия (Дортмунд)",
            "Челси", "Аякс",
            "Динамо (Киев)", "Зальцбург", "РБ Лейпциг", "Интер", "Олимпиакос", "Лацио", "Краснодар", "Аталанта",
            "Локомотив", "Олимпик Марсель", "Брюгге", "Боруссия (Мёнхенгладбах)", "Истанбул Башакшехир",
            "Мидтьюлланн", "Ренн", "Ференцварош"}*/;
    MatchProtocol [][] SeasonSchedule; // расписаниие игр, где каждая пара представлена протоклом встречи команд
    SeasonRank RankTable; // итоговые таблицы дома/в гостях/тотал - на основе обработанных протоколов  MatchProtocol
    sortRankTable (); // правило сортировки
    showRankTable (); // отображение турнирной таблицы
    refreshRankTable (); // обновление  SeasonRank RankTable на основе новых MatchProtocol в системе.
    
    
}


Конструктор должен включать в себя наполнение полей значениями
    Тур за туром заполнение расписания
        Триггер дата наступления тура
        Сортировка по правилам
