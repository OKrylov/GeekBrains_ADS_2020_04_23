package ru.geekbrains.ads.lesson4;

public class Main4 {

    public static void main(String[] args) {
        testLinkedList();
//        testStack();
//        testQueue();
    }

    private static void testLinkedList() {
//        LinkedList<Integer> linkedList = new SimpleLinkedListImpl<>();
        TwoSideLinkedList<Integer> linkedList = new TwoSideLinkedListImpl<>();
        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);
        linkedList.insertFirst(4);
        linkedList.insertLast(5);

        linkedList.display();

        System.out.println("Find 2: " + linkedList.contains(2));
        System.out.println("Find 1: " + linkedList.contains(1));
        System.out.println("Find 4: " + linkedList.contains(4));
        System.out.println("Find 4444: " + linkedList.contains(4444));

        linkedList.removeFirst();
        linkedList.remove(2);

        linkedList.display();
    }

//    private static void testStack() {
////        Stack<Integer> stack = new StackImpl<>(5);
//        Stack<Integer> stack = new LinkedStackImpl<>();
//
//        addToStack(stack, 1);
//        addToStack(stack, 2);
//        addToStack(stack, 3);
//        addToStack(stack, 4);
//        addToStack(stack, 5);
//        addToStack(stack, 6);
//
//        System.out.println("Stack size: " + stack.size());
//        System.out.println("Stack top: " + stack.peek());
//
//        while (!stack.isEmpty()) {
//            System.out.println(stack.pop());
//        }
//    }
//
//    private static void addToStack(Stack<Integer> stack, int value) {
//        if (!stack.isFull()) {
//            stack.push(value);
//        }
//    }
//
//    private static void testQueue() {
////        Queue<Integer> queue = new QueueImpl<>(5);
//        Queue<Integer> queue = new LinkedQueueImpl<>();
//        System.out.println(queue.insert(3));
//        System.out.println(queue.insert(5));
//        System.out.println(queue.insert(1));
//        System.out.println(queue.insert(2));
//        System.out.println(queue.insert(6));
//        System.out.println(queue.insert(4));
//
//        System.out.println("Queue peek: " + queue.peek());
//        System.out.println("Queue size: " + queue.size());
//        System.out.println("Queue is full: " + queue.isFull());
//
//        while (!queue.isEmpty()) {
//            System.out.println(queue.remove());
//        }
//    }

}
