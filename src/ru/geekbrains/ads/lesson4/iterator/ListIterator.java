package ru.geekbrains.ads.lesson4.iterator;

import java.util.Iterator;

public interface ListIterator<E> extends Iterator<E> {

    void reset();

    void insertBefore(E value);

    void insertAfter(E value);

}