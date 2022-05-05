package com.company;

public class MyBSTree {
    Node root;

    MyBSTree(){
        root = null;
    }

    MyBSTree(int value){
        root = new Node(value);
    }

    // insert() - insert new element
    Node insert(Node root, int key){
        if (root == null){
            root = new Node(key);
            return root;
        }

        if (key < root.key){
            root.left = insert(root.left, key); // if key is less than root, it goes to left side of node
        }

        else if (key > root.key) {
            root.right = insert(root.right, key); // if key is greater than root, it goes to right side of node
        }

        return root;
    }

    // inorder() - printing current left and right end items
    void inorder(Node root){
        if (root != null){
            inorder(root.left);
            System.out.println(root.key);
            inorder(root.right);
        }
    }
}
