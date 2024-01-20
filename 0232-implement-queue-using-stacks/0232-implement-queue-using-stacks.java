class MyQueue {
    Stack<Integer> instack = new Stack<>();
    Stack<Integer> outstack = new Stack<>();

    public MyQueue() {
    
    }
    
    public void push(int x) {
        instack.push(x);    
    }
    
    public int pop() {
        if(!outstack.isEmpty()){
            return outstack.pop();
        }else{
            while(!instack.isEmpty()){
                outstack.push(instack.pop());
            }
            return outstack.pop();
        }
    }
    
    public int peek() {
        if(!outstack.isEmpty()){
            return outstack.peek();
        }else{
            while(!instack.isEmpty()){
                outstack.push(instack.pop());
            }
            return outstack.peek();
        }
    }
    
    public boolean empty() {
        return instack.isEmpty() && outstack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */