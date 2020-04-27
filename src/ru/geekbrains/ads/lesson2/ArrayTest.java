package ru.geekbrains.ads.lesson2;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ArrayTest {

    public static void main(String[] args) {
//        testArray();
//        testDynamicArray();
        testSort();
    }

    private static void testSort() {
                Array<Integer> data = new ArrayImpl<>();
//        Array<Integer> data = new SortedArrayImpl<>();
        data.add(5);
        data.add(4);
        data.add(3);
        data.add(2);
        data.add(1);

        data.display();
//        data.sortBubble(true);
//        data.sortSelect();
        data.sortInsert();
        data.display();
    }

    private static void testDynamicArray() {
//        Array<Integer> data = new ArrayImpl<>();
        Array<Integer> data = new SortedArrayImpl<>();
        data.add(5);
        data.add(4);
        data.add(3);
        data.add(2);
        data.add(1);

        data.display();

        data.remove(Integer.valueOf(3));
//        data.remove(2);
        data.display();

        System.out.println("data[1] = " + data.get(1));
    }

    private static void testArray() {
        //        Integer[] data = new Integer[5];
//        Integer[] data = new Integer[] {1, 2, 3, 4, 5};
        Integer[] data = {1, 2, 3, 4, 5};
        data[2] = 777;

//        Integer[] data2 = new Integer[data.length * 2];
//        System.arraycopy(data, 0, data2, 0, data.length);
        data = Arrays.copyOf(data, data.length * 2);

//        data2[5] = 888;
        data[5] = 888;

//        for (Integer value : data2) {
        for (Integer value : data) {
            System.out.println(value);
        }
        new Random().nextInt();
        long start = System.nanoTime();
        TimeUnit.NANOSECONDS.toMillis(start);
//        System.out.println(data2[4]);
    }
}
