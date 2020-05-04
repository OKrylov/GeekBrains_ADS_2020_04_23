package ru.geekbrains.ads.lesson4;

import ru.geekbrains.ads.lesson3.queue.Queue;

public class LinkedQueueImpl<E> implements Queue<E> {


    private TwoSideLinkedList<E> data = new TwoSideLinkedListImpl<>();

    @Override
    public boolean insert(E value) {
        data.insertLast(value);
        return true;
    }

    @Override
    public E remove() {
        return data.removeFirst();
    }

    @Override
    public E peekFront() {
        return data.getFirst();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isFull() {
        return false;
    }
}
