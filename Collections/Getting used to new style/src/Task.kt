fun doSomethingWithCollection(collection: Collection<String>): Collection<String>? {
    // Key = string length
    // Value = collection of strings with the corresponding string length
    val groupsByLength = collection.groupBy { string -> string.length }

    // Obtains the largest value size of the groupsByLength map
    val maximumSizeOfGroup = groupsByLength.values.maxOfOrNull { group -> group.size }

    // Obtains the first value whose size == maximumSizeOfGroup
    return groupsByLength.values.firstOrNull { group -> group.size == maximumSizeOfGroup }
}
