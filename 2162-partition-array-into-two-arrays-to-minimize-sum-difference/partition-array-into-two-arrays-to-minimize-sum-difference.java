class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length / 2;
        int[] left = Arrays.copyOfRange(nums, 0, n);
        int[] right = Arrays.copyOfRange(nums, n, nums.length);
        
        List<Integer>[] leftSums = generateSums(left);
        List<Integer>[] rightSums = generateSums(right);
        
        int totalSum = Arrays.stream(nums).sum();
        int halfSum = totalSum / 2;
        int minDiff = Integer.MAX_VALUE;
        
        for (int i = 0; i <= n; i++) {
            List<Integer> leftList = leftSums[i];
            List<Integer> rightList = rightSums[n - i];
            
            Collections.sort(rightList);
            
            for (int leftSum : leftList) {
                int target = halfSum - leftSum;
                int pos = Collections.binarySearch(rightList, target);
                if (pos < 0) {
                    pos = -pos - 1;
                }
                
                if (pos < rightList.size()) {
                    int rightSum = rightList.get(pos);
                    int currSum = leftSum + rightSum;
                    minDiff = Math.min(minDiff, Math.abs(totalSum - 2 * currSum));
                }
                
                if (pos > 0) {
                    int rightSum = rightList.get(pos - 1);
                    int currSum = leftSum + rightSum;
                    minDiff = Math.min(minDiff, Math.abs(totalSum - 2 * currSum));
                }
            }
        }
        
        return minDiff;
    }
    
    private List<Integer>[] generateSums(int[] nums) {
        int n = nums.length;
        List<Integer>[] sums = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            sums[i] = new ArrayList<>();
        }
        for (int mask = 0; mask < (1 << n); mask++) {
            int sum = 0;
            int bits = Integer.bitCount(mask);
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += nums[i];
                }
            }
            sums[bits].add(sum);
        }
        return sums;
    }
}