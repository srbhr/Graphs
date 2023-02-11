import java.util.ArrayList;

class MaxSumSubarray {

    // Kadane's Algorithm
    ArrayList<Integer> maxSubarraySum(int[] arr) {
        int currSum = 0;
        int maxSum = arr[0];
        int start = 0;
        int end = 0;
        int j = 0;

        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            if (maxSum < currSum) {
                maxSum = currSum;
                start = j + 1;
                end = i;

            }
            if (currSum < 0) {
                currSum = 0;
                j = i;
            }
        }

        answer.add(start);
        answer.add(end);
        return answer;
    }

    public static void main(String[] args) {
        var maxSubSum = new MaxSumSubarray();
        int[] arr = { -2, -3, 4, 4, 8, -1, -2, 1, 5, -3 };
        System.out.println(maxSubSum.maxSubarraySum(arr));
    }

}