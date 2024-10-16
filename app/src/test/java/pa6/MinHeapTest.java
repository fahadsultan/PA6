
package pa6;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MinHeapTest {

    @Test
    void testInsert() {
        MinHeap heap = new MinHeap(5);
        heap.insert(5);
        heap.insert(3);
        heap.insert(8);
        heap.insert(1);
        heap.insert(2);
        assertEquals(1, heap.peek());
    }    

    @Test
    void testDelete() {
        MinHeap heap = new MinHeap(5);
        heap.insert(5);
        heap.insert(3);
        heap.insert(8);
        heap.insert(1);
        heap.insert(2);
        assertEquals(1, heap.delete());
        assertEquals(2, heap.delete());
        assertEquals(3, heap.delete());
        assertEquals(5, heap.delete());
        assertEquals(8, heap.delete());
    }

    @Test
    void testPeek() {
        MinHeap heap = new MinHeap(5);
        heap.insert(5);
        heap.insert(3);
        heap.insert(8);
        heap.insert(1);
        heap.insert(2);
        assertEquals(1, heap.peek());
    }

    @Test
    void testSize() {
        MinHeap heap = new MinHeap(5);
        heap.insert(5);
        heap.insert(3);
        heap.insert(8);
        heap.insert(1);
        heap.insert(2);
        assertEquals(5, heap.size());
    }

    @Test
    void testIsEmpty() {
        MinHeap heap = new MinHeap(5);
        assertTrue(heap.isEmpty());
        heap.insert(5);
        assertFalse(heap.isEmpty());
    }

    @Test
    void testPrint() {
        MinHeap heap = new MinHeap(5);
        heap.insert(5);
        heap.insert(3);
        heap.insert(8);
        heap.insert(1);
        heap.insert(2);
        heap.print();
    }

    @Test
    void testHeapSort() {
        int[] array = {5, 3, 8, 1, 2};
        int[] sortedArray = MinHeap.heapSort(array);
        assertArrayEquals(new int[]{1, 2, 3, 5, 8}, sortedArray);
    }
    
}
