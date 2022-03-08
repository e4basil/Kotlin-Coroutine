import kotlinx.coroutines.*

fun main() = runBlocking {    // Creates a blocking coroutine that executes in current thread (main)

    println("Main program starts: ${Thread.currentThread().name}")  // main thread

    val job: Job = launch(Dispatchers.Default) {     // Thread T1: Creates a non-blocking coroutine
        for (i in 0..500) {
            if(!isActive){
                break;
                // also use return@launch
            }
            print("$i.")
            //delay(1)
             Thread.sleep(1)
            // we are using Thread.sleep() here in place of delay() to check the isActive status.
            // if we use delay here it will work as cooperative suspend function
        }
    }

    delay(10)  // Let's print a few values before we cancel
    job.cancelAndJoin()

    println("\nMain program ends: ${Thread.currentThread().name}")    // main thread
}