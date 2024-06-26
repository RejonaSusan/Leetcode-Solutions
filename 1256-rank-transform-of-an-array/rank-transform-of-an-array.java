class Solution {
    public int[] arrayRankTransform(int[] arr) {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        int N = arr.length;
        
        int dummy[] = new int[N];
        
        for(int i = 0; i<N; i++){
            dummy[i] = arr[i];
        }
        
        Arrays.sort(dummy);
        int rank = 1;
        
        for(int i=0; i<N; i++){
            if (!mpp.containsKey(dummy[i])) {
                mpp.put(dummy[i], rank++);
            }
        }
        
        int ans[] = new int[N];
        
        for(int i = 0; i<N; i++){
            ans[i] = mpp.get(arr[i]);
        }
        
        return ans;
    }
}