class MedianFinder {

    public PriorityQueue<Integer> lowerhalfMaxHeap;
    public PriorityQueue<Integer> upperhalfMinHeap; 
    
    public MedianFinder() {
        lowerhalfMaxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder()); //Max Heap
        upperhalfMinHeap = new PriorityQueue<Integer>();  //Min Heap                           
    }
    
    public void addNum(int num) {
        lowerhalfMaxHeap.offer(num);

        //Rebalance
        //Lower half should be less than upper half
        if(!lowerhalfMaxHeap.isEmpty() && !upperhalfMinHeap.isEmpty() && lowerhalfMaxHeap.peek() > upperhalfMinHeap.peek()){
                upperhalfMinHeap.offer(lowerhalfMaxHeap.poll());
            }

        //difference of size is 0 or 1 . If it is greater than 1 then rebalance 
        if(lowerhalfMaxHeap.size() - upperhalfMinHeap.size() >= 2){
            upperhalfMinHeap.offer(lowerhalfMaxHeap.poll());
        }else if(upperhalfMinHeap.size() - lowerhalfMaxHeap.size() >= 2){
             lowerhalfMaxHeap.offer(upperhalfMinHeap.poll());
        }    
    }
    
    public double findMedian() {
        if(lowerhalfMaxHeap.size() != upperhalfMinHeap.size()){
            if(lowerhalfMaxHeap.size() >  upperhalfMinHeap.size()){
                return lowerhalfMaxHeap.peek();
            }else{
                return upperhalfMinHeap.peek();
            }
        }else{
            double lhmax = lowerhalfMaxHeap.peek();  
            double uhmin = upperhalfMinHeap.peek();
            return (lhmax+uhmin)/2;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */