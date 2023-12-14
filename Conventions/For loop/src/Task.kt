class DateRange(val start: MyDate, val end: MyDate) : Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> {
        return object : Iterator<MyDate> {
            var currentDate = start

            override fun hasNext() = currentDate <= end

            override fun next(): MyDate {
                if (hasNext()) {
                    val result = currentDate
                    currentDate = result.followingDate()
                    return result
                } else {
                    throw NoSuchElementException()
                }
            }

        }
    }
}

fun iterateOverDateRange(firstDate: MyDate, secondDate: MyDate, handler: (MyDate) -> Unit) {
    for (date in firstDate..secondDate) {
        handler(date)
    }
}