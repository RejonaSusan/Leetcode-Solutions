class Solution {

    public void ans(List<String> res, int n, int open, int close, String curr){
        if(curr.length() == 2*n){
            res.add(curr);
        }else{
            if(open < n){
                ans(res, n, open+1, close, curr+"(");
            }
            if(close < open){
                ans(res, n, open, close+1, curr+")");
            }
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        ans(res, n, 0, 0, "");
        return res;
    }
}