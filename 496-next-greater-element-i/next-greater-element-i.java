class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        Stack<Integer> st = new Stack();
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer,Integer> mpp = new HashMap<>();

        for(int num: nums2){
            while(!st.isEmpty() && st.peek() < num){
                mpp.put(st.pop(), num);
            }
            st.push(num);
        }
        for(int num: nums1){
            if(mpp.containsKey(num)){
                ans.add(mpp.get(num));
            }else{
                ans.add(-1);
            }
        }
        
        int arr[] = new int[ans.size()];
        for(int i = 0; i<ans.size(); i++){
            arr[i] = ans.get(i);
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();

    }
}