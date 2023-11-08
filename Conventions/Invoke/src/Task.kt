class Invokable {
    var numberOfInvocations: Int = 0
        private set

    // Keeps a record of numberOfInvocations in the current object
    operator fun invoke(): Invokable {
        numberOfInvocations++
        return this
    }
}

fun invokeTwice(invokable: Invokable) = invokable()()
