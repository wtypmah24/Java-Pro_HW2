package org.hash.map.hashmap;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Class implements a custom HashMap
 *
 * @param <K> is any not a primitive type
 * @param <V> is any not a primitive type
 *
 */
public class HashMapSelfMade<K, V> {
    private final List<LinkedList<Entry<K, V>>> hashMapList;
    private int size;

    /**
     * Construct a new instance of the custom HashMap with default Capacity of 16
     */
    public HashMapSelfMade() {
        int CAPACITY = 16;
        hashMapList = new ArrayList<>(CAPACITY);
        for (int i = 0; i < CAPACITY; i++) {
            hashMapList.add(i, new LinkedList<>());
        }
        size = 0;
    }

    /**
     * Gets a current size of the HashMap
     * @return the number of key-value pairs
     */
    public int getSize() {
        return size;
    }

    /**
     * Adds a new key-value pair to the HashMap
     * @param key is the key of the entry
     * @param value is the value of the entry
     */

    public void put(K key, V value) {
        int index = getIndex(key);
        LinkedList<Entry<K, V>> bucket = hashMapList.get(index);
        for (Entry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }
        bucket.add(new Entry<>(key, value));
        size++;
    }

    /**
     * Gets a value according to the provided key
     * @param key is the key to find a linked value
     * @return value or null if key doesn't exist
     */
    public V get(K key) {
        int index = getIndex(key);
        LinkedList<Entry<K, V>> bucket = hashMapList.get(index);
        for (Entry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return null;
    }

    /**
     * Removes a key-value pair according to provided key
     * @param key is the key to find a pair
     */
    public void remove(K key){
        int index = getIndex(key);
        LinkedList<Entry<K, V>> bucket = hashMapList.get(index);
        for (Entry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {
                bucket.remove(entry);
                size--;
                return;
            }
        }

    }

    private int getIndex (K key){
        return key.hashCode() % hashMapList.size();
    }

    private static class Entry<K, V>{
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }
    @Override
    public String toString() {
        return String.valueOf(hashMapList);
    }
}