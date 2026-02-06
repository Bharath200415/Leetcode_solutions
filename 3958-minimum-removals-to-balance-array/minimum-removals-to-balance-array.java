class Solution {

    // Returns the length of the largest valid subarray starting at index 'left'
    // Condition: nums[right] <= k * nums[left]
    // Since array is sorted, we can binary search for the farthest 'right'
    public static int getLength(int left, int k, int[] nums){

        // low/high define the binary search window
        int low = left;
        int high = nums.length;

        // Binary search to find first index where condition breaks
        while(low < high){

            // Standard mid calculation to avoid overflow
            int mid = low + (high - low) / 2;

            // If nums[mid] still satisfies condition,
            // move right to try extending the window
            // Cast to long to prevent integer overflow
            if((long) nums[mid] <= (long) k * nums[left]) {
                low = mid + 1;
            }
            // Otherwise shrink right boundary
            else {
                high = mid;
            }
        }

        // low now points to first invalid index
        // so last valid index is low - 1
        int right = low - 1;

        // Edge case: if no extension possible, at least 1 element exists
        if(right < left) return 1;

        // Length of valid subarray
        return right - left + 1;
    }

    public int minRemoval(int[] nums, int k) {

        // Sort array so smallest is at left and values grow monotonically
        Arrays.sort(nums);

        int n = nums.length;
        int maxLength = 0;

        // Try every index as the minimum element of the subarray
        for(int i = 0; i < n; i++){

            // For each i, find largest valid window starting at i
            maxLength = Math.max(maxLength, getLength(i, k, nums));
        }

        // We want to keep the largest valid subarray
        // Everything else must be removed
        return n - maxLength;
    }
}