class Solution {
    public String removeDuplicates(String s) {
        
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++ ){
            char ch = s.charAt(i);    

            if(stack.isEmpty()){
                stack.push(ch);
            }else if(!stack.isEmpty() && stack.peek() != ch){
                stack.push(ch);
            }else{
                stack.pop();
            }
            
        }

        String result = new String();
        while(! stack.isEmpty()){
            result = result + stack.pop();
        }

        String revResult = new String();
        for(int i= result.length()-1 ; i>=0; i--){
            revResult = revResult + result.charAt(i);
        }

        return revResult;
    }

    //TC - O(N) + O(N) + O(N) = O(N)
    //SC - O(N) 
}