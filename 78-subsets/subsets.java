class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        ans(0, nums, res, new ArrayList<>());
        return res;

    }

    public void ans(int id, int[] nums, List<List<Integer>> arr, List<Integer> curr){
        if(id == nums.length){
            arr.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[id]);
        ans(id+1, nums, arr, curr);
        
        curr.remove(curr.size() - 1);
        ans(id+1, nums, arr, curr);
    }
}