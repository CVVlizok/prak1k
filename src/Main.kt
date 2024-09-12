class Expense(var sumExpenses: Int, var category: String, var date: String) {

    fun displayList() {
        println("Сумма расхода: $sumExpenses, категория: $category, дата: $date")
    }
}

class ExpenseTracker {
    private val expensesList = mutableListOf<Expense>()

    fun addExpense(expenses: Expense) {
        expensesList.add(expenses)
    }

    fun categoryList(category: String) {
        expensesList.filter { it.category == category }.forEach { it.displayList() }
    }

    fun sumInCategory(category: String): Int {
        return expensesList.filter { it.category == category }.sumOf { it.sumExpenses }
    }

    fun allExpenses() {
        expensesList.forEach { it.displayList() }
    }
}

fun main() {
    val expenses = ExpenseTracker()

    expenses.addExpense(Expense(1234, "Продукты", "06/09/2024"))
    expenses.addExpense(Expense(54, "Транспорт", "12/05/2024"))
    expenses.addExpense(Expense(321, "Развлечения", "16/07/2024"))
    expenses.addExpense(Expense(5678, "Продукты", "26/08/2024"))

    println("Все расходы:")
    expenses.allExpenses()

    println("\nРасходы по категории продукты")
    expenses.categoryList("Продукты")

    println("\nСумма расходов по категории продукты")
    println(expenses.sumInCategory("Продукты"))
}