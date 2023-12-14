// Return the set of products that were ordered by all customers
fun Shop.getProductsOrderedByAll(): Set<Product> = this.customers.map {
    it.getOrderedProducts()
}.reduce { productsOrderedByAll, customerProducts ->
    productsOrderedByAll.intersect(customerProducts)
}

fun Customer.getOrderedProducts(): Set<Product> =
    this.orders.flatMap { it.products }.toSet()