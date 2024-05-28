class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n-1;
        int ans[] = new int[2];
        ans[0] = -1;
        ans[1] = -1;

        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid] == target){
                ans[1] = mid;
                low = mid + 1;
            }else if(nums[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        
        low = 0;
        high = n-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid] == target){
                ans[0] = mid;
                high = mid - 1;
            }else if(nums[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
}