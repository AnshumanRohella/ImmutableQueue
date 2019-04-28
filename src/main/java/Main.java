import DataStructures.ImmutableQueue;
import DataStructures.ImmutableStack;
import DataStructures.impl.ImmutableQueueImpl;
import DataStructures.impl.ImmutableStackImpl;
import Exceptions.EmptyQueueException;
import Exceptions.EmptyStackException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String... args) throws EmptyStackException, EmptyQueueException {
        ImmutableQueue<Integer> queue = ImmutableQueueImpl.getEmptyQueue();
        queue = queue.enQueue(1);
        queue = queue.enQueue(2);
        queue = queue.enQueue(3);
        System.out.println(queue.peek());
        queue = queue.deQueue();
        System.out.println(queue.peek());
        queue = queue.deQueue();
        System.out.println(queue.peek());

    }
}
