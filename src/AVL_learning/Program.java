package AVL_learning;

public class Program {
    public static void main(String[] args) {
        AVLTree tree = new AVLTreeImpl();
        tree.insert(1);
        tree.insert(3);
        tree.insert(2);
        tree.insert(4);
    }
}
