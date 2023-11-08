// Return the set of products that were ordered by all customers
fun Shop.getProductsOrderedByAll(): Set<Product> {
    val allProductsSet = this.customers.flatMap { it.getOrderedProducts() }.toSet()
    return this.customers.fold(allProductsSet) { productsOrderedByAllCustomers, customer ->
        productsOrderedByAllCustomers.intersect(customer.getOrderedProducts().toSet())
    }
}

fun Customer.getOrderedProducts(): List<Product> =
    this.orders.flatMap { it.products }