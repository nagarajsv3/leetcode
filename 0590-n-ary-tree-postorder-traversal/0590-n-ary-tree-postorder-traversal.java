/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        dfsPostOrder(root, list);
        return list;
    }

    void dfsPostOrder(Node root, List<Integer> list){
        if(root!=null){
            //Children        
            if(root.children!=null && root.children.size()>0){
                List<Node> kids = root.children;
                for(Node kid : kids){
                    dfsPostOrder(kid, list);
                }
            }

            //Root
            list.add(root.val);
        }
    }
}