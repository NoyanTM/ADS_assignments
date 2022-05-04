package com.company;
import java.util.ArrayList;
import java.util.Objects;

public class MyHashTable <K,V> {
    private ArrayList<HashNode<K,V>> bucketArray; // array with chain of nodes; K - key, V - value;
    private int numBuckets; // capacity of array

    private int size; // actual number or size of elements

    public MyHashTable(){
        bucketArray = new ArrayList<>();
        numBuckets = 10;
        size = 0;

        for (int i = 0; i < numBuckets; i++){
            bucketArray.add(null); // filling empty array with null elements
        }
    }

    // size() - get size
    public int size(){
        return size;
    }

    // isEmpty() - checking empty or not -> return true or false
    public boolean isEmpty(){
        return size() == 0;
    }

    public final int hashCode(K key){
        return Objects.hashCode(key);
    }
	
    private int getBucketIndex(K key){
        int hashCode = hashCode(key);
        int index = hashCode % numBuckets;

        index = (index < 0) ? index * (-1) : index; // checking index - if index negative, multiplying by (-1)
        return index;
    }
}
