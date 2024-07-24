class Solution {
    public int rob(int[] nums) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        if(nums.length == 1){
            return nums[0];
        }

        for(int i = 0; i<nums.length; i++){
            if(i!=0) arr1.add(nums[i]);
            if(i!=nums.length-1) arr2.add(nums[i]);
        }

        int ans1 = ans(arr1);
        int ans2 = ans(arr2);

        return Math.max(ans1, ans2);
    }

    public int ans(ArrayList<Integer> nums){
        int n = nums.size();
        int prev = nums.get(0);
        int prev2 = 0;

        for(int i = 1; i<n ; i++){
            int pick = nums.get(i);
            if(i>1){
                pick += prev2;
            }
            int notpick = prev;
            int curr = Math.max(pick, notpick);

            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}