package DataStructures.impl;

import DataStructures.ImmutableStack;
import Exceptions.EmptyStackException;

/**
 * This class represents an immutable Stack class. Each class consists of a
 * head variable which holds the value on the top of the stack, and a tail variable
 * which holds a reference to the immutable stack beneath the head value.
 * Each operation, push(), pop(), peek() and isEmpty() runs in O(1) constant time.
 * This data structure forms the base of {@link DataStructures.ImmutableQueue} implementation.
 *
 * Reference:
 * <b>https://blogs.msdn.microsoft.com/ericlippert/2007/12/04/immutability-in-c-part-two-a-simple-immutable-stack/</b>
 * @param <T>
 */
public final class ImmutableStackImpl<T> implements ImmutableStack<T> {

    private final T head;
    private final ImmutableStack<T> tail;

    private ImmutableStackImpl(T data, ImmutableStack<T> tail) {
        this.head = data;
        this.tail = tail;
    }

    public static ImmutableStack getEmptyStack() {
        return EmptyBaseStack.getInstance();
    }


    @Override
    public ImmutableStack<T> push(T data) {
        return new ImmutableStackImpl<>(data, this);
    }

    @Override
    public ImmutableStack<T> pop() {
        return tail;
    }

    @Override
    public T peek() {
        return this.head;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * A singleton representing the base empty Stack.
     * @param <T>
     */
    private final static class EmptyBaseStack<T> implements ImmutableStack<T> {
        private static final EmptyBaseStack instance = new EmptyBaseStack<>();

        private static EmptyBaseStack getInstance() {
            return instance;
        }

        @Override
        public ImmutableStack<T> push(T data) {
            return new ImmutableStackImpl<>(data, this);
        }

        @Override
        public ImmutableStack<T> pop() throws EmptyStackException {
            throw new EmptyStackException("Empty Stack!! Can't deQueue!!");
        }

        @Override
        public T peek() throws EmptyStackException {
            throw new EmptyStackException("Empty Stack!! Can't peek!!");
        }

        @Override
        public boolean isEmpty() {
            return true;
        }
    }
}
