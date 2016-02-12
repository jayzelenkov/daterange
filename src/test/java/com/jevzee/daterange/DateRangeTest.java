package com.jevzee.daterange;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public final class DateRangeTest {
    private DateRange oneDay;
    DateRange oneWeek;

    @BeforeClass
    public void beforeClass() throws IOException {
        LocalDate until = LocalDate.now();
        LocalDate from = until.minus(1, ChronoUnit.DAYS);
        oneDay = new DateRange(from, until);

        until = LocalDate.now();
        from = until.minus(7, ChronoUnit.DAYS);
        oneWeek = new DateRange(from, until);
    }

    @Test
    public void testOneDayPeriodInDays() throws IOException {
        assertThat(oneDay.periodInDays(), is(1L));
    }

    @Test
    public void testOneWeekPeriodInDays() throws IOException {
        assertThat(oneWeek.periodInDays(), is(7L));
    }

}
