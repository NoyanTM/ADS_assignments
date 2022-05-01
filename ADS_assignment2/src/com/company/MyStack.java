package com.company;

public class MyStack<T extends Comparable<T>> {
    private MyArrayList<T> list;

    public MyStack(){
        list = new MyArrayList<>();
    }

    public void add(T item){
        list.add(item);
    }

    public void remove(){
        list.remove(list.size()-1);
    }

    public boolean isEmpty(){
        return list.size() > 0;
    }

    public int getSize(){
        return list.size();
    }

    public T peek(){
        return list.get(getSize() - 1);
    }

    public T pop(){
        T item = list.get(getSize() - 1);
        list.remove(getSize() - 1);
        return item;
    }

    public T push(T item){
        list.add(item);
        return list.get(list.size()-1);
    }

    public T search(T item){
        return list.get(list.indexOf(item));
    }

    @Override
    public String toString(){
        return "Stack" + list.toString();
    }
}