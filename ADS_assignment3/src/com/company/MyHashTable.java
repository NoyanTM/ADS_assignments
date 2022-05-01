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

    // remove() - remove element
    public V remove (K key){
        int bucketIndex = getBucketIndex(key);
        int hashCode = hashCode(key);

        HashNode<K,V> head = bucketArray.get(bucketIndex);

        HashNode<K,V> prev = null; // extra node for connecting prev node with current node
        while (head != null){
            if (head.key.equals(key) && hashCode == head.hashCode){
                break;
            }

            prev = head;
            head = head.next;
        }

        if (head == null){
            return null;
        }

        size--;

        if (prev != null) {prev.next = head.next;} // if element is located in the middle
        else {bucketArray.set(bucketIndex, head.next);} // if element is located at the beginning
        return head.value;
    }

    // get() - getting value of element by using key.
    public V get(K key){
        int bucketIndex = getBucketIndex(key);
        int hashCode = hashCode(key);

        HashNode<K,V> head = bucketArray.get(bucketIndex); // starting from the head and getting pointer to the first element inside bucket

        while (head != null){
            if (head.key.equals(key) && head.hashCode == hashCode) // checking key with hashcode, because keys can be same with other element
            {return head.value;}

            head = head.next;
        }

        return null;
    }

    // add() - adding elements
    public void add(K key, V value){
        int bucketIndex = getBucketIndex(key);
        int hashCode = hashCode(key);
        HashNode<K,V> head = bucketArray.get(bucketIndex);

        while(head != null){
            if (head.key.equals(key) && head.hashCode == hashCode){
                head.value = value;
                return;
            }
            head = head.next;
        }

        size++;
        head = bucketArray.get(bucketIndex);
        HashNode<K,V> newNode = new HashNode<K,V>(key, value, hashCode);
        newNode.next = head;
        bucketArray.set(bucketIndex, newNode);

        // increasing capacity of array, if 70% of array filled
        if ((1.0 * size) / numBuckets >= 0.7){
            ArrayList<HashNode<K,V>> temp = bucketArray;
            bucketArray = new ArrayList<>();
            numBuckets = 2 * numBuckets;
            size = 0;
            for (int i = 0; i < numBuckets; i++){
                bucketArray.add(null);
            }

            for (HashNode<K,V> headNode:temp){
                while(headNode != null){
                    add(headNode.key, headNode.value);
                    headNode = headNode.next;
                }
            }
        }
    }
}
