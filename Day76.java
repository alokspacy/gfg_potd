// Stable Marriage Problem

class Solution {
    public int[] stableMarriage(int[][] men, int[][] women) {
        int n = men.length;
        int[] womanPartner = new int[n]; // womanPartner[w] = man matched with w
        int[] manPartner = new int[n];   // manPartner[m] = woman matched with m
        int[] nextProposal = new int[n]; // nextProposal[m] = index of next woman to propose
        int[][] rank = new int[n][n];    // rank[w][m] = preference rank of man m for woman w

        // Precompute ranks for women
        for (int w = 0; w < n; w++) {
            for (int i = 0; i < n; i++) {
                rank[w][women[w][i]] = i;
            }
        }

        Arrays.fill(womanPartner, -1);
        Arrays.fill(manPartner, -1);

        // Queue of free men
        Queue<Integer> freeMen = new LinkedList<>();
        for (int m = 0; m < n; m++) freeMen.add(m);

        while (!freeMen.isEmpty()) {
            int m = freeMen.poll();
            int w = men[m][nextProposal[m]++]; // next woman in preference list

            if (womanPartner[w] == -1) {
                // Woman is free
                womanPartner[w] = m;
                manPartner[m] = w;
            } else {
                int currentMan = womanPartner[w];
                if (rank[w][m] < rank[w][currentMan]) {
                    // Woman prefers new man
                    womanPartner[w] = m;
                    manPartner[m] = w;
                    manPartner[currentMan] = -1;
                    freeMen.add(currentMan); // old partner becomes free
                } else {
                    // Woman rejects new man
                    freeMen.add(m);
                }
            }
        }
        return manPartner;
    }
}
