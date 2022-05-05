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
	
	// search() - searching items
    public Node search(Node root, int key){
        if (root == null || root.key == key){
            return root;
        }

        if (root.key < key){
            return search(root.right, key);
        }

        return search(root.left, key);
    }

    // deleteNode() - deleting node
    Node deleteNode(Node root, int k){
        if (root == null){
            return root;
        }

        if (k < root.key){
            root.left = deleteNode(root.left, k);
        }

        else if (k > root.key){
            root.right = deleteNode(root.right, k);
        }

        else {
            if (root.left == null){
                return root.right;
            }

            else if (root.right == null){
                return root.left;
            }

            root.key = minVal(root.right);

            root.right = deleteNode(root.right, root.key);
        }
        return root;
    }

    // minVal() - return min value
    int minVal(Node root){
        int minv = root.key;
        while (root.left != null){
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }
}
