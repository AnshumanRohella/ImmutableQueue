package DataStructuresImplUnitTest;


import DataStructures.ImmutableStack;
import DataStructures.impl.ImmutableStackImpl;
import Exceptions.EmptyStackException;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class ImmutableStackImplTest {

    /**
     * Tests the basic functionality for a stack.
     *
     * @throws EmptyStackException If deQueue() is performed on an empty stack.
     */
    @Test
    public void testStackOperations() throws EmptyStackException {
        List<Integer> inputData = Arrays.asList(1, 2, 3, 4, 5, 6);
        Collections.reverse(inputData);
        List<Integer> assertionData = new ArrayList<>(inputData);
        Collections.reverse(inputData);

        ImmutableStack<Integer> stack = ImmutableStackImpl.getEmptyStack();
        int counter = 0;

        while (counter < inputData.size()) {
            stack = stack.push(inputData.get(counter));
            Assert.assertEquals(stack.peek(), inputData.get(counter));
            counter++;
        }
        counter = 0;

        while (counter < assertionData.size()) {
            Assert.assertEquals(stack.peek(), assertionData.get(counter));
            stack = stack.pop();
            counter++;
        }

        Assert.assertTrue(stack.isEmpty());
    }

    /**
     * Tests if the immutability property of the stack is preserved.
     *
     * @throws EmptyStackException if deQueue() is performed on an empty stack.
     */
    @Test
    public void testStackImmutability() throws EmptyStackException {
        ImmutableStack<Integer> stack = ImmutableStackImpl.getEmptyStack();
        ImmutableStack<Integer> cloneStack;
        stack = stack.push(1);
        stack = stack.push(2);
        stack = stack.push(3);

        // Add a reference to the stack.
        cloneStack = stack;

        // Pop an element.
        stack = stack.pop();

        // The two objects should not be equal if the stack is immutable.
        Assert.assertNotEquals(cloneStack, stack);
        Assert.assertNotEquals(cloneStack.peek(), stack.peek());

    }
}
