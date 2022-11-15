package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateParser {

    public static String getSqlDate(String date) {
        String result = "";
        try {
            SimpleDateFormat oldDateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
            SimpleDateFormat newDateFormat = new SimpleDateFormat("yyyy-dd-MM", Locale.getDefault());
            Date newDate = oldDateFormat.parse(date);
            result = newDateFormat.format(newDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }
}
