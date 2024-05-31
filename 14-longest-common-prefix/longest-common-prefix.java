class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        int s = strs[0].length();
        if (strs.length == 0){
            return "";
        }
            
        for(int i = 0; i<s; i++){
            for(int j = 1; j<n; j++){
                if(i == strs[j].length() || strs[0].charAt(i) != strs[j].charAt(i)){
                    return strs[0].substring(0,i);
                }   
            }
        }
        return strs[0];
    }
}