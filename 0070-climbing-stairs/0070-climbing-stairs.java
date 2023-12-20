class Solution {
    public int climbStairs(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        return climbStairsHelper(n, map);
    }

    public int climbStairsHelper(int n, Map<Integer, Integer> map){
        //Base Condition
        if(n==1){
            map.put(n,1);
            return 1;
        }
        if(n==2){
            map.put(n,2);
            return 2;
        }

        if(map.containsKey(n)){
            return map.get(n);
        }

        int first = climbStairsHelper(n-1, map);
        map.put(n-1, first);
        int second = climbStairsHelper(n-2, map);
        map.put(n-2, second);

        return first + second;

    }
}