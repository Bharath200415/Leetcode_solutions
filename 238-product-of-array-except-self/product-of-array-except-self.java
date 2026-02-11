class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] pref = new int[n];

        
        pref[0]=1;
        
        for (int i=1;i<nums.length;i++){
            pref[i] = pref[i-1]*nums[i-1];
        }
        
        //{1,1,2,6}
        
        //{1,2,3,4}
        
        //{24,12,8,6}
        
        int s=1;
        for (int i=n-1;i>=0;i--){
            pref[i]*=s;
            s*=nums[i];  
        }
        return pref;
    
        

        
    }
}