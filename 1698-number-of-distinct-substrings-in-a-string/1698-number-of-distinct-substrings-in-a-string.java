class Solution {
    
    
    public int countDistinct(String s) {
        Trie root = new Trie();
        for(int i=0; i<s.length(); i++){
            root.add(s.substring(i,s.length()));
        }
        return root.count;
    }
}

class Node{
    Node[] links = new Node[26];
    Node(){}
    boolean containsKey(char ch){
        return links[ch-'a'] != null ;
    }
    Node get(char ch){
        return links[ch-'a'];
    }
    void put(char ch, Node node){
        links[ch -'a'] = node;
    }
}

class Trie{
    Node root;
    int count ; 
    Trie(){
        root = new Node();
    }
    
    void add(String word){
        Node node = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(!node.containsKey(ch)){
                node.put(ch, new Node());
                count = count +1;
            }
            node = node.get(ch);
        }
    }
}

