//Kth Largest in a Stream

import java.util.*;

class Solution {
    static ArrayList<Integer> kthLargest(int[] arr, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // min-heap

        for (int num : arr) {
            pq.offer(num);
            if (pq.size() > k) pq.poll(); // keep only k largest
            if (pq.size() < k) res.add(-1);
            else res.add(pq.peek()); // kth largest
        }
        return res;
    }
}
