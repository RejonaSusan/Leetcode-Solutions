class Solution {
    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> st = new Stack();
        int n = arr.length;
        int left[] = new int[n];
        int right[] = new int[n];

        Arrays.fill(left, -1);
        Arrays.fill(right, n);

        for (int i = 0; i < arr.length; ++i) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                int index = st.pop();
                right[index] = i;
            }
            if (!st.isEmpty())
                left[i] = st.peek();
            st.push(i);
        }

        long ans = 0;
        int kMod = 1_000_000_007;
        for (int i = 0; i < arr.length; ++i) {
            ans += (long) arr[i] * (i - left[i]) * (right[i] - i);
            ans %= kMod;
        }

        return (int) ans;
    }
}
