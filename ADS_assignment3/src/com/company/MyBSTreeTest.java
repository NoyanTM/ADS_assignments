package com.company;

public class MyBSTreeTest {
    public static void main(String[] args){
        Node root = null;
        MyBSTree bst = new MyBSTree();
        root = bst.insert(root, 80);
        root = bst.insert(root, 30);
        root = bst.insert(root, 20);
        root = bst.insert(root, 50);
        root = bst.insert(root, 40);
        root = bst.insert(root, 60);
        root = bst.insert(root, 70);
        System.out.printf("\nFirst Tree\n");
        bst.inorder(root);

        root = bst.deleteNode(root, 50);
        root = bst.deleteNode(root, 70);
        System.out.printf("\nSecond Tree\n");
        bst.inorder(root);
    }
}
