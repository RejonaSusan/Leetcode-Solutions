class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        ans(0, candidates, new ArrayList<>(), 0, target, res);
        return res;
    }

    public static void ans(int id, int arr[], List<Integer> curr, int s, int sum, List<List<Integer>> res){

        if(s == sum){
            res.add(new ArrayList<>(curr));
            return;
        }

        if(s > sum || id == arr.length){
            return;
        }

        for(int i = id; i<arr.length; i++){
            if(i > id && arr[i] == arr[i-1]) continue;

            curr.add(arr[i]);
            ans(i+1, arr, curr, s+arr[i], sum, res);
            curr.remove(curr.size() - 1);
        }

    }
}