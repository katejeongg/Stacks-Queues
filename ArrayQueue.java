import java.util.NoSuchElementException;

/**
 * Implementation of an ArrayQueue.
 */
public class ArrayQueue<T> {

    /*
     * The initial capacity of the ArrayQueue.
     *
     */
    public static final int INITIAL_CAPACITY = 9;


    private T[] backingArray;
    private int front;
    private int size;

    /**
     * Constructs a new ArrayQueue.
     */
    public ArrayQueue() {
        backingArray = (T[]) new Object[INITIAL_CAPACITY];
    }

    /**
     * Adds the data to the back of the queue.
     *
     *
     * @param data the data to add to the back of the queue
     * @throws IllegalArgumentException if data is null
     */
    public void enqueue(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Data is null.");
        }
        if (backingArray.length == size) {
            T[] newArray = (T[]) new Object[backingArray.length * 2];
            for (int i = 0; i < backingArray.length; i++) {
                newArray[i] = backingArray[(i + front) % backingArray.length];

            }
            newArray[size] = data;
            backingArray = newArray;
        } else {
            backingArray[(front + size) % backingArray.length] = data;
        }
        size++;
    }

    /**
     * Removes and returns the data from the front of the queue.
     *
     * @return the data formerly located at the front of the queue
     * @throws java.util.NoSuchElementException if the queue is empty
     */
    public T dequeue() {
        if (size == 0) {
            throw new NoSuchElementException("Stack is empty.");
        }
        T topElement = backingArray[front];
        backingArray[front] = null;
        front = front + 1;
        size--;
        return topElement;
    }

    /**
     * Returns the data from the front of the queue without removing it.
     *
     * @return the data located at the front of the queue
     * @throws java.util.NoSuchElementException if the queue is empty
     */
    public T peek() {
        if (size == 0) {
            throw new NoSuchElementException("Stack is empty.");
        }
        return backingArray[front];
    }

    /**
     * Returns the front index of the queue.
     *
     * @return the front index of the queue
     */
    public int getFront() {
        return front;
    }

    /**
     * Returns the backing array of the queue.
     *
     * @return the backing array of the queue
     */
    public T[] getBackingArray() {
        return backingArray;
    }

    /**
     * Returns the size of the queue.
     *
     * @return the size of the queue
     */
    public int size() {
        return size;
    }
}
