package com.company;

public class Main {
    public static void main(String[] args){
        MyHashTable<String, Integer> HashTable = new MyHashTable<>();
        HashTable.add("JAVA", 1);
        HashTable.add("OOP", 2);
        HashTable.add("JAVA", 3);
        HashTable.add("JAVA", 4);
        HashTable.add("ADS", 4);

        System.out.println(HashTable.size());
        System.out.println(HashTable.isEmpty());
        System.out.println(HashTable.remove("JAVA"));
        System.out.println(HashTable.remove("JAVA"));
        System.out.println(HashTable.size());
        System.out.println(HashTable.isEmpty());
        System.out.println(HashTable.get("JAVA"));
    }
}
