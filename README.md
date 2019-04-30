##Immutable Queue

This is my attempt to implement an immutable queue in Java.

Unlike a conventional/mutable queue, immutable queue returns a new queue
when something is added/removed from the queue. The implementation of an immutable queue uses two immutable stacks to
mimic the behaviour of a queue. The complexities for various operations on the queue are as follows:
* enQueue (insert) : O(1)
* deQueue (remove) : O(1) (best case) & O(n) (worst case)
* peek (get the top element) : O(1)
* isEmpty : O(1)

The queue internally maintains two immutable stacks, front and back. Enqueue operation
adds an element to the front stack whereas deQueue operation removes an element from the back
stack. In case the the back stack is empty, all the elements from front stack need to be
"pushed" into the back stack. This results O(n) complexity in the worst case of deQueue operation.

The references for this implementation are as follows:
* [Immutable Stacks](https://blogs.msdn.microsoft.com/ericlippert/2007/12/04/immutability-in-c-part-two-a-simple-immutable-stack/)
* [Immutable Queue](https://blogs.msdn.microsoft.com/ericlippert/2007/12/10/immutability-in-c-part-four-an-immutable-queue/)
* [Immutable Collections](https://www.youtube.com/watch?v=pUXeNAeyY34)