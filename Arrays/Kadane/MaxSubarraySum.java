class MaxSubarraySum {

    // Kadane's Algorithm
    int maxSubarraySum(int[] arr) {
        int currSum = 0;
        int maxSum = arr[0];
        for (int i : arr) {
            currSum += i;
            maxSum = Math.max(maxSum, currSum);
            currSum = Math.max(currSum, 0);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        var maxSubSum = new MaxSubarraySum();
        int[] arr = { -2, -3, 4, -1, -2, 1, 5, -3 };
        System.out.println(maxSubSum.maxSubarraySum(arr));
    }

}