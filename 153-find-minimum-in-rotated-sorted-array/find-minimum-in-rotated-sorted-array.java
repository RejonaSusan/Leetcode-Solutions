class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0, high = n-1;
        int min = Integer.MAX_VALUE;
        while(low<=high){
            int mid = (low + high)/2;

            if(nums[low] <= nums[high]){
                min = Math.min(min, nums[low]);
            }
            if(nums[mid] >= nums[low]){
                min = Math.min(min, nums[low]);
                low = mid + 1;
            }else{
                min = Math.min(min, nums[mid]);
                high = mid - 1;
            }    
        }
        return min;
    }
}