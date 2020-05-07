package ru.geekbrains.ads.lesson4;

import ru.geekbrains.ads.lesson4.iterator.ListIterator;

import java.util.Iterator;

public class SimpleLinkedListImpl<E> implements LinkedList<E> {

    protected Entry<E> firstElement;//001[005]
    protected int size;


    @Override
    public void insertFirst(E value) {
        Entry<E> entry = new Entry<>(value);//002[007]
        entry.next = firstElement;//007[...next->005]
        firstElement = entry;//001[007]
        size++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        E removedValue = firstElement.value;
        firstElement = firstElement.next;
        size--;
        return removedValue;
    }

    @Override
    public boolean contains(E value) {
        Entry<E> current = firstElement;
        while (current != null) {
            if (current.value.equals(value)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void display() {
        System.out.println("---------");
        Entry<E> current = firstElement;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
        System.out.println("---------");
    }

    public boolean remove(E value) {
        Entry<E> current = firstElement;
        Entry<E> previous = null;
        while (current != null) {
            if (current.value.equals(value)) {
                break;
            }
            previous = current;
            current = current.next;
        }

        if (current == null) {
            return false;
        }

        if (current == firstElement) {
            firstElement = firstElement.next;
        }
        else {
            previous.next = current.next;
        }

        size--;
        return true;
    }
    @Override
    public E getFirst() {
        return firstElement != null ? firstElement.value : null;
    }

    @Override
    public Entry<E> getFirstElement() {
        return firstElement;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator<>(this);
    }


    private static class LinkedListIterator<E> implements ListIterator<E> {

        private final SimpleLinkedListImpl<E> list;

        private Entry<E> current;
        private Entry<E> previous;

        public LinkedListIterator(SimpleLinkedListImpl<E> list) {
            this.list = list;
            reset();
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            E nextValue = current.value;
            previous = current;
            current = current.next;
            return nextValue;
        }

        @Override
        public void remove() {
            if (previous == null){
                list.firstElement = current.next;
                reset();
            } else {
                previous.next = current.next;
                if ( !hasNext() ) {
                    reset();
                } else {
                    current = current.next;
                }
            }
        }

        @Override
        public void reset() {
            current = list.firstElement;
            previous = null;
        }

        @Override
        public void insertBefore(E value) {
            Entry<E> newItem = new Entry<>(value);
            if(previous == null) {
                newItem.next = list.firstElement;
                list.firstElement = newItem;
                reset();
            }
            else {
                newItem.next = previous.next;
                previous.next = newItem;
                current = newItem;
            }

        }

        @Override
        public void insertAfter(E value) {
            Entry<E> newItem = new Entry<>(value);
            if (list.isEmpty()){
                list.firstElement = newItem;
                current = newItem;
            } else {
                newItem.next = current.next;
                current.next = newItem;
                next();
            }
        }

    }


}
