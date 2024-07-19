class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        ans(0, s, res, new ArrayList<>());
        return res;
    }

    public void ans(int id, String s, List<List<String>> res, List<String> curr){
        if(id == s.length()){
            res.add(new ArrayList<>(curr));
        }

        for(int i =id; i<s.length(); ++i){
            if(isPalindrome(s, id, i)){
                curr.add(s.substring(id, i+1));
                ans(i+1, s, res, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s, int start, int end){
        while(start <= end){
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}