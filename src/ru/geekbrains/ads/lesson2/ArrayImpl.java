package ru.geekbrains.ads.lesson2;

import java.util.Arrays;
import java.util.Collections;

public class ArrayImpl<E extends Object & Comparable<? super E>> implements Array<E> {

    protected E[] data;
    protected int size;

    public ArrayImpl(int initialCapacity) {
        this(null, initialCapacity);
    }

    public ArrayImpl(E... data) {
        this(data, data.length);
        this.size = data.length;
    }

    public ArrayImpl() {
        this(null, INITIAL_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    private ArrayImpl(E[] data, int capacity) {
        this.size = data != null ? data.length : 0;
        this.data = data != null ? data : (E[]) new Object[capacity];
    }

    //O(1) - O(n)
    @Override
    public void add(E value) {
        checkAndGrow();
        data[size++] = value;
    }

    //O(1)
    @Override
    public E get(int index) {
        checkIndex(index);
        return data[index];
    }

    //O(indexOf)
    @Override
    public boolean remove(E value) {
        int index = indexOf(value);
//        if (index == -1) return false;
        try {
            return remove(index) != null;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        E removedValue = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
        size--;
        return removedValue;
    }

    //O(n)
    @Override
    public int indexOf(E value) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return this.size;
    }

    //O(n^2) - compare
    // O(n^2) = exchange
    @Override
    public void sortBubble(boolean wasChangedMode) {
        for (int i = 0; i < size - 1; i++) {
            boolean wasChanged = false;
            for (int j = 0; j < size - 1 - i; j++) {
                if (data[j].compareTo(data[j + 1]) > 0) {
                    swap(j, j + 1);
                    wasChanged = true;
                }
            }
            if (wasChangedMode && !wasChanged) {
                break;
            }
        }
    }

    //O(n^2) - compare
    // O(n) = exchange
    @Override
    public void sortSelect() {
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (data[j].compareTo(data[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(minIndex, i);
            }
        }
    }

    //O(n^2) - compare
    // O(n) = exchange
    @Override
    public void sortInsert() {
        for (int i = 1; i < size; i++) {
            E temp = data[i];
            int in = i;
            while (in > 0 && data[in - 1].compareTo(temp) > 0) {
                data[in] = data[in - 1];
                in--;
            }
            data[in] = temp;
        }
    }

    private void swap(int index1, int index2) {
        E temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }

    protected void checkAndGrow() {
        if (data.length == size) {
            data = Arrays.copyOf(data, data.length * 2);
        }
    }

    protected void checkIndex(int index) {
        if (index < 0 || index >= data.length) {
            String errMsg = String.format("Invalid index %d for array with size %d",
                    index, size);
            throw new IndexOutOfBoundsException(errMsg);
        }
    }
}
