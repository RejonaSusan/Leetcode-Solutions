class Solution {
    public long subArrayRanges(int[] nums) {

        Stack<Integer> st = new Stack();
        int n = nums.length;
        
        int prev_min[] = new int[n];
        int next_min[] = new int[n];
        int prev_max[] = new int[n];
        int next_max[] = new int[n];

        Arrays.fill(prev_min, -1);
        Arrays.fill(next_min, n);
        Arrays.fill(prev_max, -1);
        Arrays.fill(next_max, n);

        for(int i = 0; i<n; i++){
            while(!st.isEmpty() && nums[st.peek()]>nums[i]){
                next_min[st.pop()] = i;
            }
            if(!st.isEmpty()){
                prev_min[i] = st.peek(); 
            }
            st.push(i);
        }
        
        st.clear();

        for(int i = 0; i<n; i++){
            while(!st.isEmpty() && nums[st.peek()] < nums[i]){
                next_max[st.pop()] = i;
            }
            if(!st.isEmpty()){
                prev_max[i] = st.peek(); 
            }
            st.push(i);
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            long min_range = (long) nums[i] * (i - prev_min[i]) * (next_min[i] - i);
            long max_range = (long) nums[i] * (i - prev_max[i]) * (next_max[i] - i);
            sum += max_range - min_range;
        }

        return sum;
    }
}