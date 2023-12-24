class Solution {
    public String alienOrder(String[] words) {
        //Create AdjList
        int V = 26;
        List<List<Integer>> adjlist = new ArrayList<>();
        for(int i=0;i<V;i++){
            adjlist.add(new ArrayList<>());
        }
        
        Set<Character> set = new HashSet<>();
        
        if(words.length==1){
                for(int l=0;l<words[0].length();l++){
                    set.add(words[0].charAt(l));
                }        
        }

        for(int i=0; i<words.length-1 ; i++){
            
            //COmpare 1st , 2nd
            int min = Math.min(words[i].length(), words[i+1].length());
            for(int j=0;j<min;j++){
                String fir = words[i];
                String sec = words[i+1];
                
                for(int l=0;l<words[i].length();l++){
                    set.add(words[i].charAt(l));
                }
                
                for(int l=0;l<words[i+1].length();l++){
                    set.add(words[i+1].charAt(l));
                }
                
                if(fir.startsWith(sec) && fir.length() > sec.length()){
                    return "";
                }
                
                if (fir.charAt(j)!=sec.charAt(j)){
                    //(u, v) fir.char sec.char
                    int u = fir.charAt(j) - 'a';
                    set.add(fir.charAt(j));
                    int v = sec.charAt(j) - 'a';
                    set.add(sec.charAt(j));
                    adjlist.get(u).add(v);
                    break;
                }
            }
        }    
 
        //createinputdegreearray(adjlist);
        int[] inarr = new int[V];
        for(int i=0;i<V;i++){
            for(int each : adjlist.get(i)){
                inarr[each] = inarr[each]+1;
            }
        }
                
        //push0guystoqueue();
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i=0; i<V;i++){
            if(inarr[i] ==0 && presentinset(i, set)){
                queue.offer(i);
            }
        }
        
        char[] output = new char[V];
        int cnt = 0;
        int m=0;
        
        while(!queue.isEmpty()){
            int node = queue.poll();
            output[m++] = (char)(node + 'a');
            cnt++;
                            
            
            for(int each : adjlist.get(node)){
                if(inarr[each] != 0){
                    inarr[each] = inarr[each]-1;
                    if(inarr[each] ==0){
                        queue.offer(each);
                    }
                }
            }
        }
        
        
        String out = "";
        for(int n=0;n<set.size();n++){
            out = out+output[n];
        }
        return cnt==set.size()  ? out : "";
    }
    
    boolean presentinset(int i, Set<Character> set){
        char ch = (char)(i+'a');
        
        return set.contains(ch);
    }
    

    
    
}