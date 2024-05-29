class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int low = Integer.MIN_VALUE;
        int high = 0;

        for(int i = 0; i<n ; i++){
            high += weights[i];
            low = Math.max(low, weights[i]); 
        }

        while(low<=high){
            int mid = (low+high)/2;
            if(possible(weights, mid, days)){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }

    public boolean possible(int arr[], int mid, int days){
        int n = arr.length;
        int tot_days = 1;
        int load = 0;

        for(int i = 0; i<n ; i++){
            if(arr[i] + load > mid){
                tot_days++;
                load = arr[i];
            }else{
                load += arr[i];
            }
        }

        if(tot_days<=days){
            return true;
        }

        return false;
    }
}