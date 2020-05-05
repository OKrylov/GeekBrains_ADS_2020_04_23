package ru.geekbrains.ads.lesson2;

public class SortedArrayImpl<E extends Object & Comparable<? super E>> extends ArrayImpl<E> {

    //O(logN)
    @Override
    public int indexOf(E value) {
        int low = 0;
        int high = size - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (data[mid].equals(value)) {
                return mid;
            }
            else if (value.compareTo(data[mid]) > 0) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return -1;
    }

    //O(n)
    @Override
    public void add(E value) {
       checkAndGrow();

       int index = size;
        for (int i = 0; i < size; i++) {
            if (data[i].compareTo(value) > 0) {
                index = i;
                break;
            }
        }

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        size++;
    }
}
