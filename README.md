# Minitime

A Scala wrapper around `java.time`

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


## Ordering
