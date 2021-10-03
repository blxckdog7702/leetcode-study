package com.baemin.blackdog;

public class CompleteBinaryTree {
    public static void main(String[] args) {
        // 완전 이진트리는 트리 형태로 구현하는 것보다 배열 형태로 된 것이 훨씬 간편하게 이용할 수 있다.
        Tree tree = new Tree();

        for(int i = 1; i <= 10; i++) {
            int size = tree.size;
            tree.root = tree.findAndAdd(tree.root, size + 1, 1, (char)(i + 64));
        }

        tree.traverse(tree.root);
        System.out.println(tree.b.toString());
    }
}

class Tree {
    Node root;
    int size;
    StringBuilder b = new StringBuilder();

    public Node findAndAdd(Node current, int targetIndex, int currentIndex, char data) {
        if(currentIndex > targetIndex) {
            return current;
        }

        if(targetIndex == currentIndex) {
            current = new Node(data, targetIndex);
            size++;
            return current;
        }

        current.left = findAndAdd(current.left, targetIndex, currentIndex * 2, data);
        current.right = findAndAdd(current.right, targetIndex, currentIndex * 2 + 1, data);

        return current;
    }

    public void traverse(Node current) {
        if(current == null) {
            return;
        }

        traverse(current.left);
        traverse(current.right);
        b.append(current.data + " ");
    }
}

class Node {
    char data;
    int index; // 디버깅용
    Node left;
    Node right;

    public Node(char data, int index) {
        this.data = data;
        this.index = index;
        this.left = null;
        this.right = null;
    }
}
