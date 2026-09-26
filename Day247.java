// Minimum Cost Pizza Selection

class Solution {
    public int minimumCost(int x, int s, int m, int l, int cs, int cm, int cl) {
        int maxArea = x + l;
        int INF = Integer.MAX_VALUE / 2;

        int[] dp = new int[maxArea + 1];

        for (int i = 1; i <= maxArea; i++) {
            dp[i] = INF;
        }

        dp[0] = 0;

        for (int area = 1; area <= maxArea; area++) {
            if (area >= s) {
                dp[area] = Math.min(dp[area], dp[area - s] + cs);
            }

            if (area >= m) {
                dp[area] = Math.min(dp[area], dp[area - m] + cm);
            }

            if (area >= l) {
                dp[area] = Math.min(dp[area], dp[area - l] + cl);
            }
        }

        int answer = INF;

        // We need total area >= x
        for (int area = x; area <= maxArea; area++) {
            answer = Math.min(answer, dp[area]);
        }

        return answer;
    }
}

