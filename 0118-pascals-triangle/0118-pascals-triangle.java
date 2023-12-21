class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> currow = null;
        List<Integer> prerow = null;
        for(int i=0;i<numRows ; i++){
            currow = new ArrayList<>();
            for(int j=0; j<=i;j++){
                if(j==0 || j==i){
                    currow.add(1);
                }else{
                    currow.add(prerow.get(j-1) + prerow.get(j));
                }
            }
            
            list.add(currow);
            prerow = currow;
        }
        return list;
    }
    
    //TC O(N2)
    //SC O(N2)
}