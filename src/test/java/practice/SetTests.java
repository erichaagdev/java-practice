package practice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SetTests {

    Set setWithOneItem;
    Set setWithMultipleItems;

    @BeforeEach
    void beforeEach() {
        setWithOneItem = new Set();
        setWithMultipleItems = new Set();

        setWithOneItem.add(1);
        setWithMultipleItems.add(1);
        setWithMultipleItems.add(2);
        setWithMultipleItems.add(3);
    }

    @Test
    void testIsEmpty() {
        Set emptySet = new Set();

        assertTrue(emptySet.isEmpty());
        assertFalse(setWithOneItem.isEmpty());
        assertFalse(setWithMultipleItems.isEmpty());
    }

    @Test
    void testSize() {
        Set emptySet = new Set();

        assertEquals(0, emptySet.size());
        assertEquals(1, setWithOneItem.size());
        assertEquals(3, setWithMultipleItems.size());
    }

    @Test
    void testContains() {
        Set emptySet = new Set();

        assertFalse(emptySet.contains(1));
        assertTrue(setWithOneItem.contains(1));
        assertTrue(setWithMultipleItems.contains(2));
        assertFalse(setWithMultipleItems.contains(4));
    }

    @Test
    void testRemove() {
        Set emptySet = new Set();

        emptySet.remove(1);

        assertEquals(0, emptySet.size());

        setWithOneItem.remove(1);

        assertTrue(setWithOneItem.isEmpty());
        assertEquals(0, setWithOneItem.size());
        assertFalse(setWithOneItem.contains(1));

        setWithMultipleItems.remove(2);
        setWithMultipleItems.remove(4);

        assertFalse(setWithMultipleItems.isEmpty());
        assertEquals(2, setWithMultipleItems.size());
        assertFalse(setWithMultipleItems.contains(2));
    }

    @Test
    void testNoDuplicates() {
        setWithOneItem.add(1);

        assertEquals(1, setWithOneItem.size());
    }
}
