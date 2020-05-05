package ru.geekbrains.ads.lesson3.queue;

public class PriorityQueue<E extends Object & Comparable<? super E>> extends QueueImpl<E> {

    public PriorityQueue(int maxSize) {
        super(maxSize);
    }

    @Override//O(n)
    public boolean insert(E value) {
        if (isFull()) {
            return false;
        }

        int index;
        for (index = size() - 1; index >= 0; index--) {
            if (value.compareTo(data[index]) > 0) {
                data[index + 1] = data[index];
            } else {
                break;
            }
        }
            data[index + 1] = value;
            size++;
            return true;
    }

    @Override//O(1)
    public E remove() {
        return isEmpty() ? null : data[--size];
    }

    @Override//O(1)
    public E peekFront() {
        return data[size - 1];
    }
}
