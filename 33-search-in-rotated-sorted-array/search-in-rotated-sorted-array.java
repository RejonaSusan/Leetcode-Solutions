class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n-1;

        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid] == target){
                return mid;
            }

            if(nums[mid] <= nums[high]){
                if(nums[high] >= target && nums[mid] <= target){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }else{
                if(nums[low] <= target && nums[mid] >= target){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }
        }
        return -1;
    }
}