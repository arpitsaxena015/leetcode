class Solution {
    public long findKthSmallest(int[] coins, int k) {
        int n = coins.length;
        long lo = 1, hi = (long) 1e15;
        
        long[] lcms = new long[1 << n];
        lcms[0] = 1;
        for (int mask = 1; mask < (1 << n); mask++) {
            long l = 1;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    l = lcm(l, coins[i]);
                    if (l > hi) {
                        l = hi + 1;
                        break;
                    }
                }
            }
            lcms[mask] = l;
        }
        
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            long count = 0;
            for (int mask = 1; mask < (1 << n); mask++) {
                int bits = Integer.bitCount(mask);
                long l = lcms[mask];
                long cnt = mid / l;
                if (bits % 2 == 1) count += cnt;
                else count -= cnt;
            }
            
            if (count < k) lo = mid + 1;
            else hi = mid;
        }
        
        return lo;
    }
    
    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    
    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }
}