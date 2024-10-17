package utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTime {

    private final DateTimeFormatter ukFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public String currentSystemDateTime(final String format) {
        return LocalDateTime.now().format(parseDateTimeFormat(format));
    }

    public  String currentDateTimeForTimeZone(final String timeZone, final String format) {
        return ZonedDateTime.now(ZoneId.of(timeZone)).format(parseDateTimeFormat(format));
    }

    private DateTimeFormatter parseDateTimeFormat(final String format) {
        if (format.equalsIgnoreCase("default")) {
            return ukFormat;
        } else {
            return DateTimeFormatter.ofPattern(format);
        }
    }

}
