package com.company;

public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {
    private static class MyNode<T>{
        T data;
        MyNode<T> next, prev;

        MyNode(T data) {
            this.data = data;
        }
    }

    private int length = 0;
    private MyNode<T> head, tail;

    public MyLinkedList() {}

    public void add(T item) {
        MyNode<T> newNode = new MyNode<>(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public T get(int index) {
        if (index >= length || index < 0)
            throw new IndexOutOfBoundsException("index should be positive and less than size");

        MyNode<T> temp = head;

        while (index != 0) {
            temp = temp.next;
            index--;
        }

        return temp.data;
    }

    public int size() {
        return length;
    }

    @Override
    public void add(T item, int index) {
        length++;
        if (index >= length || index < 0)
            throw new IndexOutOfBoundsException("index should be positive and less than size");

        MyNode<T> newNode = new MyNode<>(item);
        MyNode<T> currentNode = head;
        MyNode<T> prevNode = null;

        int count = 0;

        if(index == length - 1){
            add(item);
        } else {
            while (count != index) {
                count++;
                prevNode = currentNode;
                currentNode = currentNode.next;
            }
            prevNode.next = newNode;
            newNode.next = currentNode;
        }
    }

    @Override
    public T remove(int index) {
        T removeItem;
        MyNode<T> currentNode = head;
        MyNode<T> prevNode = null;

        while(currentNode != null){
            if(currentNode.data==get(index)){
                if (currentNode == head) {
                    head = head.next;
                    head = null;
                } else {
                    if (prevNode != null) {
                        prevNode.next = currentNode.next;
                    }
                }
                System.out.println("Element " + currentNode.data + " has been removed");
                removeItem = currentNode.data;
                return removeItem;
            }
            prevNode = currentNode;
            currentNode = currentNode.next;
        }
        length--;
        return null;
    }

    @Override
    public boolean remove(T item) {
        MyNode<T> currentNode = head;
        MyNode<T> prevNode = null;

        while (currentNode.next != null) {
            if (currentNode.data == item) {
                if (currentNode == head) {
                    head = head.next;
                    head = null;
                } else {
                    prevNode.next = currentNode.next;
                }
                System.out.println("Element " + currentNode.data + " has been removed");
                return true;
            }
            prevNode = currentNode;
            currentNode = currentNode.next;
        }
        length--;
        return false;
    }

    @Override
    public void sort() {
        sortList(length);
    }
    private void sortList(int n){
        if(n == 1) return;
        MyNode<T> currentNode = head;
        int i = 0;
        while(i != n-1){
            if(((currentNode.data)).compareTo((currentNode.next).data) > 0){
                T temp = currentNode.data;
                currentNode.data = (currentNode.next).data;
                (currentNode.next).data = temp;
            }
            i++;
            currentNode = currentNode.next;
        }
        sortList(n-1);
    }

    @Override
    public void clear() {
        MyNode<T> currentNode = head;
        while (currentNode != null){
            currentNode.prev = null;
            currentNode = currentNode.next;
        }
        System.out.println("LinkedList has been successfully cleared");
        length = 0;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        for(MyNode<T> currentNode = head; currentNode != null; currentNode = currentNode.next){
            index += 1;
            if(((Comparable<T>)o).compareTo(currentNode.data) == 0){
                return index - 1;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = length;
        for(MyNode<T> currentNode = tail; currentNode != null; currentNode = currentNode.prev){
            index -= 1;
            if(((Comparable<T>)o).compareTo(currentNode.data) == 0){
                return index;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(Object o) {
        for(MyNode<T> currentNode = head; currentNode != null; currentNode = currentNode.next){
            if(((Comparable<T>)o).compareTo(currentNode.data) == 0) {
                return true;
            }        System.out.println(currentNode.data);
        }
        return false;
    }
}

