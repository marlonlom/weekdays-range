package dev.marlonlom.libs.weekday_range

import org.junit.jupiter.api.Test
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.Month
import java.util.*
import kotlin.test.assertEquals


internal class WeekdaysRangeTest {

  @Test
  fun shouldVerifyRangeFor20220210() {
    val inputDate = LocalDate.of(2022, 2, 10)
    val expectedDates = arrayOf(
      LocalDate.of(2022, 2, 6),
      LocalDate.of(2022, 2, 12)
    )
    val range = WeekdaysRange.fromDate(inputDate)

    assertEquals(expectedDates[0], range.sunday)
    assertEquals(expectedDates[1], range.saturday)
  }

  @Test
  fun shouldVerifyRangeFor20220101() {
    val inputDate = LocalDate.of(2022, 1, 1)
    val expectedDates = arrayOf(
      LocalDate.of(2021, 12, 26),
      LocalDate.of(2022, 1, 1)
    )
    val range = WeekdaysRange.fromDate(inputDate)

    assertEquals(expectedDates[0], range.sunday)
    assertEquals(expectedDates[1], range.saturday)
  }

  @Test
  fun shouldVerifyRangeFor20211228() {
    val inputDate = LocalDate.of(2021, 12, 28)
    val expectedDates = arrayOf(
      LocalDate.of(2021, 12, 26),
      LocalDate.of(2022, 1, 1)
    )
    val range = WeekdaysRange.fromDate(inputDate)

    assertEquals(expectedDates[0], range.sunday)
    assertEquals(expectedDates[1], range.saturday)
  }

  @Test
  fun shouldVerifyRangeFor20211107() {
    val inputDate = LocalDate.of(2021, 11, 7)
    val expectedDates = arrayOf(
      LocalDate.of(2021, 11, 7),
      LocalDate.of(2021, 11, 13)
    )
    val range = WeekdaysRange.fromDate(inputDate)

    assertEquals(expectedDates[0], range.sunday)
    assertEquals(expectedDates[1], range.saturday)
  }

  @Test
  fun shouldVerifyRangeFor20200411() {
    val inputDate = LocalDate.of(2020, 4, 11)
    val expectedDates = arrayOf(
      LocalDate.of(2020, 4, 5),
      LocalDate.of(2020, 4, 11)
    )
    val range = WeekdaysRange.fromDate(inputDate)

    assertEquals(expectedDates[0], range.sunday)
    assertEquals(expectedDates[1], range.saturday)
  }

  @Test
  fun shouldVerifyRangeFor20230110() {
    val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val expectedDates = arrayOf(
      LocalDate.of(2023, Month.JANUARY, 8),
      LocalDate.of(2023, Month.JANUARY, 14)
    )
    val aDate = sdf.parse("2023-01-10")
    val range = WeekdaysRange.fromDate(aDate)

    assertEquals(expectedDates[0], range.sunday)
    assertEquals(expectedDates[1], range.saturday)
  }
}
