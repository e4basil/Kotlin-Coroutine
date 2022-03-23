# Kotlin-Coroutine
## Table of content
* [Guide Line And Video Link](#Guide-Line-And-Video-Link)
* [What we will cover in this repository](#What-we-will-cover-in-this-repository)
* [1- Basics And Foundation Of Coroutine](#1-Basics-And-Foundation-Of-Coroutine)
* [2- Coroutine Builders](#2-Coroutine-Builders)
* [3- Cancellation And Exception Handling](#3-Cancellation-And-Exception-Handling)
* [4- Compose Suspending Functions](#4-Compose-Suspending-Functions)
* [5- CoroutineScope, CoroutineContext and Dispatchers](#5-CoroutineScope,-CoroutineContext-and-Dispatchers)
* [What are coroutines](#What-are-coroutines)
* [Couroutine Scope vs Coroutines context](#Couroutine Scope vs Coroutines context)

### Guide Line And Video Link
https://www.youtube.com/watch?v=lmRzRKIsn1g&t=576s <br />
https://github.com/smartherd/KotlinTutorial/tree/master/src

### What we will cover in this repository
1- Basics And Foundation Of Coroutine <br>
2- Coroutine Builders <br>
3- Cancellation and Exception Handling <br>
4- Compose Suspending Functions <br>
5- CoroutineScope, CoroutineContext and Dispatchers <br>

### 1-Basics And Foundation Of Coroutine
* What exactly a coroutine?
* How can you create them?
* What are coroutine builders such as launch, async and runblocking functions.
* What are suspending functions?
* How coroutine are different from threads?

### 2-Coroutine Builders
* We will dive a little deeper into each coroutine builder.
* Use GlobalScope companion object to launch coroutines. 
* Why GlobalScope is discouraged to use? 
* We will write first test case using coroutine.

### 3-Cancellation and Exception Handling
* Learn to cancel coroutines and handle exceptions.
* What is cooperative coroutine? How to write a cooperative code? 
* Explore job.cancel(), and job.cancelAndJoin() functions.
* Use of yield() and delay() suspending functions (suspend modifier). 
* Explore what is CoroutineScope.isActive boolean flag. 
* Handle CancellationException and TimeoutCancellationException.   
* Use withContext(NonCancellable), withTimeout, and withTimeoutOrNull coroutine builders

### 4-Compose Suspending Functions
* Explore how code execution in coroutine is sequential by default.
* How to execute suspending functions in a coroutine concurrently?
* Lazily execute async coroutine by using CoroutineStart.LAZY 

### 5-CoroutineScope, CoroutineContext and Dispatchers
* We will move to intermediate to little advanced concepts of coroutines.
* We will learn core concepts of coroutines such as CoroutineScope, CoroutineContext and Dispatchers.
* Understand what is CoroutineScope?
* What is CoroutineContext?
* What is a Dispatcher? 
        - Role of a dispatcher: to assign a thread to a coroutine. 
        - Types of Dispatcher: Confined, Unconfined, Default, Main, and IO
* Components of CoroutineContext: Job, Dispatcher, and Coroutine Name.

### Why we need coroutines
* Well to understand what are coroutines , you would need to first understand, how exactly your application works when user launches your application.
* So when the user launches the application, a default **THREAD** is created and this thread is known as **MAIN THREAD**.
* Now this main thread is the life of the application. 
* Let us represent the main thread with the help of this blue arrow.
* So what is the purpose of having a main thread , On this main thread we perform very small and lightweight operations <br />
  Such as UI interactions , click on the buttons , mathematical operation  or light weight logical operations. 
* So basically on the main thread we perform small operations.
* Now what about long and heavy operations,<br />
  Such as that requires the use of internet or upload or download of a file or loading and displaying an image from a server or running some heavy database queries.
* If you run all these heavy operation on the same main thread , then in that case your main thread will be blocked.
* When your main thread gets blocked then your application will freeze. In simple words it will get hanged.
* Incase your main thread remains blocked for a longer time such as 5 seconds or something then eventually your application will shut down with a crash message.
* Instead of using the main thread , we can create a worker thread or the background thread. On this background thread we can run heavy operations.<br />
  Such as we can create a thread to perform some network operations.<br />
  We can create another background thread to download or upload a file.<br />
  Similarly we can launch more threads to load images or to perform some heavy database queries.<br />
  So in general you always create a new thread to perform some operations without affecting main thread.
* These background threads sounds like a solution, but there is a limit of how many background threads you can create at a time in your application, because creating thread is very very expensive.
* If you create more and more threads then there would be a time when your device will run out of memory. And eventually once again your application will shut down with a crash message.
* Hence creating so many background threads is also not a good idea.
* Here comes coroutines into the picture.
* When you use coroutines then you don't have to create so many threads for each operation. Instead you have just one background thread And on this thread you can launch coroutines.<br />
 Such as launch a coroutine to perform file upload <br />
 Launch another coroutine on same background threadto perform some network operations.<br />
 Similary launch one more coroutine to download a file.<br />
 Similary we can have more coroutines to perform other operations.
* **NOTE** In short with the memory consumption of one background thread you can perform so many heavy operations.

### How we define coroutines
* You can think of coroutines as light weight threads.
* Like threads coroutines can run in parallel, wait for each other to finish and even communicate with each other.
* **Remember** coroutines are not threads.
* Coroutines are very very cheap , they are almost free we can create thousands of them and we don't need to worry about memory consumption, your application will run as smooth as you can imagine. Thats not possible incase of threads, you cannot create thousands of threads at a time.
* So for modern applications coroutines are indeed the modern solution.

### Couroutine Scope vs Coroutines context

The scope provides a reference(e.g. Job) to cancel them and context provides a reference to underlying thread. 
  
#### Scope

A coroutine must run in a scope <br />
It is a way to keep track of all coroutines that run in it <br />
All (cooperative) coroutines can be cancelled via their scope <br />
Scopes get uncaught exceptions <br />
They are a way to bind coroutines to an application specific lifecycle (e.g. viewModelScope in Android) to avoid leaking <br />

#### Context

The context determines on which thread the coroutines will run. There are four options:

Dispatchers.Default - for CPU intense work (e.g. sorting a big list) <br />
Dispatchers.Main - what this will be depends on what you've added to your programs runtime dependencies (e.g. kotlinx-coroutines-android, for the UI thread in Android) <br />
Dispatchers.Unconfined - runs coroutines unconfined on no specific thread <br />
Dispatchers.IO - for heavy IO work (e.g. long-running database queries)<br />
