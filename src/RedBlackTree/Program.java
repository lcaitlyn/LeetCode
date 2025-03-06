package RedBlackTree;

public class Program {
    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTreeImpl();
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.insert(2);
        tree.insert(1);
        tree.insert(7);
        System.out.println(tree);
        tree.printByBFS();

    }
}
