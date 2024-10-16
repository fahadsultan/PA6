package pa6;

public class MinHeap implements Heap {
    
    private int[] heap;
    private int size;
    private int capacity;

    public MinHeap(int capacity) {
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

    private void swap(int index1, int index2) {
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    private void bubbleUp() {
        int index = size - 1;
        while (index > 0 && heap[index] < heap[parent(index)]) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    private void bubbleDown() {
        int index = 0;
        while (index < size && !isValidParent(index)) {
            int smallerChildIndex = smallerChildIndex(index);
            swap(index, smallerChildIndex);
            index = smallerChildIndex;
        }
    }

    private boolean isValidParent(int index) {
        if (!hasLeftChild(index)) {
            return true;
        }
        if (!hasRightChild(index)) {
            return heap[index] <= heap[leftChild(index)];
        }
        return heap[index] <= heap[leftChild(index)] && heap[index] <= heap[rightChild(index)];
    }

    private int smallerChildIndex(int index) {
        if (!hasLeftChild(index)) {
            return index;
        }
        if (!hasRightChild(index)) {
            return leftChild(index);
        }
        return heap[leftChild(index)] < heap[rightChild(index)] ? leftChild(index) : rightChild(index);
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    private boolean hasLeftChild(int index) {
        return leftChild(index) < size;
    }

    private boolean hasRightChild(int index) {
        return rightChild(index) < size;
    }

    public static int[] heapSort(int[] array) {
        MinHeap minHeap = new MinHeap(array.length);
        for (int i = 0; i < array.length; i++) {
            minHeap.insert(array[i]);
        }
        int[] sortedArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            sortedArray[i] = minHeap.delete();
        }
        return sortedArray;
    }


    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(8);
        minHeap.insert(1);
        minHeap.insert(2);
        minHeap.insert(7);
        minHeap.insert(6);
        minHeap.insert(4);
        minHeap.insert(9);
        minHeap.insert(10);
        minHeap.print();
        System.out.println("Root: " + minHeap.peek());
        System.out.println("Deleted: " + minHeap.delete());
        minHeap.print();
        System.out.println("Root: " + minHeap.peek());
        System.out.println("Deleted: " + minHeap.delete());
        minHeap.print();
        System.out.println("Root: " + minHeap.peek());
        System.out.println("Deleted: " + minHeap.delete());
        minHeap.print();
        System.out.println("Root: " + minHeap.peek());
        System.out.println("Deleted: " + minHeap.delete());
        minHeap.print();
        System.out.println("Root: " + minHeap.peek());
        System.out.println("Deleted: " + minHeap.delete());
        minHeap.print();
        System.out.println("Root: " + minHeap.peek());
        System.out.println("Deleted: " + minHeap.delete());
        minHeap.print();
        System.out.println("Root: " + minHeap.peek());
        System.out.println("Deleted: " + minHeap.delete());
        minHeap.print();
        System.out.println("Root: " + minHeap.peek());
        System.out.println("Deleted: " + minHeap.delete());
        minHeap.print();
        System.out.println("Root: " + minHeap.peek());
        System.out.println("Deleted: " + minHeap.delete());
        minHeap.print();
        System.out.println("Root: " + minHeap.peek());
        System.out.println("Deleted: " + minHeap.delete());
        minHeap.print();
    }

}
