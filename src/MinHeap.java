/**
 * Your implementation of a min heap.
 * @author ufeng Wang
 * @version 1.0
 */
public class MinHeap<T extends Comparable<? super T>>
    implements HeapInterface<T> {

    private T[] backingArray;
    private int size;
    // Do not add any more instance variables

    /**
     * Creates a Heap.
     */
    public MinHeap() {
        Comparable[] a = new Comparable[STARTING_SIZE];
        backingArray = (T[]) a;
        size = 0;
    }

    @Override
    public void add(T item) {
        if (item == null) {
            throw new java.lang.IllegalArgumentException("can't be null");
        }

        if (size == backingArray.length - 1) {
            Comparable[] a = new Comparable[backingArray.length * 2];
            T[] newarr = (T[]) a;
            for (int i = 1; i < backingArray.length; i++) {
                newarr[i] = backingArray[i];
            }
            backingArray = newarr;
        }
        size = size + 1;
        int i = size;
        while ((i > 1) && (item.compareTo(backingArray[i / 2]) < 0)) {
            backingArray[i] = backingArray[i / 2];
            i = i / 2;
        }
        backingArray[i] = item;
    }

    @Override
    public T remove() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("no item");
        }
        T dt = backingArray[1];

        if (size > 1) {
            backingArray[1] = backingArray[size];
            backingArray[size] = null;
            size--;
            int i = 1;

            while (i <= size / 2) {
                if (backingArray[i].compareTo(backingArray[i * 2]) > 0) {
                    if (backingArray[i * 2 + 1 ] != null
                            && backingArray[2 * i]
                            .compareTo(backingArray[i * 2 + 1]) > 0) {
                        T temp = backingArray[i];
                        backingArray[i] = backingArray[2 * i + 1];
                        backingArray[2 * i + 1] = temp;
                        i = 2 * i + 1;
                    } else {
                        T temp = backingArray[i];
                        backingArray[i] = backingArray[2 * i];
                        backingArray[2 * i] = temp;
                        i = 2 * i;
                    }

                } else if ((backingArray[i * 2 + 1] != null)
                        && backingArray[i]
                        .compareTo(backingArray[i * 2 + 1]) > 0) {
                    T temp = backingArray[i];
                    backingArray[i] = backingArray[2 * i + 1];
                    backingArray[2 * i + 1] = temp;
                    i = 2 * i + 1;
                } else {
                    break;
                }
            }
        } else {
            backingArray[1] = null;
            size--;
        }

        return dt;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        Comparable[] a = new Comparable[size];
        backingArray = (T[]) a;
        size = 0;

    }

    /**
     * Used for grading purposes only. Do not use or edit.
     * @return the backing array
     */
    public Comparable[] getBackingArray() {
        return backingArray;
    }

}
