interface Deque <T> {
    // create an interface, that contains all the methods in both ArrayDeque and LinkedList
// check out the DequeAPI
    public void addFirst(T item);

    public void addLast(T item);

    public boolean isEmpty();

    public int size();

    public String toString();

    public T removeFirst();

    public T removeLast();

    public T get(int index);

}

// modify LinkedListDeque and/or ArrayDeque so that they implement the Deque interface
    // add implements Deque<T>
// add @Override tags for the method that overrides a Deque method

class ArrayDeque <T> implements Deque <T> {
    //starts with aar of size 8
    // for array size 16 or more your utilisation should always be at least 25%
    //  You may add any private helper classes or methods in the same file as you see fit.

    // TIP
    /* to support the add and remove ops. in constant time. (independent w/ size)
     *  try learn about circular buffer in 5.3, it has code example
     *
     * dont do resizing yet, but you'll have to do it at the end
     *
     * 4.3 discusses some idea(s) for resizing the underlying array
     */

    private T[] arr;
    public int front, end, size;


    // Creates an empty array deque.
    public ArrayDeque() {
        arr = (T[]) new Object[8];
        size = 0;
        front = end = -1;
    }

    // Creates a deep copy of other.
    public ArrayDeque(ArrayDeque<T> other) {
        // create a new array to store

        // loop through the same way and put it in
        // make sure the front and back is the same

        T[] newArr = (T[]) new Object[other.cap()];

        this.front = other.front;
        this.end = other.end;
        this.size = other.size;

        int act = 0;
        for (int index = front; index < other.arr.length && act < other.size; index++) {
            newArr[index] = other.arr[index];
            act++;
        }
        if (act < size) {
            for (int i = 0; i < end + 1; i++) {
                newArr[i] = other.arr[i];
                act++;
            }
        }

        this.arr = newArr;
    }

    public void grow(int n) {
        T[] newArr = (T[]) new Object[n];
//        System.arraycopy(arr, 0, newArr, 0, size);
        int act = 0;
        for (int i = front; i < arr.length && act < size; i++) {
            newArr[act] = arr[i];
            act++;
        }

        if (act < size) {
            for (int i = 0; i < end + 1; i++) {
                newArr[act] = arr[i];
                act++;
            }
        }

        front = 0;
        end = size - 1;

        arr = newArr;
    }

    @Override
    // Adds an item of type T to the front of the deque.
    public void addFirst(T item) {
        if (isEmpty()) { // if empty
            end++;
            front += 2; // front is now 1
        } else if (size == arr.length) { // if full
            grow((arr.length) * 2);
            addFirst(item);
            return;
        } else {
            int check = front - 1;
            if (check == -1) { // if it's -1 == we have to add it to the end
                // we have to check if the end of the list is occupied or not, the arr is full
                if (size == arr.length) {
                    grow((arr.length) * 2);
                }
                front = (arr.length); // index is at the end of the arr
            }
        }
        front--;
        arr[front % (arr.length)] = item;
        size++;
    }

    @Override
    // Adds an item of type T to the back of the deque.
    public void addLast(T item) {

        if (size == arr.length) { // if full
            grow((arr.length) * 2);
        } else if (isEmpty()) {
            front++; // set front from -1 to 0
        }
        end++;
        arr[end % (arr.length)] = item;
        size++;

    }

    @Override
    // Returns true if deque is empty, false otherwise.
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    // Returns the number of items in the deque.
    public int size() {
        return (this.size);
    }

    @Override
    // Returns a string showing the items in the deque from first to last, // separated by a space.
    public String toString() {
        // track the amount of elements that we've print out
        int act = 0;

        // there are gonna be 2 loops
        // loop starts from front until you find the end of the arr
        // after done looping check if act == size?
        // yes then break;s
        // no then loop starts from the index 0 until act == size;
        String results = "";

        for (int i = front; i < arr.length && act < size; i++) {
            results += arr[i].toString() + " ";
            act++;
        }

        if (act < size) {
            for (int i = 0; i < end + 1; i++) {
                results += arr[i].toString() + " ";
                act++;
            }
        }
        return results;
    }

    @Override
    // Removes and returns the item at the front of the deque. // If no such item exists, returns null.
    public T removeFirst() {
        T res = arr[front];
        if (isEmpty())
            return null;
        if (front == (arr.length - 1)) {
            front = 0;
        } else {
            front++;// if you plus then the index will be out of range if first is at the end
        }

        size--;
        Shrink();
        return res;
    }

