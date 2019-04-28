package DataStructures;

import Exceptions.EmptyStackException;

public interface ImmutableStack<T> {

    ImmutableStack<T> push(T data);

    ImmutableStack<T> pop() throws EmptyStackException;

    T peek() throws EmptyStackException;

    boolean isEmpty();


}
