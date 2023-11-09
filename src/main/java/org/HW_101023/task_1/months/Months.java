package org.HW_101023.task_1.months;

public enum Months {
    /*
    Создайте программу, использующую перечисление с полями.
    По введённому пользователем названию месяца (на английском языке) программа выводит среднюю температуру месяца
    и к какому сезону года месяц относится (зима, весна, лето, осень).
    */
    JANUARY(6.2, Season.WINTER),
    February(5.3, Season.WINTER),
    MARCH(8.1, Season.SPRING),
    APRIL(10.4, Season.SPRING),
    MAY(13.5, Season.SPRING),
    JUNE(17, Season.SUMMER),
    JULY(19, Season.SUMMER),
    AUGUST(20, Season.SUMMER),
    SEPTEMBER(17.4, Season.AUTUMN),
    OCTOBER(14.2, Season.AUTUMN),
    NOVEMBER(11.1, Season.AUTUMN),
    DECEMBER(8, Season.WINTER);

    private final double averageTemp;
    private final Season season;

    Months(double averageTemp, Season season) {
        this.averageTemp = averageTemp;
        this.season = season;
    }

    public double getAverageTemp() {
        return averageTemp;
    }

    public Season getSeason() {
        return season;
    }
}
