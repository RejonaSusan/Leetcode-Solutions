class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        ans(0, nums, new ArrayList<>(), res);
        return res;
    }

    public void ans(int id, int nums[], List<Integer> curr, List<List<Integer>> res){

        res.add(new ArrayList<>(curr));

        for(int i = id; i<nums.length; i++){
            if(i!=id && nums[i] == nums[i-1]) continue;

            curr.add(nums[i]);
            ans(i+1, nums, curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}