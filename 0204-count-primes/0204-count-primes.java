class Solution {
    
    //https://www.youtube.com/watch?v=eKp56OLhoQs
    //Sieve of Erasthonesis
    public int countPrimes(int n) {
        if(n==0 || n==1){
            return 0;
        }
        //0 means Prime
        int[] primes = new int[n+1];
        primes[0] = 1;
        primes[1] = 1;
        
        for(int i=2 ; i<=n ; i++){
            //If Primes[i] is prime, then multiples of it are non prime
            if(primes[i] == 0){
                //Multiples of Prime are Non Prime
                for(int j=2; (i*j) <= n ; j++){
                    //Non Prime                    
                        primes[i*j] = 1;
                }
            }
        }
        
        int counter = 0;
        for(int m = 0; m<n; m++){
            if(primes[m] == 0){
                counter++;
            }
        }
        
        return counter;
    }
}