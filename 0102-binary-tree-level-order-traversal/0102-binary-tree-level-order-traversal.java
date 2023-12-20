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
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Queue<Pair> queue = new ArrayDeque<>();

        if(root==null ){
          return list;
        }

        queue.offer(new Pair(0, root));
        while(!queue.isEmpty()){
          Pair pair = queue.poll();
          if(pair!=null){
            if(pair.level == list.size()){
              list.add(new ArrayList<Integer>());  
            }

            list.get(pair.level).add(pair.node.val);
            if(pair.node!=null && pair.node.left !=null){
              queue.offer(new Pair(pair.level+1,pair.node.left));
            }
            if(pair.node!=null && pair.node.right !=null){
              queue.offer( new Pair(pair.level+1,pair.node.right ));
            }
          }
        }

return list;
    }

    class Pair{
      int level;
      TreeNode node;
      Pair(int _l, TreeNode _n){
        this.level = _l;
        this.node = _n;
      }

    }
}