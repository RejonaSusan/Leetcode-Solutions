class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int count = 0;
        ArrayList<int[]> ans = new ArrayList<>();
        int n = intervals.length;

        Arrays.sort(intervals, (a,b)-> a[1] - b[1]);

        for(int[] interval: intervals){
            if(ans.isEmpty() || ans.get(ans.size()-1)[1] <= interval[0]){
                ans.add(interval);
            }
        }

        return n - ans.size();
    }
}