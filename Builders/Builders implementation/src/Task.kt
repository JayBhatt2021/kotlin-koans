open class Tag(private val name: String) {
    protected val children = mutableListOf<Tag>()

    override fun toString() =
        "<$name>${children.joinToString("")}</$name>"
}

fun table(init: TABLE.() -> Unit): TABLE {
    val table = TABLE()
    table.init()
    return table
}

class TABLE : Tag("table") {
    fun tr(init: TR.() -> Unit) {
        val tr = TR()
        tr.init()
        children.add(tr)
    }
}

class TR : Tag("tr") {
    fun td(init: TD.() -> Unit) {
        val td = TD()
        td.init()
        children.add(td)
    }
}

class TD : Tag("td")

fun createTable() =
    table {
        tr {
            repeat(2) {
                td {
                }
            }
        }
    }

fun main() {
    println(createTable())
    //<table><tr><td></td><td></td></tr></table>
}
