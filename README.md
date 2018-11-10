# Minitime

A Scala wrapper around [Java Time](https://docs.oracle.com/javase/8/docs/api/java/time/package-summary.html) with Scala.js support.

This library is inspired by [time for scala](https://github.com/johanandren/timeforscala) and [chronoscala](https://github.com/opt-tech/chronoscala), but with slightly different functions and more typeclass design.

## Instantiation

``` scala
import minitime._

val ld1 = LocalDate.now
val ld2 = LocalDate(2007, 8, 31)
val ld3 = LocalDate.parse("2018-03-09")

val ldt = LocalDateTime(2016, 7, 30, 19, 30, nano = 30000)

val lt = LocalTime.parse("12:35")

val zdt = ZonedDateTime.parse("2012-01-27T00:00:00.000000+09:00")

val d1: Duration = 1.hour
val d2: Duration = 2.minutes
val d3: Duration = 3.millis
val d4: Duration = Duration.parse("PT3S")

val p1: Period = 1.day
val p2: Period = 2.weeks
val p3: Period = 3.months
val p4: Period = Period(years = 1, months = 2, days = 3)
```

## Basic Arithmetic

``` scala
LocalDate(2018, 1, 31) + 1.day * 2
// 2018-02-02

LocalDate(2018, 4, 30) - 2.month
// 2018-02-28

LocalDateTime(2018, 8, 31, 23, 59) + 1.minute + 3.seconds
// 2018-09-01T00:00:03

LocalDate(2018, 3, 1) - LocalDate(2018, 2, 1)
// 28

LocalDateTime.parse("2018-09-01T15:39:39") - LocalDateTime(2018, 8, 31, 0, 0)
// java.time.Duration = PT39H39M39S

3.minutes / 2 + 3.seconds * 3
// java.time.Duration = PT1M39S
```

## Ordering

``` scala
3.minutes < 3.hours
// true

LocalDate(2018, 3, 9) <= LocalDate(2017, 8, 31)
// false

Seq(1.hour, 2.minutes, 3.seconds).sorted
// List(PT3S, PT2M, PT1H)

Set(LocalDate(2018, 8, 29), LocalDate(2018, 8, 30), LocalDate(2018, 8, 31)).max
// 2018-08-31
```

Note that `Ordering.Implicits.infixOrderingOps` is automatically imported to make the operations `>`, `<`, `>=`, `<=`, `max`, `min` available. If you don't want this feature or you met some ambiguous implicit conversions, remove the auto import using `import minitime.{infixOrderingOps => _, _}`.

## TimeRange

``` scala
LocalDate.parse("2018-01-01") to LocalDate.parse("2018-01-05")
// TimeRange(2018-01-01, 2018-01-02, 2018-01-03, 2018-01-04, 2018-01-05)

LocalDate.parse("2018-01-01") till LocalDate.parse("2018-01-05")
// TimeRange(2018-01-01, 2018-01-02, 2018-01-03, 2018-01-04)

LocalDate.parse("2018-01-01") to LocalDate.parse("2018-01-05") by 2.days
// TimeRange(2018-01-01, 2018-01-03, 2018-01-05)

LocalDate.parse("2018-01-31") to LocalDate.parse("2018-05-01") by 1.month
// TimeRange(2018-01-31, 2018-02-28, 2018-03-31, 2018-04-30)

LocalDateTime.parse("2018-01-01T00:00:00") till LocalDateTime.parse("2018-01-01T00:00:03")
// TimeRange(2018-01-01T00:00, 2018-01-01T00:00:01, 2018-01-01T00:00:02)

LocalDateTime.parse("2018-01-01T00:00") to LocalDateTime.parse("2018-01-01T06:00") by 2.hour
// TimeRange(2018-01-01T00:00, 2018-01-01T02:00, 2018-01-01T04:00, 2018-01-01T06:00)
```

`TimeRange[T]` extends `Seq[T]`, with a constant time `apply()` and linear time `length()`.
