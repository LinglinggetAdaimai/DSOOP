package mydeque;
public class LinkedListDeque <T> {


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

	// Adds an item of type T to the front of the deque.
	public void addFirst(T item) {
		sen.next = new Node(item, sen, sen.next);
		sen.next.next.prev = sen.next;
		size++;
	}


	// Adds an item of type T to the back of the deque.
	public void addLast(T item) {
		sen.prev= new Node(item, sen.prev, sen);
		sen.prev.prev.next = sen.prev;

		size++;

	}



	// Returns true if deque is empty, false otherwise.
	public boolean isEmpty() {
		return size == 0;
	}


	// Returns the number of items in the deque.
	public int size() { return this.size;}


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

	// just to print the things inside the deque
    public void printDeque() {
		Node currNode = sen.next;
		if (sen.next == null) {
			System.out.println("null kub");
		}
		for (int i = 0; i < size; i++){
			System.out.printf("H: %s ", currNode.head.toString());
			currNode = currNode.next;
		}
	}
}