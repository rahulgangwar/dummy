package exercises.linkedlist;

public class LinkedList {
    Node root;
    Node last;

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "" + data;
        }
    }

    private static void print(Node root) {
        System.out.println(root);
        if (root.next != null) print(root.next);
    }

    private static Node reverse(Node prev, Node curr) {
        Node next = curr.next;
        curr.next = prev;
        return (next == null) ? curr : reverse(curr, next);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.next = new Node(2);
        root.next.next = new Node(3);
        root.next.next.next = new Node(4);
        root.next.next.next.next = new Node(5);

        print(root);

        print(reverse(null, root));
    }
}
