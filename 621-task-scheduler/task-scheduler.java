class Solution {
    public int leastInterval(char[] tasks, int n) {
        int mpp[] = new int[26];

        for(char c: tasks){
            mpp[c-'A']++;
        }

        Arrays.sort(mpp);
        int maxi = mpp[25]-1;
        int idle = n * maxi;

        for(int i = 24; i>=0; i--){
            idle -= Math.min(maxi, mpp[i]); 
        }

        return idle > 0? idle + tasks.length : tasks.length;
    }
}