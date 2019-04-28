package DataStructuresImplUnitTest;

import DataStructures.ImmutableQueue;
import DataStructures.impl.ImmutableQueueImpl;
import org.junit.Test;

public class ImmutableQueueImplTest {


    @Test
    public void testQueueOperations(){
        ImmutableQueue<Integer> queue = ImmutableQueueImpl.getEmptyQueue();
        queue = queue.enQueue(1);
        queue = queue.enQueue(2);
        queue = queue.enQueue(3);


    }
}
