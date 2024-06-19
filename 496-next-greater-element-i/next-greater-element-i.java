class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        Stack<Integer> st = new Stack();
        ArrayList<Integer> arr = new ArrayList<>();
        HashMap<Integer, Integer> mpp = new HashMap<>();

        for(int num: nums2){
            while(!st.isEmpty() && st.peek() < num){
                mpp.put(st.pop(), num);
            }
            st.push(num);
        }

        for(int num: nums1){
            if(mpp.containsKey(num)){
                arr.add(mpp.get(num));
            }else{
                arr.add(-1);
            }
        }

        int ans[] = new int[arr.size()];

        for(int i = 0; i<arr.size(); i++){
            ans[i] = arr.get(i);
        }
        
        return ans;
    }
}