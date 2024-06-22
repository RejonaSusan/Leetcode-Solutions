class Solution {
    public int numberOfSubstrings(String s) {
        int count = 0, left = 0, right = 0;
        int[] hash = new int[3];
        Arrays.fill(hash, -1);

        while(right < s.length()) {
            char ch = s.charAt(right);
            int smallestIndex = Integer.MAX_VALUE;

            hash[ch - 'a'] = right;

            for(int index : hash) {
                if(index < smallestIndex) smallestIndex = index;
            }

            if(smallestIndex != -1) count += (smallestIndex + 1);

            right++;
        }

        return count;
    }
}