package fr.emse.dsi.junit;

import java.util.NoSuchElementException;

public class CustomQueue<E> {
  private Node<E> head, tail;

  public CustomQueue() {
    head = tail = null;
  }

  public boolean isEmpty() {
    return head == null;
  }

  public void enqueue(E element) {
    Node<E> newNode = new Node<>(element);
    if (tail == null) {
      head = tail = newNode;
    } else {
      tail.next = newNode;
      tail = newNode;
    }
  }

  public E dequeue() {
    if (isEmpty()) {
      throw new NoSuchElementException("Queue is empty");
    }
    E element = head.element;
    head = head.next;
    if (head == null) {
      tail = null;
    }
    return element;
  }

  public E front() {
    if (isEmpty()) {
      throw new NoSuchElementException("Queue is empty");
    }
    return head.element;
  }
}
