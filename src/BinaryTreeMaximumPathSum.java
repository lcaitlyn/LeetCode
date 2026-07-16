public class BinaryTreeMaximumPathSum {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

        // так, ну думаю над проблемой я понял что
// что нам нужно знать сколько будет стоить проход от рута до самоый нижней части
// потому что путь точно нужно искать от конца до конца
// я думал что он 100% будет проъходить через рут, но на самом деле
// как во втором примере он может и не проходить
// но он 100% должен прозодить от рута до рута
// надо что-то сделать чтобы знать у какого рута сколько слева и сколько справа
// до конца. точнее максимальные концы у каждой ноды. вот тогда и поймем
// какой путь самый длинный (макс Левый + макс Правый + нода)
// каждый раз у каждой ноды высчитывать её максимальную левую и правую часть -
// можно улететь в TLE. Но вообще в качестве брут форса можно и написать
// эту версию кода. А уже потом как-нибудь придумать к неё мемоизацию
// Учитывая что это хард задача мб так и поступить?
// Сделаю брутфорсом

// так хорошо что я начал с брут форса, потому что тест кейс показывает что моя
// теория относительно того что они должны быть до конца - ложная.
// пример [2,-1] у меня ответ 1, а должен быть 2. То есть отрицательное
// плечо просто нету смысла брать

// так теперь новая проблемка вышла.
// [-1,5,null,4,null,null,2,-4]
// тут одна большая колбаса и вначале и в конце отрицательные числа. Их смысла
// просто брать нету

// очень странно конечно, потому что моя задача должна отрабатывать норм.


        // private int max(TreeNode node) {
        //     if (node == null) return 0;
        //     if (node.left == null && node.right == null) return node.val;
        //     int left = Math.max(0, max(node.left));
        //     int right = Math.max(0, max(node.right));
        //     return node.val + Math.max(left, right);
        // }

        // private int dfs(TreeNode node) {
        //     if (node == null) return Integer.MIN_VALUE;
        //     int left = Math.max(0, max(node.left));
        //     int right = Math.max(0, max(node.right));
        //     int total = node.val + left + right;
        //     total = Math.max(total, dfs(node.left));
        //     return Math.max(total, dfs(node.right));
        // }

        // public int maxPathSum(TreeNode root) {
        //     return dfs(root);
        // }


// ура сделал. beats 2.10% runtime 174ms memory 88.55%
// брут форсом прошло, осталось как-то ко всему этому память добавить еще и вообще
// четко будет

// надо думать как добавить память то сюда?

// бля хуй знает. надо как-то пройти один раз и постоянно записывать результат.
// спуститься глубоко и в глобальной переменной записывать максимальный
// результат?

// бля почти получилось

// так уже лучше

        private int res = Integer.MIN_VALUE;

        private int dfs(TreeNode node) {
            if (node == null) return 0;
            int left = Math.max(0, dfs(node.left));
            int right = Math.max(0, dfs(node.right));
            int total = node.val + left + right;
            res = Math.max(res, total);
            return node.val + Math.max(left, right);
        }

        public int maxPathSum(TreeNode root) {
            dfs(root);
            return res;
        }

        // runtime 0ms beats 100% memory 19.55%

// бля а я не понимаю как сделать мега быстро че-то

// наверное посмотрю решения

// АХАХАХ а ответ точь в точь как моё решение сука
// так не понял че за хуйня
// а блять это литкод багнулся и я сделал решение на 0ms beats 100%
    }
