fun containsEven(collection: Collection<Int>): Boolean =
    collection.any { number -> number % 2 == 0 }
