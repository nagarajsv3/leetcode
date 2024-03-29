class RecentCounter {
    Deque<Integer> deq = new ArrayDeque<>(); 
    
    public RecentCounter() {       
    }
    
    public int ping(int t) {
        while(!deq.isEmpty() && deq.peek() < t-3000){
           deq.poll();
        }

        deq.offer(t);
        return deq.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */