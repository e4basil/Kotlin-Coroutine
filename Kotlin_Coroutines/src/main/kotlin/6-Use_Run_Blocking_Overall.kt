import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {   // Executes in main thread
    useRunBlockingOverall()
}

fun useRunBlockingOverall() {
    runBlocking {  // creates a coroutine that blocks the current main thread
        // This coroutine runs on the main thread
        println("Main program starts ${Thread.currentThread().name}")

        GlobalScope.launch {  // Its creates a child coroutine but in a background thread
            // Meaning this entire code starts executing parallelly in a concurrent manner in the background.
            println("Fake work starts ${Thread.currentThread().name}")  // Thread T1
            delay(1000)      // Coroutine is suspended / pause ,  but thread T1 is free (not blocked)
            println("Fake work finished ${Thread.currentThread().name}") // Either T1 or some other thread
        }

        delay(2000) // executes on main thread

        println("Main program ends ${Thread.currentThread().name}")
    }
}