package dr.sbs.common.util;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

public class LocalDateTimeUtil {
  public static LocalDateTime toLocalDateTime(Date date) {
    return date.toInstant().atZone(ZoneOffset.ofHours(8)).toLocalDateTime();
  }

  public static Date toDate(LocalDateTime localDateTime) {
    return Date.from(localDateTime.atZone(ZoneOffset.ofHours(8)).toInstant());
  }
}
