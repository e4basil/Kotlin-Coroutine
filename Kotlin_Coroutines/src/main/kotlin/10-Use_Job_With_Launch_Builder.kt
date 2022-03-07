
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {   // Executes in main thread
    useJonWithLaunchBuilder()

}

fun useJonWithLaunchBuilder() = runBlocking {  // creates a coroutine that blocks the current main thread
    // This coroutine runs on the main thread
    println("Main program starts ${Thread.currentThread().name}")

    val job : Job = launch {  // Thread main
        // This child coroutine inherits the scope of parent coroutine
        println("Fake work starts ${Thread.currentThread().name}")
        delay(1000)
        println("Fake work finished ${Thread.currentThread().name}")
    }

    // delay(2000) // executes on main thread
    job.join()

    println("Main program ends ${Thread.currentThread().name}")
}