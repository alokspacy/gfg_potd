// Maximum Frequency with K Increments

import java.util.*;

 

class Solution {

    public static int maxFrequency(int[] arr, int k) {

        Arrays.sort(arr);

 

        int left = 0;

        long sum = 0;

        int maxFreq = 1;

 

        for (int right = 0; right < arr.length; right++) {

            sum += arr[right];

 

            // Cost to make every element in the window equal to arr[right]

            while ((long) arr[right] * (right - left + 1) - sum > k) {

                sum -= arr[left];

                left++;

            }

 

            maxFreq = Math.max(maxFreq, right - left + 1);

        }

 

        return maxFreq;

    }

 

    public static void main(String[] args) {

        int[] arr = {2, 2, 4};

        int k = 4;

 

        System.out.println(maxFrequency(arr, k)); // 3

    }

}
