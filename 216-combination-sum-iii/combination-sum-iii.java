class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        ans(1, k, n, new ArrayList<>(), res);
        return res;
    }

    public static void ans(int id, int k, int n, List<Integer> curr, List<List<Integer>> res){
        if(n == 0){
            if(curr.size() == k){
                res.add(new ArrayList<>(curr));
            }
            return;
        }

        for(int i = id; i<=9; i++){
            curr.add(i);
            ans(i+1, k, n-i, curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}