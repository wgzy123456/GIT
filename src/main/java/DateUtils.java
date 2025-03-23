import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * 日期工具类，提供常用的日期操作方法
 */
public class DateUtils {
    
    /**
     * 获取当前日期时间
     * @return LocalDateTime
     */
    public static LocalDateTime getCurrentDateTime() {
        return LocalDateTime.now();
    }

    /**
     * 获取当前日期
     * @return LocalDate
     */
    public static LocalDate getCurrentDate() {
        return LocalDate.now();
    }

    /**
     * 日期格式化
     * @param date 日期
     * @param pattern 格式
     * @return 格式化后的日期字符串
     */
    public static String formatDate(LocalDateTime date, String pattern) {
        if (date == null) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return date.format(formatter);
    }

    /**
     * 字符串转日期
     * @param dateStr 日期字符串
     * @param pattern 格式
     * @return LocalDateTime
     */
    public static LocalDateTime parseDate(String dateStr, String pattern) {
        if (dateStr == null || dateStr.trim().isEmpty()) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDateTime.parse(dateStr, formatter);
    }

    /**
     * 计算两个日期之间的天数差
     * @param date1 第一个日期
     * @param date2 第二个日期
     * @return 天数差
     */
    public static long getDaysBetween(LocalDate date1, LocalDate date2) {
        return ChronoUnit.DAYS.between(date1, date2);
    }

    /**
     * 日期加减天数
     * @param date 日期
     * @param days 天数（正数加，负数减）
     * @return 计算后的日期
     */
    public static LocalDateTime addDays(LocalDateTime date, long days) {
        if (date == null) {
            return null;
        }
        return date.plusDays(days);
    }

    /**
     * 判断日期是否在指定范围内
     * @param date 要判断的日期
     * @param start 开始日期
     * @param end 结束日期
     * @return 是否在范围内
     */
    public static boolean isDateInRange(LocalDateTime date, LocalDateTime start, LocalDateTime end) {
        if (date == null || start == null || end == null) {
            return false;
        }
        return !date.isBefore(start) && !date.isAfter(end);
    }

    /**
     * 获取指定日期的开始时间（00:00:00）
     * @param date 日期
     * @return 开始时间
     */
    public static LocalDateTime getStartOfDay(LocalDateTime date) {
        if (date == null) {
            return null;
        }
        return date.toLocalDate().atStartOfDay();
    }

    /**
     * 获取指定日期的结束时间（23:59:59）
     * @param date 日期
     * @return 结束时间
     */
    public static LocalDateTime getEndOfDay(LocalDateTime date) {
        if (date == null) {
            return null;
        }
        return date.toLocalDate().atTime(23, 59, 59);
    }

    /**
     * 判断是否是闰年
     * @param year 年份
     * @return 是否是闰年
     */
    public static boolean isLeapYear(int year) {
        return Year.of(year).isLeap();
    }

    /**
     * 获取指定月份的天数
     * @param year 年份
     * @param month 月份
     * @return 天数
     */
    public static int getDaysInMonth(int year, int month) {
        return YearMonth.of(year, month).lengthOfMonth();
    }

    /**
     * Date转LocalDateTime
     * @param date Date对象
     * @return LocalDateTime
     */
    public static LocalDateTime dateToLocalDateTime(Date date) {
        if (date == null) {
            return null;
        }
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**
     * LocalDateTime转Date
     * @param localDateTime LocalDateTime对象
     * @return Date
     */
    public static Date localDateTimeToDate(LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return null;
        }
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
} 