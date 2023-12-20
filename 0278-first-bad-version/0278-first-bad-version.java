/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {

        //Identify First Bad Version Using Binary Search
        int bestBadVersion = -1;
        bestBadVersion = findBestBadVersion(n, 1, n, bestBadVersion);        
        return bestBadVersion;      
    }

    int findBestBadVersion(int n, int left, int right , int bestBadVersion){
        if(left > right){
            return bestBadVersion;
        }

        int mid = left+(right-left)/2;
        
        if(isBadVersion(mid)){
            System.out.println("Mid="+mid+" ;Bad=True");
            bestBadVersion = mid;
            return findBestBadVersion(n, left, mid-1, bestBadVersion);
        }else{
            System.out.println("Mid="+mid+" ;Bad=False");
            return findBestBadVersion(n, mid+1, right, bestBadVersion);
        }
    }

   

    
    
    
   
    
    
    
}