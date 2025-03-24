package RedBlackTree;

public class Program {
    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTreeImpl();
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.printByBFS();
        tree.remove(4);
        tree.printByBFS();
    }
}
