import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class DateUtilsTest {

    @Test
    public void testGetCurrentDateTime() {
        LocalDateTime now = DateUtils.getCurrentDateTime();
        assertNotNull(now);
        assertTrue(now.getYear() >= 2024);
    }

    @Test
    public void testGetCurrentDate() {
        LocalDate now = DateUtils.getCurrentDate();
        assertNotNull(now);
        assertTrue(now.getYear() >= 2024);
    }

    @Test
    public void testFormatDate() {
        LocalDateTime date = LocalDateTime.of(2024, 3, 20, 10, 30, 0);
        String formatted = DateUtils.formatDate(date, "yyyy-MM-dd HH:mm:ss");
        assertEquals("2024-03-20 10:30:00", formatted);
    }

    @Test
    public void testParseDate() {
        String dateStr = "2024-03-20 10:30:00";
        LocalDateTime parsed = DateUtils.parseDate(dateStr, "yyyy-MM-dd HH:mm:ss");
        assertNotNull(parsed);
        assertEquals(2024, parsed.getYear());
        assertEquals(3, parsed.getMonthValue());
        assertEquals(20, parsed.getDayOfMonth());
        assertEquals(10, parsed.getHour());
        assertEquals(30, parsed.getMinute());
    }

    @Test
    public void testGetDaysBetween() {
        LocalDate date1 = LocalDate.of(2024, 3, 20);
        LocalDate date2 = LocalDate.of(2024, 3, 25);
        long days = DateUtils.getDaysBetween(date1, date2);
        assertEquals(5, days);
    }

    @Test
    public void testAddDays() {
        LocalDateTime date = LocalDateTime.of(2024, 3, 20, 10, 30, 0);
        LocalDateTime futureDate = DateUtils.addDays(date, 5);
        assertEquals(25, futureDate.getDayOfMonth());
        
        LocalDateTime pastDate = DateUtils.addDays(date, -5);
        assertEquals(15, pastDate.getDayOfMonth());
    }

    @Test
    public void testIsDateInRange() {
        LocalDateTime date = LocalDateTime.of(2024, 3, 20, 10, 30, 0);
        LocalDateTime start = LocalDateTime.of(2024, 3, 19, 0, 0, 0);
        LocalDateTime end = LocalDateTime.of(2024, 3, 21, 23, 59, 59);
        
        assertTrue(DateUtils.isDateInRange(date, start, end));
        assertFalse(DateUtils.isDateInRange(date, end, start));
    }

    @Test
    public void testGetStartOfDay() {
        LocalDateTime date = LocalDateTime.of(2024, 3, 20, 10, 30, 0);
        LocalDateTime startOfDay = DateUtils.getStartOfDay(date);
        assertEquals(0, startOfDay.getHour());
        assertEquals(0, startOfDay.getMinute());
        assertEquals(0, startOfDay.getSecond());
    }

    @Test
    public void testGetEndOfDay() {
        LocalDateTime date = LocalDateTime.of(2024, 3, 20, 10, 30, 0);
        LocalDateTime endOfDay = DateUtils.getEndOfDay(date);
        assertEquals(23, endOfDay.getHour());
        assertEquals(59, endOfDay.getMinute());
        assertEquals(59, endOfDay.getSecond());
    }

    @Test
    public void testIsLeapYear() {
        assertTrue(DateUtils.isLeapYear(2024));
        assertTrue(DateUtils.isLeapYear(2020));
        assertFalse(DateUtils.isLeapYear(2023));
        assertFalse(DateUtils.isLeapYear(2100));
    }

    @Test
    public void testGetDaysInMonth() {
        assertEquals(31, DateUtils.getDaysInMonth(2024, 1));
        assertEquals(29, DateUtils.getDaysInMonth(2024, 2)); // 闰年
        assertEquals(28, DateUtils.getDaysInMonth(2023, 2)); // 非闰年
        assertEquals(31, DateUtils.getDaysInMonth(2024, 3));
    }

    @Test
    public void testDateConversion() {
        // 测试 Date 转 LocalDateTime
        Date date = new Date();
        LocalDateTime localDateTime = DateUtils.dateToLocalDateTime(date);
        assertNotNull(localDateTime);

        // 测试 LocalDateTime 转 Date
        LocalDateTime now = LocalDateTime.now();
        Date convertedDate = DateUtils.localDateTimeToDate(now);
        assertNotNull(convertedDate);
    }

    @Test
    public void testNullHandling() {
        assertNull(DateUtils.formatDate(null, "yyyy-MM-dd"));
        assertNull(DateUtils.parseDate(null, "yyyy-MM-dd"));
        assertNull(DateUtils.parseDate("", "yyyy-MM-dd"));
        assertNull(DateUtils.addDays(null, 1));
        assertNull(DateUtils.getStartOfDay(null));
        assertNull(DateUtils.getEndOfDay(null));
        assertNull(DateUtils.dateToLocalDateTime(null));
        assertNull(DateUtils.localDateTimeToDate(null));
    }
} 