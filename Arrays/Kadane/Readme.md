# Kadane's Algorithm

Kadane's Algorithm is an efficient algorithm to find the maximum sum subarray in a given array of numbers. The algorithm was proposed by Jay Kadane in 1986 and is used to solve the maximum subarray problem.

The maximum subarray problem is to find the contiguous subarray of a given array of numbers with the largest sum.

#### Step by Step Approach:

1. Initialize two variables, maxEndingHere and maxSoFar, with 0 and Integer.MIN_VALUE, respectively.
   - maxEndingHere is used to store the maximum sum ending at the current position i in the array.
   - maxSoFar is used to store the maximum sum found so far.
2. Start a for loop to iterate through each element in the array.

3. At each iteration, update the value of maxEndingHere by taking the maximum of the current element arr[i] and the sum of the current element arr[i] and the previous maxEndingHere.

   - This step helps us keep track of the maximum sum ending at the current position i.

4. Update the value of maxSoFar by taking the maximum of the current maxEndingHere and the previous maxSoFar.

   - This step helps us keep track of the maximum sum found so far.

5. Repeat steps 3 and 4 for each element in the array.

6. After the for loop, return maxSoFar as the result of the function.

This algorithm runs in **O(n) time complexity**, where n is the number of elements in the array, making it a highly efficient solution to the maximum subarray problem.

### Code in  Java

```java
public static int maxSubArraySum(int[] arr) {
    int maxEndingHere = 0, maxSoFar = Integer.MIN_VALUE;
    for (int i = 0; i < arr.length; i++) {
        maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
        maxSoFar = Math.max(maxSoFar, maxEndingHere);
    }
    return maxSoFar;
}
```

**Explaination**

In the code above, `maxEndingHere`   stores the maximum sum ending at the current position `i` and `maxSoFar` stores the maximum sum found so far. 
At each iteration, the value of `maxEndingHere` is updated by taking the maximum of the current element and the sum of the current element and the previous `maxEndingHere`. 
Finally, `maxSoFar` is updated by taking the maximum of the current `maxEndingHere` and the previous `maxSoFar`.



