class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int i = 0;

        ArrayList<int[]> ans = new ArrayList<>();

        while(i<n && intervals[i][1] < newInterval[0]){
            ans.add(intervals[i++]);
        }

        while(i<n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }

        ans.add(newInterval);

        while(i<n){
            ans.add(intervals[i++]);
        }

        return ans.toArray(int[][] ::new);
    }
}