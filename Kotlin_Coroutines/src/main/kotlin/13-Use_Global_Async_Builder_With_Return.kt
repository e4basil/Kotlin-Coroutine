
import kotlinx.coroutines.*

fun main() {   // Executes in main thread
    useGlobalAsyncBuilderWithReturn()

}

fun useGlobalAsyncBuilderWithReturn() = runBlocking {  // creates a coroutine that blocks the current main thread
    // This coroutine runs on the main thread
    println("Main program starts ${Thread.currentThread().name}")

    val jobDeferred : Deferred<String> = GlobalScope.async {  // Thread T1
        // This child coroutine inherits the scope of parent coroutine
        println("Fake work starts ${Thread.currentThread().name}")
        delay(1000)
        println("Fake work finished ${Thread.currentThread().name}")
        "John"
    }

    jobDeferred.join()
    // If you want to use the return value you can use function
    //jobDeferred.await()

    println("Main program ends ${Thread.currentThread().name}")
}