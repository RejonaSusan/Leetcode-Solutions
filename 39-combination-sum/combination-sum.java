class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        ans(0, candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    public static void ans(int id, int[] arr, int sum, int s, List<Integer> curr, List<List<Integer>> res){

        if(s == sum){
            res.add(new ArrayList<>(curr));
            return;
        }

        if(s > sum || id == arr.length){
            return;
        }

        curr.add(arr[id]);
        ans(id, arr, sum, s+arr[id], curr, res);

        curr.remove(curr.size() - 1);
        ans(id+1, arr, sum, s, curr, res);
    } 
}