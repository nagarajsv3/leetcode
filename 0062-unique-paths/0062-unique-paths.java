class Solution {
    public int uniquePaths(int m, int n) {
        //Combinations problem
        int ncom = m-1 + n-1;
        int rcom = m-1;

        long result = 1;
        for(int i=1 ; i<=rcom ; i++){
            result = (long)result* (ncom-rcom+i)/i;
        }

        return (int)result;

    }
}