// Return all products the given customer has ordered
fun Customer.getOrderedProducts(): List<Product> =
    this.orders.flatMap { it.products }

// Return all products that were ordered by at least one customer
fun Shop.getOrderedProducts(): Set<Product> =
    this.customers.flatMap { customer ->
        customer.getOrderedProducts() // first function
    }.toSet()
