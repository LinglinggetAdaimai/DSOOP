package mydeque;
public class ArrayDeque <T> {
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

    // Returns true if deque is empty, false otherwise.
    public boolean isEmpty() {
        return (size == 0);
    }

    // Returns the number of items in the deque.
    public int size() {
        return (this.size);
    }

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

    // Removes and returns the item at the front of the deque. // If no such item exists, returns null.
    public T removeFirst() {
        if (isEmpty())
            return null;
        if (front == (arr.length - 1)) {
            front = 0;
        } else {
            front++;// if you plus then the index will be out of range if first is at the end
        }

        size--;
        Shrink();
        return arr[front];
    }

    // Removes and returns the item at the back of the deque. // If no such item exists, returns null.
    public T removeLast() {

        // you have to set the removed element to null for the garbage collector
        // and return the element that you removed

        // store the item first
        T lastitem =  arr[end];

        int last_ind = end;
        if (isEmpty())
            return null;
        else if (end == 0) {
            end = front;
        }
        else {
            end--;
        }
        size--;
        if (isEmpty()) {
            return null;
        }
        arr[last_ind] = null;
        Shrink();
        return lastitem;
    }

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


    public void printDeque() {
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
        System.out.println( results);

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