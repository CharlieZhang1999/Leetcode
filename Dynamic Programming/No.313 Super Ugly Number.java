import java.lang.Math;
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int [] ugly = new int[n];
        int [] prime_idx = new int[primes.length];
        
        ugly[0] = 1;
        for(int i = 1; i < n; i++){
            ugly[i] = Integer.MAX_VALUE;
            for(int j = 0; j < primes.length; j++){
                ugly[i] = Math.min(ugly[i], primes[j]*ugly[prime_idx[j]]);
            }
            
            // update prime_idx
            for(int j = 0; j < primes.length; j++){
                while(primes[j]*ugly[prime_idx[j]] <= ugly[i]){
                    prime_idx[j] += 1;
                } 
            }
        }
        
        return ugly[n-1];
    }
}
/**
    这道题不太对劲，如果按照most voted的答案来的话是不对的，在16行while要加一个prime_idx[j]<n的判断，然后整个算法要1000ms
    所以这题太烂了！
 */