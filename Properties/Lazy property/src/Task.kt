class LazyProperty(private val initializer: () -> Int) {
    private var calledNumber: Int? = null
    val lazy: Int
        get() {
            if (calledNumber == null) {
                calledNumber = initializer()
            }
            return calledNumber!!
        }
}
