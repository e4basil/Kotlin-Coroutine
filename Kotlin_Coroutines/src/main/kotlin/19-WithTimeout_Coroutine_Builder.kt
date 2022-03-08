import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout

fun main() = runBlocking {    // Creates a blocking coroutine that executes in current thread (main)

    println("Main program starts: ${Thread.currentThread().name}")  // main thread

    withTimeout(1300) {
        try {
            for (i in 0..1000) {
                println("\nMain program withTimeout: ${Thread.currentThread().name}")
                print("$i.")
                delay(500)
            }
        } catch (ex: TimeoutCancellationException) {
            // .. code..
        } finally {
            // .. code..
        }
    }

    println("\nMain program ends: ${Thread.currentThread().name}")    // main thread
}