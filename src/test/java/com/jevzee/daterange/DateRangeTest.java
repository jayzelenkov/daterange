package com.jevzee.daterange;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

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

    @Test
    public void testOneDayPeriodBetween() throws IOException {
        List<LocalDate> range = oneDay.periodBetween();
        assertThat(range, hasSize(2));
        assertThat(range.get(0).toString(), is(LocalDate.now().minus(1, ChronoUnit.DAYS).toString()));
        assertThat(range.get(1).toString(), is(LocalDate.now().toString()));
    }

    @Test
    public void testOneWeekPeriodBetween() throws IOException {
        List<LocalDate> range = oneWeek.periodBetween();
        assertThat(range, hasSize(8));
        assertThat(range.get(0).toString(), is(LocalDate.now().minus(7, ChronoUnit.DAYS).toString()));
        assertThat(range.get(1).toString(), is(LocalDate.now().minus(6, ChronoUnit.DAYS).toString()));
        assertThat(range.get(2).toString(), is(LocalDate.now().minus(5, ChronoUnit.DAYS).toString()));
        assertThat(range.get(3).toString(), is(LocalDate.now().minus(4, ChronoUnit.DAYS).toString()));
        assertThat(range.get(4).toString(), is(LocalDate.now().minus(3, ChronoUnit.DAYS).toString()));
        assertThat(range.get(5).toString(), is(LocalDate.now().minus(2, ChronoUnit.DAYS).toString()));
        assertThat(range.get(6).toString(), is(LocalDate.now().minus(1, ChronoUnit.DAYS).toString()));
        assertThat(range.get(7).toString(), is(LocalDate.now().toString()));
    }

}
