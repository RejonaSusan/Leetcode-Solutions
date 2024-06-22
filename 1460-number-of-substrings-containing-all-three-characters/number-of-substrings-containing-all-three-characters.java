class Solution {
    public int numberOfSubstrings(String s) {
        char[] nums = s.toCharArray();
        int[] freq = new int[3];
        int l=0, r=0, cnt=0, unq=0;
        while(r < nums.length){
            freq[nums[r] - 'a']++;
            if(freq[nums[r] - 'a'] == 1) unq++;
            while(unq == 3){
                cnt += (nums.length - r);
                freq[nums[l] - 'a']--;
                if(freq[nums[l] - 'a'] == 0) unq--;
                l++;
            } 
            r++;
        }
        return cnt;
    }
}