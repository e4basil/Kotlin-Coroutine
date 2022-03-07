import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {   // Executes in main thread
    useDelayInPlaceOfThread()

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