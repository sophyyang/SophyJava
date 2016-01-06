
/**
 * 
 * @author Sophy
 * Java 8
 * Date Time
 * 
 */

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;  
import java.time.temporal.TemporalAdjusters;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.Date;
import java.util.GregorianCalendar;

import java.util.TreeSet;
import javax.swing.JOptionPane;

public class DateTimeJava8 {

	public static void main(String[] args) {
		// Sophy Yang
		Logger.getGlobal().setLevel(Level.INFO);
		// Logger.getGlobal().setLevel(Level.OFF);

		LocalDateTime timeInThePast = LocalDateTime.now().withDayOfMonth(5).withYear(2005); // year
																							// 2005
																							// current
																							// month
																							// day
																							// 5
		System.out.println("timeInThePass: " + timeInThePast);
		LocalDateTime moreInThePast = timeInThePast.minusWeeks(2).plus(3, ChronoUnit.DAYS); // -2
																							// weeks
																							// +
																							// 3
																							// days
		System.out.println("moreInThePast: " + moreInThePast);

		// temporal adjuster
		LocalDate now1 = LocalDate.now();
		LocalDate adjusted = now1.with(TemporalAdjusters.lastDayOfMonth()); // temporal
																			// change
																			// day
																			// to
																			// last
																			// day
		System.out.println("\nnow with last day of month " + adjusted);
		System.out.println("now " + now1); // now did not change

		// Time Zones
		ZoneId zoneIdParis = ZoneId.of("Europe/Paris");
		ZoneId zoneIdAGT = ZoneId.of(ZoneId.SHORT_IDS.get("AGT"));
		ZoneId zoneIdTaipei = ZoneId.of("Asia/Taipei");
		LocalDateTime dateTime = LocalDateTime.now(zoneIdAGT);
		ZonedDateTime zonedDateTimeAGT = ZonedDateTime.of(dateTime, zoneIdAGT);
		LocalDateTime dateTimeParis = LocalDateTime.now(zoneIdParis);
		ZonedDateTime zonedDateTimeParis = ZonedDateTime.of(dateTimeParis, zoneIdParis);
		LocalDateTime dateTimeTaipei = LocalDateTime.now(zoneIdTaipei);
		ZonedDateTime zonedDateTimeTaipei = ZonedDateTime.of(dateTimeTaipei, zoneIdTaipei);
		System.out.println("\ndateTime = " + dateTime);
		System.out.println("zonedDateTimeAGT = " + zonedDateTimeAGT);
		System.out.println("\ndateTimeParis = " + dateTimeParis);
		System.out.println("zonedDateTimeParis = " + zonedDateTimeParis);
		System.out.println("\ndateTimeTaipei = " + dateTimeTaipei);
		System.out.println("zonedDateTimeTaipei = " + zonedDateTimeTaipei);

		// Instants and timesSamps
		// Epoch: first second of 1.1.1970
		Instant now2 = Instant.now();
		Instant epochNow = Instant.ofEpochSecond(60 * 60 * 24 * 30);
		Instant tenSecondsAfter = now2.plusSeconds(10);
		System.out.println("\nepoch seconds " + now2.getEpochSecond());
		System.out.println("10 seconds after " + tenSecondsAfter.getEpochSecond());
		System.out.println("epochNow seconds " + epochNow.getEpochSecond());
		System.out.println("nano seconds " + now2.getNano());

		// Periods
		Period period = Period.of(3, 2, 1);
		System.out.println("\nPeriod Day:");
		System.out.println("Period of 3,2,1: " + period);
		Period period4Months = period.ofMonths(4);
		System.out.println("Period of Months 4: " + period4Months);
		period = period.between(LocalDate.now(), LocalDate.of(2015, Month.JANUARY, 1));
		System.out.println("Period between now and 2015-01-01: " + period);
		period4Months.get(ChronoUnit.DAYS);
		LocalDate newDate = LocalDate.now().plus(period4Months);
		System.out.println("new period of 4 Months from now: " + newDate);

		// Durations: similar to a period but is precision is based on hours,
		// minutes, seconds, milliseconds...
		Duration duration = Duration.ofSeconds(59);
		Duration duration59Mines = Duration.ofMinutes(59);
		Duration duration59Secds = Duration.ofSeconds(59);
		Duration duration3Hours = Duration.ofHours(3);
		duration = Duration.between(LocalTime.now(), LocalTime.MIDNIGHT);
		System.out.println("\nDuration Hour:");
		System.out.println("duration now: " + duration);
		duration = Duration.between(LocalTime.now(ZoneId.of(ZoneId.SHORT_IDS.get("AGT"))), LocalTime.MIDNIGHT);
		System.out.println("duration between now and AGT midnight: " + duration);
		duration.get(ChronoUnit.SECONDS);
		LocalTime timeNow = LocalTime.now().plus(duration);
		System.out.println("Local time + duration: " + timeNow);
		timeNow = LocalTime.now();
		System.out.println("Local time: " + timeNow);
		System.out.println("Local time + 59 seconds: " + timeNow.plus(duration59Secds));
		System.out.println("Local time + 59 minutes: " + timeNow.plus(duration59Mines));
		System.out.println("Local time + 3 hours: " + timeNow.plus(duration3Hours));

		// Formatting
		LocalDateTime dateTime1 = LocalDateTime.of(2014, Month.DECEMBER, 15, 15, 0, 30);
		System.out.println("\nwithout formatting " + dateTime1);
		String isoDateTime = dateTime1.format(DateTimeFormatter.ISO_DATE_TIME);
		System.out.println("iso date time " + isoDateTime);
		String isoDate = dateTime1.format(DateTimeFormatter.ISO_DATE);
		System.out.println("iso date  " + isoDate);
		String isoTime = dateTime1.format(DateTimeFormatter.ISO_TIME);
		System.out.println("iso time  " + isoTime);
		String patternDateTime = dateTime1.format(DateTimeFormatter.ofPattern("MM/dd/yyyy HH:ss"));
		System.out.println("using pattern  " + patternDateTime);

		// Parsing string into date
		LocalDate fromString = LocalDate.parse("2014-01-20");
		System.out.println("\nparsed from an string  " + fromString);
		LocalDate parsedFromPatern = LocalDate.parse("2014/03/03", DateTimeFormatter.ofPattern("yyyy/MM/dd"));
		System.out.println("using pattern  " + parsedFromPatern);

		// Gregorian Calendar
		Date d1 = new GregorianCalendar(1900, 10, 18, 23, 59).getTime();
		Date today = new Date();
		long diff = today.getTime() - d1.getTime();
		System.out.println("You (up to " + today + ") are " + (diff / (1000 * 60 * 60 * 24)) + " days old.");
		LocalDate todayL = LocalDate.now();
		LocalDate DOB = LocalDate.of(1960, Month.OCTOBER, 18);
		LocalDate nextDOB = DOB.plusYears(-1);
		Period p = Period.between(DOB, todayL);
		Period p1 = Period.between(nextDOB, todayL);
		long p2 = ChronoUnit.DAYS.between(DOB, todayL); //get number of the days
		long p3 = ChronoUnit.DAYS.between(nextDOB, todayL);
		LocalDateTime time1 = LocalDateTime.now();
		int second1 = time1.getSecond();
		System.out.println("Today is " + todayL);
		System.out.println("Today is " + todayL.getDayOfWeek());
		System.out.println("DBO " + DOB);
		System.out.println(
				"Next year you will be " + p1.getYears() + " years " + p1.getMonths() + " months, and " + p1.getDays() + " days old.");
		System.out.println(
				"You are " + p.getYears() + " years " + p.getMonths() + " months, and " + p.getDays() + " days old.");
		System.out.printf("You are %,d days old.\n", p2);
		System.out.printf("Next year you are %,d days old.\n", p3);
		JOptionPane.showMessageDialog (null,"Are you a closet Taylor Swift fan?");
		LocalDateTime time2 = LocalDateTime.now();
		int second2 = time2.getSecond();
		int different =(second2 -second1);
		JOptionPane.showMessageDialog(null, "End seconds: " + second2 
				+ "\nStart seconds: " + second1 + "\nIt took " + different 
				+ " seconds for you to answer.\nWas it a difficult decision?");
 

		// System.out.println();
		// DisplayTimeZones();
		// System.out.println();
		// DisplayAllZonesTime();

	}

	static void DisplayTimeZones() {
		TreeSet<String> sortedZones = new TreeSet<>(ZoneId.getAvailableZoneIds());

		System.out.println("Number of zones: " + sortedZones.size() + "\n");
		for (String zone : sortedZones) {
			System.out.println(zone);
		}
	}

	static void DisplayAllZonesTime() {
		ZoneId.SHORT_IDS.keySet().stream()
				.forEach(zoneKey -> System.out.println(ZoneId.of(ZoneId.SHORT_IDS.get(zoneKey)) + ": "
						+ LocalDateTime.now(ZoneId.of(ZoneId.SHORT_IDS.get(zoneKey)))));
	}

}
