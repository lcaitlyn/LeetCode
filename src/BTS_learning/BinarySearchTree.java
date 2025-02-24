package BTS_learning;

public interface BinarySearchTree {
    void insert(int value);

    boolean search(int value);

    void printPreorder();

    void printInorder();

    void printPostorder();

    void delete(int value);

    int findMin();

    int findMax();

    int countNodes();

    int getHeight();
}
