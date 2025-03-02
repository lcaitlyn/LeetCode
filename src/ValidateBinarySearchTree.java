import javax.swing.tree.TreeNode;

public class ValidateBinarySearchTree {

    // Вот начинаю думать как это решить
    // нужно проверить валиденл ли наш BST
    // при каких условиях бст валидный? если все что от рута слева < рута и все что справа
    // от рута > рута. Возможно можно использовать DFS и просто проверять, 
    // root.left < root < root.right, если неверно, возвращать false;

    // на ум еще пришло делать max(root.left) < root < min(root.right)
    // думаю это и есть правильное решение, но пока хочу сделать решение по проще 

    // public boolean isValidBST(TreeNode root) {
    //     if (root == null) return true;
    //     if (root.left != null && root.right != null) {
    //         if (root.left.val >= root.val 
    //             || root.right.val <= root.val) {
    //             return false;
    //         }
    //     }
    //     if (root.left != null && root.left.val >= root.val) {
    //         return false;
    //     }
    //     if (root.right != null && root.right.val <= root.val) {
    //         return false;
    //     }
    //     if (!isValidBST(root.left)) return false;
    //     return isValidBST(root.right); 
    // }

    // ну крч как я и думал, решение оказалось не верным
    // на кейсе root = [5,4,6,null,null,3,7], все отвалилось.
    // значит нужно делать то решение

    // private TreeNode findMin(TreeNode root) {
    //     if (root == null) return null;
    //     while (root.left != null) {
    //         root = root.left;
    //     }
    //     return root;
    // }

    // private TreeNode findMax(TreeNode root) {
    //     if (root == null) return null;
    //     while (root.right != null) {
    //         root = root.right;
    //     }
    //     return root;
    // } 

    // public boolean isValidBST(TreeNode root) {
    //     if (root == null) return true;
    //     TreeNode left = findMax(root.left);
    //     TreeNode right = findMin(root.right);
    //     if (left != null && left.val >= root.val) {
    //         return false;
    //     }
    //     if (right != null && right.val <= root.val) {
    //         return false;
    //     }
    //     if (left != null && right != null) {
    //         if (!isValidBST(root.left)) return false;
    //     }
    //     return isValidBST(root.right); 
    // }

    // написал такое решение, отвалилось на кейсе: [45,42,null,null,44,43,null,41]
    // очень странно блять, потому что должно было работать
    // крч я дебик поставил не нужное условие в конце, все работало.

    private TreeNode findMin(TreeNode root) {
        if (root == null) return null;
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    private TreeNode findMax(TreeNode root) {
        if (root == null) return null;
        while (root.right != null) {
            root = root.right;
        }
        return root;
    } 

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        TreeNode left = findMax(root.left);
        TreeNode right = findMin(root.right);
        if (left != null && left.val >= root.val) {
            return false;
        }
        if (right != null && right.val <= root.val) {
            return false;
        }
        if (!isValidBST(root.left)) return false;
        return isValidBST(root.right); 
    }

    // Результат runtime 100% memory 54%

    // чет в решения какое то супер ебануто решение 

    // пиздец там решений нахуй. я в ахуе. через стеки, очереди и прочую поеботу
}
