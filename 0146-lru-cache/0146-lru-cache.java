class LRUCache {
    int capacity;
    Node head =new Node(0,0);
    Node tail = new Node(0,0);
    Map<Integer, Node> map ;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head.next = tail;
        this.tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            insert(key, node.value);
            return node.value;
        }else{
            return -1;
        }
    }
    
    void insert(int key, int value){
        Node node = new Node(key, value);
        map.put(key, node);
        
        node.next = head.next;
        head.next = node;
        
        node.prev = node.next.prev;
        node.next.prev = node;
    }
    
    void remove(Node node){
        map.remove(node.key);
        
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public void put(int key, int value) {
    //Already Present
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            insert(key, value);
        }else{
            if(map.size()<capacity){
                insert(key, value);
            }else{
                remove(tail.prev);
                insert(key, value);
            }
        }
    //Not Present-Capacity available
    //Not Present-Capacity Not available    
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

class Node{
    int key;
    int value;
    Node prev;
    Node next;
    Node(int key, int value){
        this.key= key;
        this.value = value;
    }
}