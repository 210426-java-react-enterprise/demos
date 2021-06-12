package com.revature.structures;

public interface Queue<T> extends Collection<T> {
    T poll();
    T peek();
}
