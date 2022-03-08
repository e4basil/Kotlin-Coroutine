import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis


fun main() = runBlocking {    // Creates a blocking coroutine that executes in current thread (main)

    println("Main program starts: ${Thread.currentThread().name}")  // main thread

    val time = measureTimeMillis {
        val msgOne: Deferred<String> = async { getMessageOneConcurrency() }
        val msgTwo: Deferred<String> = async { getMessageTwoConcurrency() }
        println("The entire message is: ${msgOne.await() + msgTwo.await()}")
    }

    println("Completed in $time ms")
    println("Main program ends: ${Thread.currentThread().name}")    // main thread
}

suspend fun getMessageOneConcurrency(): String {
    delay(1000L)    // pretend to do some work
    return "Hello "
}

suspend fun getMessageTwoConcurrency(): String {
    delay(1000L)    // pretend to do some work
    return "World!"
}