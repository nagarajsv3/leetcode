class LRUCache {
    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    int capacity = 0;
    Map<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head.next = this.tail; 
        this.tail.previous = this.head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            int value = node.value;
            //Remove
            remove(node);
            //Insert
            insert(node);
            return value;
        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        //Record Exist. Update
        if(this.map.containsKey(key)){
            remove(map.get(key));
        }
        
        //New Insert & Capacity Full
        if(this.map.size() == capacity){
            //Remove LRU
            remove(tail.previous);
        }
        
        //New Insert & Capacity available
        insert(new Node(key, value));
    }

    void remove(Node node){
    map.remove(node.key);

    //1   2   3
    node.previous.next = node.next;
    node.next.previous = node.previous; 
}

void insert(Node node){
    
        map.put(node.key, node);

        Node headNext = head.next;

        node.next = head.next; //1    2    3
        head.next.previous = node;

        head.next = node;
        node.previous=head; 
}



}




class Node{
    int key;
    int value;
    Node previous;
    Node next;

    Node(int key, int value){
        this.key = key;
        this.value= value;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */