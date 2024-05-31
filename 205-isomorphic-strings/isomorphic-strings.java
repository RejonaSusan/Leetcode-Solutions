class Solution {
    public boolean isIsomorphic(String s, String t) {
        int a = s.length();

        Map<Character, Integer> mppS = new HashMap<>();
        Map<Character, Integer> mppT = new HashMap<>();
        
        for(Integer i = 0; i<a; i++){
            if(mppS.put(s.charAt(i), i) != mppT.put(t.charAt(i), i)){
                return false;
            }
        }

        return true;
    }
}