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
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> list = new ArrayList<>();
        if(root==null){
            return list;
        }
        Queue<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(0, root));
        
        while(!queue.isEmpty()){
            Pair polled = queue.poll();
            TreeNode node = polled.node;
            int level = polled.level;
            
            if(list.size() == level){
                list.add(new ArrayList<Integer>());
            }
            list.get(level).add(node.val);
            
            if(node.left!=null){
                queue.offer(new Pair(level+1, node.left));
            }
            
            if(node.right!=null){
                queue.offer(new Pair(level+1, node.right));
            }
        }
        return list;
    }
}

class Pair{
    int level;
    TreeNode node;
    Pair(int level, TreeNode node){
        this.level = level;
        this.node = node;
    }
}