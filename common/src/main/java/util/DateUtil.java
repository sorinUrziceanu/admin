package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    private final static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public static Date dateToSimpleDateFormat(Date date) {
        try {
            return simpleDateFormat.parse(simpleDateFormat.format(date));
        } catch (ParseException e) {
            return null;
        }
    }
}
