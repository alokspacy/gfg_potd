// Range GCD Queries

class Solution {

    int[] tree;

 

    public ArrayList<Integer> processQueries(int[] arr, int[][] queries) {

        int n = arr.length;

        tree = new int[4 * n];

 

        build(arr, 1, 0, n - 1);

 

        ArrayList<Integer> ans = new ArrayList<>();

 

        for (int[] query : queries) {

            if (query[0] == 0) {

                // Range GCD query: [0, l, r]

                int l = query[1];

                int r = query[2];

 

                ans.add(getGcd(1, 0, n - 1, l, r));

            } else {

                // Update: [1, index, value]

                int index = query[1];

                int value = query[2];

 

                update(1, 0, n - 1, index, value);

            }

        }

 

        return ans;

    }

 

    private void build(int[] arr, int node, int start, int end) {

        if (start == end) {

            tree[node] = arr[start];

            return;

        }

 

        int mid = start + (end - start) / 2;

 

        build(arr, 2 * node, start, mid);

        build(arr, 2 * node + 1, mid + 1, end);

 

        tree[node] = gcd(tree[2 * node], tree[2 * node + 1]);

    }

 

    private void update(int node, int start, int end,

                        int index, int value) {

 

        if (start == end) {

            tree[node] = value;

            return;

        }

 

        int mid = start + (end - start) / 2;

 

        if (index <= mid) {

            update(2 * node, start, mid, index, value);

        } else {

            update(2 * node + 1, mid + 1, end, index, value);

        }

 

        tree[node] = gcd(tree[2 * node], tree[2 * node + 1]);

    }

 

    private int getGcd(int node, int start, int end,

                       int l, int r) {

 

        // No overlap

        if (r < start || end < l) {

            return 0;

        }

 

        // Complete overlap

        if (l <= start && end <= r) {

            return tree[node];

        }

 

        int mid = start + (end - start) / 2;

 

        int left = getGcd(2 * node, start, mid, l, r);

        int right = getGcd(2 * node + 1, mid + 1, end, l, r);

 

        return gcd(left, right);

    }

 

    private int gcd(int a, int b) {

        while (b != 0) {

            int temp = a % b;

            a = b;

            b = temp;

        }

        return a;

    }

}
