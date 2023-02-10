function maxSubarraySum(arr) {
    let maxSum = arr[0];
    let currSum = 0;

    for (let n of arr) {
        currSum += n;
        currSum = Math.max(currSum, 0);
        maxSum = Math.max(maxSum, currSum);
    }
    return maxSum;
}

let arr = [- 2, -3, 4, -1, -2, 1, 5, -3];

console.log(maxSubarraySum(arr));
