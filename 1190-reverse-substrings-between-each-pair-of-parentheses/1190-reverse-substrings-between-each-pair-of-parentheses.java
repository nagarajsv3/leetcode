class Solution {
    public String reverseParentheses(String s) {
        
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new ArrayDeque<>();

        for(int i=0; i<s.length() ; i++){
            Character ch = s.charAt(i);
            if(ch != ')'){
                stack.push(ch);
            }else{
                //Start Popping until we find ( and add it to queue
                while(! stack.isEmpty()){
                    Character retstack = stack.pop();
                    if(retstack == '('){
                        break;
                    }else{
                        queue.offer(retstack);
                    }
                }

                //Once Popping from stack then //Add everything back to stack
                while (!queue.isEmpty()){
                    stack.push(queue.poll());
                }
            }
        }

        //pop everything to form final response
        char[] chars = new char[stack.size()];
        int pos = stack.size()-1;
        while(!stack.isEmpty()){
            chars[pos] = stack.pop();
            pos--;
        }

        //Convert array to String
        return new String(chars);

        //TC - O(N)
        //SC - O(N)

    }
}