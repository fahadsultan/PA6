
package pa6;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MaxHeapTest {

    @Test
    void testInsert() {
        MaxHeap heap = new MaxHeap(5);
        heap.insert(5);
        heap.insert(3);
        heap.insert(8);
        heap.insert(1);
        heap.insert(2);
        assertEquals(8, heap.peek());
    }

    @Test
    void testDelete() {
        MaxHeap heap = new MaxHeap(5);
        heap.insert(5);
        heap.insert(3);
        heap.insert(8);
        heap.insert(1);
        heap.insert(2);
        assertEquals(8, heap.delete());
        assertEquals(5, heap.peek());
    }

    @Test
    void testPeek() {
        MaxHeap heap = new MaxHeap(5);
        heap.insert(5);
        heap.insert(3);
        heap.insert(8);
        heap.insert(1);
        heap.insert(2);
        assertEquals(8, heap.peek());
    }

    @Test
    void testSize() {
        MaxHeap heap = new MaxHeap(5);
        heap.insert(5);
        heap.insert(3);
        heap.insert(8);
        heap.insert(1);
        heap.insert(2);
        assertEquals(5, heap.size());
    }

    @Test
    void testIsEmpty() {
        MaxHeap heap = new MaxHeap(5);
        assertTrue(heap.isEmpty());
        heap.insert(5);
        assertFalse(heap.isEmpty());
    }

    @Test
    void testPrint() {
        MaxHeap heap = new MaxHeap(5);
        heap.insert(5);
        heap.insert(3);
        heap.insert(8);
        heap.insert(1);
        heap.insert(2);
        heap.print();
    }


}
