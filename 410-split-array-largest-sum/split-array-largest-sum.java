class Solution {
    public int findSplits(int[] nums, int midsum){
        int splits = 1;
        int initial = 0;
        for (int i=0;i<nums.length;i++){
            if (initial+nums[i]<=midsum){
                initial+=nums[i];
            }else{
                splits+=1;
                initial=nums[i];
            }
        }
        return splits;
    }

    public int splitArray(int[] nums, int k) {
        int start = 0;
        int end = 0;
        for (int i=0;i<nums.length;i++){
            start = Math.max(start,nums[i]);
            end+=nums[i];
        }

        while (start<=end){
            int mid = start+(end-start)/2;
            int splitNum = findSplits(nums,mid);
            if (splitNum>k){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return start;
        
    }
}