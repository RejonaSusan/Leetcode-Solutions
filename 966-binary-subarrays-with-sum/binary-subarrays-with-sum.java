class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int ans = 0;
        int prefix = 0;
        Map<Integer, Integer> count = new HashMap<>();
        count.put(0, 1);

        for(int num: nums){
            prefix += num;
            int key = prefix - goal;
            if(count.containsKey(key)){
                ans += count.get(key);
            }
            count.put(prefix, count.getOrDefault(prefix, 0)+ 1);
        }

        return ans;
    }
}

