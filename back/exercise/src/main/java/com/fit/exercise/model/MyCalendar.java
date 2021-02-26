package com.fit.exercise.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MyCalendar {
    private List<LocalDate> specialDates;

    public MyCalendar(){
        specialDates = new ArrayList<>();
        initializeDates();
    }

    private void initializeDates() {
        specialDates.add(LocalDate.of(2021,5,25));
        specialDates.add(LocalDate.of(2021,12,25));
    }

    public boolean isSpecialDate(LocalDate date) {
//        return specialDates.stream().filter(localDate -> localDate.equals(date)).findFirst().isPresent();
        return date.getDayOfWeek().getValue() == 1;
    }
}
