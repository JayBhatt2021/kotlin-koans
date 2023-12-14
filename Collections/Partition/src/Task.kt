// Return customers who have more undelivered orders than delivered
fun Shop.getCustomersWithMoreUndeliveredOrders(): Set<Customer> = this.customers.filter { customer ->
    val (deliveredOrders, undeliveredOrders) = customer.orders.partition { it.isDelivered }
    undeliveredOrders.size > deliveredOrders.size
}.toSet()
