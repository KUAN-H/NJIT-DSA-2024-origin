package oy.tol.tra;


public class StackImplementation<E> implements StackInterface<E> {

    private Object [] itemArray;
    private int capacity;
    private int currentIndex = -1;
    private static final int DEFAULT_STACK_SIZE = 10;

    public StackImplementation() throws StackAllocationException {
        this(10);
    }

    public StackImplementation(int capacity) throws StackAllocationException {
        if (capacity < 2) {
            throw new StackAllocationException("Size should be at least 2.");
        }
        this.capacity = capacity;
        this.itemArray = new Object[capacity];
        this.currentIndex = -1;

    }

    @Override
    public int capacity() {

        return capacity;
    }

    @Override
    public void push(E element) throws StackAllocationException, NullPointerException {
        if (element == null) {

            throw new NullPointerException("Element is null.");
        }

        if (currentIndex == capacity - 1) {

            int newCapacity = capacity * 2;
            Object[] newArray = new Object[newCapacity];
            for (int i = 0; i < capacity; i++) {
                newArray[i] = itemArray[i];
            }
            itemArray = newArray;
            capacity = newCapacity;
        }

        currentIndex++;
        itemArray[currentIndex] = element;

    }


    @Override
    public E pop() throws StackIsEmptyException {
        if (isEmpty()) {
            throw new StackIsEmptyException("Stack is empty.");
        }

        E element = (E) itemArray[currentIndex];
        itemArray[currentIndex] = null;
        currentIndex--;

        return element;
    }

    @Override
    public E peek() throws StackIsEmptyException {
        if (isEmpty()) {
            throw new StackIsEmptyException("Stack i empty.");
        }

        return (E) itemArray[currentIndex];
    }

    @Override
    public int size() {

        return currentIndex + 1;
    }

    @Override
    public void clear() {
        for (int i = 0; i <= currentIndex; i++) {
            itemArray[i] = null;
        }
        currentIndex = -1;
    }

    @Override
    public boolean isEmpty() {

        return currentIndex== -1;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder("[");
        for (var index = 0; index <= currentIndex; index++) {
            builder.append(itemArray[index].toString());
            if (index < currentIndex) {
                builder.append(", ");
            }
        }
        builder.append("]");
        return builder.toString();
    }
}