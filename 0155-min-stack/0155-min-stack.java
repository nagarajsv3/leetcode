class MinStack {

    Stack<int[]> stack;
    
    
    
    
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if(stack.isEmpty()){

          
            stack.push(new int[]{val, val});
        }else{
            int currmin = getMin() ; ;
            
            stack.push(new int[]{val, currmin > val ? val : currmin });
        }    
    }
    
    public void pop() {
        stack.pop();
        
    }
    
    public int top() {
        int[] peeked = stack.peek();
        return peeked[0];
    }
    
    public int getMin() {
        int[] peeked = stack.peek();
        return peeked[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */