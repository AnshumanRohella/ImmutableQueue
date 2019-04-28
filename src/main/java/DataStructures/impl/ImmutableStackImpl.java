package DataStructures.impl;

import DataStructures.ImmutableStack;
import Exceptions.EmptyStackException;


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