    @Override
    // Removes and returns the item at the back of the deque. // If no such item exists, returns null.
    public T removeLast() {
        // you have to set the removed element to null for the garbage collector
        // and return the element that you removed

        // store the item first
        T lastitem = arr[end];

        int last_ind = end;
        if (!isEmpty()) {
            if (end == 0) {
                end = front;
            } else {
                end--;
            }
            size--;
            if (!isEmpty()) {
                arr[last_ind] = null;
                Shrink();
            }
        }
        return lastitem;
    }

    @Override
    // Gets the item at the given index, where 0 is the front, 1 is the next item, // and so forth. If no such item exists, returns null. Must not alter the deque!
    // if you know the first one and the last one so you know the middle one right?
    public T get(int index) {
        int expind = (front + index) % arr.length;
        if (index > arr.length) {
            return null;
        } else {
            return arr[expind];
        }
    }

    public int cap() {
        return arr.length;
    }

    public void Shrink() {
        double ratio = size/(this.cap());
        if (this.cap() > 16) {
            if (ratio < 2.5) {
                grow(size*2);// grow smaller
            }
        }
    }

}



class LinkedListDeque <T> implements Deque<T> {


    class Node {
        private T head;
        private Node prev, next;

        public Node(T head, Node prev, Node next) {
            this.head = head;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node sen;
    private int size;

    // Creates an empty linked list deque.
    public LinkedListDeque() {

        sen = new Node(null, null, null);
        sen.prev= sen;
        sen.next = sen;
        size = 0;

    }


    // Creates a deep copy of other.
    public LinkedListDeque(LinkedListDeque<T> other) {
        // A good test is, if you change other, the “copied” LinkedListDeque should not change.

        /* iterate through linked list
		use get() to get the head put in
		make sure there is a link for prev and next */

        sen = new Node(null, null, null);
        sen.prev= sen;
        sen.next = sen;
        size = 0;

        Node currNodeOth = other.sen.next;
        for (int i = 0; i < other.size; i++) {
            T value = currNodeOth.head;
            this.addLast(value);
            currNodeOth = currNodeOth.next;
        }

    }

    @Override
    // Adds an item of type T to the front of the deque.
    public void addFirst(T item) {
        sen.next = new Node(item, sen, sen.next);
        sen.next.next.prev = sen.next;
        size++;
    }


    @Override
    // Adds an item of type T to the back of the deque.
    public void addLast(T item) {
        sen.prev= new Node(item, sen.prev, sen);
        sen.prev.prev.next = sen.prev;

        size++;

    }



    @Override
    // Returns true if deque is empty, false otherwise.
    public boolean isEmpty() {
        return size == 0;
    }


    @Override
    // Returns the number of items in the deque.
    public int size() { return this.size;}


    @Override
    // Returns a string showing the items in the deque from first to last, // separated by a space.
    public String toString() {
        Node currNode = sen.next;
        String result = "";

        for (int i = 0; i < size; i++) {
            result += currNode.head.toString() + " ";
            currNode = currNode.next;
        }

        return result;
    }


    @Override
    // Removes and returns the item at the front of the deque. // If no such item exists, returns null.
    public T removeFirst() {
        Node firstNode = sen.next;
        T firstitem = firstNode.head;
        sen.next = firstNode.next;
        firstNode.prev = sen;
        size--;
        firstNode.head = null;

        return firstitem;
    }


    @Override
    // Removes and returns the item at the back of the deque. // If no such item exists, returns null.
    public T removeLast() {

        Node lastnode = sen.prev;
        T lastitem = lastnode.head;
        lastnode.prev.next = sen;
        sen.prev = lastnode.prev;
        size--;
        lastnode.head = null;
        return lastitem;
    }


    @Override
    // Gets the item at the given index, where 0 is the front, 1 is the next item,
    // and so forth. If no such item exists, returns null. Must not alter the deque!
    public T get(int index) {
        if (index > size) {
            return null;
        }
        else {
            Node currNode = sen.next;
            for (int i = 0; i < index; i++) {
                currNode = currNode.next;
            }
            return currNode.head;
        }

    }

//    public static void main(String[] args) {
//        Deque<Integer> deque = new ArrayDeque<Integer>();
//        deque.addFirst(10);
//        deque.addFirst(1);
//        deque.addFirst(0);
//        deque.addFirst(9);
//        deque.addFirst(6);
//
//        System.out.println(deque.toString());
//
//        System.out.println(deque.removeFirst());
//        System.out.println(deque.removeFirst());
//        System.out.println(deque.removeFirst());
//        System.out.println(deque.removeFirst());
//        System.out.println(deque.removeFirst());
//    }

}