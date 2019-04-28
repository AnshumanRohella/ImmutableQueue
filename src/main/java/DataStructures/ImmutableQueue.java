package DataStructures;

import Exceptions.EmptyQueueException;
import Exceptions.EmptyStackException;

public interface ImmutableQueue<T> {
    T peek() throws EmptyQueueException, EmptyStackException;

    ImmutableQueue<T> deQueue() throws EmptyQueueException, EmptyStackException;

    ImmutableQueue<T> enQueue(T data);

    boolean isEmpty();
}
