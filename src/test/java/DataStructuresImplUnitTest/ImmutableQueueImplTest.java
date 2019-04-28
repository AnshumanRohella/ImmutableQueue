package DataStructuresImplUnitTest;

import DataStructures.ImmutableQueue;
import DataStructures.impl.ImmutableQueueImpl;
import Exceptions.EmptyQueueException;
import Exceptions.EmptyStackException;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class ImmutableQueueImplTest {


    @Test
    public void testQueueOperations() throws EmptyQueueException, EmptyStackException {
        ImmutableQueue<Integer> queue = ImmutableQueueImpl.getEmptyQueue();
        Deque<Integer> inputData = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        for (Integer inputDatum : inputData) {
            queue = queue.enQueue(inputDatum);
        }
        while (!queue.isEmpty() && !inputData.isEmpty()) {
            Assert.assertEquals(queue.peek(), inputData.pop());
            queue = queue.deQueue();
        }
    }

    @Test
    public void testQueueImmutability() throws EmptyQueueException, EmptyStackException {
        ImmutableQueue<Integer> queue = ImmutableQueueImpl.getEmptyQueue();
        ImmutableQueue<Integer> cloneQueue;
        queue = queue.enQueue(1);
        queue = queue.enQueue(2);
        queue = queue.enQueue(3);

        // Same objects when referenced.
        cloneQueue = queue;
        Assert.assertEquals(cloneQueue, queue);

        queue = queue.deQueue();

        // The reference should change once the deQueue operation has been performed.
        Assert.assertNotEquals(cloneQueue, queue);

        // The values should be different since they don't refer the same object.
        Assert.assertNotEquals(cloneQueue.peek(), queue.peek());

    }
}
