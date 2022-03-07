import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {   // Executes in main thread
    customSuspendFunctionCall()

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