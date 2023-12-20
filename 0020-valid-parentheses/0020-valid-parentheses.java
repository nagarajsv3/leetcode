class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<>();
        boolean isvalid = true;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '{' || c=='(' || c =='['){
                stack.push(c);
            }
            
            if(c == '}' || c == ')' || c==']'){
                if(stack.empty()){
                    return false;
                }else{
                    char charfromstack = stack.pop();
                    if(charfromstack == '('){
                        if(c != ')'){
                            return false;
                        }
                    }

                    if(charfromstack == '{'){
                        if(c != '}'){
                            return false;
                        }
                    }

                    if(charfromstack == '['){
                        if(c != ']'){
                            return false;
                        }
                    }
                }
                
                
            }
            
        }
        
        if(!stack.isEmpty()){
            return false;
        }else{
            return true;            
        }
        

    }
}