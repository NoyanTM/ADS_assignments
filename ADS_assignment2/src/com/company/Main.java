package com.company;

public class Main {
    public static void main(String[] args){
        MyStack<String> st = new MyStack<>();

        st.push("Java");
        st.push("OOP");
        st.push("ADS");
        System.out.println(st);
        System.out.println("Peek : " + st.peek());
    }
}
