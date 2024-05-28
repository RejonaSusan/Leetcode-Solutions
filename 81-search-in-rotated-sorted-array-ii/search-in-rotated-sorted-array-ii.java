class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n-1;

        while(low<=high){
            int mid = (low + high)/2;
            if(nums[mid] == target){
                return true;
            }

            if(nums[mid] == nums[low] && nums[mid] == nums[high]){
                high = high - 1;
                low = low + 1;
                continue;
            }

            if(nums[mid] >= nums[low]){
                if(nums[mid] >= target && nums[low] <= target){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }else{
                if(nums[high] >= target && nums[mid] <= target){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}