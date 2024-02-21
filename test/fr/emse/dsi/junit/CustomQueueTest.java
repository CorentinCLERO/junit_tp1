package fr.emse.dsi.junit;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

public class CustomQueueTest {
  CustomQueue<String> emptyQueue, singleElementQueue, multipleElementsQueue;

  @Before
  public void setUp() throws Exception {
    emptyQueue = new CustomQueue<>();

    singleElementQueue = new CustomQueue<>();
    singleElementQueue.enqueue("first");

    multipleElementsQueue = new CustomQueue<>();
    multipleElementsQueue.enqueue("first");
    multipleElementsQueue.enqueue("second");
    multipleElementsQueue.enqueue("third");
  }

  @Test
  public void testIsEmpty() {
    assertTrue(emptyQueue.isEmpty());
    assertFalse(singleElementQueue.isEmpty());
    assertFalse(multipleElementsQueue.isEmpty());
  }

  @Test
  public void testEnqueueDequeue() {
    emptyQueue.enqueue("new");
    assertEquals("new", emptyQueue.dequeue());
    assertTrue(emptyQueue.isEmpty());

    assertEquals("first", singleElementQueue.dequeue());
    assertTrue(singleElementQueue.isEmpty());

    assertEquals("first", multipleElementsQueue.dequeue());
    assertEquals("second", multipleElementsQueue.dequeue());
    assertFalse(multipleElementsQueue.isEmpty());
  }

  @Test
  public void testFront() {
    try {
      emptyQueue.front();
      fail("Should have thrown an exception");
    } catch (NoSuchElementException e) {
      // Expected exception
    }

    assertEquals("first", singleElementQueue.front());
    assertEquals("first", multipleElementsQueue.front());
  }
}
