package fr.emse.dsi.junit;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Queue<E> {
    private LinkedList<E> list = new LinkedList<>();

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void push(E elem) {
        list.addLast(elem);
    }

    public E pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return list.removeFirst();
    }

    // Les nouvelles méthodes demandées
    public int size() {
        return list.size();
    }

    public E front() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return list.getFirst();
    }
}
