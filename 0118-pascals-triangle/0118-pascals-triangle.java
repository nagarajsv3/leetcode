class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> previous = new ArrayList<>();
        for(int i=0; i<numRows; i++){
            List<Integer> innerlist = new ArrayList<>();
            for(int j=0; j<=i; j++){
                if(j==0 || j==i){
                    innerlist.add(1);
                }else{
                    innerlist.add(previous.get(j-1) + previous.get(j));
                }
            }
            lists.add(innerlist);
            previous = innerlist;
        }
        
        return lists;
    }
}