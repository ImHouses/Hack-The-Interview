
/**
 * List implemented using Arrays. The list automatically resizes if the 
 * array that holds is full.
 * 
 * @param <T> The type of the elements of this list.
 */
public class ArrayList<T> {

    private int MAX_SIZE = 64;
    private int size = 0;
    private T[] array;
    private int nextElementIndex = 0;

    ArrayList() {
        this.array = generateGenericArray(MAX_SIZE);
    }

    @SuppressWarnings("unchecked")
    private T[] generateGenericArray(int capacity) {
        return (T[]) new Object[capacity];
    }

    /**
     * Returns the number of elements contained in the list.
     * 
     * @return The number of elements contained in the list.
     */
    public int size() {
        return this.size;
    }

    /**
     * Returns the current capacity of the list.
     * 
     * @return The current capacity of the list.
     */
    public int capacity() {
        return this.MAX_SIZE;
    }
    
    /**
     * Returns true if the list is empty, false if not.
     * 
     * @return true if the list is empty, false if not.
     */
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    /**
     * Return the element located at the given index.
     * 
     * @param index The index where the element is located.
     * @return The element located at the given index.
     */
    public T elementAt(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Index cannot be lower than 0.");
        }
        return this.array[index];
    }

    /**
     * Adds a new element at the end of the list.
     * 
     * @param element The new element to add to the list.
     */
    public void push(T element) {
        resize();
        this.array[nextElementIndex] = element;
        this.nextElementIndex++;
        this.size++;
    }

    /**
     * Inserts a new element at the given index.
     * 
     * @param index The index where the new element will be located.
     * @param element The new element.
     */
    public void insert(int index, T element) {
        resize();
        if (this.nextElementIndex == index) {
            this.push(element);
            return;
        }
        T currentElement = this.array[index];
        this.array[index] = element;
        for (int i = index; i < this.nextElementIndex; i++) {
            T nextElement = this.array[i+1];
            this.array[i+1] = currentElement;
            currentElement = nextElement;
        }
        this.nextElementIndex++;
        this.size++;
    }

    /**
     * Deletes the last element of the list and returns it.
     * 
     * @return The last element of the list before deleting it.
     */
    public T pop() {
        T element = this.array[this.nextElementIndex-1];
        this.array[this.nextElementIndex-1] = null;
        this.nextElementIndex--;
        this.size--;
        return element;
    }

    /**
     * Returns a string representation of the list.
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < this.nextElementIndex-1; i++) {
            builder.append(String.format("%s, ", this.array[i].toString()));
        }
        builder.append(String.format("%s]", this.array[this.nextElementIndex-1].toString()));
        return builder.toString();
    }

    /**
     * Deletes the element located at the given index.
     * 
     * @param index The index of the element to be deleted.
     */
    public void delete(int index) {
        if (index >= this.nextElementIndex || index < 0) {
            throw new IllegalArgumentException();
        }
        if (this.nextElementIndex == index) {
            this.pop();
            return;
        }
        for (int i = index; i < this.nextElementIndex; i++) {
            this.array[i] = this.array[i+1];
        }
        this.size--;
        this.nextElementIndex--;
    }

    /**
     * Removes all occurences of the given element.
     * 
     * @param element The element to be removed from the list.
     */
    public void remove(T element) {
        ArrayList<T> nonMatchingElements = new ArrayList<>();
        for (int i = 0; i < this.nextElementIndex; i++) {
            if (!this.array[i].equals(element)) {
                nonMatchingElements.push(this.array[i]);
            }
        }
        int index = 0;
        while (index < nonMatchingElements.size()) {
            this.array[index] = nonMatchingElements.elementAt(index);
            index++;
        }
        this.size = nonMatchingElements.size();
        this.nextElementIndex = index;
    }

    /**
     * Finds an element and returns its index or -1 if it was not found.
     * 
     * @param element The element to find inside the list.
     * @return The index of the element or -1 if it was not found.
     */
    public int find(T element) {
        for (int i = 0; i < this.nextElementIndex; i++) {
            if (this.array[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Deletes all elements of the list.
     */
    public void clear() {
        for (int i = 0; i < this.nextElementIndex; i++) {
            this.array[i] = null;
        }
        this.size = 0;
        this.nextElementIndex = 0;
    }

    /**
     * Resizes the list in case is needed.
     */
    private void resize() {
        boolean needsResize = false;
        if (this.size == 1/4) {
            this.MAX_SIZE = this.MAX_SIZE / 2;
            needsResize = true;
        }
        if (this.size == this.MAX_SIZE) {
            this.MAX_SIZE = this.MAX_SIZE * 2;
            needsResize = true; 
        }
        T[] newArray = generateGenericArray(this.MAX_SIZE);
        if (needsResize) {
            for (int i = 0; i < this.nextElementIndex; i++) {
                newArray[i] = this.array[i];
            }
            this.array = newArray;
        }
    }
}