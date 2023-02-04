# Arrays


#### Problem: Leaders in an array

> Write a program to print all the LEADERS in the array. An element is a leader if it is greater than all the elements to its right side. And the rightmost element is always a leader. 

``` 
Input: arr[] = {16, 17, 4, 3, 5, 2}, 
Output: 17, 5, 2

Input: arr[] = {1, 2, 3, 4, 5, 2, 21}, // Edge Case
Output: 21
```

**Brute Force**

```java
class Solution{
    //Function to find the leaders in the array.
    static ArrayList<Integer> leaders(int arr[], int n){
        // Your code here
        ArrayList<Integer> leads = new ArrayList<Integer>();
        boolean isMax = false;
        
        for (int i=0; i<n; i++) {
            isMax = false;
            for (int j=i+1; j<n;j++){
                if (arr[i] <= arr[j]){
                    isMax = true;
                    break;
                }
            }
            if (!isMax) {leads.add(arr[i]);}
        }
    return leads;
    }
}
```

**Optimised**

1. Traverse the array from right side. 
2. Find maximum element so far.
3. Print it.

```java

class Solution{
    //Function to find the leaders in the array.
    static ArrayList<Integer> leaders(int arr[], int n){
        // Your code here
        int currMax = arr[n-1];
        ArrayList<Integer> leads = new ArrayList<Integer>();
        leads.add(currMax);
        for (int i=n-1; i<-1; i--) {
            if (arr[i] > currMax){
                currMax = arr[i];
                leads.add(currMax);
            }
        }
        Collections.sort(leads);
        return leads;
    }
}

```

**For Stack Approach**

Time O(n)

Space O(n) [O(k), where k = number of leaders.]

