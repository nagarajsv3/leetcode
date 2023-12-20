import java.lang.*;
class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean notValidSudoku = true;
        List<Set<Character>> rowList = new ArrayList<>();
            for(int m=0;m<9;m++){
                rowList.add(new HashSet<>());
            }
        
        
        List<Set<Character>> colList = new ArrayList<>();
        for(int m=0;m<9;m++){
                colList.add(new HashSet<>());
            }
        
        
         Set[] boxSet = new HashSet[9];
            boxSet[0] = new HashSet<Character>();
            boxSet[1] = new HashSet<Character>();
            boxSet[2] = new HashSet<Character>();
            boxSet[3] = new HashSet<Character>();
            boxSet[4] = new HashSet<Character>();
            boxSet[5] = new HashSet<Character>();
            boxSet[6] = new HashSet<Character>();
            boxSet[7] = new HashSet<Character>();
            boxSet[8] = new HashSet<Character>();
            
        
        
        for(int i=0; i<9; i++){                        
            for(int j=0;j<9;j++){
                char c = board[i][j];
                if(c != '.'){
                     notValidSudoku =  duplicateCharPresentInRowSet(c, i, rowList) || 
                                    duplicateCharPresentInColSet(c, j, colList) ||                                
                                    duplicateCharPresentInBoxSet(c, i,j, boxSet);     
                if (notValidSudoku ==true){
                    return false;
                }
                }
               
            
            }
                        
        }
        
        return true;
        
    }

    boolean duplicateCharPresentInRowSet(char c, int i, List<Set<Character>> rowList ){   
        System.out.println(rowList.get(i).toString());
        if (rowList.get(i).contains(c)){
            System.out.println("Char="+c);
            return true;
        }else{
            System.out.println("Adding Char="+c);
            rowList.get(i).add(c);
        }
        return false;
    }
    
    boolean duplicateCharPresentInColSet(char c, int j, List<Set<Character>> colList ){
        System.out.println(colList.get(j).toString());
        if (colList.get(j).contains(c)){
            System.out.println("Char="+c);
            return true;
        }else{
            System.out.println("Adding Char="+c);
            colList.get(j).add(c);
        }
        return false;
    }
    
    boolean duplicateCharPresentInBoxSet(char c, int i,int j,  Set[] boxSet){
       
        
        if((i >=0 && i<=2) && (j>=0 && j<=2)){
            if(boxSet[0].contains(c)){
                System.out.println("Char="+c);
                return true;
            }else{
                System.out.println("Adding Char="+c);
                boxSet[0].add(c);
            }
        }
        
        if((i >=0 && i<=2) && (j>=3 && j<=5)){
            if(boxSet[1].contains(c)){
                System.out.println("Char="+c);
                return true;
            }else{
                System.out.println("Adding Char="+c);
                boxSet[1].add(c);
            }
        }
        
        if((i >=0 && i<=2) && (j>=6 && j<=8)){
            if(boxSet[2].contains(c)){
                System.out.println("Char="+c);
                return true;
            }else{
                System.out.println("Adding Char="+c);
                boxSet[2].add(c);
            }
        }
        
        if((i >=3 && i<=5) && (j>=0 && j<=2)){
            if(boxSet[3].contains(c)){
                System.out.println("Char="+c);
                return true;
            }else{
                System.out.println("Adding Char="+c);
                boxSet[3].add(c);
            }
        }
        
        if((i >=3 && i<=5) && (j>=3 && j<=5)){
            if(boxSet[4].contains(c)){
                System.out.println("Char="+c);
                return true;
            }else{
                System.out.println("Adding Char="+c);
                boxSet[4].add(c);
            }
        }
        
        if((i >=3 && i<=5) && (j>=6 && j<=28)){
            if(boxSet[5].contains(c)){
                System.out.println("Char="+c);
                return true;
            }else{
                System.out.println("Adding Char="+c);
                boxSet[5].add(c);
            }
        }
                
        
        
         if((i >=6 && i<=8) && (j>=0 && j<=2)){
            if(boxSet[6].contains(c)){
                System.out.println("Char="+c);
                return true;
            }else{
                System.out.println("Adding Char="+c);
                boxSet[6].add(c);
            }
        }
        
        if((i >=6 && i<=8) && (j>=3 && j<=5)){
            if(boxSet[7].contains(c)){
                System.out.println("Char="+c);
                return true;
            }else{
                System.out.println("Adding Char="+c);
                boxSet[7].add(c);
            }
        }
        
        if((i >=6 && i<=8) && (j>=6 && j<=28)){
            if(boxSet[8].contains(c)){
                System.out.println("Char="+c);
                return true;
            }else{
                System.out.println("Adding Char="+c);
                boxSet[8].add(c);
            }
        }
        
        return false;
    }
    
    
}