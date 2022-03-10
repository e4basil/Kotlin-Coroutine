import kotlinx.coroutines.*

fun main() = runBlocking {    // Creates a blocking coroutine that executes in current thread (main)

    println("Main program starts: ${Thread.currentThread().name}")  // main thread

    val job: Job = launch {
        for (i in 0..500) {
            print("$i.")
            delay(100)
            // check documentation of delay() or yield()
            //yield()     // or use delay() or any other suspending function as per your need.
        }
    }

    delay(1000)  // Let's print a few values before we cancel
    //job.cancelAndJoin()  // we can also use this function
    job.cancel()
    job.join()

    println("\nMain program ends: ${Thread.currentThread().name}")    // main thread
}