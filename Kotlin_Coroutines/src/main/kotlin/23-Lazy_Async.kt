import kotlinx.coroutines.*

fun main() = runBlocking {    // Creates a blocking coroutine that executes in current thread (main)

    println("Main program starts: ${Thread.currentThread().name}")  // main thread
    val msgOne: Deferred<String> = async(start = CoroutineStart.LAZY) { getMessageOneLazyAsync() }
    val msgTwo: Deferred<String> = async(start = CoroutineStart.LAZY) { getMessageTwoLazyAsync() }
    //println("The entire message is: ${msgOne.await() + msgTwo.await()}")

    println("Main program ends: ${Thread.currentThread().name}")    // main thread
}

suspend fun getMessageOneLazyAsync(): String {
    delay(1000L)    // pretend to do some work
    println("After working in getMessageOne()")
    return "Hello "
}

suspend fun getMessageTwoLazyAsync(): String {
    delay(1000L)    // pretend to do some work
    println("After working in getMessageTwo()")
    return "World!"
}