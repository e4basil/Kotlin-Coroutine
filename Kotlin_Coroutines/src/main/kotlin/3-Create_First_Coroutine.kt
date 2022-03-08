import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun main() {   // Executes in main thread
    createFirstCoroutine()

}


fun createFirstCoroutine() {
    println("Main program starts ${Thread.currentThread().name}")

    GlobalScope.launch {  // create a background coroutine that runs on background thread
        println("Fake work starts ${Thread.currentThread().name}")
        Thread.sleep(1000)      // Pretend doing some work... may be file uploading
        println("Fake work finished ${Thread.currentThread().name}")
    }

    Thread.sleep(2000)

    println("Main program ends ${Thread.currentThread().name}")

    // Just note that in case of coroutines, the application didn't wait for all coroutine to complete.
    /* When we launch a coroutine the application by default don't know it has to wait for the coroutine code to end.
       This is a difference between while using thread and while using coroutine
     */
}