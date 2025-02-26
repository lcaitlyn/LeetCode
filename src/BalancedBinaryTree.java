public class BalancedBinaryTree {
    // private int height(TreeNode node) {
    //     if (node == null) return 0;
    //     return 1 + Math.max(height(node.left), height(node.right));
    // }

    // private int balanceFactor(TreeNode node) {
    //     if (node == null) return 0;
    //     return (height(node.left) - height(node.right));
    // }

    // public boolean isBalanced(TreeNode root) {
    //     if (root == null) return true;
    //     if (balanceFactor(root) > 1) return false;
    //     if (balanceFactor(root) < -1) return false;
    //     return (isBalanced(root.left) && isBalanced(root.right));
    // }

    // Результат: Runtime beats 26.69%. Memory 93.19%
    // Вопрос почему runtime такой слабый и как можно ускорить?

    // Скорее всего проблемы с функцией Height(), которая считает высоту. 
    // Она слишком частно вызывается.
    // Можно ли как-то ускорить её?
    // Может быть стоит использовать итерации, а не рекурсию?
    // хотя не, по памяти то мы не просидаем...

    // в каких условия у нас идет перевес? когда у рута одна разница 
    // сторон по модулю больше 1
    // обычно такое бывает, когда у корня нету второй высоты.
    // возможно мы должны считать высоты лишь тех у кого отсутсвует один корень.
    // если у корня есть два корня значит нужно идти глубже.

    // Хах, заметил что в isBalanced я два раза вызываю balanceFactor,
    // и я заменил 14 и 15 строчку на if (Math.abs(balanceFactor(root)) > 1) return false;
    // Результат: Runtime beats 26.69%. Memory 56.02%
    // Т.е возможно все таки проблема в высоте

    // крч нет, не правильное решение.
    // взгляну в ответы.
    // крч видимо не понять мне(

}
