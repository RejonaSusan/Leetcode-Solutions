class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = max(piles);
        
        while(low<=high){
            int mid = (low+high)/2;
            int rate = speed(piles, mid);
            if(rate<=h){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return low;
    }

    public int max(int piles[]){
        int m = Integer.MIN_VALUE;
        for(int i = 0; i<piles.length; i++){
            m = Math.max(m, piles[i]);
        }
        return m;
    }

    public int speed(int piles[], int mid){
        int h = 0;
        int n = piles.length;

        for(int i = 0; i<n; i++){
            h += Math.ceil((double)(piles[i])/(double)(mid));
        }
        return h;
    }
}