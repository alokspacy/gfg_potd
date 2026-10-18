// Shortest Path From 1 To n

class Solution {
    public int minimumStep(int n) {
        int steps = 0;

        // Greedy approach: Work backwards from n to 1
        while (n > 1) {
            if (n % 3 == 0) {
                n /= 3;
            } else {
                n -= 1;
            }
            steps++;
        }

        return steps;
    }
}
