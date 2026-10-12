# 🧵 Multithreading

Multithreading is the process of executing multiple threads concurrently within a process.

A **thread** is an independent path of execution inside a process.

---

## 📌 1. Process vs Thread

* **Process** → A program in execution.
* **Thread** → A lightweight unit of execution within a process.
* Multiple threads of the same process share resources such as heap memory.

---

## 📌 2. Concurrency

**Concurrency** means multiple tasks make progress during overlapping periods of time.

> Threads do not necessarily execute at exactly the same time. The JVM/OS scheduler decides which thread gets CPU time.

Multithreading can improve CPU/resource utilization, especially when one thread is waiting for I/O or another resource.

---

## 📌 3. Creating Threads

Java provides two common approaches:

1. Extending `Thread`
2. Implementing `Runnable`

`Runnable` separates the **task** from the **thread** that executes it.

---

# 🔄 Thread Lifecycle & States

Important thread states:

| State           | Meaning                                        |
| --------------- | ---------------------------------------------- |
| `NEW`           | Thread object created but not started          |
| `RUNNABLE`      | Thread is ready to run or currently running    |
| `BLOCKED`       | Waiting to acquire a monitor lock              |
| `WAITING`       | Waiting indefinitely for another thread/action |
| `TIMED_WAITING` | Waiting for a specified amount of time         |
| `TERMINATED`    | Execution has finished                         |

---

# 🎚️ Thread Priority

Java thread priorities range from **1 to 10**.

```text
MIN_PRIORITY    = 1
NORM_PRIORITY   = 5
MAX_PRIORITY    = 10
```

Priority is only a **scheduling hint**.

> Higher priority does **not** guarantee that a thread will execute first.

A newly created thread inherits the priority of its creator at the time it is created.

---

# 👻 Daemon Threads

A **daemon thread** is a background thread that does not keep the JVM alive.

`setDaemon(true)` must be called **before** starting the thread.

If no non-daemon threads remain, the JVM can terminate even if daemon threads are still running.

---

# 🔒 `synchronized`

`synchronized` provides **mutual exclusion** using a monitor lock.

Only one thread at a time can execute synchronized code protected by the **same lock**.

It can be used with:

* Synchronized methods
* Synchronized blocks

An instance synchronized method locks `this`.

A synchronized block allows us to protect only the required **critical section**.

### Critical Section

A critical section is the part of code that accesses shared mutable data and requires protection.

> Different objects have different monitor locks, so synchronized methods on different objects can execute concurrently.

---

# 🚦 BLOCKED vs WAITING vs TIMED_WAITING

| State           | General situation                      |
| --------------- | -------------------------------------- |
| `BLOCKED`       | Waiting to acquire a monitor lock      |
| `WAITING`       | Waiting indefinitely                   |
| `TIMED_WAITING` | Waiting for a specified amount of time |

A thread calling `wait()` releases the monitor and enters a waiting state.

A thread calling `sleep()` enters timed waiting but **does not release locks it holds**.

---

# 🔔 `wait()`, `notify()`, `notifyAll()`

These methods are used for **thread communication**.

* `wait()` → releases the monitor and waits.
* `notify()` → wakes one waiting thread.
* `notifyAll()` → wakes all waiting threads.

The notified thread does not immediately continue; it must first reacquire the monitor.

Use a condition-checking loop:

```java
while (!condition) {
    lock.wait();
}
```

> `wait()`, `notify()`, and `notifyAll()` must be used while owning the corresponding object's monitor.

---

# 💀 Deadlock

A **deadlock** occurs when threads wait indefinitely for locks/resources held by each other.

Typical situation:

```text
Thread 1: Lock A → waits for Lock B
Thread 2: Lock B → waits for Lock A
```

### Four Necessary Conditions

1. **Mutual exclusion**
2. **Hold and wait**
3. **No preemption**
4. **Circular wait**

### Prevention

A common technique is **consistent lock ordering**:

```text
Always acquire Lock A → then Lock B
```

Another approach is to avoid holding one lock while waiting for another.

> `interrupt()` does not automatically break a thread blocked trying to acquire a normal `synchronized` monitor.

---

# 🔐 `ReentrantLock`

`ReentrantLock` provides **explicit lock control**.

Important capabilities include:

* `lock()`
* `unlock()`
* `tryLock()`
* Timed `tryLock()`
* Reentrant locking

> A successfully acquired lock should be released, typically using `finally`.

### Reentrant Nature

The same thread can acquire the same lock multiple times.

If a thread acquires a lock 3 times, it must release it 3 times.

---

# 👀 `volatile`

`volatile` mainly provides **visibility**, not atomicity.

It is useful when one thread needs to observe changes made by another thread.

However:

```java
volatile int count;
count++;
```

is still **not atomic**.

---

# ⚛️ Atomic Classes

Atomic classes provide atomic operations for common shared-state operations.

For example:

```java
AtomicInteger count = new AtomicInteger(0);
```

Important operations include:

* `incrementAndGet()`
* `getAndIncrement()`
* `compareAndSet()`

`compareAndSet()` performs a **Compare-And-Set (CAS)** operation.

---

# 🏊 ExecutorService & Thread Pools

Instead of creating a large number of threads manually, an `ExecutorService` can manage a pool of worker threads.

A fixed thread pool has a fixed number of worker threads.

Extra tasks wait in the executor's queue.

Worker threads can be reused for multiple tasks.

### Benefits

* Thread reuse
* Controlled number of threads
* Task queueing
* Easier thread management

---

# 📦 Runnable vs Callable

| `Runnable`                          | `Callable`                            |
| ----------------------------------- | ------------------------------------- |
| `run()`                             | `call()`                              |
| Returns `void`                      | Returns a value                       |
| Cannot declare checked exceptions   | Can throw checked exceptions          |
| Suitable for tasks without a result | Suitable for tasks producing a result |

---

# 📋 Future

A `Future` represents the result of an asynchronous computation.

It can be used to:

* Obtain the result
* Check completion
* Cancel a task
* Check cancellation

---

# 🛑 Executor Shutdown

### `shutdown()`

Stops accepting new tasks while allowing already submitted tasks to complete.

### `shutdownNow()`

Attempts to interrupt running tasks and returns tasks that were still waiting in the queue.

> Neither method guarantees that a running task will stop immediately.

Submitting a task after shutdown results in `RejectedExecutionException`.

---

# 🚀 CompletableFuture

`CompletableFuture` provides a way to build **asynchronous pipelines** and coordinate multiple asynchronous operations.

Common operations include:

```text
supplyAsync()
thenApply()
thenAccept()
thenCompose()
exceptionally()
handle()
thenCombine()
thenAcceptBoth()
allOf()
anyOf()
```

### Basic flow

```text
supplyAsync()
      ↓
thenApply()
      ↓
thenAccept()
```

### Composition

`thenCompose()` is used to chain dependent asynchronous operations.

### Exception Handling

* `exceptionally()` → handles exceptional completion with a fallback.
* `handle()` → handles both successful and exceptional completion.

### Combining

* `thenCombine()` → combines results from two independent futures.
* `thenAcceptBoth()` → consumes results from two futures.
* `allOf()` → completes when all supplied futures complete.
* `anyOf()` → completes when any supplied future completes.

---