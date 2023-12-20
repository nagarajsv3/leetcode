class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> sstack = new Stack<>();
        for(int i=0;i <s.length(); i++){
            char sch = s.charAt(i);
            if(sch == '#'){
                if(! sstack.isEmpty()){
                    sstack.pop();
                }
            }else{
                sstack.push(sch);
            }
        }


        Stack<Character> tstack = new Stack<>();
        for(int i=0;i <t.length(); i++){
            char tch = t.charAt(i);
            if(tch == '#'){
                if(! tstack.isEmpty()){
                    tstack.pop();
                }
            }else{
                tstack.push(tch);
            }
        }

        while(!sstack.isEmpty() && !tstack.isEmpty()){
            if(sstack.pop() != tstack.pop()){
                return false;
            }
        }
        return sstack.isEmpty() && tstack.isEmpty();
    }

    //TC - O(N) + O(N) + O(N) = O(N)
    //SC - O(N) + O(N) = O(N)
}