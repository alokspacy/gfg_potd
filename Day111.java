// Range LCM Queries

import java.util.*;

class Solution {
    // Utility gcd
    private long gcd(long a, long b) {
        while (b != 0) {
            long tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    // Utility lcm
    private long lcm(long a, long b) {
        if (a == 0 || b == 0) return 0;
        return (a / gcd(a, b)) * b;
    }

    // Segment Tree
    private long[] seg;
    private int n;

    private void build(int[] arr, int idx, int l, int r) {
        if (l == r) {
            seg[idx] = arr[l];
            return;
        }
        int mid = (l + r) / 2;
        build(arr, 2 * idx + 1, l, mid);
        build(arr, 2 * idx + 2, mid + 1, r);
        seg[idx] = lcm(seg[2 * idx + 1], seg[2 * idx + 2]);
    }

    private void update(int idx, int l, int r, int pos, int val) {
        if (l == r) {
            seg[idx] = val;
            return;
        }
        int mid = (l + r) / 2;
        if (pos <= mid) update(2 * idx + 1, l, mid, pos, val);
        else update(2 * idx + 2, mid + 1, r, pos, val);
        seg[idx] = lcm(seg[2 * idx + 1], seg[2 * idx + 2]);
    }

    private long query(int idx, int l, int r, int ql, int qr) {
        if (qr < l || ql > r) return 1; // neutral for LCM
        if (ql <= l && r <= qr) return seg[idx];
        int mid = (l + r) / 2;
        long left = query(2 * idx + 1, l, mid, ql, qr);
        long right = query(2 * idx + 2, mid + 1, r, ql, qr);
        return lcm(left, right);
    }

    public ArrayList<Long> RangeLCMQuery(int[] arr, int[][] queries) {
        n = arr.length;
        seg = new long[4 * n];
        build(arr, 0, 0, n - 1);

        ArrayList<Long> ans = new ArrayList<>();
        for (int[] q : queries) {
            if (q[0] == 1) {
                // Update
                int index = q[1], value = q[2];
                update(0, 0, n - 1, index, value);
            } else {
                // Range Query
                int L = q[1], R = q[2];
                ans.add(query(0, 0, n - 1, L, R));
            }
        }
        return ans;
    }
}
