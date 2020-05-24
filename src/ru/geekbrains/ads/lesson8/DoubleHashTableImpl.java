package ru.geekbrains.ads.lesson8;

public class DoubleHashTableImpl<K, V> extends HashTableImpl<K, V> {

    private static final int DOUBLE_HASH_CONST = 5;

    public DoubleHashTableImpl(int maxSize) {
        super(maxSize);
    }

    @Override
    protected int getStep(K key) {
        return hashDoubleFunc(key);
    }

    private int hashDoubleFunc(K key) {
        return DOUBLE_HASH_CONST - (key.hashCode() % DOUBLE_HASH_CONST);
    }
}
