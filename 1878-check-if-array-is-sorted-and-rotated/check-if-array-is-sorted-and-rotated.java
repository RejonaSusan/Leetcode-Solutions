class Solution {
    public boolean check(int[] nums) {
        int inversion = 0;
        int n = nums.length;
        boolean flag = false;
        if(n == 1){
            flag = true;
        }
        for(int i = 0; i<n-1; i++){
            if(nums[i] > nums[i+1]){
                inversion++;
            }
        }
        if(inversion == 0){
            for (int i = 1; i < n; i++) {
            if (nums[i] >= nums[i - 1])
                flag = true;
            }
        }
        else if(inversion == 1 && nums[n-1] <= nums[0]){
            flag = true;
        }
        return flag;
        
    }
}