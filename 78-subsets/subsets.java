class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = 1 << (nums.length);

        List<List<Integer>> ans = new ArrayList<>();

        for(int i =0; i<n; i++){

            List<Integer> list = new ArrayList<>();

            for(int j = 0; j < nums.length; j++){
                if((i & (1 << j)) != 0){
                    list.add(nums[j]);
                }
            }

            ans.add(list);
        }

        return ans;
    }
}