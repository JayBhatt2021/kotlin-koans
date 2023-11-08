fun doSomethingWithCollection(collection: Collection<String>): Collection<String>? {
    // Keys = string lengths while Values = collection of strings with the corresponding string lengths
    val groupsByLength = collection.groupBy { string -> string.length }

    // Obtains the largest group size
    val maximumSizeOfGroup = groupsByLength.values.maxOfOrNull { group -> group.size }

    // Obtains the first group whose size == maximumSizeOfGroup
    return groupsByLength.values.firstOrNull { group -> group.size == maximumSizeOfGroup }
}
