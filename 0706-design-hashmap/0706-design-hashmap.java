class MyHashMap {

    LinkedList<HMNode>[] buckets = null;
    

    public MyHashMap() {
        
        buckets = new LinkedList[4];

        for(int i=0; i<4 ; i++){
            buckets[i] = new LinkedList<HMNode>();
        }
    }
    //TC O(k) k elements in each bucket
    //SC O(1)
    public void put(int key, int value) {
        System.out.println("Operation put()"+key + " "+value);
        int bi = getBucket(key);
        int di = getDataIndex(buckets[bi] , key);

        System.out.println("BI="+bi +" ; DI="+di);

        if(di !=-1){
            HMNode node = buckets[bi].get(di);
            node.value = value;
        }else{
            HMNode node = new HMNode(key, value);
            buckets[bi].add(node);
            
        }
    }

    int getBucket(int key){
        return Math.abs(key) % buckets.length;
    }


    int getDataIndex(LinkedList<HMNode> lis, int key){
        int di  = 0;
        for(HMNode node : lis){
            if(node.key == key){
                return di;
            }
            di++;
        }
        return -1;
    }
    
    public int get(int key) {
        System.out.println("Operation get()"+key);
        int bi = getBucket(key);
        int di = getDataIndex(buckets[bi] , key);

        if(di !=-1){
            HMNode node = buckets[bi].get(di);
            return node.value;
        }else{
            return -1;
        }
    }
    
    public void remove(int key) {
        System.out.println("Operation remove()"+key);
        int bi = getBucket(key);
        int di = getDataIndex(buckets[bi] , key);

        if(di !=-1){
            HMNode node = buckets[bi].remove(di);
        }
    }

    public class HMNode{
        int key;
        int value;

        HMNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */