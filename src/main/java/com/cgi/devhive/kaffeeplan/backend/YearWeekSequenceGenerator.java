package com.cgi.devhive.kaffeeplan.backend;

public class YearWeekSequenceGenerator implements SequenceGenerator {

    @Override
    public String getNext(String yearWeek) {
        int number = Integer.parseInt(yearWeek);
        int year = number/100;
        int week = number%100;
        if (week < 52) week++;
        else {
            week = 1;
            year++;
        }
        return "" + year + (week < 10 ? "0" + week : week);
    }
}
