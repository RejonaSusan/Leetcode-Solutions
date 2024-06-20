class Solution {
    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> st1 = new Stack();
        Stack<Integer> st2 = new Stack();
        int n = arr.length;
        int left[] = new int[n];
        int right[] = new int[n];

        Arrays.fill(left, -1);
        Arrays.fill(right, n);

        for (int i = 0; i < n; i++) {
            while (!st1.isEmpty() && arr[st1.peek()] > arr[i]) {
                st1.pop();
            }
            left[i] = st1.isEmpty() ? -1 : st1.peek();
            st1.push(i);
        }

        for (int i = n - 1; i >= 0; i--) {
            while (!st2.isEmpty() && arr[st2.peek()] >= arr[i]) {
                st2.pop();
            }
            right[i] = st2.isEmpty() ? n : st2.peek();
            st2.push(i);
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
