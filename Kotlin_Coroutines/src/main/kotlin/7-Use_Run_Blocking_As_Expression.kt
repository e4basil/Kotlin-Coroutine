import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {   // Executes in main thread
    makeFunctionAsRunBlockingExpression()

}

fun makeFunctionAsRunBlockingExpression() = runBlocking {  // creates a coroutine that blocks the current main thread
    // This coroutine runs on the main thread
    println("Main program starts ${Thread.currentThread().name}")

    GlobalScope.launch {
        println("Fake work starts ${Thread.currentThread().name}")
        delay(1000)
        println("Fake work finished ${Thread.currentThread().name}")
    }

    delay(2000) // executes on main thread

    println("Main program ends ${Thread.currentThread().name}")
}