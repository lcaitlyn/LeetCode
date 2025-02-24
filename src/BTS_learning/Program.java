package BTS_learning;

public class Program {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTreeImpl();
        tree.insert(5);
        tree.insert(5);
        tree.insert(15);
        tree.insert(2);
        tree.insert(7);
        tree.insert(12);
        tree.insert(20);
        tree.printPreorder();
        tree.printInorder();
        tree.printPostorder();
        tree.delete(2);
        tree.printPreorder();
        tree.printInorder();
        tree.printPostorder();
        tree.delete(12);
        tree.printPreorder();
        tree.printInorder();
        tree.printPostorder();
        System.out.println("min = " + tree.findMin());
        System.out.println("max = " + tree.findMax());
        System.out.println("sum = " + tree.countNodes());
        System.out.println("height = " + tree.getHeight());
        tree.insert(1);
        tree.insert(1);
        tree.insert(24);
        tree.insert(24);
        tree.printInorder();
        System.out.println("min = " + tree.findMin());
        System.out.println("max = " + tree.findMax());
        System.out.println("sum = " + tree.countNodes());

        System.out.println("height = " + tree.getHeight());

        tree = new BinarySearchTreeImpl();
        for (int i = 1; i < 8; i++) {
            tree.insert(i);
        }
        tree.printInorder();

        System.out.println("height = " + tree.getHeight());
    }
}
