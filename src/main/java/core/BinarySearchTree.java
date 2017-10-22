package main.java.core;

import main.java.pojo.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree {

    public Node createTestBinarySearchTree() {
        Node root = new Node(100, "Bob");

        Node level1Left = new Node(50, "Bob", null, new Node(64, "Emily"));

        Node level1Right = new Node(128, "Emily",
                new Node(110, "Georgia"),
                new Node(130, "Georgia", null, new Node(256, "Emily")));

        root.setLeft(level1Left);
        root.setRight(level1Right);

        return root;
    }

    /**
     * This function checks of a key if present in the BST and returns the value associated to that key or else will
     * return <b>NULL</b> which implies "NO KEY FOUND"
     *
     * @param root The root node of the BST
     * @param key  An integer representation of the key to be searched in a BST
     * @return String value associated to that key.
     */
    public String findValueByKey(Node root, int key) {
        Node node = findNodeByKey(root, key);
        return node == null ? null : node.getValue();
    }

    /*
    This is a helper function which is a recursive function to search the node and if found it return the node
    or else will return null
     */
    private Node findNodeByKey(Node node, int key) {
        if (node == null) {
            return null;
        } else if (node.getKey() == key) {
            return node;
        } else if (key < node.getKey()) {
            return findNodeByKey(node.getLeft(), key);
        } else {
            return findNodeByKey(node.getRight(), key);
        }
    }

    /**
     * Search the first value "DEPTH FIRST APPROACH" going from left --> current --> right node. If the return value is
     * <b>null</b> it implies that no such key exists.
     *
     * @param root  The root node of the BST
     * @param value A value searched in a BST
     * @return Integer representation of the value i.e. key
     */
    public Integer findKeyByValueDepthFirst(Node root, String value) {
        Node node = findNodeByValueDepthFirst(root, value);
        return node == null ? null : node.getKey();
    }

    private Node findNodeByValueDepthFirst(Node node, String value) {
        if (node == null) {
            return null;
        } else {
            Node temp = findNodeByValueDepthFirst(node.getLeft(), value);
            if (temp != null && temp.getValue().equals(value)) {
                return temp;
            } else if (node.getValue().equals(value)) {
                return node;
            } else {
                temp = findNodeByValueDepthFirst(node.getRight(), value);
                if (temp != null && temp.getValue().equals(value)) {
                    return temp;
                } else {
                    return null;
                }
            }
        }

    }

    public List<Integer> accumulateKeysByValueDepthFirst(Node node, String value) {
        List<Integer> list = new ArrayList<>();
        accumulateKeysByValueDepthFirstHelper(list, node, value);
        return list;
    }

    private void accumulateKeysByValueDepthFirstHelper(List<Integer> list, Node node, String value) {
        if (node != null) {
            accumulateKeysByValueDepthFirstHelper(list, node.getLeft(), value);
            if (node.getValue().equals(value)) {
                list.add(node.getKey());
            }
            accumulateKeysByValueDepthFirstHelper(list, node.getRight(), value);
        }
    }


    /**
     * Search the first value "BREADTH FIRST APPROACH" going level wise with shallower levels first then deeper levels.
     * If the return value is <b>null</b> it implies that no such key exists.
     *
     * @param root  The root node of the BST
     * @param value A value searched in a BST
     * @return Integer representation of the value i.e. key
     */
    public Integer findKeyByValueBreadthFirst(Node root, String value) {
        List<Integer> list = findByValueBreadthFirstHelper(root, value, true);
        return list.size() > 0 ? list.get(0) : null;
    }

    /**
     * The method returns a list of all the keys that matches the value. If the list is empty that means it has no
     * key found with a matching value
     *
     * @param root  The root node of the BST
     * @param value A value searched in a BST
     * @return list
     */
    public List<Integer> accumulateKeysByValueBreadthFirst(Node root, String value) {
        return findByValueBreadthFirstHelper(root, value, false);
    }


    private List<Integer> findByValueBreadthFirstHelper(Node root, String value, boolean isSingleKeySearch) {
        List<Integer> list = new ArrayList<>();
        boolean found = false;
        int numberOfElementsAtLevel = 0;
        Queue<Node> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
            numberOfElementsAtLevel++;
        }

        while (!queue.isEmpty() && !found) {
            int localNumberOfElementsAtLevel = 0;
            for (int i = numberOfElementsAtLevel; i > 0; i--) {
                Node temp = queue.remove();
                if (temp.getValue().equals(value)) {
                    if (!isSingleKeySearch) {
                        list.add(temp.getKey());
                    } else {
                        list.add(temp.getKey());
                        found = true;
                        break;
                    }
                }
                if (temp.getLeft() != null) {
                    localNumberOfElementsAtLevel++;
                    queue.add(temp.getLeft());
                }
                if (temp.getRight() != null) {
                    localNumberOfElementsAtLevel++;
                    queue.add(temp.getRight());
                }

            }
            numberOfElementsAtLevel = localNumberOfElementsAtLevel;
        }
        return list;
    }

}
