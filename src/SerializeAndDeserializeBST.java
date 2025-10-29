public class SerializeAndDeserializeBST {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return null;

        Queue<TreeNode> q = new LinkedList<>();

        StringBuilder sb = new StringBuilder();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node != null) {
                    sb.append(node.val);
                    q.add(node.left);
                    q.add(node.right);
                } else {
                    sb.append('n');
                }
                sb.append(';');
            }
        }

        return sb.substring(0, sb.length() - 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) return null;

        Queue<TreeNode> q = new LinkedList<>();
        String[] vals = data.split(";");

        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        q.add(root);
        int i = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int j = 0; j < size; j++) {
                TreeNode node = q.poll();
                TreeNode tmp;
                if (vals[i].equals("n")) {
                    node.left = null;
                } else {
                    tmp = new TreeNode(Integer.parseInt(vals[i]));
                    q.add(tmp);
                    node.left = tmp;
                }
                i++;
                if (vals[i].equals("n")) {
                    node.right = null;
                } else {
                    tmp = new TreeNode(Integer.parseInt(vals[i]));
                    q.add(tmp);
                    node.right = tmp;
                }
                i++;
            }
        }

        return root;
    }

//    beats 35% memory 21% runtime 10ms
//    хз как ускорять если честно
//    за то все тесты с 1ого раза прошло (удивительно)
}
