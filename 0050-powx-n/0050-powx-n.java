class Solution {
    public double myPow(double x, int n) { //(2,10)
        long nn = n;
        nn = nn < 0 ? -1*nn : nn; //10 5 4 2
        
        double ans = 1.0;//4
        
        while(nn>0){
            if(nn%2 == 1){
                ans = ans * x; //256*4=1024
                nn = nn-1;
            }else{
                x = x * x; //4 //16 //256
                nn = nn/2; //5 //2 //1
            }
        }
        
        if(n<0){
            ans = 1.0/(ans);
        }
        return ans;
        //TC O(log n)
        //SC O(1)
        
    }
}