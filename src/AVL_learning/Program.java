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

        tree = createTree(new int[] {30, 20, 40, 10, 25, 35, 50});
        tree.delete(10);
        System.out.println(tree.search(10));
    }
}
