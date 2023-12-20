class Solution {
    public List<String> generateParenthesis(int n) {
        List<String > result = new ArrayList<>();
        recursiveGenerateParenthesis("(", 1, 0,  result, n);
        return result;
    }

    void recursiveGenerateParenthesis(String current, int openparcnt, int closeparcnt , List<String >result, int maxpairs){ 

        //Break / Base Conditions
        if(openparcnt == closeparcnt && openparcnt==maxpairs){
            result.add(current);
            return;
        }

        //openparcnt < numpairs
        if(openparcnt < maxpairs){
            recursiveGenerateParenthesis(current + "(", openparcnt+1, closeparcnt,  result, maxpairs);
        } 

        //closeparcnt < openparcnt
        if(closeparcnt < openparcnt){
            recursiveGenerateParenthesis(current + ")", openparcnt, closeparcnt + 1,  result, maxpairs);
        }

    }
}