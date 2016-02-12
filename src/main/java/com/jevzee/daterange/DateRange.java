package com.jevzee.daterange;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;


/**
 * This class models a quantity or amount of time in terms of years, months and days between two LocalDate objects.
 * <p>
 * DateRange implements Stream API
 *
 * @author jevzee
 */
public final class DateRange {
    private LocalDate from;
    private LocalDate to;

    DateRange(LocalDate from, LocalDate to) {
        this.from = from;
        this.to = to;
    }

    public long periodInDays() {
        final Period between = Period.between(from, to);
        return between.get(ChronoUnit.DAYS);
    }

    public List<LocalDate> periodBetween() {
        final List<LocalDate> result = new ArrayList<LocalDate>();
        LocalDate rangeIterator = LocalDate.from(from);

        while (rangeIterator.isBefore(to) || rangeIterator.equals(to)) {
            result.add(LocalDate.from(rangeIterator));
            rangeIterator = rangeIterator.plus(1, ChronoUnit.DAYS);
        }

        return result;
    }
}