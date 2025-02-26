package AVL_learning;

public class Program {
    private static AVLTree createTree(int [] arr) {
        AVLTree tree = new AVLTreeImpl();
        for (int i = 0; i < arr.length; i++) {
            tree.insert(arr[i]);
        }
        return tree;
    }

    public static void main(String[] args) {
        AVLTree tree = null;
        tree = createTree(new int[] {1, 2, 3}); // LL case
        tree = createTree(new int[] {3, 2, 1}); // RR case
        tree = createTree(new int[] {1, 3, 2}); // LR case
        tree = createTree(new int[] {3, 1, 2}); // RL case
    }
}
