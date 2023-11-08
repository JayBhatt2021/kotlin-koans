import TimeInterval.*

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int)

// Supported intervals that might be added to the dates:
enum class TimeInterval { DAY, WEEK, YEAR }

// For only adding a single TimeInterval to the current MyDate object
operator fun MyDate.plus(timeInterval: TimeInterval): MyDate = this.addTimeIntervals(timeInterval, 1)

// Holds a TimeInterval and its RHS coefficient
class MultipliedTimeInterval(val timeInterval: TimeInterval, val coefficient: Int)

// For multiplying a number to the current TimeInterval
operator fun TimeInterval.times(coefficient: Int): MultipliedTimeInterval = MultipliedTimeInterval(this, coefficient)

// For adding a MultipliedTimeInterval to the current MyDate object
operator fun MyDate.plus(multipliedTimeInterval: MultipliedTimeInterval): MyDate =
    this.addTimeIntervals(multipliedTimeInterval.timeInterval, multipliedTimeInterval.coefficient)

fun task1(today: MyDate): MyDate {
    return today + YEAR + WEEK
}

fun task2(today: MyDate): MyDate {
    return today + YEAR * 2 + WEEK * 3 + DAY * 5
}
