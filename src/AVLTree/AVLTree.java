package AVLTree;

import java.util.List;

public interface AVLTree {
    void insert(int value);
    void delete(int value);
    boolean search(int value);
    void printTreeWithBFS();
    List<List<Integer>> getByLevelOrder(); // LeetCode Problem №102
}
