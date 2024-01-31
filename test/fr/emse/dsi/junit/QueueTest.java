package fr.emse.dsi.junit;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

public class QueueTest {
	Queue<String> fa0, fa1, fa2;

	@Before
	public void setUp() throws Exception {
		fa0 = new Queue<String>();

		fa1 = new Queue<String>();
		fa1.push("plop");

		fa2 = new Queue<String>();
		fa2.push("a");
		fa2.push("b");
	}

	@Test
	public void testIsEmpty() {
		assertTrue(fa0.isEmpty());
		assertFalse(fa1.isEmpty());
	}

	@Test
	public void testPush() {
		assertTrue(fa0.isEmpty());
		fa0.push("toto");
		assertFalse(fa0.isEmpty());
	}

	@Test
	public void testPop() {
		// exception
		try {
			fa0.pop();
			fail();
		} catch (Exception e) {
			// ok
		}
		assertEquals(fa1.pop(), "plop");
		assertTrue(fa1.isEmpty());
		assertEquals(fa2.pop(), "a");
		assertEquals(fa2.pop(), "b");
		assertTrue(fa2.isEmpty());
	}

	@Test
	public void testSize() {
		assertEquals(0, fa0.size());
		assertEquals(1, fa1.size());
		assertEquals(2, fa2.size());
	}

	@Test
	public void testFront() {
		// Exception pour la file vide
		try {
			fa0.front();
			fail("Should have thrown an exception");
		} catch (NoSuchElementException e) {
			// ok
		}

		assertEquals("plop", fa1.front());
		assertEquals(1, fa1.size());

		assertEquals("a", fa2.front());
		assertEquals(2, fa2.size());
	}

}
