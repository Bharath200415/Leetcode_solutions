class Solution {

    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int high=0;

        for (int i:piles){
            high = Math.max(high,i);
        }

        int ans = high, r=high;
        while (l<=r){
           int mid = (l+(r-l)/2);
            if (canEat(piles,h,mid)){
                ans = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
            
        }
        return ans;
    }

    static boolean canEat(int[]piles, int h, long k){
        long hours = 0;

        for (int i:piles){
            hours+= (i+k-1)/k;
        }
        if (hours<=h){
            return true;
        }else{
            return false;
        }
    }
}
