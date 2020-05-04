package ru.geekbrains.ads.lesson4.iterator;

import ru.geekbrains.ads.lesson4.LinkedList;
import ru.geekbrains.ads.lesson4.SimpleLinkedListImpl;

import java.util.Iterator;
import java.util.List;

public class TestIterator {

    public static void main(String[] args) {
        int[] array = {1 , 2 , 3};

        for (int i = 0; hasNext(array, i); i++) {
            int value = nextValue(array, i);
            doIt(value);
        }

        System.out.println("---------");

        for (int value : array) {
            System.out.println(value);
        }

        System.out.println("---------");

        List<Integer> jLinkedList = new java.util.LinkedList<>();
        jLinkedList.add(1);
        jLinkedList.add(2);
        jLinkedList.add(3);

        for (Integer value : jLinkedList) {
            System.out.println(value);
        }

        Iterator<Integer> iterator = jLinkedList.iterator();
        while (iterator.hasNext()) {
            Integer value = iterator.next();
            System.out.println(value);
        }

        System.out.println("---------");

        LinkedList<Integer> linkedList = new SimpleLinkedListImpl<>();
        linkedList.insertFirst(3);
        linkedList.insertFirst(2);
        linkedList.insertFirst(1);

        for (java.lang.Object o : linkedList) {

        }

        LinkedList.Entry<Integer> current = linkedList.getFirstElement();
        while (hasNextList(current)) {
            Integer value = getNextList(current);
            doIt(value);
            current = current.next;
        }




    }

    private static Integer getNextList(LinkedList.Entry<Integer> current) {
        return current.value;
    }

    private static boolean hasNextList(LinkedList.Entry<Integer> current) {
        return current != null;
    }

    private static boolean hasNext(int[] array, int i) {
        return i < array.length;
    }

    private static int nextValue(int[] array, int i) {
        return array[i];
    }

    private static void doIt(int value) {
        System.out.println(value);
    }
}
