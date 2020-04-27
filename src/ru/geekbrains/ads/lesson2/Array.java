package ru.geekbrains.ads.lesson2;

public interface Array<E> {

    int INITIAL_CAPACITY = 4;

    void add(E value);

    E get(int index);

    boolean remove(E value);
    E remove(int index);

    default boolean contains(E value) {
        return indexOf(value) != -1;
    }

    int indexOf(E value);

    int size();

    default boolean isEmpty() {
        return size() == 0;
    }

    default void display() {
        System.out.print("[");
        for (int i = 0; i < size(); i++) {
            E value = get(i);
            System.out.print(value + ", ");
        }
        System.out.println("]");
    }

    void sortBubble(boolean wasChangedMode);
    void sortSelect();
    void sortInsert();

}
