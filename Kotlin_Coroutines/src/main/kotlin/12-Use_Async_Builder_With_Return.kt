
import kotlinx.coroutines.*

fun main() {   // Executes in main thread
    useAsyncBuilderWithReturn()
}

fun useAsyncBuilderWithReturn() = runBlocking {  // creates a coroutine that blocks the current main thread
    // This coroutine runs on the main thread
    println("Main program starts ${Thread.currentThread().name}")

    val jobDeferred : Deferred<String> = async {  // Thread main
        // This child coroutine inherits the scope of parent coroutine
        println("Fake work starts ${Thread.currentThread().name}")
        delay(1000)
        println("Fake work finished ${Thread.currentThread().name}")
        "John"
    }

    // jobDeferred.join() (If you don't want to use the return value you can use this function)_

    // If you want to use the return value you can use function
    val result = jobDeferred.await()

    println("Return type  $result")

    println("Main program ends ${Thread.currentThread().name}")
}