fun main() {   // Executes in main thread
    checkMainThread()
}
fun checkMainThread() {
    println("Main program starts ${Thread.currentThread().name}")

    // do some work here

    println("Main program ends ${Thread.currentThread().name}")
}