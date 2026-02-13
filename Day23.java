// All numbers with specific difference

class Solution {
    public int getCount(int n, int d) {
        int count = 0;
        
        for (int x = Math.max(1, d); x <= Math.min(n, d + 90); x++) {
            if (x - digitSum(x) >= d) {
                count++;
            }
        }

        if (n > d + 90) {
            count += (n - (d + 90));
        }
        
        return count;
    }
    
    private int digitSum(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
}
