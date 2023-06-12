import java.util.NoSuchElementException;
import java.util.Objects;

public class MyArrayList {
    private int[] items;
    private String encryptCode;
    private int size;

    public MyArrayList() {
        items = new int[2];
        size = 0;
        encryptCode = null;
    }

    private void grow(int newCapacity) {
        int[] newItems = new int[newCapacity];
        System.arraycopy(items, 0, newItems, 0, size);
        items = newItems;
    }

    public void add(int value) {
        if (size == items.length) {
            grow(items.length * 2);
        }
        items[size] = value;
        size += 1;
    }

    public void setEncryptCode(String val) {
        this.encryptCode = val;
    }

    public int size() {
        return size;
    }

    public int removeFirst() {
        int temp = 0;
        if (size > 0) {
            temp += items[0];
            for (int i = 1; i < size; i++) {
                items[i-1] = items[i];
            }
            size--;
            return temp;
        }
        else {throw new NoSuchElementException();}
    }

    public boolean equals(Object o) {

        if( o == null) {
            return false;
        }
        if(o.getClass() != this.getClass()) {
            return false;
        }

        MyArrayList other = (MyArrayList) o;

        if (!Objects.equals(other.encryptCode, this.encryptCode)) { //use .equals prevent null encrytpcode
            return false;
        }

        if (other.size != this.size) {
            return false;
        }
        for(int idx = 0; idx < this.size; idx++) {
            if(other.items[idx] != this.items[idx]){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        MyArrayList arrayList = new MyArrayList();
        arrayList.add(10);
        arrayList.add(11);
        arrayList.add(12);
        for (int i = 0; i < arrayList.size; i++) {
            System.out.println(arrayList.items[i]);
        }
        System.out.println(arrayList.removeFirst());
    }

}
