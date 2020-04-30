package ru.geekbrains.ads.lesson2.homework;

import ru.geekbrains.ads.lesson2.Array;
import ru.geekbrains.ads.lesson2.ArrayImpl;
import ru.geekbrains.ads.lesson2.SortedArrayImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.function.Supplier;

public class ConcurrencyMainDZ {

    private static final int ARRAY_CAPACITY = 10_000;
    private static final int MAX_VALUE = 10_000;

    public static void main(String[] args) throws InterruptedException, TimeoutException, ExecutionException {
        Supplier<Array<Integer>> constructor = ArrayImpl::new;
//        Supplier<Array<Integer>> constructor = SortedArrayImpl::new;

        Array<Integer> arr1 = createArray(constructor);
        Array<Integer> arr2 = createArray(constructor);
        Array<Integer> arr3 = createArray(constructor);

//        randomInitialize(arr1);
//        Array<Integer> arr2 = arr1.copy();
//        Array<Integer> arr3 = arr1.copy();

        randomInitialize(arr1, arr2, arr3);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<Runnable> tasks = List.of(
                measureTime(arr1::sortBubble, "Sort Bubble"),
                measureTime(arr2::sortSelect, "Sort Select"),
                measureTime(arr3::sortInsert, "Sort Insert")
        );

        tasks.forEach(executorService::execute);

//        for (Runnable task : tasks) {
//            executorService.execute(task);
//        }

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println("bubble: " + Arrays.toString(arr1.toArray()));
        System.out.println("select: " + Arrays.toString(arr2.toArray()));
        System.out.println("insert: " + Arrays.toString(arr3.toArray()));
    }

    private static void randomInitialize(Array<Integer>... arrays) {
        Random random = new Random();
        for (int i = 0; i < ARRAY_CAPACITY; i++) {
            int value = random.nextInt(MAX_VALUE);
            for (Array<Integer> array : arrays) {
                array.add(value);
            }
        }
    }

    private static Runnable measureTime(Runnable action, String actionName) {
        return () -> {
            long startTime = System.nanoTime();
            action.run();
            long finishTime = System.nanoTime();
            long duration = finishTime - startTime;

            System.out.printf("%s took time: %d micros.%n", actionName, TimeUnit.NANOSECONDS.toMicros(duration));
        };
    }

    private static Array<Integer> createArray(Supplier<Array<Integer>> factory) {
        return factory.get();//new ArrayImpl()
    }

}