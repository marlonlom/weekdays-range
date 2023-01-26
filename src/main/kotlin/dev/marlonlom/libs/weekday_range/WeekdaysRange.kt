package dev.marlonlom.libs.weekday_range

import java.time.DayOfWeek
import java.time.LocalDate
import java.time.ZoneId
import java.util.*

object WeekdaysRange {

  fun fromDate(aDate: Date): WeekRangeDates = aDate.toInstant()
    .atZone(ZoneId.systemDefault())
    .toLocalDate().let { localDate ->
      WeekRangeDates(
        calculateInitialRangeDate(localDate),
        calculateFinalRangeDate(localDate)
      )
    }

  fun fromDate(aDate: LocalDate): WeekRangeDates =
    WeekRangeDates(calculateInitialRangeDate(aDate), calculateFinalRangeDate(aDate))

  private fun isSaturday(aDate: LocalDate) = aDate.dayOfWeek.equals(DayOfWeek.SATURDAY)

  private fun isSunday(aDate: LocalDate) = aDate.dayOfWeek.equals(DayOfWeek.SUNDAY)

  private fun calculateInitialRangeDate(aDate: LocalDate): LocalDate {
    var firstDayOfRangeWeek = LocalDate.of(aDate.year, aDate.month.value, aDate.dayOfMonth)
    if (isSunday(firstDayOfRangeWeek)) {
      return firstDayOfRangeWeek
    }
    do {
      firstDayOfRangeWeek = firstDayOfRangeWeek.minusDays(1)
    } while (!isSunday(firstDayOfRangeWeek))
    return firstDayOfRangeWeek
  }

  private fun calculateFinalRangeDate(aDate: LocalDate): LocalDate {
    var lastDayOfRangeWeek = LocalDate.of(aDate.year, aDate.month.value, aDate.dayOfMonth)
    if (isSaturday(lastDayOfRangeWeek)) {
      return lastDayOfRangeWeek
    }
    do {
      lastDayOfRangeWeek = lastDayOfRangeWeek.plusDays(1)
    } while (!isSaturday(lastDayOfRangeWeek))
    return lastDayOfRangeWeek
  }
}
