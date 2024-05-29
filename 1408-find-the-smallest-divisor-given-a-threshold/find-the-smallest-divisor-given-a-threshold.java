class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int low = 1, high  = Integer.MIN_VALUE;

        if(n>threshold){
            return -1;
        }

        for(int i = 0; i<n ; i++){
            high = Math.max(high, nums[i]);
        }

        while(low<=high){
            int mid = (low + high)/2;
            if(possible(nums, mid, threshold)){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }

    public boolean possible(int arr[], int mid, int k){
        int n = arr.length;
        int sum = 0;

        for(int i = 0; i<n ; i++){
            sum += Math.ceil((double)(arr[i])/(double)(mid));
        }

        return sum <= k;
    }
}