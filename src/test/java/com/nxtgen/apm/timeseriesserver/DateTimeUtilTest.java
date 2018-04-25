package com.nxtgen.apm.timeseriesserver;

import org.junit.Test;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by kyel on 4/22/2018.
 */
public class DateTimeUtilTest {

    @Test
    public void dateTimeConvertionTest() {
        String  dateTime = "2007-07-03T10:14:30+01:00";
        ZonedDateTime.parse(dateTime, DateTimeFormatter.ISO_DATE_TIME);
    }
}
