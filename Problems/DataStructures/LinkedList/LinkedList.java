/**
 * Class for Double Linked List's where each node has a previous and a next node.
 * https://en.wikipedia.org/wiki/Linked_list
 * @param <T> The type of the elements of the list.
 */
class LinkedList<T> {

    /**
     * Node class for the list.
     * Each Node contains an element.
     */
    private class Node {
        
        /* The previous node. */
        Node previous = null;
        /* The next node. */
        Node next = null;
        /* The element that the Node holds. */
        T element;

        /**
         * Node constructor.
         * 
         * @param element The element the node will be holding.
         */
        Node(T element) {
            this.element = element;
        }
    }
    
    /* The head of the list. */
    private Node head;
    /* The tail of the list. */
    private Node tail;
    /* The size of the list. */
    private int size;


    /**
     * The constructor of the list.
     * Initializes the head and tail to null and the size to 0.
     */
    LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Returns the current size of the list.
     * 
     * @return The current size of the list.
     */
    public int size() {
        return this.size;
    }

    /**
     * Returns the first element of the list.
     * 
     * @return The first element of the list.
     */
    public T getFirst() {
        return this.head == null ? null : this.head.element;
    }

    /**
     * Returns the last element of the list.
     * 
     * @return The last element of the list.
     */
    public T getLast() {
        return this.tail == null ? null : this.tail.element;
    }

    /**
     * Returns the element located at the given index.
     * 
     * @param index The index of the element to be returned.
     * @return The element located at the given index.
     */
    public T getElementAt(int index) {
        Node iterator = this.head;
        int i = 0;
        while (iterator != null) {
            if (i == index) {
                return iterator.element;
            }
            i++;
            iterator = iterator.next;
        }
        return null;
    }

    /**
     * Adds an element at the given index.
     * 
     * @param index The index where the given element will be placed.
     * @param element The new element to be added.
     */
    public void addElementAt(int index, T element) {
        Node iterator = this.head;
        int i = 0;
        while (iterator != null) {
            if (i == index && i == this.size-1) {
                this.addEnd(element);
            } else if (i == index && i == 0) {
                this.addStart(element);
            } else if (i == index) {
                Node newNode = new Node(element);
                iterator.previous.next = newNode;
                newNode.previous = iterator.previous;
                iterator.previous = newNode;
                newNode.next = iterator;
            }
            i++;
            iterator = iterator.next;
        }
    }

    /**
     * Adds an element at the start of the list.
     * 
     * @param element The new element to be added at the start.
     */
    public void addStart(T element) {
        if (this.head == null) {
            this.addEmpty(element);
        } else {
            Node newNode = new Node(element);
            this.head.previous = newNode;
            newNode.next = this.head;
            this.head = newNode;
        }
        this.size++;
    }

    /**
     * Adds an element at the end of the list.
     * 
     * @param element The new element to be added at the end.
     */
    public void addEnd(T element) {
        if (this.head == null) {
            this.addEmpty(element);
        } else {
            Node newNode = new Node(element);
            this.tail.next = newNode;
            newNode.previous = this.tail;
            this.tail = newNode;
        }
        this.size++;
    }

    /**
     * Returns true if the given element is contained in the list, false if not.
     * 
     * @param element The element to be searched inside the list.
     */
    public boolean containsElement(T element) {
        Node iterator = this.head;
        while (iterator != null) {
            if (iterator.element.equals(element)) {
                return true;
            }
            iterator = iterator.next;
        }
        return false;
    }

    /**
     * Removes the first element.
     */
    public void popStart() {
        if (this.head == null) {
            return;
        }
        if (this.size == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.head.next.previous = null;
            this.head = this.head.next;
        }
        this.size--;
    }

    /**
     * Removes the last element.
     */
    public void popEnd() {
        if (this.head == null) {
            return;
        }
        if (this.size == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.tail.previous.next = null;
            this.tail = this.tail.previous;
        }
        this.size--;
    }

    /**
     * Add the given element to the list.
     * This will add the new element at the end of the list.
     * 
     * @param element The new element of the list.
     */
    public void add(T element) {
        this.addEnd(element);
    }

    /**
     * Returns a String representation of the list.
     * 
     * @return A String representation of the list.
     */
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("[");
        Node iterator = this.head;
        while (iterator != this.tail) {
            buffer.append(String.format("%s, ", iterator.element.toString()));
            iterator = iterator.next;
        }
        buffer.append(String.format("%s]", iterator.element.toString()));
        return buffer.toString();
    }

    /**
     * Removes the element located at the given index.
     * @param index The index where is located the element to be removed.
     */
    public void removeAtIndex(int index) {
        if (this.size <= index) {
            throw new IllegalArgumentException("Invalid index.");
        }
        if (this.size == 1) {
            this.popEnd();
            return;
        }
        if (index == 0) {
            this.popStart();
            return;
        }
        if (index == this.size-1) {
            this.popEnd();
            return;
        }
        int i = 0;
        Node iterator = this.head;
        while (iterator != null) {
            if (i == index) {
                iterator.next.previous = iterator.previous;
                iterator.previous.next = iterator.next;
                iterator = null;
                this.size--;
                return;
            }
            i++;
            iterator = iterator.next;
        }
    }

    /**
     * Removes the first occurence of the given element.
     * 
     * @param element The element to be removed.
     */
    public void remove(T element) {
        Node iterator = this.head;
        while (iterator != null) {
            if (iterator == this.head && iterator.element.equals(element)) {
                popStart();
            } else if (iterator == this.tail && iterator.element.equals(element)) {
                popEnd();
            } else {
                iterator.previous.next = iterator.next;
                iterator.next.previous = iterator.previous;
                this.size--;
                iterator = null;
                return;
            }
        }
    }

    /**
     * Removes all the occurences of the given element.
     * 
     * @param element The element to be removed.
     */
    public void removeAllOccurences(T element) {
        Node iterator = this.head;
        while (iterator != null) {
            if (iterator == this.head && iterator.element.equals(element)) {
                popStart();
            } else if (iterator == this.tail && iterator.element.equals(element)) {
                popEnd();
            } else if (iterator != this.head && iterator != this.tail && iterator.element.equals(element)) {
                iterator.previous.next = iterator.next;
                iterator.next.previous = iterator.previous;
                this.size--;
            }
            iterator = iterator.next;
        }
    }
    
    /**
     * Removes all the elements of the list.
     */
    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Add an element when the list is empty.
     */
    private void addEmpty(T element) {
        Node newNode = new Node(element);
        this.head = newNode;
        this.tail = newNode;
        this.size++;
    }
}