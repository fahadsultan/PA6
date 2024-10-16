package pa6;

public class MaxHeap implements Heap {
    private int[] heap;
    private int size;
    private int capacity;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    public void insert(int value) {
        if (size == capacity) {
            System.out.println("Heap is full");
            return;
        }
        heap[size] = value;
        size++;
        bubbleUp();
    }

    public int delete() {
        if (size == 0) {
            System.out.println("Heap is empty");
            return -1;
        }
        int root = heap[0];
        heap[0] = heap[size - 1];
        size--;
        bubbleDown();
        return root;
    }

    public int peek() {
        if (size == 0) {
            System.out.println("Heap is empty");
            return -1;
        }
        return heap[0];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static int[] heapSort(int[] array) {

        MaxHeap heap = new MaxHeap(array.length);
        int[] sortedArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            heap.insert(array[i]);
        }

        for (int i = 0; i < array.length; i++) {
            sortedArray[i] = heap.delete();
        }

        return sortedArray;

    }

    private void bubbleUp() {
        int index = size - 1;
        while (index > 0 && heap[index] > heap[parent(index)]) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    private void bubbleDown() {
        int index = 0;
        while (index < size && !isValidParent(index)) {
            int largerChildIndex = largerChildIndex(index);
            swap(index, largerChildIndex);
            index = largerChildIndex;
        }
    }

    private boolean isValidParent(int index) {
        if (!hasLeftChild(index)) {
            return true;
        }
        if (!hasRightChild(index)) {
            return heap[index] >= leftChild(index);
        }
        return heap[index] >= leftChild(index) && heap[index] >= rightChild(index);
    }

    private int largerChildIndex(int index) {
        if (!hasLeftChild(index)) {
            return index;
        }
        if (!hasRightChild(index)) {
            return leftChildIndex(index);
        }
        return leftChild(index) > rightChild(index) ? leftChildIndex(index) : rightChildIndex(index);
    }

    private boolean hasLeftChild(int index) {
        return leftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return rightChildIndex(index) < size;
    }

    private int leftChild(int index) {
        return heap[leftChildIndex(index)];
    }

    private int rightChild(int index) {
        return heap[rightChildIndex(index)];
    }

    private int leftChildIndex(int index) {
        return index * 2 + 1;
    }

    private int rightChildIndex(int index) {
        return index * 2 + 2;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private void swap(int index1, int index2) {
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }
    
}
