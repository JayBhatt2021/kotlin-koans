// Return customers who have more undelivered orders than delivered
fun Shop.getCustomersWithMoreUndeliveredOrders(): Set<Customer> =
    this.customers.filter { customer ->
        customer.orders.partition { order ->
            order.isDelivered
        }.let { (delivered, undelivered) ->
            delivered.size < undelivered.size
        }
    }.toSet()
