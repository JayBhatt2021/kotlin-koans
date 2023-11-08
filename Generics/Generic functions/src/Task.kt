import java.util.*

fun <T, C : MutableCollection<T>> Collection<T>.partitionTo(
    firstCollection: C,
    secondCollection: C,
    predicate: (T) -> Boolean
) : Pair<C, C> {
    for (element in this) {
        if (predicate(element)) {
            firstCollection.add(element)
        } else {
            secondCollection.add(element)
        }
    }
    return Pair(firstCollection, secondCollection)
}

fun partitionWordsAndLines() {
    val (words, lines) = listOf("a", "a b", "c", "d e")
        .partitionTo(ArrayList(), ArrayList()) { s -> !s.contains(" ") }
    check(words == listOf("a", "c"))
    check(lines == listOf("a b", "d e"))
}

fun partitionLettersAndOtherSymbols() {
    val (letters, other) = setOf('a', '%', 'r', '}')
        .partitionTo(HashSet(), HashSet()) { c -> c in 'a'..'z' || c in 'A'..'Z' }
    check(letters == setOf('a', 'r'))
    check(other == setOf('%', '}'))
}
