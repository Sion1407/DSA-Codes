package Exercises.dsaProblems;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class Test {
    private static final LocalTime START_TIME = LocalTime.of(10, 0);
    private static final LocalTime END_TIME = LocalTime.of(21, 30);
    public static void main(String[] args) {
//        ZonedDateTime inputTime = ZonedDateTime.of(2024, 6, 18, 22, 0, 0, 0, ZoneId.of("UTC"));
        ZonedDateTime inputTime = ZonedDateTime.now(ZoneId.systemDefault());
        String formattedDateTime = inputTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z"));
        System.out.println("formatted"+formattedDateTime);
        System.out.println(calculateSmsSendTime(inputTime));
        ZonedDateTime[] zonedDateTimes = getStartAndEndDates(1,"akjdls");
        ZonedDateTime startDate;
        ZonedDateTime endDate;
        startDate = zonedDateTimes[0];endDate = zonedDateTimes[1];
        Instant startInstant = startDate.toInstant();
        Instant endInstant = endDate.toInstant();

        long diffInMillis = endInstant.toEpochMilli() - startInstant.toEpochMilli();
//        long diffInDays = TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS);


    }

    public static String calculateSmsSendTime(ZonedDateTime inputTime) {
//        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("UTC"));
        ZonedDateTime smsTime;
        System.out.println(inputTime.toLocalTime());
        if (inputTime.toLocalTime().isAfter(START_TIME) && inputTime.toLocalTime().isBefore(END_TIME)) {
            smsTime = inputTime;
        } else {
            smsTime = inputTime.withHour(10).withMinute(0).withSecond(0);
            if (inputTime.toLocalTime().isAfter(END_TIME)) {
                smsTime = smsTime.plusDays(1);
            }
        }

//        return smsTime.format(DateTimeFormatter.ISO_INSTANT);
        return smsTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'"));

    }

    public static ZonedDateTime[] getStartAndEndDates(int count, String actualOrderDate) {
        LocalDate futureOrderDate = calculateFutureOrderDate(1, LocalDate.of(2024,06,27));
        // Check if futureOrderDate is null
        if (futureOrderDate == null) {
            // Handle the null case. You could throw an exception, return a default value, etc.
            throw new IllegalArgumentException("Future order date cannot be null");
        }
        ZoneId zoneId = ZoneId.of("PST",ZoneId.SHORT_IDS);
        ZonedDateTime futureOrderDateTime = futureOrderDate.atStartOfDay(zoneId);
        ZonedDateTime currentZonedDateTimePST = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));

        return calculateStartAndEndDates(currentZonedDateTimePST, futureOrderDateTime);
    }
    private static LocalDate calculateFutureOrderDate(int count, LocalDate actualOrderDate){
        return Optional.of(count)
                .map(unitCount -> actualOrderDate.plusDays(7L * unitCount))
                .orElse(null);
    }
    public static ZonedDateTime[] calculateStartAndEndDates(ZonedDateTime currentDate, ZonedDateTime futureDate) {
        ZonedDateTime startDate;
        ZonedDateTime endDate;

        // Define the time boundary as 11:00:00 PM PST
        ZonedDateTime timeBoundary = currentDate.withHour(23).withMinute(0).withSecond(0).withZoneSameInstant(ZoneId.of("PST8PDT"));

        // Calculate the start date
        if (currentDate.isBefore(timeBoundary)) {
            startDate = currentDate.plusDays(1);
        } else {
            startDate = currentDate.plusDays(2);
        }

        // Calculate the end date
        ZonedDateTime sevenOrEightDaysFromNow = currentDate.isBefore(timeBoundary) ? currentDate.plusDays(7) :
                currentDate.plusDays(8);
        ZonedDateTime fourDaysBeforeFutureDate = futureDate.minusDays(4);

        if (sevenOrEightDaysFromNow.isBefore(fourDaysBeforeFutureDate)) {
            endDate = sevenOrEightDaysFromNow;
        } else {
            endDate = fourDaysBeforeFutureDate;
        }

        return new ZonedDateTime[] {
                startDate,
                endDate
        };
    }
}
