/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Trio<U, V, W>{
    public U node;
    public V vert;
    public W level;

    public Trio(U node, V vert, W level){
        this.node = node;
        this.vert = vert;
        this.level = level;
    }

    public U getnode(){
        return node;
    }

    public V getvert(){
        return vert;
    }

    public W getlevel(){
        return level;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        Queue<Trio<TreeNode, Integer, Integer>> q = new LinkedList<>();

        Map<Integer, Map<Integer, ArrayList<Integer>>> mpp = new TreeMap<>();

        q.add(new Trio<>(root, 0, 0));

        while(!q.isEmpty()){
            Trio<TreeNode, Integer, Integer> trio = q.poll();
            TreeNode node = trio.getnode();
            int x = trio.getvert();
            int y = trio.getlevel();

            mpp.computeIfAbsent(x, k -> new TreeMap<>())
                .computeIfAbsent(y, k -> new ArrayList<>())
                .add(node.val);

            if (node.left != null) {
                q.add(new Trio<>(node.left, x-1, y+1));
            }

            if (node.right != null) {
                q.add(new Trio<>(node.right, x+1, y+1));
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        for (Map.Entry<Integer, Map<Integer, ArrayList<Integer>>> entry : mpp.entrySet()) {
            List<Integer> col = new ArrayList<>();
            for (ArrayList<Integer> list : entry.getValue().values()) {
                Collections.sort(list);
                col.addAll(list);
            }
            res.add(col);
        }

        return res;
    }
}