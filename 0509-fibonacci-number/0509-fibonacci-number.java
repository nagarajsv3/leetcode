class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public int fib(int n) {
        if(n==0){
            map.put(n,0);
            return 0;
        }

        if(n==1){
            map.put(n,1);
            return 1;
        }

        if(map.containsKey(n)){
            return map.get(n);
        }
        
            int f1 = fib(n-1);
            map.put(n-1, f1);
        
            int f2 = fib(n-2);
            map.put(n-2, f2);
        
        
        return map.get(n-1)+ map.get(n-2);
    }
}