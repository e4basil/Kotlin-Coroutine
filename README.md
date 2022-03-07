# Kotlin-Coroutine
## Table of content
* [Basics And Foundation Of Coroutine](#Basics-And-Foundation-Of-Coroutine)
* [Coroutine Builders](#Coroutine-Builders)
* [Cancellation And Exception Handling](#Cancellation-And-Exception-Handling)
* [Compose Suspending Functions](#Compose-Suspending-Functions)
* [CoroutineScope, CoroutineContext and Dispatchers](#CoroutineScope,-CoroutineContext-and-Dispatchers)

### Basics And Foundation Of Coroutine
* What exactly a coroutine?
* How can you create them?
* What are coroutine builders such as launch, async and runblocking functions.
* What are suspending functions?
* How coroutine are different from threads?

### Coroutine Builders
* We will dive a little deeper into each coroutine builder.
* Use GlobalScope companion object to launch coroutines. 
* Why GlobalScope is discouraged to use? 
* We will write first test case using coroutine.

### Cancellation and Exception Handling
* Learn to cancel coroutines and handle exceptions.
* What is cooperative coroutine? How to write a cooperative code? 
* Explore job.cancel(), and job.cancelAndJoin() functions.
* Use of yield() and delay() suspending functions (suspend modifier). 
* Explore what is CoroutineScope.isActive boolean flag. 
* Handle CancellationException and TimeoutCancellationException.   
* Use withContext(NonCancellable), withTimeout, and withTimeoutOrNull coroutine builders

### Compose Suspending Functions
* Explore how code execution in coroutine is sequential by default.
* How to execute suspending functions in a coroutine concurrently?
* Lazily execute async coroutine by using CoroutineStart.LAZY 

### CoroutineScope, CoroutineContext and Dispatchers
* We will move to intermediate to little advanced concepts of coroutines.
* We will learn core concepts of coroutines such as CoroutineScope, CoroutineContext and Dispatchers.
* Understand what is CoroutineScope?
* What is CoroutineContext?
* What is a Dispatcher? 
        - Role of a dispatcher: to assign a thread to a coroutine. 
        - Types of Dispatcher: Confined, Unconfined, Default, Main, and IO
* Components of CoroutineContext: Job, Dispatcher, and Coroutine Name.
      
