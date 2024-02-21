package fr.emse.dsi.junit;

import java.util.NoSuchElementException;

public class Stack<E> {
  private java.util.LinkedList<E> list = new java.util.LinkedList<>();

  public boolean isEmpty() {
    return list.isEmpty();
  }

  public void push(E elem) {
    list.addFirst(elem);
  }

  public E pop() {
    if (isEmpty()) {
      throw new NoSuchElementException("Stack is empty");
    }
    return list.removeFirst();
  }

  public int size() {
    return list.size();
  }

  public E top() {
    if (isEmpty()) {
      throw new NoSuchElementException("Stack is empty");
    }
    return list.getFirst();
  }
}
