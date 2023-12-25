class Solution {
    public String alienOrder(String[] words) {
        int V=26;
        //Create Adjacenecy List
        List<List<Integer>> adjlist = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        for(int i=0;i<V;i++){
            adjlist.add(new ArrayList<>());
        }
        
        if(words.length ==1){
            for(int fps=0;fps<words[0].length();fps++){
                set.add(words[0].charAt(fps));
            }                
        }
        
        //Populate Adjacency List
        for(int i=0;i<words.length-1;i++){
            String fword = words[i];
            String sword = words[i+1];
            
            if(fword.startsWith(sword) && fword.length() > sword.length()){
                return "";
            }
            
            if(i==0){
                for(int fps=0;fps<fword.length();fps++){
                    set.add(fword.charAt(fps));
                }                
            }
            
            for(int sps=0;sps<sword.length();sps++){
                set.add(sword.charAt(sps));
            }
            
            
            int min = Math.min(fword.length(), sword.length());
            
            for(int l=0;l<min; l++){
                if(fword.charAt(l) != sword.charAt(l)){
                    set.add(fword.charAt(l));
                    set.add(sword.charAt(l));
                    adjlist.get(chartoint(fword.charAt(l))).add(chartoint(sword.charAt(l)));
                    break;
                }
            }
        }
        
        //Populate Indegree array
        int[] inarr = new int[V];
        for(int i=0;i<V;i++){
            for(int each : adjlist.get(i)){
                inarr[each] = inarr[each] + 1; 
            }
        }
        
        //Calculate Output
        Queue<Integer> queue = new ArrayDeque<>();
                                                    
        for(int i=0;i<V ; i++){
            if(inarr[i] ==0 && set.contains(inttochar(i))){
                queue.offer(i);
            }
        }
                                                                
        //Populate Output and counter
        int[] output = new int[set.size()];
        int counter = 0;
        int m=0;                                                    
        while(!queue.isEmpty()){
            int node = queue.poll();
            counter++;
            output[m++] = node;
            
            for(int neigh : adjlist.get(node)){
                if(inarr[neigh] != 0){
                    inarr[neigh] = inarr[neigh] -1 ;
                    if(inarr[neigh] == 0){
                        queue.offer(neigh);
                    }
                }
            }
        }
                                                                
        //populate output in string
        if(counter==set.size()){
            String s = "";
            for(int i=0;i<output.length; i++){
                s = s+ inttochar(output[i]);
            }
            return s;
        }else{
            return "";
        }
       
    }
                                                                
      
    
    int chartoint(char ch){
        return ch - 'a';
    }
    
    char inttochar(int in){
        return (char)(in + 'a');
    }
}