package main.java;

import main.java.core.BinarySearchTree;
import main.java.pojo.Node;

public class Solution {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Node root = bst.createTestBinarySearchTree();

        System.out.println("------------Search KEY--------------");
        System.out.println(bst.findValueByKey(root, 100));
        System.out.println(bst.findValueByKey(root, 64));
        System.out.println(bst.findValueByKey(root, 120));
        System.out.println(bst.findValueByKey(root, 10));
        System.out.println(bst.findValueByKey(null, 10));
        System.out.println(bst.findValueByKey(null, -1));


        System.out.println("------------DFS--------------");
        System.out.println(bst.findKeyByValueDepthFirst(root, "Bob"));
        System.out.println(bst.findKeyByValueDepthFirst(root, "Georgia"));
        System.out.println(bst.findKeyByValueDepthFirst(root, "Emily"));
        System.out.println(bst.findKeyByValueDepthFirst(root, "James"));
        System.out.println(bst.findKeyByValueDepthFirst(null, ""));
        System.out.println(bst.findKeyByValueDepthFirst(null, "James"));


        System.out.println("------------BFS--------------");
        System.out.println(bst.findKeyByValueBreadthFirst(root, "Bob"));
        System.out.println(bst.findKeyByValueBreadthFirst(root, "Georgia"));
        System.out.println(bst.findKeyByValueBreadthFirst(root, "Emily"));
        System.out.println(bst.findKeyByValueBreadthFirst(root, "James"));
        System.out.println(bst.findKeyByValueBreadthFirst(null, ""));
        System.out.println(bst.findKeyByValueBreadthFirst(null, "James"));


        System.out.println("------------Accumulate DFS--------------");
        System.out.println(bst.accumulateKeysByValueDepthFirst(root, "Bob"));
        System.out.println(bst.accumulateKeysByValueDepthFirst(root, "Georgia"));
        System.out.println(bst.accumulateKeysByValueDepthFirst(root, "Emily"));
        System.out.println(bst.accumulateKeysByValueDepthFirst(root, "James"));
        System.out.println(bst.accumulateKeysByValueDepthFirst(null, ""));
        System.out.println(bst.accumulateKeysByValueDepthFirst(null, "James"));


        System.out.println("------------Accumulate BFS--------------");
        System.out.println(bst.accumulateKeysByValueBreadthFirst(root, "Bob"));
        System.out.println(bst.accumulateKeysByValueBreadthFirst(root, "Georgia"));
        System.out.println(bst.accumulateKeysByValueBreadthFirst(root, "Emily"));
        System.out.println(bst.accumulateKeysByValueBreadthFirst(root, "James"));
        System.out.println(bst.accumulateKeysByValueBreadthFirst(null, ""));
        System.out.println(bst.accumulateKeysByValueBreadthFirst(null, "James"));

    }
}
