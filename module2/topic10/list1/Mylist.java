package topic10.list1;

import java.util.Arrays;

public class Mylist<E> {
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public Mylist() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public Mylist(int capacity) {
        elements = new Object[capacity];
        size = 0;
    }

    public void add(int index, E element) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        ensureCapacity(size + 1);
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    public int size() {
        return this.size;
    }

    public E remove(int index) {
        E removed = (E) this.elements[index];

        for (int i = index; i < this.size() - 1; i++) {
            this.elements[i] = this.elements[i + 1];
        }
        this.elements[this.size - 1] = null;
        this.size--;
        return removed;
    }

    public Mylist<E> clone() {
        Mylist<E> newArr = new Mylist<>();

        for (int i = 0; i < this.size(); i++) {
            newArr.add((E) this.elements[i]);
        }
        return newArr;
    }

    public boolean containers(E o) {
        for (int i = 0; i < this.elements.length; i++) {
            if (this.elements[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(E o) {
        for (int i = 0; i < this.elements.length; i++) {
            if (this.elements[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    public boolean add(E e) {
        ensureCapacity(size+1);
        elements[size++] = e;
        return true;
    }

    public void ensureCapacity(int minCapacity) {
        if (elements.length >= minCapacity) return;
        int newCapacity = elements.length + (elements.length >> 1);
        if (newCapacity < minCapacity) newCapacity = minCapacity;
        Object[] newArr = new Object[newCapacity];
        System.arraycopy(elements, 0, newArr, 0, size);
        elements = newArr;
    }

    public E get(int i) {
        return (E) this.elements[i];
    }

    public void clear() {
        Arrays.fill(this.elements, null);
    }

}
