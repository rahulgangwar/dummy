package exercises;

public class Calculator {
    public interface Node {
        double eval();
    }

    class DataNode implements Node {
        double data;

        public DataNode(double value) {
            data = value;
        }

        public double eval() {
            return data;
        }
    }

    abstract class OperatorNode implements Node {

        public Node left, right;

        public OperatorNode(Node left, Node right) {

            this.left = left;
            this.right = right;
        }

        public abstract double eval();
    }

    public class Addition extends OperatorNode {

        public Addition(Node left, Node right) {
            super(left, right);
        }

        public double eval() {
            return left.eval() + right.eval();
        }
    }

    public class Multiplication extends OperatorNode {

        public Multiplication(Node left, Node right) {
            super(left, right);
        }

        public double eval() {
            return left.eval() * right.eval();
        }
    }
}
