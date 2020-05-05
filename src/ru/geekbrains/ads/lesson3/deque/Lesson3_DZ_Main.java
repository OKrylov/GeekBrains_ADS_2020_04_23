package ru.geekbrains.ads.lesson3.deque;


import ru.geekbrains.ads.lesson3.stack.Stack;
import ru.geekbrains.ads.lesson3.stack.StackImpl;

public class Lesson3_DZ_Main {
    public static void main(String[] args) {
        // TASK 1
//        String str = "abcd";
//
//        System.out.println(new StringBuilder(str).reverse());
//
//        Stack<Character> st = new StackImpl<>(str.length());
//        for (int i = 0; i < str.length(); i++) {
//            st.push(str.charAt(i));
//        }
//
//        while ( !st.isEmpty() ) {
//            System.out.print(st.pop());
//        }
//        System.out.println();
//
//        if (true) {
//            return;
//        }


        //TASK 2
        Deque<Integer> deq = new DequeImpl<>(6);

        insertRight(deq, 1);
        insertRight(deq, 2);
        insertRight(deq, 3);
        insertRight(deq, 4);// 1 2 3 4
        insertLeft(deq, 5); // 5 1 2 3 4
        insertLeft(deq, 6); // 6 5 1 2 3 4

        removeLeft(deq); //5 1 2 3 4
        removeRight(deq); // 5 1 2 3

//        displayLeftToRight(deq); // Queue
        displayRightToLeft(deq); //Stack
    }

    private static <E> void insertRight(Deque<E> deq, E value) {
        if ( !deq.isFull() ) {
            deq.insertRight(value);
        }
    }

    private static <E> void insertLeft(Deque<E> deq, E value) {
        if ( !deq.isFull() ) {
            deq.insertLeft(value);
        }
    }

    private static <E> void removeRight(Deque<E> deq) {
        if ( !deq.isEmpty() ) {
            deq.removeRight();
        }
    }

    private static <E> void removeLeft(Deque<E> deq) {
        if ( !deq.isEmpty() ) {
            deq.removeLeft();
        }
    }

    private static <E> void displayRightToLeft(Deque<E> deq) {
        while ( !deq.isEmpty() ) {
            System.out.println(deq.removeRight());
        }
    }

    private static <E> void displayLeftToRight(Deque<E> deq) {
        while ( !deq.isEmpty() ) {
            System.out.println(deq.removeLeft());
        }
    }
}