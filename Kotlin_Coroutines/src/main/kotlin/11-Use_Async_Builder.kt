
import kotlinx.coroutines.*

fun main() {   // Executes in main thread
    useAsyncBuilder()

}

fun useAsyncBuilder() = runBlocking {  // creates a coroutine that blocks the current main thread
    // This coroutine runs on the main thread
    println("Main program starts ${Thread.currentThread().name}")

    val job :Job = async {  // Thread main
        // This child coroutine inherits the scope of parent coroutine
        println("Fake work starts ${Thread.currentThread().name}")
        delay(1000)
        println("Fake work finished ${Thread.currentThread().name}")
    }

    job.join()

    println("Main program ends ${Thread.currentThread().name}")
}