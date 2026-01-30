//Interleave the First Half of the Queue with Second Half

import java.util.*;

class Solution {
    public void rearrangeQueue(Queue<Integer> q) {
        int n = q.size();
        int half = n / 2;

        // Step 1: Split into two halves
        Queue<Integer> firstHalf = new LinkedList<>();
        Queue<Integer> secondHalf = new LinkedList<>();

        for (int i = 0; i < half; i++) {
            firstHalf.add(q.poll());
        }
        while (!q.isEmpty()) {
            secondHalf.add(q.poll());
        }

        // Step 2: Interleave elements
        while (!firstHalf.isEmpty() && !secondHalf.isEmpty()) {
            q.add(firstHalf.poll());
            q.add(secondHalf.poll());
        }
    }

    // For testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        Queue<Integer> q1 = new LinkedList<>(Arrays.asList(2, 4, 3, 1));
        sol.rearrangeQueue(q1);
        System.out.println(q1); // Output: [2, 3, 4, 1]

        Queue<Integer> q2 = new LinkedList<>(Arrays.asList(3, 5));
        sol.rearrangeQueue(q2);
        System.out.println(q2); // Output: [3, 5]
    }
}
