// Find the most expensive product among all the delivered products
// ordered by the customer. Use `Order.isDelivered` flag.
fun findMostExpensiveProductBy(customer: Customer): Product? =
    customer.orders.asSequence().filter { order ->
        order.isDelivered
    }.flatMap { deliveredOrder ->
        deliveredOrder.products
    }.maxByOrNull { deliveredProduct ->
        deliveredProduct.price
    }


// Count the amount of times a product was ordered.
// Note that a customer may order the same product several times.
fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int =
    this.customers.asSequence().flatMap { customer ->
        customer.getOrderedProducts()
    }.count { it == product }

fun Customer.getOrderedProducts(): Sequence<Product> =
    this.orders.asSequence().flatMap { it.products }
