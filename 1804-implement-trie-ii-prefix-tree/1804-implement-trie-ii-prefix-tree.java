class Trie {
    Node root ;

    public Trie() {
        this.root = new Node();
    }
    
    public void insert(String word) {
        Node node = this.root;
        for(int i=0; i<word.length();i++){
            char ch = word.charAt(i);
            if(!node.contains(ch)){
                node.put(ch, new Node());
                node = node.get(ch);
            }else{
                node = node.get(ch);
            }
            node.prfwordcount = node.prfwordcount+1;
            node.endword = true;
        }
        node.eqwordcount = node.eqwordcount+1;
    }
    
        public boolean search(String word) {
        Node node = root;
        for(int i=0;i<word.length(); i++){
            char ch = word.charAt(i);
            if(!node.contains(ch)){
                return false;
            }else{
                node = node.get(ch);
            }
        }
        return node.endword==true;
    }
    
    public boolean startsWith(String prefix) {
        Node node = root;
        for(int i=0;i<prefix.length(); i++){
            char ch = prefix.charAt(i);
            if(!node.contains(ch)){
                return false;
            }else{
                node = node.get(ch);
            }
        }
        return true;
    }

    
    public int countWordsEqualTo(String word) {
        Node node = this.root;

        for(int i=0; i<word.length();i++){
            char ch = word.charAt(i);
            if(!node.contains(ch)){
                return 0;
            }else{
                node = node.get(ch);
            }
        }
        return node.eqwordcount;
    }
    
    public int countWordsStartingWith(String prefix) {
        Node node = root;
        for(int i=0; i<prefix.length();i++){
            char ch = prefix.charAt(i);
            if(!node.contains(ch)){
                return 0;
            }else{
                node = node.get(ch);
            }

        }
        return node.prfwordcount;
    }
    
    public void erase(String word) {
        Node node = root;
        for(int i=0; i<word.length();i++){
            char ch = word.charAt(i);
            if(!node.contains(ch)){
                return;
            }else{
                node = node.get(ch);
            }
            node.prfwordcount = node.prfwordcount - 1;
        }
        node.eqwordcount = node.eqwordcount-1;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * int param_2 = obj.countWordsEqualTo(word);
 * int param_3 = obj.countWordsStartingWith(prefix);
 * obj.erase(word);
 */

class Node{
    Node[] links = new Node[26];
    int prfwordcount;
    int eqwordcount;
    boolean endword;
    
        boolean contains(char ch){
        return get(ch)!=null  ; 
    }
    
    Node get(char ch){
        return links[ch-'a'];
    }
    
    void put(char ch, Node node){
        links[ch - 'a'] = node;
    }
} 