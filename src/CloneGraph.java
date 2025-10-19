public class CloneGraph {
    private void visit(Map<Integer, Node> map, Node node) {
        if (node == null) return;

        if (map.containsKey(node.val)) return;

        map.put(node.val, new Node(node.val, new ArrayList()));
        Node current = map.get(node.val);

        for (Node n : node.neighbors) {
            if (!map.containsKey(n.val)) {
                visit(map, n);
            }
            current.neighbors.add(map.get(n.val));
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        Map<Integer, Node> map = new HashMap();
        visit(map, node);
        return map.getOrDefault(node.val, null);
    }

//    beats 65% runtime 25ms memory 89%. Как-то.с первого раза решил 🙃
//    gpt предлагает через bfs сделать с интерациями, чтобы ускорить

//    public Node cloneGraph(Node node) {
//        if (node == null) return null;
//
//        Map<Integer, Node> map = new HashMap();
//        Queue<Node> q = new LinkedList();
//
//        map.put(node.val, new Node(node.val, new ArrayList()));
//        q.add(node);
//
//        while (!q.isEmpty()) {
//            Node cur = q.poll();
//
//            for (Node n : cur.neighbors) {
//                if (!map.containsKey(n.val)) {
//                    map.put(n.val, new Node(n.val, new ArrayList()));
//                    q.add(n);
//                }
//                map.get(cur.val).neighbors.add(map.get(n.val));
//            }
//        }
//
//        return map.get(node.val);
//    }

//    beats 48% runtime 26ms memory 37% еще медленнее говнище лол
}
