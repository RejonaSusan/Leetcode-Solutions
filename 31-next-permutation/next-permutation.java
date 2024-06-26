class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int breakpt = -1;
        for(int i = n-2; i>=0; i--){
            if(nums[i] < nums[i+1]){
                breakpt = i;
                break;
            }
        }
        if(breakpt == -1){
            reverse(nums, 0, n - 1);
        }else{
            for(int i = n-1; i > breakpt; i--){
                if(nums[i] > nums[breakpt]){
                    int temp = nums[i];
                    nums[i] = nums[breakpt];
                    nums[breakpt] = temp;
                    break;
                }
            }
            reverse(nums, breakpt + 1, n - 1);
        }
    }

    public void reverse(int nums[], int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        } 
    }
}