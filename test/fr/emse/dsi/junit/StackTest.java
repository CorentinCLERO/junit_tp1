package fr.emse.dsi.junit;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

public class StackTest {
  Stack<String> stackEmpty, stackOne, stackMany;

  @Before
  public void setUp() throws Exception {
    stackEmpty = new Stack<>();

    stackOne = new Stack<>();
    stackOne.push("test");

    stackMany = new Stack<>();
    stackMany.push("first");
    stackMany.push("second");
  }

  @Test
  public void testIsEmpty() {
    assertTrue(stackEmpty.isEmpty());
    assertFalse(stackOne.isEmpty());
    assertFalse(stackMany.isEmpty());
  }

  @Test
  public void testPush() {
    stackEmpty.push("pushTest");
    assertFalse(stackEmpty.isEmpty());
  }

  @Test
  public void testPop() {
    assertEquals("test", stackOne.pop());
    assertTrue(stackOne.isEmpty());

    assertEquals("second", stackMany.pop());
    assertEquals("first", stackMany.pop());
    assertTrue(stackMany.isEmpty());
  }

  @Test
  public void testSize() {
    assertEquals(0, stackEmpty.size());
    assertEquals(1, stackOne.size());
    assertEquals(2, stackMany.size());
  }

  @Test
  public void testTop() {
    try {
      stackEmpty.top();
      fail("Should have thrown an exception");
    } catch (NoSuchElementException e) {
      // Expected exception
    }

    assertEquals("test", stackOne.top());
    assertEquals(1, stackOne.size());

    assertEquals("second", stackMany.top());
    assertEquals(2, stackMany.size());
  }
}
