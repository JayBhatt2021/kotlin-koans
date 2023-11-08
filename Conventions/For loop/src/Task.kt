class DateRange(val startDate: MyDate, val endDate: MyDate) : Iterable<MyDate> {
    override fun iterator() =
        object : Iterator<MyDate> {
            var currentDate = startDate

            override fun hasNext() = currentDate <= endDate

            override fun next(): MyDate {
                if (!hasNext()) throw NoSuchElementException()

                val nextDate = currentDate

                // Actually moves currentDate to the next date
                // (Prevents infinite loop)
                currentDate = currentDate.followingDate()

                // Since currentDate is a reference type, the previous
                // statement actually changed the value of nextDate indirectly.
                return nextDate
            }
        }
}

fun iterateOverDateRange(firstDate: MyDate, secondDate: MyDate, handler: (MyDate) -> Unit) {
    for (date in firstDate..secondDate) {
        handler(date)
    }
}