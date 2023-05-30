package com.example.springjava.util.function;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {
    public static Date convertStringToDate(String datetime) throws ParseException {
        String dateTime = "20140505 03:23:50";
        DateFormat formatter = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        Date date = formatter.parse(dateTime);
        return date;

    }
}
