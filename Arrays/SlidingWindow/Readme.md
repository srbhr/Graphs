# Sliding Window

The sliding window technique is a general algorithmic concept used to solve problems that involve a subarray or subsequence of a given array or sequence. The idea behind the sliding window technique is to maintain a "window" of elements in the given array or sequence and use this window to keep track of some information about the elements it contains. The window is then "slid" along the array or sequence, either from left to right or from right to left, to cover all possible combinations of subarrays or subsequences.

<br/>

### Step-by-step explanation of the sliding window technique:

1. Define the size of the window: The first step is to determine the size of the window, which is usually dependent on the problem you are trying to solve. For example, if you're trying to find the longest increasing subsequence in an array, the size of the window can be 1, representing a single element in the array.

2. Initialize the window: Start with a window of the defined size that covers the first few elements of the array or sequence.

3. Maintain the information: Keep track of the information you want to know about the elements within the window. For example, if you're trying to find the maximum sum subarray, you can keep track of the sum of the elements within the window.

4. Slide the window: Slide the window to the right (or left) by one element, updating the information you are keeping track of as you go. Repeat this step until the window has covered all possible combinations of subarrays or subsequences.

5. Get the result: Use the information you have been keeping track of to find the answer to the problem you are trying to solve. For example, if you're trying to find the maximum sum subarray, the result would be the maximum sum you found while sliding the window.

6. The sliding window technique is used to solve many problems, such as finding the longest repeating character in a string, finding the longest increasing subsequence in an array, or finding the minimum length subarray sum to a given value. It's a powerful technique that can be used to solve a variety of problems efficiently.

<br/>

The problem  of finding the longest repeating character in a string can be solved using Sliding Window and here's the implementation in Java and JavaScript. 


Java code 👇

```java
public static char longestRepeatingCharacter(String s) {
    int n = s.length();
    int[] count = new int[256];
    int maxLength = 0;
    char result = ' ';
    for (int i = 0, j = 0; j < n; j++) {
        count[s.charAt(j)]++;
        while (count[s.charAt(j)] > 1) {
            count[s.charAt(i)]--;
            i++;
        }
        if (j - i + 1 > maxLength) {
            maxLength = j - i + 1;
            result = s.charAt(j);
        }
    }
    return result;
}

```

JavaScript code 👇
```javascript
function longestRepeatingCharacter(s) {
  let n = s.length;
  let count = Array(256).fill(0);
  let maxLength = 0;
  let result = " ";
  for (let i = 0, j = 0; j < n; j++) {
    count[s.charCodeAt(j)]++;
    while (count[s.charCodeAt(j)] > 1) {
      count[s.charCodeAt(i)]--;
      i++;
    }
    if (j - i + 1 > maxLength) {
      maxLength = j - i + 1;
      result = s[j];
    }
  }
  return result;
}
```


**Explaination**

In the code above, the `count` array is used to keep track of the frequency of each character in the window. The two pointers `i` and `j` define the current window. The pointer `j` moves from left to right, while the pointer `i` moves only when the frequency of a character exceeds 1, which means there's a repeating character in the window. The length of the window `j - i + 1` is compared with the `maxLength` to find the longest repeating character. The result is the character that gives the maximum length.