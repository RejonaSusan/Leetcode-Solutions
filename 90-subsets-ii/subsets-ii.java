class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> st = new HashSet<>();
        Arrays.sort(nums);
        ans(0, nums, new ArrayList<>(), st);
        List<List<Integer>> res = new ArrayList<>(st);
        return res;
    }

    public void ans(int id, int nums[], List<Integer> curr, Set<List<Integer>> st){
        if(id == nums.length){
            st.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[id]);
        ans(id+1, nums, curr, st);

        curr.remove(curr.size() - 1);
        ans(id+1, nums, curr, st);
    }
}