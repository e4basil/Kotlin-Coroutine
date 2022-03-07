import kotlin.concurrent.thread

fun main() {   // Executes in main thread
    createBackgroundThread()

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