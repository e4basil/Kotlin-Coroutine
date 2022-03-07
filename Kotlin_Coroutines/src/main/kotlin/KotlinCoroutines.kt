import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

fun main() {   // Executes in main thread
    customSuspendFunctionCall()

}

fun checkMainThread() {
    println("Main program starts ${Thread.currentThread().name}")

    // do some work here

    println("Main program ends ${Thread.currentThread().name}")
}

fun createBackgroundThread() {
    println("Main program starts ${Thread.currentThread().name}")

    thread {  // create a background thread (worker thread)
        println("Fake work starts ${Thread.currentThread().name}")
        Thread.sleep(1000)      // Pretend to do some work... may be file uploading
        println("Fake work finished ${Thread.currentThread().name}")
    }

    println("Main program ends ${Thread.currentThread().name}")

    // The background thread did not block the code of the main thread , these two threads are running in parallel.
    // Hence immediately after line 19 was executed , the code within the main thread resumes.
    // They ran in parallel i.e in a concurrent manner.
    // Just note that in case of threads, the application waits for all background threads to complete.
}

fun createFirstCoroutine() {
    println("Main program starts ${Thread.currentThread().name}")

    GlobalScope.launch {  // create a background coroutine that runs on background thread
        println("Fake work starts ${Thread.currentThread().name}")
        Thread.sleep(1000)      // Pretend doing some work... may be file uploading
        println("Fake work finished ${Thread.currentThread().name}")
    }

    //Thread.sleep(2000)

    println("Main program ends ${Thread.currentThread().name}")

    // Just note that in case of coroutines, the application didn't wait for all coroutine to complete.
    /* When we launch a coroutine the application by default don't know it has to wait for the coroutine code to end.
       This is a difference between while using thread and while using coroutine
     */
}

fun createCoroutineWithDelay() {
    println("Main program starts ${Thread.currentThread().name}")

    GlobalScope.launch {  // Thread T1
        println("Fake work starts ${Thread.currentThread().name}")  // Thread T1
        delay(1000)      // Coroutine is suspended / pause ,  but thread T1 is free (not blocked)
        println("Fake work finished ${Thread.currentThread().name}") // Either T1 or some other thread
    }

    Thread.sleep(2000)

    println("Main program ends ${Thread.currentThread().name}")

}

fun useDelayInPlaceOfThread() {
    println("Main program starts ${Thread.currentThread().name}")

    GlobalScope.launch {  // Thread T1
        println("Fake work starts ${Thread.currentThread().name}")  // Thread T1
        delay(1000)      // Coroutine is suspended / pause ,  but thread T1 is free (not blocked)
        println("Fake work finished ${Thread.currentThread().name}") // Either T1 or some other thread
    }

    runBlocking {   // creates a coroutine that blocks the current main thread
        delay(2000)
    }

    println("Main program ends ${Thread.currentThread().name}")

    /*
      GlobalScope.launch() is non blocking in nature whereas
      runblocking() blocks the thread in which it operates
     */
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

fun customSuspendFunctionCall() = runBlocking {
    println("Main program starts ${Thread.currentThread().name}")

    GlobalScope.launch {
        println("Fake work starts ${Thread.currentThread().name}")
        myCustomSuspendDelayFunction(1000)
        println("Fake work finished ${Thread.currentThread().name}")
    }

    myCustomSuspendDelayFunction(2000)

    println("Main program ends ${Thread.currentThread().name}")
}

suspend fun myCustomSuspendDelayFunction(time: Long) {
    delay(time)
}