class LazyProperty(initializer: () -> Int) {
    val lazyValue: Int by lazy(initializer)
}
