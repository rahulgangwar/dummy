package exercises.binarytree;

import java.util.Stack;

public class BinaryTree {
    Node root;

    private static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    private static void printLevelOrder(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (stack.peek() != null) {
            Node curr = stack.pop();
            System.out.println(curr.data);
            if (curr.left != null) stack.push(curr.left);
            if (curr.right != null) stack.push(curr.right);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(3);

        printLevelOrder(root);
    }
}
