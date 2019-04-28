package DataStructures.impl;

import DataStructures.ImmutableQueue;
import DataStructures.ImmutableStack;
import Exceptions.EmptyQueueException;
import Exceptions.EmptyStackException;

/**
 * Immutable queue uses two {@link ImmutableStack}, front and back to mimic the
 * operation of a Queue data structure. Every enQueue to the queue pushes an element
 * in the back {@link ImmutableStack}. Every deQueue operation pops an element from the
 * front {@link ImmutableStack}. Every enQueue operation takes constant O(1) time. Every deQueue
 * operation takes O(1) and O(n) time in the worst case. The worst case arises when the
 * front {@link ImmutableStack} is empty. In that case, the whole back stack needs to be
 * reversed and "pushed" into the front stack. ( Note that there is no actual pushing of elements
 * in {@link ImmutableStack}. The front instance of the Queue is just replaced by the reversed
 * back stack.
 *
 * @param <T>
 * @author luci
 */
@SuppressWarnings("unchecked")
public final class ImmutableQueueImpl<T> implements ImmutableQueue<T> {

    ImmutableStack<T> front;
    ImmutableStack<T> back;

    public static ImmutableQueue getEmptyQueue() {
        return EmptyBaseQueue.getInstance();
    }

    private ImmutableQueueImpl(ImmutableStack<T> front, ImmutableStack<T> back) {
        this.front = front;
        this.back = back;
    }


    @Override
    public T peek() throws EmptyQueueException, EmptyStackException {
        if (!front.isEmpty()) {
            try {
                return front.peek();
            } catch (EmptyStackException e) {
                throw new EmptyQueueException("Empty Queue!! Can't peek.");
            }
        } else if (!back.isEmpty()) {
            reverse(back).peek();
        }
        throw new EmptyQueueException("Empty Queue!! Can't peek");
    }

    @Override
    public ImmutableQueue<T> deQueue() throws EmptyQueueException, EmptyStackException {
        ImmutableStack<T> frontStack;
        try {
            frontStack = this.front.pop();
        } catch (EmptyStackException e) {
            throw new EmptyQueueException("Empty Queue!! Can't deQueue.");
        }
        if (!frontStack.isEmpty()) {
            return new ImmutableQueueImpl<>(frontStack, back);
        }

        // All elements have been popped.
        if (back.isEmpty()) {
            return ImmutableQueueImpl.getEmptyQueue();
        } else { // "push" all the elements from back stack to front stack.
            return new ImmutableQueueImpl<>(reverse(back), ImmutableStackImpl.getEmptyStack());
        }
    }

    @Override
    public ImmutableQueue<T> enQueue(T data) {
        return new ImmutableQueueImpl(this.front, this.back.push(data));
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    private static final class EmptyBaseQueue<T> implements ImmutableQueue<T> {

        private static final EmptyBaseQueue emptyBaseQueue = new EmptyBaseQueue();

        private static EmptyBaseQueue getInstance() {
            return emptyBaseQueue;
        }

        @Override
        public T peek() throws EmptyQueueException {
            throw new EmptyQueueException("Empty Queue!! Can't peek.");
        }

        @Override
        public ImmutableQueue<T> deQueue() throws EmptyQueueException {
            throw new EmptyQueueException("Empty Queue!! Can't deQueue.");
        }


        @Override
        public ImmutableQueue<T> enQueue(T data) {
            return new ImmutableQueueImpl<>(ImmutableStackImpl.getEmptyStack().push(data),
                    ImmutableStackImpl.getEmptyStack());
        }

        @Override
        public boolean isEmpty() {
            return true;
        }
    }

    private static ImmutableStack reverse(ImmutableStack stack) throws EmptyStackException {
        ImmutableStack temp = ImmutableStackImpl.getEmptyStack();
        while (!stack.isEmpty()) {
            temp = temp.push(stack.peek());
            stack = stack.pop();
        }
        return temp;
    }
}
